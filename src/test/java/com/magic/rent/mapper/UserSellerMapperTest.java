package com.magic.rent.mapper;

import com.magic.rent.pojo.UserSeller;
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

    private UserSellerMapper userSellerMapper;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-ehcache.xml");
        userSellerMapper = applicationContext.getBean(UserSellerMapper.class);
    }

    @Test
    public void selectByUserID() throws Exception {
        System.out.println(userSellerMapper.selectByUserID(1));

    }

    @Test
    public void deleteByPrimaryKey() throws Exception {
        System.out.print(userSellerMapper.deleteByPrimaryKey(0));
    }

    @Test
    public void selectSellersByStoreID() throws Exception {
        UserSeller userSeller = new UserSeller();
        userSeller.setStoreId(1);

        System.out.print(userSellerMapper.selectSellersByStoreIDAndStatusID(userSeller));
    }
}