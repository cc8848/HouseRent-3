package com.magic.rent.service.impl;

import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.exception.custom.ParameterException;
import com.magic.rent.mapper.SysUsersMapper;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.BaseService;
import com.magic.rent.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/19
 * 类说明:
 */
@Service
public class UserServiceImpl extends BaseService implements IUserService {

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
    @Cacheable(value = "userCache")
    public SysUsers findSysUserByUserName(String userName) throws Exception {
        return sysUsersMapper.selectByUserName(userName);
    }

    /**
     * 根据用户ID查找用户
     *
     * @param userID
     * @return 用户信息
     */
    @Cacheable(value = "userCache")
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
            throw new ParameterException("用户ID为空");
        if (StringUtils.isEmpty(sysUsers.getLoginIp()))
            throw new ParameterException("用户登录IP为空");
        if (null == sysUsers.getLastLogin())
            throw new ParameterException("用户登录时间为空");
        return sysUsersMapper.updateByPrimaryKeySelective(sysUsers);
    }

    /**
     * 用户注册
     *
     * @param sysUsers
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean register(SysUsers sysUsers) throws Exception {
        if (null != sysUsersMapper.selectByUserName(sysUsers.getUsername())) {
            throw new BusinessException(messageSourceAccessor.getMessage("UserService.UserNameIsExist", "用户名已存在！"));
        }
        //初始化用户信息
        Date createDate = new Date();
        sysUsers.setDtCreate(createDate);//账户创建日期
        sysUsers.setEnabled(true);//账户可用:true-可用,false-不可用
        sysUsers.setAccountNonExpired(true);//账户未过期:true-未过期,false-过期
        sysUsers.setAccountNonLocked(true);//账户未锁定:true-未锁定,false-锁定
        sysUsers.setCredentialsNonExpired(false);//证书未过期:true-未过期,false-过期
        //对密码进行MD5加密
        String passwordMD5 = passwordEncoder.encodePassword(sysUsers.getPassword(), sysUsers.getUsername());
        sysUsers.setPassword(passwordMD5);
        //插入数据库并返回
        int isSuccess = sysUsersMapper.insertSelective(sysUsers);
        if (isSuccess <= 0) {
            throw new BusinessException(messageSourceAccessor.getMessage("", "用户注册失败！"));
        }
        return true;
    }


}
