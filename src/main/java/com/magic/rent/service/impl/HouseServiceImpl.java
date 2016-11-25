package com.magic.rent.service.impl;

import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.mapper.HouseMapper;
import com.magic.rent.mapper.HouseRelateUserMapper;
import com.magic.rent.pojo.House;
import com.magic.rent.pojo.HouseRelateUser;
import com.magic.rent.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    private HouseRelateUserMapper houseRelateUserMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int issueHouse(House house, int userID) {
        int houseRows = houseMapper.insertSelective(house);

        if (houseRows <= 0) {
            throw new BusinessException("添加房屋信息失败！");
        }

        HouseRelateUser relate = new HouseRelateUser();
        relate.setUserId(userID);
        relate.setHouseId(house.getId());

        int relaterows = houseRelateUserMapper.insert(relate);

        if (relaterows <= 0) {
            throw new BusinessException("建立房屋与用户关系失败！");
        }

        return house.getId();
    }
}
