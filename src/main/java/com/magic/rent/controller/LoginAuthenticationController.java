package com.magic.rent.controller;

import com.alibaba.fastjson.JSON;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.IUserService;
import com.magic.rent.util.HttpUtil;
import com.magic.rent.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.Date;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wuxinzhe   创建时间: 16/10/3
 * 类说明:
 */
public class LoginAuthenticationController implements AuthenticationSuccessHandler, AuthenticationFailureHandler {

    @Autowired
    private IUserService iUserService;

    private static Logger logger = LoggerFactory.getLogger(LoginAuthenticationController.class);

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SysUsers users;
        String jsonStr;
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
            jsonStr = JSON.toJSONString(JsonResult.error("用户登录信息保存失败!"));
            HttpUtil.returnJson(response, jsonStr);
            logger.error("登录异常:用户登录信息保存失败!", e);
            return;
        }
        jsonStr = JSON.toJSONString(JsonResult.success("登录验证成功!", users));
        HttpUtil.returnJson(response, jsonStr);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("登录失败:请求IP地址[{}];\n失败原因:{};", HttpUtil.getIP(request), exception.getMessage());
        String jsonStr = JSON.toJSONString(JsonResult.error("登录失败:" + exception.getMessage() + "!"));
        HttpUtil.returnJson(response, jsonStr);
    }

}
