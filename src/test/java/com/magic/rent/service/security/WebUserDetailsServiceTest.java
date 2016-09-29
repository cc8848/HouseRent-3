package com.magic.rent.service.security;

import com.magic.rent.pojo.SysUsers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        SysUsers sysUserLoginDetails = (SysUsers) webUserDetailsService.loadUserByUsername("18650155502");
        System.out.print(sysUserLoginDetails);
    }
}