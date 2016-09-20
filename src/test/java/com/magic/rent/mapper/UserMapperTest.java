package com.magic.rent.mapper;

import com.magic.rent.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/19
 * 类说明:
 */
public class UserMapperTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext-dao.xml");
    }

    @Test
    public void testSelectBySelective() throws Exception {
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        User user = new User();
//        user.setUserName("李四");
//        user.setPhone("121231");
//        user.setEmail("ba@qw.com");
//        user.setJob("教师");
//        user.setSex(1);
        List<User> userList = userMapper.selectBySelective(user);
        for (User user0 : userList) {
            System.out.println(user0);
        }

    }
}