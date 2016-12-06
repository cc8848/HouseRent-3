package com.magic.rent.service.impl;

import com.magic.rent.pojo.Store;
import com.magic.rent.pojo.SysStatus;
import com.magic.rent.service.IHouseService;
import com.magic.rent.service.IStoreService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/6
 * 类说明:
 * 更新记录：
 */
public class StoreServiceImplTest {
    private ApplicationContext applicationContext;
    private IStoreService iStoreService;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-service.xml",
                "classpath:config/spring/applicationContext-JCaptcha.xml",
                "classpath:config/spring/applicationContext-security.xml",
                "classpath:config/spring/applicationContext-transaction.xml",
                "classpath:config/spring/applicationContext-ehcache.xml");
        iStoreService = applicationContext.getBean(IStoreService.class);
    }

    @Test
    public void create() throws Exception {
        Store store=new Store();
        store.setAuditingTime(new Date());
        store.setSysStatus(SysStatus.AUDITING);
        store.setProvinceId(350000);
        store.setCityId(350200);
        store.setAreaId(350205);
        store.setAddress("测试地址");
        store.setName("saf");
        iStoreService.create(store,4);
    }

    @Test
    public void cancel() throws Exception {

    }

    @Test
    public void pass() throws Exception {

    }

    @Test
    public void refuse() throws Exception {

    }

    @Test
    public void getCurrentStoreInfo() throws Exception {

    }

}