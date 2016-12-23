package com.magic.rent.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/23
 * 类说明:
 * 更新记录：
 */
public class HouseParameterMapperTest {

    private ApplicationContext applicationContext;

    private HouseParameterMapper houseParameterMapper;

    private String[] config = {"/config/spring/applicationContext-dao.xml", "/config/spring/applicationContext-ehcache.xml"};

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(config);
        houseParameterMapper = applicationContext.getBean(HouseParameterMapper.class);
    }

    @Test
    public void getOrientationMap() throws Exception {
        List<Map<Integer, String>> map = houseParameterMapper.getOrientationMap();
//        for (Map.Entry entry : map.entrySet()) {
//            System.out.println(entry.getValue());
//        }
        System.out.print(map.get(1).get("DECORATION_VALUE"));
    }

}