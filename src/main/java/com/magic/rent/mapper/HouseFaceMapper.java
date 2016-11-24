package com.magic.rent.mapper;

import com.magic.rent.pojo.HouseFaceKey;

public interface HouseFaceMapper {
    int deleteByPrimaryKey(HouseFaceKey key);

    int insert(HouseFaceKey record);

    int insertSelective(HouseFaceKey record);
}