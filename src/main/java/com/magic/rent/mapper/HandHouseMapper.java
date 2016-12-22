package com.magic.rent.mapper;

import com.magic.rent.pojo.HandHouse;
import com.magic.rent.pojo.HandHouseBase;
import com.magic.rent.pojo.HandHouseDetail;
import com.magic.rent.pojo.HandHousePrice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HandHouseMapper {

    int deleteByPrimaryKey(Integer houseId);

    int insert(HandHouseDetail handHouseDetail);

    int insertSelective(HandHouseDetail handHouseDetail);

    HandHouse selectBaseByPrimaryKey(Integer houseId);

    HandHouseDetail selectByPrimaryKey(Integer houseId);

    List<HandHouseDetail> selectBySelective(HandHouseDetail handHouseDetail);

    int updateByPrimaryKeySelective(HandHouseDetail handHouseDetail);

    int updateByPrimaryKeyForDetail(HandHouseDetail handHouseDetail);

    int updateByPrimaryKeyForBase(HandHouseBase handHouseBase);

    int updateByPrimaryKeyWithPrice(HandHousePrice handHousePrice);

    int updateByPrimaryKey(HandHouse handHouse);
}