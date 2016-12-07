package com.magic.rent.mapper;

import com.alibaba.fastjson.JSON;
import com.magic.rent.pojo.Province;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/10/9
 * 类说明:
 */
public class ProvinceMapperTest {

    private ApplicationContext applicationContext;
    private ProvinceMapper provinceMapper;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-ehcache.xml");
        provinceMapper = applicationContext.getBean(ProvinceMapper.class);
    }

    @Test
    public void testSelectAllProvince() throws Exception {
    }

    @Test
    public void selectAllAddress() throws Exception {
        List<Province> provinceList = provinceMapper.selectAllAddress();
        JSON.toJSON(provinceList);
        System.out.print(provinceList);
    }
}