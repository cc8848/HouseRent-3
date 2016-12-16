package com.magic.rent.mapper;

import com.magic.rent.pojo.MajorArea;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/16
 * 类说明:
 * 更新记录：
 */
public class MajorAreaMapperTest {
    private ApplicationContext applicationContext;
    private MajorAreaMapper majorAreaMapper;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-ehcache.xml");
        majorAreaMapper = applicationContext.getBean(MajorAreaMapper.class);
    }

    @Test
    public void selectBySelective() throws Exception {
        MajorArea majorArea = new MajorArea();
        majorArea.setUserId(15);
        List<MajorArea> majorAreaList = majorAreaMapper.selectBySelective(majorArea);
        System.out.print(majorAreaList);
    }


}