package com.magic.rent.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wuxinzhe   创建时间: 16/10/1
 * 类说明:
 */
public class UserControllerTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-service.xml",
                "classpath:config/spring/applicationContext-JCaptcha.xml",
                "classpath:config/spring/applicationContext-security.xml",
                "classpath:config/spring/applicationContext-transaction.xml",
                "classpath:config/spring/applicationContext-ehcache.xml"});
    }

    @Test
    public void testRegister() throws Exception {
        UserController userController=(UserController)applicationContext.getBean(UserController.class);

    }
}