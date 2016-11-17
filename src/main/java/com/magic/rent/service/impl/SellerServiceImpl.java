package com.magic.rent.service.impl;

import com.magic.rent.controller.HomeController;
import com.magic.rent.mapper.UserSellerMapper;
import com.magic.rent.pojo.SysRoles;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.pojo.UserSeller;
import com.magic.rent.service.ISellerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wu on 2016/11/17.
 */
@Service
public class SellerServiceImpl implements ISellerService {

    private static int member_role_ID = 1;//会员角色
    private static int seller_role_ID = 6;//经纪人角色


    @Autowired
    private UserSellerMapper userSellerMapper;

    private static Logger logger = LoggerFactory.getLogger(SellerServiceImpl.class);

    public UserSeller selectSellerInfoByUserID(SysUsers sysUsers) {
        for (Object sysRoles : sysUsers.getSysRoles()) {
            if (seller_role_ID == ((SysRoles) sysRoles).getRoleId() || member_role_ID == ((SysRoles) sysRoles).getRoleId()) {
                return userSellerMapper.selectByUserID(sysUsers.getUserId());
            }
        }

        logger.info("没有符合的角色，无法查询SellerInfo!");
        //若没有符合的角色，则返回空
        return null;
    }

}
