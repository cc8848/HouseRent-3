package com.magic.rent.exception.exhandler;

import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.exception.custom.ParameterException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/29
 * 类说明:
 */

public class CustomExceptionHandler implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ex", ex.toString());
        // 根据不同错误转向不同页面
        if (ex instanceof BusinessException) {
            return new ModelAndView("../error/business_error", model);
        } else if (ex instanceof ParameterException) {
            return new ModelAndView("../error/parameter_error", model);
        } else {
            return new ModelAndView("../error/404", model);
        }
    }
}
