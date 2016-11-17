package com.magic.rent.mapper;

import com.magic.rent.pojo.UserSeller;

public interface UserSellerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserSeller record);

    int insertSelective(UserSeller record);

    UserSeller selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserSeller record);

    int updateByPrimaryKey(UserSeller record);
}