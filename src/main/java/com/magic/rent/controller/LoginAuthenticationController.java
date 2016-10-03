package com.magic.rent.controller;

import com.alibaba.fastjson.JSON;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.IUserService;
import com.magic.rent.util.JsonResult;
import com.magic.rent.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wuxinzhe   创建时间: 16/10/3
 * 类说明:
 */
public class LoginAuthenticationController implements AuthenticationSuccessHandler, AuthenticationFailureHandler {

    @Autowired
    private IUserService iUserService;

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SysUsers users;
        String jsonStr;
        try {
            users = this.saveLoginInfo(request, authentication);
        } catch (Exception e) {
            jsonStr = JSON.toJSONString(JsonResult.error("用户登录信息保存失败!"));
            returnJson(response, jsonStr);
            Log.error(this, "登录异常", "用户登录信息保存失败!", e);
            return;
        }
        jsonStr = JSON.toJSONString(JsonResult.success(users));
        returnJson(response, jsonStr);
    }


    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Log.info(this, "登录失败", "登录IP" + getIP(request) + "\n失败原因:" + exception.toString());
        String jsonStr = JSON.toJSONString(JsonResult.error("登录失败:" + exception.toString()));
        returnJson(response, jsonStr);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public SysUsers saveLoginInfo(HttpServletRequest request, Authentication authentication) throws Exception {
        SysUsers user = (SysUsers) authentication.getPrincipal();
        Date date = new Date();
        user.setLastLogin(date);
        user.setLoginIp(getIP(request));
        try {
            iUserService.updateUserLoginInfo(user);
        } catch (DataAccessException e) {
            Log.error(this, "登录异常", "保存登录数据失败!", e);
        }
        return user;
    }

    /**
     * 返回Json
     *
     * @param response
     * @param jsonString
     */
    private void returnJson(HttpServletResponse response, String jsonString) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 获取IP地址
     *
     * @param request
     * @return IP地址
     */
    private String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
