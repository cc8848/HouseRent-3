package cn.com.showings.controller;

import cn.com.showings.pojo.exception.HouseImageSaveException;
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
 * 类说明: 统一异常处理
 */

public class ExceptionController implements HandlerExceptionResolver {

    private static Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        //控制台打印异常追踪记录
        ex.printStackTrace();
        ModelAndView modelAndView = new ModelAndView();
        logger.info("异常信息：{}。", ex.getMessage());
        if (isAjaxRequest(httpServletRequest)) {//判断是否为Ajax请求，是则返回Json
            modelAndView.setView(new MappingJackson2JsonView());
            modelAndView.addObject("message", ex.getMessage()).addObject("status", false);
            if (ex instanceof HouseImageSaveException) {
                Object data = ((HouseImageSaveException) ex).getData();
                //如果报异常的位置有返回具体异常数据，则加入到报文中返回前端
                if (null != data) {
                    modelAndView.addObject("data", data);
                    logger.info("异常数据：{}。", data);
                }
            }
            return modelAndView;
        } else {
            modelAndView.setViewName("views/error");
            modelAndView.addObject("exception", ex.getMessage());
            return modelAndView;
        }
    }

    private boolean isAjaxRequest(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With")) || !StringUtils.isEmpty(request.getParameter("jsonp"));
    }
}