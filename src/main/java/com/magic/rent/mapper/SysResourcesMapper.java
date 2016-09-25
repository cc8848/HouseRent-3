package com.magic.rent.mapper;


import com.magic.rent.pojo.SysResources;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysResourcesMapper {
    int deleteByPrimaryKey(Integer resourceId);

    int insert(SysResources record);

    int insertSelective(SysResources record);

    SysResources selectByPrimaryKey(Integer resourceId);

    int updateByPrimaryKeySelective(SysResources record);

    int updateByPrimaryKey(SysResources record);

    List<Map<String, String>> getURLResourceMapping();

    List<Map<String,String>> getMethodResourceMapping();
}