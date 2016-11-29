package com.magic.rent.mapper;

import com.magic.rent.pojo.AuditingStatus;

public interface AuditingStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuditingStatus record);

    int insertSelective(AuditingStatus record);

    AuditingStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuditingStatus record);

    int updateByPrimaryKey(AuditingStatus record);
}