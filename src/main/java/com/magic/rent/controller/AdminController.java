package com.magic.rent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/6
 * 类说明:
 * 更新记录：
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/index")
    public String admin() {
        return "/admin/index";
    }

}
