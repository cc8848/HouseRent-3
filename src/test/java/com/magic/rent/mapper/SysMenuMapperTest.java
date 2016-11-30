package com.magic.rent.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wu on 2016/11/23.
 */
public class SysMenuMapperTest {
    private ApplicationContext applicationContext;
    private SysMenuMapper sysMenuMapper;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-ehcache.xml");
        sysMenuMapper = applicationContext.getBean(SysMenuMapper.class);
    }

    @Test
    public void selectMenusByUserID() throws Exception {
    }

}