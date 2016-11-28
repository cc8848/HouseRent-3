package com.magic.rent.service.impl;

import com.magic.rent.pojo.Company;
import com.magic.rent.service.security.ICompanyService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/11/28
 * 类说明:家访问控制器
 * 更新记录：
 */
public class CompanyServiceTest {
    private ApplicationContext applicationContext;
    private ICompanyService iCompanyService;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-service.xml",
                "classpath:config/spring/applicationContext-security.xml",
                "classpath:config/spring/applicationContext-transaction.xml",
                "classpath:config/spring/applicationContext-ehcache.xml");
        iCompanyService = applicationContext.getBean(ICompanyService.class);
    }

    @Test
    public void create() throws Exception {
        Company company = new Company();
        company.setCompanyName("福建中吴置业有限公司");
        company.setPhone("05921123231");
        company.setDeveloperId(2);
        company.setEnable(false);
        company.setAddress("厦门集美大石路123号");

        iCompanyService.create(company);
    }

}