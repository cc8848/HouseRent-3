package com.magic.rent.mapper;

import com.magic.rent.pojo.SysAuthorities;

public interface SysAuthoritiesMapper {
    int deleteByPrimaryKey(Integer authorityId);

    int insert(SysAuthorities record);

    int insertSelective(SysAuthorities record);

    SysAuthorities selectByPrimaryKey(Integer authorityId);

    int updateByPrimaryKeySelective(SysAuthorities record);

    int updateByPrimaryKey(SysAuthorities record);
}