package com.magic.rent.service;

import com.magic.rent.pojo.SysUsers;
import com.magic.rent.pojo.UserSeller;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by wu on 2016/11/17.
 */
public class ISellerServiceTest {
    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-service.xml",
                "classpath:config/spring/applicationContext-transaction.xml",
                "classpath:config/spring/applicationContext-ehcache.xml");
    }

    @Test
    public void selectSellerInfoByUserID() throws Exception {
        ISellerService iSellerService = applicationContext.getBean(ISellerService.class);
        SysUsers sysUsers = new SysUsers();
        sysUsers.setUserId(1);
        UserSeller userSeller = iSellerService.selectSellerInfoByUserID(sysUsers);
        System.out.println(userSeller.toString());

    }

}