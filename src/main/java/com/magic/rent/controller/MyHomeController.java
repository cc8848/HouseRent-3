package com.magic.rent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wuxinzhe   创建时间: 16/10/6
 * 类说明:
 */
@Controller
@RequestMapping("/user")
public class MyHomeController {

    @RequestMapping("/home")
    public String myHome() {
        return "home";
    }
}
