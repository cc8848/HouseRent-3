package com.magic.rent.controller;

import com.magic.rent.pojo.IDInfo;
import com.magic.rent.service.IIDInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/19
 * 类说明:
 */
@Controller
@RequestMapping("/IDInfo")
public class IDInfoController {
    @Autowired
    private IIDInfoService iidInfoService;

    @RequestMapping("/findAllIDInfo")
    public ModelAndView findAllIDInfo() {
        ModelAndView modelAndView = new ModelAndView();
        List<IDInfo> idInfoList = iidInfoService.findALLIDInfo();
        modelAndView.addObject(idInfoList);
        modelAndView.setViewName("IDInfo");
        return modelAndView;
    }

}
