package com.magic.rent.service.impl;

import com.magic.rent.pojo.Company;
import com.magic.rent.service.ICompanyService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/11/29
 * 类说明:
 * 更新记录：
 */
public class CompanyServiceTest {
    private ApplicationContext applicationContext;
    private ICompanyService iCompanyService;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-service.xml",
                "classpath:config/spring/applicationContext-JCaptcha.xml",
                "classpath:config/spring/applicationContext-security.xml",
                "classpath:config/spring/applicationContext-transaction.xml",
                "classpath:config/spring/applicationContext-ehcache.xml");
        iCompanyService = applicationContext.getBean(ICompanyService.class);
    }

    @Test
    public void create() throws Exception {

        Company company = new Company();
        company.setCompanyName("北京当天网络科技有限公司");
        company.setPhone("02231231231");
        company.setDeveloperId(2);
        company.setAddress("北京路边摊");

        iCompanyService.create(company);
    }

    @Test
    public void pass() throws Exception {
        System.out.print(iCompanyService.pass(5));
    }

    @Test
    public void cancel() throws Exception {
        System.out.print(iCompanyService.cancel(6,2));
    }

    @Test
    public void refuse() throws Exception {
        System.out.print(iCompanyService.refuse(5));
    }

    @Test
    public void getAuditingCompanies() throws Exception {

    }

}