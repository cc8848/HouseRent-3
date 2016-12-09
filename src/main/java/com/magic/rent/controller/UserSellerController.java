package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.pojo.UserSeller;
import com.magic.rent.service.IUserSellerService;
import com.magic.rent.util.HttpUtil;
import com.magic.rent.pojo.JsonResult;
import com.magic.rent.util.MyStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: Wu   创建时间: 16/10/6
 * 类说明:销售员控制器
 */
@Controller
@RequestMapping("/seller")
public class UserSellerController extends BaseController {

    @Autowired
    private IUserSellerService iUserSellerService;

    @ResponseBody
    @RequestMapping("/create")
    public JsonResult create(HttpServletRequest request) throws Exception {
        SysUsers sysUsers = HttpUtil.getSessionUser(request);
        Integer storeID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("storeID"), "店铺ID不能为空！"));

        UserSeller userSeller = new UserSeller();
        userSeller.setUserId(sysUsers.getUserId());
        userSeller.setStoreId(storeID);
        if (iUserSellerService.create(userSeller)) {
            return JsonResult.success();
        } else {
            return JsonResult.error("申请加入失败！请联系客服！");
        }
    }

    @ResponseBody
    @RequestMapping("/cancel")
    public JsonResult cancel(HttpServletRequest request) throws Exception {
        SysUsers sysUsers = HttpUtil.getSessionUser(request);

        if (iUserSellerService.cancel(sysUsers.getUserId())) {
            return JsonResult.success();
        } else {
            return JsonResult.error("取消申请失败！请联系客服！");
        }
    }

    @ResponseBody
    @RequestMapping("/pass")
    public JsonResult pass(HttpServletRequest request) throws Exception {

        Integer userID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("userID"), "用户ID不能为空！"));

        if (iUserSellerService.pass(userID)) {
            return JsonResult.success();
        } else {
            return JsonResult.error("审批通过失败！请联系管理员！");
        }
    }

    @ResponseBody
    @RequestMapping("/refuse")
    public JsonResult refuse(HttpServletRequest request) throws Exception {
        Integer userID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("userID"), "用户ID不能为空！"));

        if (iUserSellerService.refuse(userID)) {
            return JsonResult.success();
        } else {
            return JsonResult.error("审批拒绝失败！请联系管理员！");
        }
    }

    @ResponseBody
    @RequestMapping("/quit")
    public JsonResult quit(HttpServletRequest request) throws Exception {

        SysUsers sysUsers = HttpUtil.getSessionUser(request);

        if (iUserSellerService.quit(sysUsers.getUserId())) {
            return JsonResult.success();
        } else {
            return JsonResult.error("退出门店失败！请联系客服！");
        }
    }

}
