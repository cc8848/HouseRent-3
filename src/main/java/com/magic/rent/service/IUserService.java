package com.magic.rent.service;

import com.magic.rent.pojo.SysUsers;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/19
 * 类说明:
 */
public interface IUserService {

    SysUsers findSysUserByUserName(String userName) throws Exception;

    SysUsers findUserByUserID(int userID) throws Exception;

    int changePassword(SysUsers sysUsers) throws Exception;

    int updateUserLoginInfo(SysUsers sysUsers) throws Exception;

    int register(SysUsers sysUsers) throws Exception;


}
