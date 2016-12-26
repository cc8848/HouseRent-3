package com.magic.rent.controller;

import com.github.pagehelper.PageInfo;
import com.magic.rent.controller.base.BaseController;
import com.magic.rent.pojo.*;
import com.magic.rent.service.IHandHouseService;
import com.magic.rent.tools.HttpTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
    @ResponseBody
    public JsonResult issueHouse(HandHouseInfo handHouseInfo, HouseImageListForm houseImageListForm) throws Exception {

        JsonResult jsonResult;

        if (iHandHouseService.issueHouse(handHouseInfo, houseImageListForm.getHouseImages())) {
            jsonResult = JsonResult.success();
        } else {
            jsonResult = JsonResult.error("发布房源失败！");
        }

        return jsonResult;
    }

    @RequestMapping("/query")
    @ResponseBody
    public JsonResult getUserHouses(HttpServletRequest request) throws Exception {

        SysUsers sysUsers = HttpTools.getSessionUser(request);

        int pageSize = HttpTools.getPageSize(request);

        int pageNum = HttpTools.getPageNum(request);

        PageInfo<HandHouseInfo> houseInfoPage = iHandHouseService.getHandHouseByUser(sysUsers.getUserId(), pageSize, pageNum);

        return JsonResult.success(houseInfoPage);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult deleteHouse(int houseID, HttpServletRequest request) throws Exception {
        SysUsers sysUsers = HttpTools.getSessionUser(request);

        if (iHandHouseService.deleteHouse(houseID, sysUsers.getUserId())) {
            return JsonResult.success();
        } else {
            return JsonResult.error("删除房源失败！");
        }
    }

    @RequestMapping(value = "/modify/price", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult modifyPrice(HttpServletRequest request, HandHousePrice handHousePrice) throws Exception {
        SysUsers sysUsers = HttpTools.getSessionUser(request);
        handHousePrice.setUserId(sysUsers.getUserId());

        if (iHandHouseService.modifyPrice(handHousePrice)) {
            return JsonResult.success();
        } else {
            return JsonResult.error("修改价格失败！");
        }
    }

    @RequestMapping(value = "/modify/detail", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult modifyDetail(HttpServletRequest request, HandHouseDetail handHouseDetail) throws Exception {
        SysUsers sysUsers = HttpTools.getSessionUser(request);
        handHouseDetail.setUserId(sysUsers.getUserId());
        if (iHandHouseService.modifyDetail(handHouseDetail)) {
            return JsonResult.success();
        } else {
            return JsonResult.error("修改详细信息失败！");
        }
    }

    @RequestMapping(value = "/modify/info", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult modifyInfo(HttpServletRequest request, HandHouseInfo handHouseInfo) throws Exception {
        SysUsers sysUsers = HttpTools.getSessionUser(request);
        handHouseInfo.setUserId(sysUsers.getUserId());
        if (iHandHouseService.modifyInfo(handHouseInfo)) {
            return JsonResult.success();
        } else {
            return JsonResult.error("修改房源信息失败！");
        }
    }
}
