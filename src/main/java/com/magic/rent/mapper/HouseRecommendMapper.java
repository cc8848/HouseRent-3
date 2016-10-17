package com.magic.rent.mapper;

import com.magic.rent.pojo.HouseRecommend;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRecommendMapper {
    int deleteByPrimaryKey(int id);

    int insert(HouseRecommend record);

    int insertSelective(HouseRecommend record);

    HouseRecommend selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(HouseRecommend record);

    int updateByPrimaryKey(HouseRecommend record);

    HouseRecommend selectByRecommendDate(HouseRecommend record);

}