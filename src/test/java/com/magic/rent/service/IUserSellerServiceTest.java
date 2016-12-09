package com.magic.rent.service;

import com.magic.rent.pojo.SysUsers;
import com.magic.rent.pojo.UserSeller;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wu on 2016/11/17.
 */
public class IUserSellerServiceTest {
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
//        IUserSellerService iUserSellerService = applicationContext.getBean(IUserSellerService.class);
//        UserSeller userSeller = iUserSellerService.selectSellerInfoByUserID(1);
//        System.out.println(userSeller.toString());

    }

}