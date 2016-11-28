package com.magic.rent.mapper;

import com.magic.rent.pojo.HouseDecoration;

public interface HouseDecorationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseDecoration record);

    int insertSelective(HouseDecoration record);

    HouseDecoration selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseDecoration record);

    int updateByPrimaryKey(HouseDecoration record);
}