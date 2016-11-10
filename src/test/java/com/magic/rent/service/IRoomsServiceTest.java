package com.magic.rent.service;

import com.magic.rent.pojo.Rooms;
import com.magic.rent.service.impl.RoomsServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wu on 2016/11/10.
 */
public class IRoomsServiceTest {
    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        String[] xmls = new String[]{"classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-service.xml",
                "classpath:config/spring/applicationContext-JCaptcha.xml",
                "classpath:config/spring/applicationContext-security.xml",
                "classpath:config/spring/applicationContext-transaction.xml",
                "classpath:config/spring/applicationContext-ehcache.xml"};

        applicationContext = new ClassPathXmlApplicationContext(xmls);
    }

    @Test
    public void selectRoomsByHouseID() throws Exception {
        IRoomsService iRoomsService = applicationContext.getBean(IRoomsService.class);
        List<Rooms> roomsList = iRoomsService.selectRoomsByHouseID(1);
        System.out.println(roomsList);
    }

}