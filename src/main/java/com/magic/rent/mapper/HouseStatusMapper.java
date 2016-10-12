package com.magic.rent.mapper;

import com.magic.rent.pojo.HouseStatus;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseStatusMapper {
    int deleteByPrimaryKey(int id);

    int insert(HouseStatus record);

    int insertSelective(HouseStatus record);

    HouseStatus selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(HouseStatus record);

    int updateByPrimaryKey(HouseStatus record);
}