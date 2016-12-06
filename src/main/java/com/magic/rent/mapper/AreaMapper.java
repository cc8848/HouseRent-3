package com.magic.rent.mapper;

import com.magic.rent.pojo.Area;
import com.magic.rent.pojo.SelectPoJo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer id);

    List<SelectPoJo> selectByCityID(int cityID);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}