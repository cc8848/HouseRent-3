package com.magic.rent.mapper;

import com.magic.rent.pojo.House;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/11/25
 * 类说明:
 * 更新记录：
 */
public class HouseMapperTest {
    private ApplicationContext applicationContext;
    private HouseMapper houseMapper;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:config/spring/applicationContext-dao.xml",
                "classpath:config/spring/applicationContext-ehcache.xml");
        houseMapper = applicationContext.getBean(HouseMapper.class);
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
        House house = houseMapper.selectHouseDetails(1);
        System.out.print(house);
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {

        House house = new House();
        house.setTittle("测试房屋");
        house.setDescription("测试描述");
        house.setAddress("测试地址");
        house.setFloorArea(123.22);
        house.setPoolArea(22.22);
        house.setFaceId(1);
        house.setExpectPrice(123.00);
        house.setFloor(12);
        house.setLayoutId(1);
        house.setHouseDecorationId(1);
        house.setProvinceId(350000);
        house.setCityId(350200);
        house.setAreaId(350205);
        house.setHouseStatus(1);
        house.setEnabled(false);//待后台审核后可修改为可用
        houseMapper.insertSelective(house);
        System.out.print(house.getId());
    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

}