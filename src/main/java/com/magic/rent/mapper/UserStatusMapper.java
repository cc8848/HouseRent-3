package com.magic.rent.mapper;

import com.magic.rent.pojo.UserStatus;

public interface UserStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserStatus record);

    int insertSelective(UserStatus record);

    UserStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserStatus record);

    int updateByPrimaryKey(UserStatus record);
}