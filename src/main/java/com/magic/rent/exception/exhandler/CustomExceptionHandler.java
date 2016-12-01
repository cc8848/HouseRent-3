package com.magic.rent.exception.exhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/29
 * 类说明:
 */

public class CustomExceptionHandler implements HandlerExceptionResolver {

    private static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        logger.info(ex.toString());
        return model(httpServletRequest, ex);
    }

    private ModelAndView model(HttpServletRequest request, Exception e) {
        if (isAjaxRequest(request)) {
            return new ModelAndView(new MappingJackson2JsonView()).addObject("message", e.getMessage()).addObject("status", false);
        }
        return new ModelAndView("error").addObject("message", e.getMessage());
    }


    private boolean isAjaxRequest(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With")) || !StringUtils.isEmpty(request.getParameter("jsonp"));
    }
}
