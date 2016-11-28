package com.magic.rent.mapper;

import com.magic.rent.pojo.HouseElevator;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseElevatorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseElevator record);

    int insertSelective(HouseElevator record);

    HouseElevator selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseElevator record);

    int updateByPrimaryKey(HouseElevator record);
}