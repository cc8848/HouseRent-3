package com.magic.rent.mapper;

import com.magic.rent.pojo.UserSeller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSellerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserSeller record);

    int insertSelective(UserSeller record);

    UserSeller selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserSeller record);

    int updateByPrimaryKey(UserSeller record);

    List<UserSeller> selectBySelective(UserSeller query);
}