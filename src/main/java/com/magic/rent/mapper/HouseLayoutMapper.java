package com.magic.rent.mapper;

import com.magic.rent.pojo.HouseLayout;

public interface HouseLayoutMapper {
    int deleteByPrimaryKey(int id);

    int insert(HouseLayout record);

    int insertSelective(HouseLayout record);

    HouseLayout selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(HouseLayout record);

    int updateByPrimaryKey(HouseLayout record);
}