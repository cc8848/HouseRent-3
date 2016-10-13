package com.magic.rent.mapper;

import com.magic.rent.pojo.DecorationType;

public interface DecorationTypeMapper {
    int deleteByPrimaryKey(int id);

    int insert(DecorationType record);

    int insertSelective(DecorationType record);

    DecorationType selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(DecorationType record);

    int updateByPrimaryKey(DecorationType record);
}