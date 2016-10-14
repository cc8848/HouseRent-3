package com.magic.rent.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.magic.rent.exception.custom.ParameterException;
import com.magic.rent.mapper.HouseMapper;
import com.magic.rent.pojo.Community;
import com.magic.rent.pojo.House;
import com.magic.rent.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wuxinzhe   创建时间: 2016/10/13
 * 类说明:
 */
@Service
public class HouseServiceImpl implements IHouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Autowired
    private MessageSourceAccessor messageSourceAccessor;

    public PageInfo<House> selectHousesByCommunity(Community community, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<House> houseList = houseMapper.selectByCommunity(community);
        PageInfo<House> housePageInfo = new PageInfo<House>(houseList);

        return housePageInfo;
    }

    public PageInfo<House> selectBySearchTerms(Map<String, Object> parameterMap, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<House> houseList = houseMapper.selectBySearchTerms(parameterMap);
        PageInfo<House> housePageInfo = new PageInfo<House>(houseList);
        return housePageInfo;
    }
}
