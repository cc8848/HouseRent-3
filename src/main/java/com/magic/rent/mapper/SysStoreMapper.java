package com.magic.rent.mapper;

import com.magic.rent.pojo.SysStore;
import org.springframework.stereotype.Repository;

@Repository
public interface SysStoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysStore record);

    int insertSelective(SysStore record);

    SysStore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysStore record);

    int updateByPrimaryKey(SysStore record);
}