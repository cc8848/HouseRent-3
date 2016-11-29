package com.magic.rent.controller;

import com.magic.rent.pojo.Community;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.ICommunityService;
import com.magic.rent.util.HttpUtil;
import com.magic.rent.util.JsonResult;
import com.magic.rent.util.MyStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

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


    @RequestMapping(value = "/create", method = {RequestMethod.POST})
    public JsonResult create(HttpServletRequest request) throws Exception {

        SysUsers sysUsers = HttpUtil.getSessionUser(request);

        String communityName = MyStringUtil.checkParameter(request.getParameter("communityName"), "社区名称不能为空！");

        Integer provinceID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("provinceID"), "省份ID不能为空！"));

        Integer cityID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("cityID"), "城市ID不能为空！"));

        Integer areaID = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("areaID"), "地区ID不能为空！"));

        Double mapX = Double.parseDouble(MyStringUtil.checkParameter(request.getParameter("mapX"), "地图数据获取失败！"));

        Double mapY = Double.parseDouble(MyStringUtil.checkParameter(request.getParameter("mapY"), "地图数据获取失败！"));

        Community community = new Community();
        community.setProvinceId(provinceID);
        community.setCityId(cityID);
        community.setAreaId(areaID);
        community.setName(communityName);
        community.setMapX(mapX);
        community.setMapY(mapY);

        boolean isSuccess = iCommunityService.create(community, sysUsers.getUserId());

        return JsonResult.success();
    }
}
