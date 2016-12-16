package com.magic.rent.controller;

import com.github.pagehelper.PageInfo;
import com.magic.rent.pojo.Company;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.ICompanyService;
import com.magic.rent.tools.HttpTools;
import com.magic.rent.pojo.JsonResult;
import com.magic.rent.tools.MyStringTools;
import org.apache.commons.lang3.StringUtils;
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
    private ICompanyService iCompanyService;

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public JsonResult createCompany(HttpServletRequest request) throws Exception {

        SysUsers users = HttpTools.getSessionUser(request);

        String companyName = MyStringTools.checkParameter(request.getParameter("companyName"), "公司名称不能为空！");
        Integer provinceID = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("provinceID"), "省份不能为空！"));
        Integer cityID = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("cityID"), "城市不能为空！"));
        Integer areaID = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("areaID"), "地区不能为空！"));
        String address = MyStringTools.checkParameter(request.getParameter("address"), "具体地址不能为空！");
        String phone = MyStringTools.checkParameter(request.getParameter("phone"), "联系电话不能为空！");
        int userID = users.getUserId();

        Company company = new Company();
        company.setProvinceId(provinceID);
        company.setCityId(cityID);
        company.setAreaId(areaID);
        company.setAddress(address);
        company.setPhone(phone);
        company.setDeveloperId(userID);
        company.setCompanyName(companyName);

        boolean isSuccess = iCompanyService.create(company);

        if (isSuccess) {
            return JsonResult.success();
        } else {
            return JsonResult.error("申请失败！您可直接与我公司电话申请开通企业服务！");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/pass", method = RequestMethod.POST)
    public JsonResult passCompany(HttpServletRequest request) throws Exception {
        Integer companyID = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("companyID"), "公司编号不能为空！"));

        if (iCompanyService.pass(companyID)) {
            return JsonResult.success();
        } else {
            return JsonResult.error("操作失败！请联系技术人员！");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/refuse", method = RequestMethod.POST)
    public JsonResult refuseCompany(HttpServletRequest request) throws Exception {
        Integer companyID = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("companyID"), "公司编号不能为空！"));

        if (iCompanyService.refuse(companyID)) {
            return JsonResult.success();
        } else {
            return JsonResult.error("操作失败！请联系技术人员！");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public JsonResult cancelCompany(HttpServletRequest request) throws Exception {
        SysUsers sysUsers = HttpTools.getSessionUser(request);

        Integer companyID = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("companyID"), "公司ID不能为空！"));


        if (iCompanyService.cancel(companyID, sysUsers.getUserId())) {
            return JsonResult.success();
        } else {
            return JsonResult.error("操作失败！请联系技术人员！");
        }
    }

    @ResponseBody
    @RequestMapping("/select")
    public JsonResult select(HttpServletRequest request) throws Exception {

        int pageSize = 10;
        int pageNum = 0;

        Company query = new Company();
        if (StringUtils.isNotEmpty(request.getParameter("ID"))) {
            query.setId(Integer.parseInt(request.getParameter("ID")));
        }
        if (StringUtils.isNotEmpty(request.getParameter("companyName"))) {
            query.setCompanyName(request.getParameter("companyName"));
        }
        if (StringUtils.isNotEmpty(request.getParameter("address"))) {
            query.setAddress(request.getParameter("address"));
        }
        if (StringUtils.isNotEmpty(request.getParameter("phone"))) {
            query.setPhone(request.getParameter("phone"));
        }
        if (StringUtils.isNotEmpty(request.getParameter("status"))) {
            query.setStatus(Integer.parseInt(request.getParameter("status")));
        }
        if (StringUtils.isNotEmpty(request.getParameter("provinceID"))) {
            query.setProvinceId(Integer.parseInt(request.getParameter("provinceID")));
        }
        if (StringUtils.isNotEmpty(request.getParameter("cityID"))) {
            query.setCityId(Integer.parseInt(request.getParameter("cityID")));
        }
        if (StringUtils.isNotEmpty(request.getParameter("areaID"))) {
            query.setAreaId(Integer.parseInt(request.getParameter("areaID")));
        }
        if (StringUtils.isNotEmpty(request.getParameter("pageNum"))) {
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }

        PageInfo<Company> companyPageInfo = iCompanyService.getCompanies(query, pageNum, pageSize);

        return JsonResult.table(companyPageInfo.getList(),companyPageInfo.getTotal());
    }
}
