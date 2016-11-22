package com.magic.rent.controller;

import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.IUserService;
import com.magic.rent.util.HttpUtil;
import com.magic.rent.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
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
import java.util.Date;
import java.util.Locale;

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

    private String AttrName;

    private static Logger logger = LoggerFactory.getLogger(LoginAuthenticationController.class);

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public void setSuccessURL(String successURL) {
        this.successURL = successURL;
    }

    public void setFailURL(String failURL) {
        this.failURL = failURL;
    }

    public void setAttrName(String attrName) {
        AttrName = attrName;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SysUsers users;
        JsonResult jsonResult;
        try {
            users = (SysUsers) authentication.getPrincipal();
            Date date = new Date();
            users.setLastLogin(date);
            users.setLoginIp(HttpUtil.getIP(request));
            try {
                iUserService.updateUserLoginInfo(users);
            } catch (DataAccessException e) {
                logger.error("登录异常:保存登录数据失败!", e);
            }
        } catch (Exception e) {
            jsonResult = JsonResult.error("用户登录信息保存失败!");
            logger.error("登录异常:用户登录信息保存失败!", e);
            request.setAttribute(AttrName, jsonResult);
            return;
        }
        request.getSession().setAttribute("user", users);
        httpReturn(request, response, true);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("登录失败:请求IP地址[{}];失败原因:{};", HttpUtil.getIP(request), exception.getMessage());
        JsonResult jsonResult = JsonResult.error(exception.getMessage());
        request.setAttribute(AttrName, jsonResult);
        httpReturn(request, response, false);
    }

    public void afterPropertiesSet() throws Exception {
        if (StringUtils.isEmpty(successURL))
            throw new ExceptionInInitializerError("成功后跳转的地址未设置!");
        if (StringUtils.isEmpty(failURL))
            throw new ExceptionInInitializerError("失败后跳转的地址未设置!");
        if (StringUtils.isEmpty(AttrName))
            throw new ExceptionInInitializerError("Attr的Key值未设置!");
    }

    private void httpReturn(HttpServletRequest request, HttpServletResponse response, boolean success) throws IOException, ServletException {
        if (success) {
            logger.info("登录成功:直接转发至地址-[{}]", successURL);
            redirectStrategy.sendRedirect(request, response, successURL);
        } else {
            logger.info("登录失败:直接转发至地址-[{}]", failURL);
            request.getRequestDispatcher(this.failURL).forward(request, response);
        }
    }
}
