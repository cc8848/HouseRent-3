package com.magic.rent.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/19
 * 类说明:
 */
public class IDInfoMapperTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext-dao.xml");
    }

    @Test
    public void testSelectALLIDInfo() throws Exception {
        IDInfoMapper idInfoMapper = (IDInfoMapper) applicationContext.getBean("IDInfoMapper");
        List<IDInfo> idInfoList = idInfoMapper.selectALLIDInfo();
        for (IDInfo idinfo : idInfoList) {
            System.out.println(idinfo.toString());
        }
    }
}