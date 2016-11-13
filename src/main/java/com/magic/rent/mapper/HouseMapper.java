package com.magic.rent.mapper;

import com.magic.rent.pojo.Community;
import com.magic.rent.pojo.House;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface HouseMapper {
    int deleteByPrimaryKey(int id);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    List<House> selectByCommunity(Community community);

    List<House> selectBySearchTerms(Map<String, Object> terms);

    House selectHouseDetailByID(int id);

    List<House> selectSameHouse(House record);
}