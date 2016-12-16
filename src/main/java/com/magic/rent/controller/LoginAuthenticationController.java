package com.magic.rent.controller;

import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.IUserService;
import com.magic.rent.tools.HttpTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wuxinzhe   创建时间: 16/10/3
 * 类说明:
 */
public class LoginAuthenticationController implements AuthenticationSuccessHandler, AuthenticationFailureHandler, InitializingBean {

    @Autowired
    private IUserService iUserService;

    private String successURL;

    private String failURL;

    private static Logger logger = LoggerFactory.getLogger(LoginAuthenticationController.class);

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public void setSuccessURL(String successURL) {
        this.successURL = successURL;
    }

    public void setFailURL(String failURL) {
        this.failURL = failURL;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SysUsers users;
        try {
            users = (SysUsers) authentication.getPrincipal();
            Date date = new Date();
            users.setLastLogin(date);
            users.setLoginIp(HttpTools.getIP(request));
            try {
                iUserService.updateUserLoginInfo(users);
            } catch (DataAccessException e) {
                logger.error("登录异常:保存登录数据失败!", e);
            }
        } catch (Exception e) {
            logger.error("登录异常:用户登录信息保存失败!", e);
            String url = failURL + "?error=用户登录信息保存失败!" + e.getMessage();
            redirectStrategy.sendRedirect(request, response, url);
            try {
                HttpTools.sendRedirect(failURL, "用户登录信息保存失败!", request, response);
            } catch (Exception e2) {
                logger.error("登录异常:跳转页面失败！", e);
            }
            return;
        }
        request.getSession().setAttribute("user", users);
        redirectStrategy.sendRedirect(request, response, successURL);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("登录失败:请求IP地址[{}];失败原因:{};", HttpTools.getIP(request), exception.getMessage());
        exception.printStackTrace();
        String error = URLEncoder.encode(exception.getMessage(), "UTF-8");
        String url = failURL + "?error=" + error;
        redirectStrategy.sendRedirect(request, response, url);
    }

    public void afterPropertiesSet() throws Exception {
        if (StringUtils.isEmpty(successURL))
            throw new ExceptionInInitializerError("成功后跳转的地址未设置!");
        if (StringUtils.isEmpty(failURL))
            throw new ExceptionInInitializerError("失败后跳转的地址未设置!");
    }
}
