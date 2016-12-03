package com.magic.rent.service;

import com.github.pagehelper.PageInfo;
import com.magic.rent.pojo.House;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: WuXinZhe   创建时间: 2016/10/13
 * 类说明:
 */
public interface IHouseService {

    /**
     * 创建房源申请
     *
     * @param house
     * @param userID
     * @return
     * @throws Exception
     */
    boolean create(House house, int userID) throws Exception;

    /**
     * 取消房源申请
     *
     * @param houseID
     * @param userID
     * @return
     * @throws Exception
     */
    boolean cancel(int houseID, int communityID, int userID) throws Exception;

    /**
     * 批准房源申请
     *
     * @param houseID
     * @return
     * @throws Exception
     */
    boolean pass(int houseID) throws Exception;

    /**
     * 拒绝房源申请
     *
     * @param houseID
     * @return
     * @throws Exception
     */
    boolean refuse(int houseID) throws Exception;

    /**
     * 修改房屋信息
     *
     * @param house
     * @param userID
     * @return
     * @throws Exception
     */
    boolean update(House house, int userID) throws Exception;

    /**
     * 获取指定社区的房源
     *
     * @param communityID
     * @param pageSize
     * @param pageNum
     * @return
     * @throws Exception
     */
    PageInfo<House> getCommunityHouses(int communityID, int pageSize, int pageNum) throws Exception;

    /**
     * 获取公司下所有房源
     *
     * @param companyID
     * @param pageSize
     * @param pageNum
     * @return
     * @throws Exception
     */
    PageInfo<House> getAllHouses(int companyID, int pageSize, int pageNum) throws Exception;


    House getDetail(int houseID) throws Exception;
}
