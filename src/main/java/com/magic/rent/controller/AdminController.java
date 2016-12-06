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
        return "admin/index";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "../admin/welcome";
    }

    @RequestMapping("/pic-list")
    public String picture() {
        return "../admin/picture-list";
    }


    @RequestMapping("/art-list")
    public String article() {
        return "../admin/article-list";
    }

    @RequestMapping("/pro-company")
    public String company() {
        return "../admin/product-company";
    }

    @RequestMapping("/pro-store")
    public String store() {
        return "../admin/product-store";
    }

    @RequestMapping("/pro-house")
    public String house() {
        return "../admin/product-house";
    }

    @RequestMapping("pro-store-add")
    public String storeAdd() {
        return "../admin/product-store-add";
    }
}
