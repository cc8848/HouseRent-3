package com.magic.rent.service.impl;

import com.magic.rent.pojo.HouseRecommend;
import com.magic.rent.service.IHouseRecommendService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by wu on 2016/10/17.
 */
public class HouseRecommendServiceImplTest {

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
    public void testSelectTodayRecommend() throws Exception {
        IHouseRecommendService iHouseRecommend = applicationContext.getBean(IHouseRecommendService.class);
        System.out.println(iHouseRecommend.selectTodayRecommend());
    }
}