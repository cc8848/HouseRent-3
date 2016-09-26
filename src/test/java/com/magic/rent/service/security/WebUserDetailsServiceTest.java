package com.magic.rent.service.security;

import com.magic.rent.pojo.SysUserLoginDetails;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by wuxinzhe on 16/9/24.
 */
public class WebUserDetailsServiceTest {

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
    public void testLoadUserByUsername() throws Exception {
        WebUserDetailsService webUserDetailsService = (WebUserDetailsService) applicationContext.getBean("webUserDetailsService");
        SysUserLoginDetails sysUserLoginDetails = (SysUserLoginDetails) webUserDetailsService.loadUserByUsername("18650155502");
        System.out.print(sysUserLoginDetails);
    }
}