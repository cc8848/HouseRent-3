package com.magic.rent.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.magic.rent.pojo.Company;
import com.magic.rent.pojo.SysStatus;
import com.magic.rent.pojo.Community;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/2
 * 类说明:
 * 更新记录：
 */
public class CommunityMapperTest {
    private ApplicationContext applicationContext;
    private CommunityMapper communityMapper;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-ehcache.xml");
        communityMapper = applicationContext.getBean(CommunityMapper.class);
    }

    @Test
    public void deleteByPrimaryKey() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        Community community = new Community();
        community.setProvinceId(350000);
        community.setCityId(350200);
        community.setAreaId(350205);
        community.setName("测试社区");
        community.setLng(123.123123d);
        community.setLat(22.1122d);
        community.setAddress("法师打发是飞洒");
        community.setCompanyId(1);
        community.setAuditingTime(new Date());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date openTime = dateFormat.parse("2016-11-11");
        community.setOpenTime(openTime);
        Date realEstateTime = dateFormat.parse("2018-01-01");
        community.setRealEstateTime(realEstateTime);
        community.setEstateManageCompany("XXX");
        community.setStatus(SysStatus.AUDITING);
        communityMapper.insert(community);
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
        Community query = new Community();
        query.setStatus(SysStatus.AUDITING);
        query.setCompanyId(1);
        List<Community> communityList = communityMapper.selectBySelective(query);
        System.out.print(communityList);
    }

    @Test
    public void selectEnableByUserID() throws Exception {

    }

    @Test
    public void countByStatusForUser() throws Exception {

    }

}