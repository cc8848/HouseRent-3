package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.pojo.HouseRecommend;
import com.magic.rent.service.IHouseRecommendService;
import com.magic.rent.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wuxinzhe   创建时间: 16/10/7
 * 类说明:
 */
@Controller
@RequestMapping("/*")
public class PageController extends BaseController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }

    @RequestMapping("/test")
    public ModelAndView test() {


        return new ModelAndView("test").addObject("message", FileUtil.getFilePath("1", 1));
    }

}
