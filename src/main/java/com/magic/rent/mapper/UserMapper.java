package com.magic.rent.mapper;

import com.magic.rent.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> selectBySelective(User user);

    int insertUser(User user);

    int insertUserSelective(User user);
}