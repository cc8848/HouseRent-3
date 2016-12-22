package com.magic.rent.service;

import com.github.pagehelper.PageInfo;
import com.magic.rent.pojo.HandHouseDetail;
import com.magic.rent.pojo.HandHousePrice;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: Wu   创建时间: 2016/12/22
 * 类说明: 二手房相关服务接口
 * 更新记录：
 */
public interface IHandHouseService {

    /**
     * 获取指定用户的房源清单
     *
     * @param userID   指定用户的ID
     * @param pageSize 分页大小
     * @param pageNum  页码
     * @return
     * @throws Exception
     */
    PageInfo<HandHouseDetail> getHandHouseByUser(Integer userID, int pageSize, int pageNum) throws Exception;

    /**
     * 发布二手房信息
     *
     * @param handHouseDetail 房源信息
     * @return
     * @throws Exception
     */
    boolean issueHouse(HandHouseDetail handHouseDetail) throws Exception;

    /**
     * 删除房源信息
     *
     * @param houseID 删除房屋的ID
     * @param userID  当前操作用户的ID
     * @return
     * @throws Exception
     */
    boolean deleteHouse(Integer houseID, Integer userID) throws Exception;

    /**
     * 修改房源价格信息
     *
     * @param housePrice 新房源价格信息
     * @return
     * @throws Exception
     */
    boolean modifyPrice(HandHousePrice housePrice) throws Exception;
}
