package com.magic.rent.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by wu on 2016/11/22.
 */
public class SysRolesMapperTest {
    private ApplicationContext applicationContext;
    private SysRolesMapper sysRolesMapper;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-ehcache.xml");
        sysRolesMapper = applicationContext.getBean(SysRolesMapper.class);
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
    public void selectRolesByUserId() throws Exception {

    }

    @Test
    public void insertRolesByUserID() throws Exception {

    }

    @Test
    public void selectRolesIDByUserID() throws Exception {
        System.out.print(sysRolesMapper.selectRolesIDByUserID(3));
    }

    @Test
    public void deleteUsersRoleByUserIDAndRoleID() throws Exception {
        Map<String, Integer> stringIntegerMap = new HashMap<String, Integer>();
        stringIntegerMap.put("userID", 3);
        stringIntegerMap.put("roleID", 2);
        System.out.print(sysRolesMapper.deleteUsersRoleByUserIDAndRoleID(stringIntegerMap));
    }
}