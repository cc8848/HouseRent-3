package com.magic.rent.mapper;

import com.magic.rent.pojo.HouseFile;

public interface HouseFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseFile record);

    int insertSelective(HouseFile record);

    HouseFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseFile record);

    int updateByPrimaryKey(HouseFile record);
}