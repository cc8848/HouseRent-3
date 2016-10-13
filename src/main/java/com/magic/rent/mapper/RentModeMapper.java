package com.magic.rent.mapper;

import com.magic.rent.pojo.RentMode;

public interface RentModeMapper {
    int deleteByPrimaryKey(int id);

    int insert(RentMode record);

    int insertSelective(RentMode record);

    RentMode selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(RentMode record);

    int updateByPrimaryKey(RentMode record);
}