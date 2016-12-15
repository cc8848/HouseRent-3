package com.magic.rent.util;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/12/14
 * 类说明:
 * 更新记录：
 */
public class FileUtilTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-service.xml",
                "classpath:config/spring/applicationContext-transaction.xml",
                "classpath:config/spring/applicationContext-ehcache.xml");

    }

    @Test
    public void getWebRootPath() throws Exception {

    }

    @Test
    public void getPortraitPath() throws Exception {

    }

    @Test
    public void getPortraitFileName() throws Exception {

    }

    @Test
    public void filePathToHref() throws Exception {

    }

    @Test
    public void getListFiles() throws Exception {
        String path = FileUtil.getWebRootPath();
        System.out.println(path);
        System.out.print(FileUtil.getListFiles(path));
    }

}