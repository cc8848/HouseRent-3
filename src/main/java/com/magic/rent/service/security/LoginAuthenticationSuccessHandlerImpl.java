package com.magic.rent.service.security;

import com.magic.rent.exception.custom.ParameterException;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.IUserService;
import com.magic.rent.util.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/22
 * 类说明:登录成功后需要执行的页面
 */

public class LoginAuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler, InitializingBean {

    private String defaultTargetUrl;

    private boolean forwardToDestination = false;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private IUserService iUserService;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        try {
            this.saveLoginInfo(request, authentication);
        } catch (Exception e) {
            Log.error(this, "登录异常", "用户登录信息保存失败!", e);
        }

        if (this.forwardToDestination) {
            Log.info(this, "登录成功", "Login success,Forwarding to [" + this.defaultTargetUrl + "]");
            request.getRequestDispatcher(this.defaultTargetUrl).forward(request, response);
        } else {
            Log.info(this, "登录成功", "Login success,Redirecting to [" + this.defaultTargetUrl + "]");
            this.redirectStrategy.sendRedirect(request, response, this.defaultTargetUrl);
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void saveLoginInfo(HttpServletRequest request, Authentication authentication) throws Exception {
        SysUsers user = (SysUsers) authentication.getPrincipal();
        try {
            String ip = this.getIpAddress(request);
            Date date = new Date();
            user.setLastLogin(date);
            user.setLoginIp(ip);
            iUserService.updateUserLoginInfo(user);
        } catch (DataAccessException e) {
            Log.info(this, "保存登录数据", "保存登录数据失败:" + e.toString());
        }
    }

    public String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public void setDefaultTargetUrl(String defaultTargetUrl) {
        this.defaultTargetUrl = defaultTargetUrl;
    }

    public void setForwardToDestination(boolean forwardToDestination) {
        this.forwardToDestination = forwardToDestination;
    }

    public void afterPropertiesSet() throws Exception {
        if (StringUtils.isEmpty(defaultTargetUrl))
            throw new ExceptionInInitializerError("You must configure defaultTargetUrl");
    }
}
