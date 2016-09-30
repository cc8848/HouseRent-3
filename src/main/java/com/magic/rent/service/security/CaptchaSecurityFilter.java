package com.magic.rent.service.security;

import com.magic.rent.util.Log;
import com.octo.captcha.CaptchaException;
import com.octo.captcha.service.image.ImageCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/26
 * 类说明:
 */
public class CaptchaSecurityFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private ImageCaptchaService imageCaptchaService;

    @Autowired
    private MessageSource messageSource;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String captcha = request.getParameter("captcha");

        Boolean isResponseCorrect = imageCaptchaService.validateResponseForID(request.getSession().getId(), captcha);

        if (!isResponseCorrect) {
            Log.info(CaptchaSecurityFilter.class, "验证码校验", "验证码出错,输入的验证码为:" + captcha);
            throw new CaptchaException(
                    this.messageSource.getMessage("AbstractUserDetailsAuthenticationProvider.badCaptcha", null, "Default", null));
        }

        return super.attemptAuthentication(request, response);
    }
}
