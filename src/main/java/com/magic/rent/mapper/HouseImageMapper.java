package com.magic.rent.mapper;

import com.magic.rent.pojo.HouseImage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseImageMapper {
    int deleteByPrimaryKey(Integer imageId);

    int insert(HouseImage record);

    int insertSelective(HouseImage record);

    HouseImage selectByPrimaryKey(Integer imageId);

    int updateByPrimaryKeySelective(HouseImage record);

    int updateByPrimaryKey(HouseImage record);

    HouseImage selectByImageAndUserID(HouseImage houseImage);
}