package com.magic.rent.service.impl;

import com.magic.rent.exception.custom.ParameterException;
import com.magic.rent.mapper.SysUsersMapper;
import com.magic.rent.pojo.SysRoles;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/19
 * 类说明:
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private SysUsersMapper sysUsersMapper;


    public SysUsers findSysUserByUserName(String userName) {

        SysUsers sysUsers = sysUsersMapper.selectByUserName(userName);

        List<SysRoles> sysRolesList = sysUsersMapper.selectRolesByUserId(sysUsers.getUserId());

        sysUsers.setSysRoles(sysRolesList);

        return sysUsers;
    }

    public int updateUserLoginInfo(SysUsers sysUsers) {
        if (StringUtils.isEmpty(sysUsers.getUserId()))
            throw new ParameterException("用户ID为空", this);
        if (StringUtils.isEmpty(sysUsers.getLoginIp()))
            throw new ParameterException("用户登录IP为空", this);
        if (null == sysUsers.getLastLogin())
            throw new ParameterException("用户登录时间为空", this);

        int userID = sysUsersMapper.updateByPrimaryKeySelective(sysUsers);
        return userID;
    }

    public int updateUserInfo(SysUsers sysUsers) {

        int userID = sysUsersMapper.updateByPrimaryKeySelective(sysUsers);

        return userID;
    }
}
