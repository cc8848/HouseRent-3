package com.magic.rent.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.magic.rent.exception.custom.AuthorityOverstepException;
import com.magic.rent.exception.custom.TargetNotFoundException;
import com.magic.rent.mapper.HandHouseMapper;
import com.magic.rent.pojo.HandHouse;
import com.magic.rent.pojo.HandHouseDetail;
import com.magic.rent.pojo.HandHousePrice;
import com.magic.rent.service.IHandHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: Wu   创建时间: 2016/12/22
 * 类说明: 二手房相关服务实现
 * 更新记录：
 */
@Service
public class HandHouseService implements IHandHouseService {

    @Autowired
    private HandHouseMapper handHouseMapper;

    public PageInfo<HandHouseDetail> getHandHouseByUser(Integer userID, int pageSize, int pageNum) throws Exception {
        HandHouseDetail houseDetail = new HandHouseDetail();
        houseDetail.setUserId(userID);
        PageHelper.startPage(pageNum, pageSize);
        List<HandHouseDetail> houseDetailList = handHouseMapper.selectBySelective(houseDetail);
        return new PageInfo<HandHouseDetail>(houseDetailList);
    }

    public boolean issueHouse(HandHouseDetail handHouseDetail) throws Exception {
        return handHouseMapper.insert(handHouseDetail) > 0;
    }

    public boolean deleteHouse(Integer houseID, Integer userID) throws Exception {
        HandHouse handHouse = handHouseMapper.selectBaseByPrimaryKey(houseID);
        if (null == handHouse) {//判断房源是否存在
            throw new TargetNotFoundException("对应房源不存在！");
        } else if (!handHouse.getUserId().equals(userID)) {//判断房屋对应的用户ID是否与当前操作用户相同
            throw new AuthorityOverstepException("您没有权限删除他人的房源！");
        } else {
            return handHouseMapper.deleteByPrimaryKey(houseID) > 0;
        }
    }

    public boolean modifyPrice(HandHousePrice housePrice) throws Exception {
        HandHouse handHouse = handHouseMapper.selectBaseByPrimaryKey(housePrice.getHouseId());
        if (null == handHouse) {
            throw new TargetNotFoundException("对应房源不存在！");
        } else if (!handHouse.getUserId().equals(housePrice.getUserId())) {//判断房屋对应的用户ID是否与当前操作用户相同
            throw new AuthorityOverstepException("您没有权限修改他人的房源！");
        } else {
            return handHouseMapper.updateByPrimaryKeyWithPrice(housePrice) > 0;
        }
    }

}
