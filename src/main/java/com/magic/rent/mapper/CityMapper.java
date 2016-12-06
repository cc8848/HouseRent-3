package com.magic.rent.mapper;

import com.magic.rent.pojo.City;
import com.magic.rent.pojo.Province;
import com.magic.rent.pojo.SelectPoJo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);

    List<SelectPoJo> selectByProvinceID(Integer provinceID);

    List<SelectPoJo> selectAllCity();

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}