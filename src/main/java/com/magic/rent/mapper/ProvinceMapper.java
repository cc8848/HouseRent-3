package com.magic.rent.mapper;

import com.magic.rent.pojo.Province;
import com.magic.rent.pojo.SelectPoJo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Province record);

    int insertSelective(Province record);

    Province selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);

    List<Province> selectAllAddress();

    List<SelectPoJo> selectAllProvince();
}