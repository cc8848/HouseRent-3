package com.magic.rent.service.impl;

import com.magic.rent.mapper.SysUsersMapper;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by wuxinzhe on 16/9/24.
 */
public class UserServiceImplTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-service.xml",
                "classpath:config/spring/applicationContext-JCaptcha.xml",
                "classpath:config/spring/applicationContext-security.xml",
                "classpath:config/spring/applicationContext-transaction.xml",});
    }

    @Test
    public void testFindSysUserByUserName() throws Exception {

        UserServiceImpl iUserService = (UserServiceImpl) applicationContext.getBean("userServiceImpl");

        SysUsers sysUsers = iUserService.findSysUserByUserName("18650155502");

        System.out.print(sysUsers.toString());
    }
}