package com.magic.rent.mapper;

import com.magic.rent.pojo.HouseFace;

public interface HouseFaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseFace record);

    int insertSelective(HouseFace record);

    HouseFace selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseFace record);

    int updateByPrimaryKey(HouseFace record);
}