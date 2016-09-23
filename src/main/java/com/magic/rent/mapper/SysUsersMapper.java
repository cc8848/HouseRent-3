package com.magic.rent.mapper;


import com.magic.rent.pojo.SysUsers;

public interface SysUsersMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(SysUsers record);

    int insertSelective(SysUsers record);

    SysUsers selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SysUsers record);

    int updateByPrimaryKey(SysUsers record);
}