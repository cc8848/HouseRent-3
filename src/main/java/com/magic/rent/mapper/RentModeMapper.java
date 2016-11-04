package com.magic.rent.mapper;

import com.magic.rent.pojo.RentMode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentModeMapper {
    int deleteByPrimaryKey(int id);

    int insert(RentMode record);

    int insertSelective(RentMode record);

    RentMode selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(RentMode record);

    int updateByPrimaryKey(RentMode record);

    List<RentMode> selectByHouseID(int houseID);
}