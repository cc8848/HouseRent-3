package com.magic.rent.mapper;

import com.magic.rent.pojo.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer id);

    List<Area> selectByCityName(String cityName);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}