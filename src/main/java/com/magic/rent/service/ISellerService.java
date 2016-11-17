package com.magic.rent.service;

import com.magic.rent.pojo.SysUsers;
import com.magic.rent.pojo.UserSeller;
import org.springframework.stereotype.Service;

/**
 * Created by wu on 2016/11/17.
 */
@Service
public interface ISellerService {

    UserSeller selectSellerInfoByUserID(SysUsers sysUsers);
}
