package com.magic.rent.service.impl;

import com.github.pagehelper.PageInfo;
import com.magic.rent.pojo.Community;
import com.magic.rent.pojo.House;
import com.magic.rent.service.IHouseService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by wu on 2016/11/3.
 */
public class HouseServiceImplTest {
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


}