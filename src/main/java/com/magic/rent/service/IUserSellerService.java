package com.magic.rent.service;

import com.magic.rent.pojo.SysUsers;
import com.magic.rent.pojo.UserSeller;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: Wu   创建时间: 16/10/6
 * 类说明:销售员服务
 */
public interface IUserSellerService {

    UserSeller selectSellerInfoByUserID(int userID) throws Exception;

    boolean auditingSecede(int userID) throws Exception;

    boolean auditingSubmit(UserSeller userSeller) throws Exception;

    boolean auditingUpdate(UserSeller userSeller) throws Exception;

    boolean auditingPass(UserSeller userSeller) throws Exception;

    boolean auditingRefuse(UserSeller userSeller) throws Exception;
}
