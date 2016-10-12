package com.magic.rent.mapper;

import com.magic.rent.pojo.Rooms;

public interface RoomsMapper {
    int deleteByPrimaryKey(int id);

    int insert(Rooms record);

    int insertSelective(Rooms record);

    Rooms selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(Rooms record);

    int updateByPrimaryKey(Rooms record);
}