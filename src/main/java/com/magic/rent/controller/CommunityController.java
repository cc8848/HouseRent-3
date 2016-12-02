package com.magic.rent.controller;

import com.github.pagehelper.PageInfo;
import com.magic.rent.pojo.Community;
import com.magic.rent.pojo.SelectPoJo;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.ICommunityService;
import com.magic.rent.util.HttpUtil;
import com.magic.rent.util.JsonResult;
import com.magic.rent.util.MyStringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/11/28
 * 类说明:社区控制器
 * 更新记录：
 */
@Controller
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private ICommunityService iCommunityService;

    @ResponseBody
    @RequestMapping(value = "/create", method = {RequestMethod.POST})
    public JsonResult create(HttpServletRequest request) throws Exception {

        SysUsers sysUsers = HttpUtil.getSessionUser(request);
        String communityName = MyStringUtil.checkParameter(request.getParameter("communityName"), "社区名称不能为空！");
        Integer provinceID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("provinceID"), "省份ID不能为空！"));
        Integer cityID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("cityID"), "城市ID不能为空！"));
        Integer areaID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("areaID"), "地区ID不能为空！"));
        Double lng = Double.parseDouble(MyStringUtil.checkParameter(request.getParameter("lng"), "地图数据获取失败！"));
        Double lat = Double.parseDouble(MyStringUtil.checkParameter(request.getParameter("lat"), "地图数据获取失败！"));
        String openTimeString = request.getParameter("openTime");
        String realEstateTimeString = request.getParameter("realEstateTime");
        String estateManageCompany = request.getParameter("estateManageCompany");
        String address = MyStringUtil.checkParameter(request.getParameter("address"), "地址不能为空！");

        Community community = new Community();
        community.setProvinceId(provinceID);
        community.setCityId(cityID);
        community.setAreaId(areaID);
        community.setName(communityName);
        community.setLng(lng);
        community.setLat(lat);
        community.setAddress(address);
        if (!StringUtils.isEmpty(openTimeString)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date openTime = dateFormat.parse(openTimeString);
            community.setOpenTime(openTime);
        }
        if (!StringUtils.isEmpty(realEstateTimeString)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date realEstateTime = dateFormat.parse(realEstateTimeString);
            community.setRealEstateTime(realEstateTime);
        }
        if (!StringUtils.isEmpty(estateManageCompany)) {
            community.setEstateManageCompany(estateManageCompany);
        }
        boolean isSuccess = iCommunityService.create(community, sysUsers.getUserId());

        if (isSuccess) {
            return JsonResult.success().setMessage("申请提交成功，等待审核。");
        } else {
            return JsonResult.error("创建社区项目失败！");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public JsonResult cancel(HttpServletRequest request) throws Exception {
        Integer communityID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("communityID"), "社区编号不能为空！"));
        SysUsers sysUsers = HttpUtil.getSessionUser(request);

        boolean isSuccess = iCommunityService.cancel(communityID, sysUsers.getUserId());

        if (isSuccess) {
            return JsonResult.success().setMessage("操作成功！");
        } else {
            return JsonResult.error("取消项目申请失败！");
        }

    }

    @ResponseBody
    @RequestMapping("/pass")
    public JsonResult pass(HttpServletRequest request) throws Exception {
        Integer communityID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("communityID"), "社区编号不能为空！"));
        boolean isSuccess = iCommunityService.pass(communityID);

        if (isSuccess) {
            return JsonResult.success();
        } else {
            return JsonResult.error("通过项目申请失败！");
        }
    }

    @ResponseBody
    @RequestMapping("/refuse")
    public JsonResult refuse(HttpServletRequest request) throws Exception {
        Integer communityID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("communityID"), "社区编号不能为空！"));
        boolean isSuccess = iCommunityService.refuse(communityID);

        if (isSuccess) {
            return JsonResult.success();
        } else {
            return JsonResult.error("取消申请拒绝失败！");
        }
    }

    /**
     * 获取分类社区清单，不区分用户
     *
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/classify")
    public JsonResult getClassify(HttpServletRequest request) throws Exception {
        Integer status = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("status"), "状态不能为空！"));
        Integer pageNum = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("pageNum"), "查询页数不能为空！"));
        Integer pageSize = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("pageSize"), "查询笔数不能为空！"));
        Integer userID = null;
        if (StringUtils.isNotEmpty(request.getParameter("userID"))) {
            userID = Integer.parseInt(request.getParameter("userID"));
        }

        PageInfo<Community> communityPageInfo = iCommunityService.getClassifyCommunities(status, userID, pageNum, pageSize);
        return JsonResult.success(communityPageInfo);
    }

    /**
     * 开发商获取审核成功项目的清单，主要用于下拉列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/success")
    public JsonResult getSuccess(HttpServletRequest request) throws Exception {
        SysUsers sysUsers = HttpUtil.getSessionUser(request);
        List<Community> communityList = iCommunityService.getSuccessCommunities(sysUsers.getUserId());
        return JsonResult.success(communityList);
    }

    /**
     * 获取分类清单，区分用户
     *
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/myClassify")
    public JsonResult getMyClassify(HttpServletRequest request) throws Exception {

        Integer status = null;
        Integer pageNum = 0;
        Integer pageSize = 10;

        if (StringUtils.isNotEmpty(request.getParameter("status"))) {
            status = Integer.parseInt(request.getParameter("status"));
        }
        if (StringUtils.isNotEmpty(request.getParameter("pageNum"))) {
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }
        if (StringUtils.isNotEmpty(request.getParameter("pageSize"))) {
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        }

        SysUsers sysUsers = HttpUtil.getSessionUser(request);

        PageInfo<Community> communityPageInfo = iCommunityService.getClassifyCommunities(status, sysUsers.getUserId(), pageNum, pageSize);

        return JsonResult.success(communityPageInfo);
    }

    @ResponseBody
    @RequestMapping("/select")
    public JsonResult getSuccessSelect(HttpServletRequest request) throws Exception {
        SysUsers sysUsers = HttpUtil.getSessionUser(request);

        List<SelectPoJo> selectPoJos = iCommunityService.getSuccessCommunitiesForSelect(sysUsers.getUserId());

        return JsonResult.success(selectPoJos);
    }
}
