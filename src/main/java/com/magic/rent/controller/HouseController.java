package com.magic.rent.controller;

import com.github.pagehelper.PageInfo;
import com.magic.rent.exception.custom.ParameterException;
import com.magic.rent.pojo.Community;
import com.magic.rent.pojo.House;
import com.magic.rent.pojo.HouseRecommend;
import com.magic.rent.service.IHouseRecommendService;
import com.magic.rent.service.IHouseService;
import com.magic.rent.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wuxinzhe   创建时间: 2016/10/13
 * 类说明:
 */
@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private IHouseService iHouseService;

    @Autowired
    private IHouseRecommendService iHouseRecommendService;

    @Autowired
    private MessageSourceAccessor messageSourceAccessor;

    @ResponseBody
    @RequestMapping("/selectHousesByCommunity")
    public JsonResult selectHousesByCommunity(HttpServletRequest request, HttpServletResponse response) {
        //参数校验
        if (StringUtils.isEmpty(request.getParameter("pageNum")))
            throw new ParameterException(messageSourceAccessor.getMessage("PageHelper.pageNumNotNull", "查询页码不能为空!"));
        if (StringUtils.isEmpty(request.getParameter("pageSize")))
            throw new ParameterException(messageSourceAccessor.getMessage("PageHelper.pageSizeNotNull", "查询笔数不能为空!"));
        if (StringUtils.isEmpty(request.getParameter("communityName")))
            throw new ParameterException(messageSourceAccessor.getMessage("HouseService.communityNameNotNull", "社区名称不能为空!"));

        //获取参数
        int pageNum = Integer.valueOf(request.getParameter("pageNum").trim());
        int pageSize = Integer.valueOf(request.getParameter("pageSize").trim());
        String communityName = request.getParameter("communityName");

        //封装条件对象
        Community community = new Community();
        community.setName(communityName);

        //数据查询
        PageInfo<House> housePageInfo = iHouseService.selectByCommunity(community, pageNum, pageSize);

        return JsonResult.success("", housePageInfo);
    }

    @ResponseBody
    @RequestMapping("/selectHousesListBySearchTerms")
    public JsonResult selectHousesListBySearchTerms(HttpServletRequest request, HttpServletResponse response) {
        //参数校验
        if (StringUtils.isEmpty(request.getParameter("pageNum")))
            throw new ParameterException(messageSourceAccessor.getMessage("PageHelper.pageNumNotNull", "其实笔数不能为空!"));
        if (StringUtils.isEmpty(request.getParameter("pageSize")))
            throw new ParameterException(messageSourceAccessor.getMessage("PageHelper.pageSizeNotNull", "查询笔数不能为空!"));

        //创建参数载体
        Map<String, Object> parameterMap = new HashMap<String, Object>();

        int pageNum = Integer.valueOf(request.getParameter("pageNum"));
        int pageSize = Integer.valueOf(request.getParameter("pageSize"));

        if (!StringUtils.isEmpty(request.getParameter("minRent")))
            parameterMap.put("minRent", Double.valueOf(request.getParameter("minRent")));

        if (!StringUtils.isEmpty(request.getParameter("maxRent")))
            parameterMap.put("maxRent", Double.valueOf(request.getParameter("maxRent")));

        if (!StringUtils.isEmpty(request.getParameter("areaName")))
            parameterMap.put("areaName", request.getParameter("areaName"));

        if (!StringUtils.isEmpty(request.getParameter("roomNum")))
            parameterMap.put("roomNum", request.getParameter("roomNum"));

        if (!StringUtils.isEmpty(request.getParameter("rentMode")))
            parameterMap.put("rentMode", request.getParameter("rentMode"));

        //查询信息
        PageInfo<House> housePageInfo = iHouseService.selectBySearchTerms(parameterMap, pageNum, pageSize);

        return JsonResult.success("", housePageInfo);
    }

    @RequestMapping("/selectHouseDetailByHouseID")
    public ModelAndView selectHouseDetailByHouseID(HttpServletRequest request, HttpServletResponse response) {


        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/selectRecommend")
    public JsonResult selectRecommend(HttpServletRequest request, HttpServletResponse response) {

        HouseRecommend houseRecommend = iHouseRecommendService.selectTodayRecommend();

        return JsonResult.success(houseRecommend);
    }
}
