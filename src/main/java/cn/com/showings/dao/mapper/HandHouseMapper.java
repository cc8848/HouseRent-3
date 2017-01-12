package cn.com.showings.dao.mapper;

import cn.com.showings.pojo.HandHouse;
import cn.com.showings.pojo.HandHouseInfo;
import cn.com.showings.pojo.HandHouseDetail;
import cn.com.showings.pojo.HandHousePrice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HandHouseMapper {

    int deleteByPrimaryKey(Integer houseId);

    int insert(HandHouseInfo handHouseInfo);

    int insertSelective(HandHouseInfo handHouseInfo);

    HandHouse selectBaseByPrimaryKey(Integer houseId);

    HandHouseDetail selectByPrimaryKey(Integer houseId);

    List<HandHouseInfo> selectBySelective(HandHouseInfo handHouseInfo);

    int updateByPrimaryKeySelective(HandHouseInfo handHouseInfo);

    int updateByPrimaryKeyForDetail(HandHouseDetail handHouseDetail);

    int updateByPrimaryKeyForInfo(HandHouseInfo handHouseInfo);

    int updateByPrimaryKeyForPrice(HandHousePrice handHousePrice);

    int updateByPrimaryKeyForBase(HandHouse handHouse);
}