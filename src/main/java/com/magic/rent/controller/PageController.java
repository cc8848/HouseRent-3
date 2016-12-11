package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: WuXinZhe   创建时间: 16/10/7
 * 类说明:
 */
@Controller
@RequestMapping("/*")
public class PageController extends BaseController {

    @RequestMapping
    public String index() {
        return "views/index";
    }

    @RequestMapping("/error")
    public String error() {
        return "views/error";
    }

    @RequestMapping("register")
    public String register() {
        return "views/register";
    }

}
