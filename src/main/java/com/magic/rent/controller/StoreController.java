package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.exception.custom.ParameterException;
import com.magic.rent.pojo.Store;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.IStoreService;
import com.magic.rent.util.HttpUtil;
import com.magic.rent.util.JsonResult;
import com.magic.rent.util.MyStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/、11/19
 * 类说明:家访问控制器
 * 更新记录：
 */
@Controller
@RequestMapping("/store")
public class StoreController extends BaseController {
    @Autowired
    private IStoreService iStoreService;

    @ResponseBody
    @RequestMapping("/create")
    public JsonResult create(HttpServletRequest request) throws Exception {
        String name = MyStringUtil.checkParameter(request.getParameter("name"), "店铺名不能为空！");
        Integer provinceID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("provinceID"), "省份不能为空！"));
        Integer cityID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("cityID"), "城市不能为空！"));
        Integer areaID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("areaID"), "地区不能为空！"));
        String address = MyStringUtil.checkParameter(request.getParameter("address"), "地址不能为空！");
        SysUsers sysUsers = HttpUtil.getSessionUser(request);

        Store store = new Store();
        store.setName(name);
        store.setProvinceId(provinceID);
        store.setCityId(cityID);
        store.setAreaId(areaID);
        store.setAddress(address);

        boolean isSuccess = iStoreService.create(store, sysUsers.getUserId());

        if (isSuccess) {
            return JsonResult.success();
        } else {
            return JsonResult.error("创建申请失败！");
        }
    }

    @ResponseBody
    @RequestMapping("/cancel")
    public JsonResult cancel(HttpServletRequest request) throws Exception {
        Integer storeID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("storeID"), "店铺ID不能为空！"));
        SysUsers sysUsers = HttpUtil.getSessionUser(request);
        boolean isSuccess = iStoreService.cancel(storeID, sysUsers.getUserId());
        if (isSuccess) {
            return JsonResult.success();
        } else {
            return JsonResult.error("取消申请失败！");
        }
    }

    @ResponseBody
    @RequestMapping("/pass")
    public JsonResult pass(HttpServletRequest request) throws Exception {
        Integer storeID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("storeID"), "店铺ID不能为空！"));
        boolean isSuccess = iStoreService.pass(storeID);

        if (isSuccess) {
            return JsonResult.success();
        } else {
            return JsonResult.error("批准申请失败！");
        }
    }

    @ResponseBody
    @RequestMapping("/refuse")
    public JsonResult refuse(HttpServletRequest request) throws Exception {
        Integer storeID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("storeID"), "店铺ID不能为空！"));
        boolean isSuccess = iStoreService.refuse(storeID);

        if (isSuccess) {
            return JsonResult.success();
        } else {
            return JsonResult.error("拒绝申请失败！");
        }
    }

}
