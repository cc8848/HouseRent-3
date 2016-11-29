package com.magic.rent.mapper;

import com.magic.rent.pojo.Company;
import com.magic.rent.pojo.SysCompany;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/11/28
 * 类说明:
 * 更新记录：
 */
public class SysCompanyMapperTest {
    private ApplicationContext applicationContext;
    private CompanyMapper companyMapper;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-ehcache.xml");
        companyMapper = applicationContext.getBean(CompanyMapper.class);
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
        Company sysCompany = companyMapper.selectByPrimaryKey(1);
        System.out.print(sysCompany);
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

    @Test
    public void selectByUserID() throws Exception {
    }
}