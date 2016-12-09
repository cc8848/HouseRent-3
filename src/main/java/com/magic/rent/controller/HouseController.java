package com.magic.rent.controller;

import com.github.pagehelper.PageInfo;
import com.magic.rent.controller.base.BaseController;
import com.magic.rent.pojo.*;
import com.magic.rent.service.ICommunityService;
import com.magic.rent.service.ICompanyService;
import com.magic.rent.service.IHouseService;
import com.magic.rent.util.HttpUtil;
import com.magic.rent.pojo.JsonResult;
import com.magic.rent.util.MyStringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: WuXinZhe   创建时间: 2016/10/13
 * 类说明:
 */
@Controller
@RequestMapping("/house")
public class HouseController extends BaseController {

    @Autowired
    private IHouseService iHouseService;

    @Autowired
    private ICommunityService iCommunityService;

    @Autowired
    private ICompanyService iCompanyService;

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public JsonResult issueHouse(HttpServletRequest request) throws Exception {

        SysUsers sysUsers = HttpUtil.getSessionUser(request);

        //获取参数
        String tittle = MyStringUtil.checkParameter(request.getParameter("tittle"), "标题不能为空！");
        String desc = MyStringUtil.checkParameter(request.getParameter("desc"), "描述不能为空！");
        int faceID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("faceID"), "朝向不能为空！"));
        String address = MyStringUtil.checkParameter(request.getParameter("address"), "地址不能为空！");
        double floorArea = Double.parseDouble(MyStringUtil.checkParameter(request.getParameter("floorArea"), "建筑面积不能为空！"));
        double poolArea = Double.parseDouble(MyStringUtil.checkParameter(request.getParameter("poolArea"), "公摊面积不能为空！"));
        double price = Double.parseDouble(MyStringUtil.checkParameter(request.getParameter("price"), "售价不能为空！"));
        int floor = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("floor"), "楼层不能为空！"));
        int layout = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("layout"), "房屋布局不能为空！"));
        int decorationType = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("decorationType"), "装修种类不能为空！"));
        int province = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("province"), "省份不能为空！"));
        int city = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("city"), "城市不能为空！"));
        int area = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("area"), "地区不能为空！"));
        int houseStatus = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("houseStatus"), "房屋状态不能为空！"));
        int communityID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("communityID"), "项目编号不能为空！"));
        int age = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("age"), "产权年限不能为空！"));
        Double brokerage = Double.parseDouble(MyStringUtil.checkParameter(request.getParameter("brokerage"), "佣金不能为空！"));
        int elevatorTypeID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("elevatorType"), "梯户类型不能为空！"));

        //封装对象
        House house = new House();
        house.setTittle(tittle);
        house.setDescription(desc);
        house.setAddress(address);
        house.setFloorArea(floorArea);
        house.setPoolArea(poolArea);
        house.setFaceId(faceID);
        house.setExpectPrice(price);
        house.setFloor(floor);
        house.setLayoutId(layout);
        house.setHouseDecorationId(decorationType);
        house.setProvinceId(province);
        house.setCityId(city);
        house.setAreaId(area);
        house.setHouseStatus(houseStatus);
        house.setCommunityId(communityID);
        house.setAge(age);
        house.setBrokerage(brokerage);
        house.setElevatorTypeId(elevatorTypeID);

        if (iHouseService.create(house, sysUsers.getUserId())) {
            return JsonResult.success().setMessage("发布成功，请等待审核！");
        } else {
            return JsonResult.error("添加失败，请联系管理员！");
        }
    }

    @ResponseBody
    @RequestMapping("/myHouse")
    public JsonResult getMyHouse(HttpServletRequest request) throws Exception {
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

        Integer companyID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("companyID"), "公司编号不能为空！"));

        if (null == request.getParameter("communityID")) {
            PageInfo<House> housePageInfo = iHouseService.getAllHouses(companyID, pageSize, pageNum);
            return JsonResult.success(housePageInfo);
        } else {
            Integer communityID = Integer.parseInt(request.getParameter("communityID"));
            PageInfo<House> housePageInfo = iHouseService.getCommunityHouses(communityID, pageSize, pageNum);
            return JsonResult.success(housePageInfo);
        }
    }

    @RequestMapping("/detail")
    public ModelAndView detail(HttpServletRequest request) throws Exception {

        ModelAndView modelAndView = new ModelAndView("house_sell");
        Integer houseID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("houseID"), "房屋编号不能为空！"));
        House house = iHouseService.getDetail(houseID);
        modelAndView.addObject("house", house);
        if (null != house) {
            int communityID = house.getCommunity().getId();
            Community community = iCommunityService.getDetail(communityID);
            modelAndView.addObject("community", community);
            Company company = iCompanyService.getDetail(community.getCompanyId());
            modelAndView.addObject("company", company);
        }
        return modelAndView;
    }
}
