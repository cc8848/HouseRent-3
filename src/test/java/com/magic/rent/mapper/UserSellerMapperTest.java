package com.magic.rent.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by wu on 2016/11/17.
 */
public class UserSellerMapperTest {
    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-ehcache.xml");
    }

    @Test
    public void selectByUserID() throws Exception {
        UserSellerMapper userSellerMapper = applicationContext.getBean(UserSellerMapper.class);
        System.out.println(userSellerMapper.selectByUserID(1));

    }

    @Test
    public void deleteByPrimaryKey() throws Exception {
        UserSellerMapper userSellerMapper = applicationContext.getBean(UserSellerMapper.class);
        System.out.print(userSellerMapper.deleteByPrimaryKey(0));
    }
}