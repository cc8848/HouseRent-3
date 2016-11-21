package com.magic.rent.service.impl;

import com.magic.rent.mapper.SysUsersMapper;
import com.magic.rent.mapper.UserSellerMapper;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.pojo.UserSeller;
import com.magic.rent.service.IUserSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wu on 2016/11/17.
 */
@Service
public class UserSellerServiceImpl implements IUserSellerService {

    @Autowired
    private UserSellerMapper userSellerMapper;

    @Autowired
    private SysUsersMapper sysUsersMapper;

    public UserSeller selectSellerInfoByUserID(int userID) throws Exception {

        return userSellerMapper.selectByUserID(userID);
    }

    public boolean auditingSecede(int userID) throws Exception {

        int isSuccess = userSellerMapper.deleteByUserID(userID);

        return isSuccess > 0;
    }

    public boolean auditingSubmit(UserSeller userSeller) throws Exception {

        int isSuccess = userSellerMapper.insertSelective(userSeller);

        return isSuccess > 0;

    }

    public boolean auditingUpdate(UserSeller userSeller) throws Exception {

        int isSuccess = userSellerMapper.updateByPrimaryKeySelective(userSeller);

        return isSuccess > 0;
    }

    public boolean auditingPass(UserSeller userSeller) throws Exception {

        int isSuccess = userSellerMapper.updateByUserIDSelective(userSeller);

        if (isSuccess > 0) {
        }

        return isSuccess > 0;
    }

    public boolean auditingRefuse(UserSeller userSeller) throws Exception {

        int isSuccess = userSellerMapper.updateByUserIDSelective(userSeller);

        return isSuccess > 0;
    }

    public List<UserSeller> getAuditingSellersByStoreID() throws Exception {
        return null;
    }
}
