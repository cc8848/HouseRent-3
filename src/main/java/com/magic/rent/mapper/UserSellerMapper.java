package com.magic.rent.mapper;

import com.magic.rent.pojo.UserSeller;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSellerMapper {
    int deleteByPrimaryKey(int id);

    int insert(UserSeller record);

    int insertSelective(UserSeller record);

    UserSeller selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(UserSeller record);

    int updateByPrimaryKey(UserSeller record);

    UserSeller selectByUserID(int userID);
}