package com.magic.rent.mapper;


import com.magic.rent.pojo.SysResources;

public interface SysResourcesMapper {
    int deleteByPrimaryKey(Integer resourceId);

    int insert(SysResources record);

    int insertSelective(SysResources record);

    SysResources selectByPrimaryKey(Integer resourceId);

    int updateByPrimaryKeySelective(SysResources record);

    int updateByPrimaryKey(SysResources record);
}