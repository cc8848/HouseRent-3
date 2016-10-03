package com.magic.rent.service.JCaptcha;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/28
 * 类说明:
 */

import com.alibaba.fastjson.JSON;
import com.magic.rent.util.JsonResult;
import com.magic.rent.util.Log;
import com.octo.captcha.service.CaptchaService;
import com.octo.captcha.service.CaptchaServiceException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 针对 JCaptcha 专门的过滤器(Filter)
 *
 * @author liukai
 */
public class JCaptchaFilter implements Filter {

    //web.xml中的参数名定义
    public static final String PARAM_CAPTCHA_PARAMTER_NAME = "captchaParamterName";
    public static final String PARAM_CAPTCHA_SERVICE_ID = "captchaServiceId";
    public static final String PARAM_FILTER_PROCESSES_URL = "filterProcessesUrl";
    public static final String PARAM_FAILURE_URL = "failureUrl";
    public static final String PARAM_AUTO_PASS_VALUE = "autoPassValue";

    //默认值定义
    public static final String DEFAULT_FILTER_PROCESSES_URL = "/login.do";
    public static final String DEFAULT_CAPTCHA_SERVICE_ID = "captchaService";
    public static final String DEFAULT_CAPTCHA_PARAMTER_NAME = "captcha";

    private String failureUrl;
    private String filterProcessesUrl = DEFAULT_FILTER_PROCESSES_URL;
    private String captchaServiceId = DEFAULT_CAPTCHA_SERVICE_ID;
    private String captchaParamterName = DEFAULT_CAPTCHA_PARAMTER_NAME;
    private String autoPassValue;

    private CaptchaService captchaService;

    /**
     * Filter回调初始化函数.
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        initParameters(filterConfig);
        initCaptchaService(filterConfig);

    }

    public void doFilter(ServletRequest theRequest, ServletResponse theResponse,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) theRequest;
        HttpServletResponse response = (HttpServletResponse) theResponse;
        String servletPath = request.getServletPath();
        Log.info(this, "过滤链接地址", "servletPath:" + servletPath);
        //符合filterProcessesUrl为验证处理请求,其余为生成验证图片请求.
        if (StringUtils.startsWith(servletPath, filterProcessesUrl)) {
            boolean validated = validateCaptchaChallenge(request);
            if (validated) {
                chain.doFilter(request, response);
            } else {
                redirectFailureUrl(request, response);
            }
        } else {
            genernateCaptchaImage(request, response);
        }
    }

    /**
     * Filter回调退出函数.
     */
    public void destroy() {
        // TODO Auto-generated method stub

    }

    /**
     * 初始化web.xml中定义的filter init-param.
     */
    protected void initParameters(final FilterConfig fConfig) {
        if (StringUtils.isBlank(fConfig.getInitParameter(PARAM_FAILURE_URL))) {
            throw new IllegalArgumentException("CaptchaFilter缺少failureUrl参数");
        }
        failureUrl = fConfig.getInitParameter(PARAM_FAILURE_URL);
        Log.info(this, "初始化参数", "验证失败URL:" + failureUrl);
        if (StringUtils.isNotBlank(fConfig.getInitParameter(PARAM_FILTER_PROCESSES_URL))) {
            filterProcessesUrl = fConfig.getInitParameter(PARAM_FILTER_PROCESSES_URL);
        }

        if (StringUtils.isNotBlank(fConfig.getInitParameter(PARAM_CAPTCHA_SERVICE_ID))) {
            captchaServiceId = fConfig.getInitParameter(PARAM_CAPTCHA_SERVICE_ID);
        }

        if (StringUtils.isNotBlank(fConfig.getInitParameter(PARAM_CAPTCHA_PARAMTER_NAME))) {
            captchaParamterName = fConfig.getInitParameter(PARAM_CAPTCHA_PARAMTER_NAME);
        }

        if (StringUtils.isNotBlank(fConfig.getInitParameter(PARAM_AUTO_PASS_VALUE))) {
            autoPassValue = fConfig.getInitParameter(PARAM_AUTO_PASS_VALUE);
        }
    }

    /**
     * 从ApplicatonContext获取CaptchaService实例.
     */
    protected void initCaptchaService(final FilterConfig fConfig) {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(fConfig.getServletContext());
        captchaService = (CaptchaService) context.getBean(captchaServiceId);
    }

    /**
     * 生成验证码图片.
     */
    protected void genernateCaptchaImage(final HttpServletRequest request, final HttpServletResponse response)
            throws IOException {

        setDisableCacheHeader(response);
        response.setContentType("image/jpeg");

        ServletOutputStream out = response.getOutputStream();
        try {
            String captchaId = request.getSession(true).getId();
            BufferedImage challenge = (BufferedImage) captchaService.getChallengeForID(captchaId, request.getLocale());
            ImageIO.write(challenge, "jpg", out);
            out.flush();
        } catch (CaptchaServiceException e) {
            Log.error(this, "获取验证码图片异常", e.getMessage(), e);
        } finally {
            out.close();
        }
    }

    /**
     * 验证验证码.
     */
    protected boolean validateCaptchaChallenge(final HttpServletRequest request) {
        try {
            String captchaID = request.getSession().getId();
            Log.info(this, "生成验证码的SessionID", "SessionID:" + captchaID);
            String challengeResponse = request.getParameter(captchaParamterName);
            Log.info(this, "输入的验证码", "ChallengeResponse:" + challengeResponse);
            //自动通过值存在时,检验输入值是否等于自动通过值
            if (StringUtils.isNotBlank(autoPassValue) && autoPassValue.equals(challengeResponse)) {
                return true;
            }
            return captchaService.validateResponseForID(captchaID, challengeResponse);
        } catch (CaptchaServiceException e) {
            Log.error(this, "校验验证码异常", e.getMessage(), e);
            return false;
        }
    }

    /**
     * 验证失败跳转页面
     *
     * @param request
     * @param response
     * @throws IOException
     */
    protected void redirectFailureUrl(final HttpServletRequest request, final HttpServletResponse response)
            throws IOException {
//        Log.info(this, "验证失败跳转", "失败URL:" + request.getContextPath() + failureUrl);
//        response.sendRedirect(request.getContextPath() + failureUrl);
        Log.info(this, "验证码验证", "验证失败,IP地址:" + getIP(request));
        String jsonStr = JSON.toJSONString(JsonResult.error("验证码输入错误!"));
        returnJson(response, jsonStr);
    }

    /**
     * 设置禁止客户端缓存的Header.
     */
    public static void setDisableCacheHeader(HttpServletResponse response) {
        //Http 1.0 header
        response.setDateHeader("Expires", 1L);
        response.addHeader("Pragma", "no-cache");
        //Http 1.1 header
        response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
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