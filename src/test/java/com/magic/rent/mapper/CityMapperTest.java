package com.magic.rent.mapper;

import com.magic.rent.pojo.City;
import com.magic.rent.pojo.Province;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/10/10
 * 类说明:
 */
public class CityMapperTest {
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
    public void testSelectByProvinceID() throws Exception {
        CityMapper cityMapper = applicationContext.getBean(CityMapper.class);
        Province province = new Province();
        province.setProvinceID(350000);

//        List<City> cityList = cityMapper.selectByProvinceID(province.getProvinceID());
//        for (City city : cityList) {
//            System.out.println(city.toString());
//        }
    }
}