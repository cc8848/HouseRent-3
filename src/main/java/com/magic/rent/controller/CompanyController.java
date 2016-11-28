package com.magic.rent.controller;

import com.magic.rent.pojo.Company;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.security.ICompanyService;
import com.magic.rent.util.HttpUtil;
import com.magic.rent.util.JsonResult;
import com.magic.rent.util.MyStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/11/28
 * 类说明: 公司相关控制器
 * 更新记录：
 */
@Controller
@RequestMapping("/company")
public class CompanyController {


    @Autowired
    private ICompanyService companyService;

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public JsonResult createCompany(HttpServletRequest request) throws Exception {

        SysUsers users = HttpUtil.getSessionUser(request);

        String companyName = MyStringUtil.checkParameter(request.getParameter("companyName"), "公司名称不能为空！");
        String provinceName = MyStringUtil.checkParameter(request.getParameter("provinceName"), "省份不能为空！");
        String cityName = MyStringUtil.checkParameter(request.getParameter("cityName"), "城市不能为空！");
        String areaName = MyStringUtil.checkParameter(request.getParameter("areaName"), "地区不能为空！");
        String address = MyStringUtil.checkParameter(request.getParameter("address"), "具体地址不能为空！");
        String phone = MyStringUtil.checkParameter(request.getParameter("phone"), "联系电话不能为空！");
        int userID = users.getUserId();

        Company company = new Company();
        company.setAddress(provinceName + cityName + areaName + address);
        company.setPhone(phone);
        company.setDeveloperId(userID);
        company.setCompanyName(companyName);
        company.setEnable(false);

        boolean isSuccess = companyService.create(company);

        if (isSuccess) {
            return JsonResult.success();
        } else {
            return JsonResult.error("申请失败！您可直接与我公司电话申请开通企业服务！");
        }

    }
}
