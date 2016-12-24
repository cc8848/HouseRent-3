package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.pojo.HandHouseInfo;
import com.magic.rent.pojo.JsonResult;
import com.magic.rent.service.IHandHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/12/24
 * 类说明:
 * 更新记录：
 */
@Controller
@RequestMapping("/handHouse")
public class HandHouseController extends BaseController {

    @Autowired
    private IHandHouseService iHandHouseService;


    @RequestMapping("/issue")
    public JsonResult issueHouse(HandHouseInfo handHouseInfo) throws Exception {


        return null;
    }
}
