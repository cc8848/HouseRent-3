package com.magic.rent.service.impl;

import com.magic.rent.mapper.UserMapper;
import com.magic.rent.pojo.User;
import com.magic.rent.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/19
 * 类说明:
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserByID(User user) throws Exception {
        List<User> userList = userMapper.selectBySelective(user);
        return userList.get(0);
    }

    public boolean phoneIsExist(User user) throws Exception {
        List<User> userList = userMapper.selectBySelective(user);
        return userList.size() > 0;
    }

    public User loginCheck(User user) throws Exception {
        List<User> userList = userMapper.selectBySelective(user);
        if (null != userList && userList.size() == 1) {
            return userList.get(0);
        } else {
            return null;
        }
    }


}
