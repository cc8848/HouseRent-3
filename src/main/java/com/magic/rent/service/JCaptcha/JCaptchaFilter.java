package com.magic.rent.service.JCaptcha;

import com.magic.rent.util.Log;
import com.octo.captcha.service.CaptchaService;
import com.octo.captcha.service.CaptchaServiceException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by wuxinzhe on 16/9/25.
 *
 */
public class JCaptchaFilter implements Filter {

    //web.xml中的参数名定义
    public static final String PARAM_CAPTCHA_PARAMETER_NAME = "captchaParamterName";
    public static final String PARAM_CAPTCHA_SERVICE_ID = "captchaServiceId";
    public static final String PARAM_FILTER_PROCESSES_URL = "filterProcessesUrl";
    public static final String PARAM_FAILURE_URL = "failureUrl";
    public static final String PARAM_AUTO_PASS_VALUE = "autoPassValue";

    //默认值定义
    public static final String DEFAULT_FILTER_PROCESSES_URL = "/j_spring_security_check";
    public static final String DEFAULT_CAPTCHA_SERVICE_ID = "captchaService";
    public static final String DEFAULT_CAPTCHA_PARAMETER_NAME = "j_captcha";


    private String failureUrl;
    private String filterProcessesUrl = DEFAULT_FILTER_PROCESSES_URL;
    private String captchaServiceId = DEFAULT_CAPTCHA_SERVICE_ID;
    private String captchaParameterName = DEFAULT_CAPTCHA_PARAMETER_NAME;
    private String autoPassValue;

    private CaptchaService captchaService;

    /**
     * Filter回调初始化函数.
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        initParameters(filterConfig);
        initCaptchaService(filterConfig);
    }

    public void doFilter(ServletRequest theRequest, ServletResponse theResponse,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) theRequest;
        HttpServletResponse response = (HttpServletResponse) theResponse;
        String servletPath = request.getServletPath();
        Log.info(JCaptchaFilter.class, "获取ServletPath", "servletPath:" + servletPath);
        //符合filterProcessesUrl为验证处理请求,其余为生成验证图片请求.
        if (StringUtils.startsWith(servletPath, filterProcessesUrl)) {
            boolean validated = validateCaptchaChallenge(request);
            if (validated) {
                chain.doFilter(request, response);
            } else {
                redirectFailureUrl(request, response);
            }
        } else {
            generateCaptchaImage(request, response);
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
        Log.info(JCaptchaFilter.class, "获取失败URL", "FailureUrl:" + failureUrl);

        if (StringUtils.isNotBlank(fConfig.getInitParameter(PARAM_FILTER_PROCESSES_URL))) {
            filterProcessesUrl = fConfig.getInitParameter(PARAM_FILTER_PROCESSES_URL);
        }

        if (StringUtils.isNotBlank(fConfig.getInitParameter(PARAM_CAPTCHA_SERVICE_ID))) {
            captchaServiceId = fConfig.getInitParameter(PARAM_CAPTCHA_SERVICE_ID);
        }

        if (StringUtils.isNotBlank(fConfig.getInitParameter(PARAM_CAPTCHA_PARAMETER_NAME))) {
            captchaParameterName = fConfig.getInitParameter(PARAM_CAPTCHA_PARAMETER_NAME);
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
    protected void generateCaptchaImage(final HttpServletRequest request, final HttpServletResponse response)
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
            Log.error(JCaptchaFilter.class, "验证码服务异常[GenerateCaptchaImage]", e.getMessage());
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
            Log.info(JCaptchaFilter.class, "验证码ID", "captchaID:" + captchaID);
            String challengeResponse = request.getParameter(captchaParameterName);
            Log.info(JCaptchaFilter.class, "验证码challengeResponse", "challengeResponse:" + challengeResponse);
            //自动通过值存在时,检验输入值是否等于自动通过值
            if (StringUtils.isNotBlank(autoPassValue) && autoPassValue.equals(challengeResponse)) {
                return true;
            }
            return captchaService.validateResponseForID(captchaID, challengeResponse);
        } catch (CaptchaServiceException e) {
            Log.error(JCaptchaFilter.class, "验证码服务异常[ValidateCaptchaChallenge]", e.getMessage());
            return false;
        }
    }

    /**
     * 跳转到失败页面.
     * <p>
     * 可在子类进行扩展, 比如在session中放入SpringSecurity的Exception.
     */
    protected void redirectFailureUrl(final HttpServletRequest request, final HttpServletResponse response)
            throws IOException {
        Log.info(JCaptchaFilter.class, "验证失败后跳转", "跳转页面:" + request.getContextPath() + failureUrl);
        response.sendRedirect(request.getContextPath() + failureUrl);
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
}
