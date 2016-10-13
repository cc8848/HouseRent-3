package com.magic.rent.service.impl;

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

    public List<House> selectHouseByCommunity(Community community) {
        if (StringUtils.isEmpty(community.getName()))
            throw new ParameterException(messageSourceAccessor.getMessage("HouseService.CommunityNameNotNull", "社区名称不能为空!"));

        List<House> houseList = houseMapper.selectByCommunity(community);

        return houseList;
    }
}
