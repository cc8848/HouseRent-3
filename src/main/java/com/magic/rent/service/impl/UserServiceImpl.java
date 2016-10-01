package com.magic.rent.service.impl;

import com.magic.rent.exception.custom.ParameterException;
import com.magic.rent.mapper.SysUsersMapper;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/19
 * 类说明:
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private SysUsersMapper sysUsersMapper;

    @Autowired
    MessageDigestPasswordEncoder passwordEncoder;

    /**
     * 根据用户名查询用户信息
     *
     * @param userName
     * @return 用户信息
     * @throws Exception
     */
    public SysUsers findSysUserByUserName(String userName) throws Exception {
        return sysUsersMapper.selectByUserName(userName);
    }

    /**
     * 根据用户ID查找用户
     *
     * @param userID
     * @return 用户信息
     */
    public SysUsers findUserByUserID(int userID) throws Exception {
        return sysUsersMapper.selectByPrimaryKey(userID);
    }

    /**
     * 更改用户密码
     *
     * @param sysUsers
     * @return 用户ID
     * @throws Exception
     */
    public int changePassword(SysUsers sysUsers) throws Exception {

        return 0;
    }

    /**
     * 更新用户登录信息
     *
     * @param sysUsers
     * @return 用户ID
     * @throws Exception
     */
    public int updateUserLoginInfo(SysUsers sysUsers) throws Exception {
        if (StringUtils.isEmpty(sysUsers.getUserId()))
            throw new ParameterException("用户ID为空", this);
        if (StringUtils.isEmpty(sysUsers.getLoginIp()))
            throw new ParameterException("用户登录IP为空", this);
        if (null == sysUsers.getLastLogin())
            throw new ParameterException("用户登录时间为空", this);
        return sysUsersMapper.updateByPrimaryKeySelective(sysUsers);
    }

    /**
     * 用户注册
     *
     * @param sysUsers
     * @return
     */
    public int register(SysUsers sysUsers) throws Exception {
        //初始化用户信息
        Date createDate = new Date();
        sysUsers.setDtCreate(createDate);//账户创建日期
        sysUsers.setEnabled(true);//账户可用
        sysUsers.setAccountNonExpired(false);//账户未过期
        sysUsers.setAccountNonLocked(false);//账户不锁定
        sysUsers.setCredentialsNonExpired(true);//证书有效
        //对密码进行MD5加密
        String passwordMD5 = passwordEncoder.encodePassword(sysUsers.getPassword(), sysUsers.getUsername());
        sysUsers.setPassword(passwordMD5);
        //插入数据库并返回
        return sysUsersMapper.insertSelective(sysUsers);
    }


}
