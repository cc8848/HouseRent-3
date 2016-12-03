package com.magic.rent.service.impl;

import com.magic.rent.pojo.House;
import com.magic.rent.service.IHouseService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/12/4
 * 类说明:家访问控制器
 * 更新记录：
 */
public class HouseServiceImplTest {
    private ApplicationContext applicationContext;
    private IHouseService iHouseService;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-service.xml",
                "classpath:config/spring/applicationContext-JCaptcha.xml",
                "classpath:config/spring/applicationContext-security.xml",
                "classpath:config/spring/applicationContext-transaction.xml",
                "classpath:config/spring/applicationContext-ehcache.xml");
        iHouseService = applicationContext.getBean(IHouseService.class);
    }

    @Test
    public void create() throws Exception {

    }

    @Test
    public void cancel() throws Exception {

    }

    @Test
    public void pass() throws Exception {

    }

    @Test
    public void refuse() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void getCommunityHouses() throws Exception {

    }

    @Test
    public void getAllHouses() throws Exception {

    }

    @Test
    public void getDetail() throws Exception {
        House house = iHouseService.getDetail(60);
        System.out.print(house);
    }

}