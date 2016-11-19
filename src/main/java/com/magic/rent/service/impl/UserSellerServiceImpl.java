package com.magic.rent.service.impl;

import com.magic.rent.mapper.UserSellerMapper;
import com.magic.rent.pojo.UserSeller;
import com.magic.rent.service.IUserSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wu on 2016/11/17.
 */
@Service
public class UserSellerServiceImpl implements IUserSellerService {

    @Autowired
    private UserSellerMapper userSellerMapper;

    public UserSeller selectSellerInfoByUserID(int userID) throws Exception {

        return userSellerMapper.selectByUserID(userID);
    }

    public boolean auditingCancel(int sellerID) throws Exception {

        int isSuccess = userSellerMapper.deleteByPrimaryKey(sellerID);

        return isSuccess > 0;
    }

}
