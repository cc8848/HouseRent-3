package com.magic.rent.service.impl;

import com.magic.rent.mapper.UserSellerMapper;
import com.magic.rent.pojo.SysRoles;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.pojo.UserSeller;
import com.magic.rent.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by wu on 2016/11/17.
 */
public class SellerServiceImpl implements ISellerService {

    private static int seller_role_ID = 6;//角色ID

    @Autowired
    private UserSellerMapper userSellerMapper;

    public UserSeller selectSellerInfoByUserID(SysUsers sysUsers) {
        for (Object sysRoles : sysUsers.getSysRoles()) {
            if (seller_role_ID == ((SysRoles) sysRoles).getRoleId()) {
                return userSellerMapper.selectByUserID(sysUsers.getUserId());
            }
        }
        //若没有符合的角色，则返回空
        return null;
    }

}
