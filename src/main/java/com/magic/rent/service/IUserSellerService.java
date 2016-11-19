package com.magic.rent.service;

import com.magic.rent.pojo.SysUsers;
import com.magic.rent.pojo.UserSeller;
import org.springframework.stereotype.Service;

/**
 * Created by wu on 2016/11/17.
 */
public interface IUserSellerService {

    UserSeller selectSellerInfoByUserID(int userID) throws Exception;

    boolean auditingCancel(int sellerID) throws Exception;
}
