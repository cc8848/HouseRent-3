package com.magic.rent.mapper;

import com.magic.rent.pojo.HouseRelateUser;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRelateUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseRelateUser record);

    int insertSelective(HouseRelateUser record);

    HouseRelateUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseRelateUser record);

    int updateByPrimaryKey(HouseRelateUser record);
}