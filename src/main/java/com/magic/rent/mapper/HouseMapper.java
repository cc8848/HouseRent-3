package com.magic.rent.mapper;

import com.magic.rent.pojo.House;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseMapper {
    int deleteByPrimaryKey(int id);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);
}