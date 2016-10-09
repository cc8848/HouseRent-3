package com.magic.rent.controller;

import com.magic.rent.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/10/9
 * 类说明:
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    @ResponseBody
    @RequestMapping("/getCity")
    public JsonResult getCity() {


        return JsonResult.success("", null);
    }
}
