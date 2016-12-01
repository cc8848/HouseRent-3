package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.pojo.*;
import com.magic.rent.service.IHouseRecommendService;
import com.magic.rent.service.IHouseService;
import com.magic.rent.util.HttpUtil;
import com.magic.rent.util.JsonResult;
import com.magic.rent.util.MyStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
    private IHouseRecommendService iHouseRecommendService;

    @ResponseBody
    @RequestMapping("/selectRecommend")//获取推荐楼房信息
    public JsonResult selectRecommend() throws Exception {

        HouseRecommend houseRecommend = iHouseRecommendService.selectTodayRecommend();

        return JsonResult.success(houseRecommend);
    }

    @ResponseBody
    @RequestMapping(value = "/issue", method = {RequestMethod.POST})
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
        int status = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("status"), "房屋状态不能为空！"));

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
        house.setHouseStatusId(status);
        house.setEnabled(false);//待后台审核后可修改为可用

        //写入房屋数据
        int houseID = iHouseService.issueHouse(house, sysUsers.getUserId());

        return JsonResult.success("添加成功").setData(houseID);
    }

    @RequestMapping("/sell")
    public ModelAndView getSellHouseDetails(HttpServletRequest request) throws Exception {
        int houseID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("houseID"), "房屋编号不能为空！"));
        Map<String, Object> dataMap = iHouseService.showHouseDetails(houseID);
        House house = (House) dataMap.get("house");
        Company company = (Company) dataMap.get("company");
        return new ModelAndView("house_sell").addObject("house", house).addObject("company", company);
    }
}
