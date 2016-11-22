package com.magic.rent.mapper;

import com.magic.rent.pojo.SysScene;

public interface SysSceneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysScene record);

    int insertSelective(SysScene record);

    SysScene selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysScene record);

    int updateByPrimaryKey(SysScene record);
}