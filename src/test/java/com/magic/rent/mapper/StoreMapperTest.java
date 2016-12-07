package com.magic.rent.mapper;

import com.magic.rent.pojo.Store;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/12/7
 * 类说明:家访问控制器
 * 更新记录：
 */
public class StoreMapperTest {

    private ApplicationContext applicationContext;
    private StoreMapper storeMapper;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-ehcache.xml");
        storeMapper = applicationContext.getBean(StoreMapper.class);
    }
    @Test
    public void deleteByPrimaryKey() throws Exception {

    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void insertSelective() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() throws Exception {

    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

    @Test
    public void selectBySelective() throws Exception {

    }

    @Test
    public void selectCurrentStoreInfo() throws Exception {
        Store store=storeMapper.selectCurrentStoreInfo(4);
        System.out.print(store);
    }

}