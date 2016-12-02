package com.magic.rent.mapper;

import com.magic.rent.pojo.SysStatus;

public interface SysStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysStatus record);

    int insertSelective(SysStatus record);

    SysStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysStatus record);

    int updateByPrimaryKey(SysStatus record);
}