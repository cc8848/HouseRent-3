package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.exception.custom.ParameterException;
import com.magic.rent.service.ISysStoreService;
import com.magic.rent.util.JsonResult;
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
public class SysStoreController extends BaseController {
    @Autowired
    private ISysStoreService iSysStoreService;

    @RequestMapping("/getNum")
    @ResponseBody
    public JsonResult getNum(HttpServletRequest request) throws Exception {

        if (StringUtils.isEmpty(request.getParameter("areaID"))) {
            throw new ParameterException(messageSourceAccessor.getMessage("SysStoreService.areaNameNotNUll", "地区名称不能为空！"));
        }

        String areaID = request.getParameter("areaID");

        return JsonResult.success(iSysStoreService.selectStoreNumByAreaID(areaID));
    }

    @RequestMapping("/getRoles")
    @ResponseBody
    public JsonResult getRoles(HttpServletRequest request) throws Exception {
        if (StringUtils.isEmpty(request.getParameter("storeID"))) {
            throw new ParameterException(messageSourceAccessor.getMessage("SysStoreService.storeID", "店铺ID不能为空！"));
        }

        int storeID = Integer.parseInt(request.getParameter("storeID"));

        return JsonResult.success(iSysStoreService.selectRolesByStoreID(storeID));
    }
}
