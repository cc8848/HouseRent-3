package com.magic.rent.util;

import com.magic.rent.exception.custom.LoginTimeOutException;
import com.magic.rent.pojo.SysUsers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wuxinzhe   创建时间: 16/10/3
 * 类说明:
 */
public class HttpUtil {

    /**
     * Servlet模式下返回Json数据
     *
     * @param response
     * @param jsonString
     */
    public static void returnJson(HttpServletResponse response, String jsonString) {
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
     * 从request中获取请求IP地址
     *
     * @param request
     * @return IP地址
     */
    public static String getIP(HttpServletRequest request) {
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

    /**
     * 从Session中获取已登录的用户信息
     *
     * @param request
     * @return sysUsers
     */
    public static SysUsers getSessionUser(HttpServletRequest request) {

        SysUsers sysUsers = (SysUsers) request.getSession().getAttribute("user");

        if (sysUsers == null) {
            throw new LoginTimeOutException("用户登录超时或尚未登录！请重新登录！");
        } else {
            return sysUsers;
        }
    }
}
