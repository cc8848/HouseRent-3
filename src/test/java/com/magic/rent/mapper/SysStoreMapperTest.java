package com.magic.rent.mapper;

import com.magic.rent.pojo.SelectPoJo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wu on 2016/11/19.
 */
public class SysStoreMapperTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-service.xml",
                "classpath:config/spring/applicationContext-JCaptcha.xml",
                "classpath:config/spring/applicationContext-security.xml",
                "classpath:config/spring/applicationContext-transaction.xml",
                "classpath:config/spring/applicationContext-ehcache.xml");
    }

    @Test
    public void selectByAreaName() throws Exception {
        SysStoreMapper sysStoreMapper = applicationContext.getBean(SysStoreMapper.class);
        List<SelectPoJo> selectPoJoList = sysStoreMapper.selectByAreaID("350205");
        System.out.println(selectPoJoList);
    }

}