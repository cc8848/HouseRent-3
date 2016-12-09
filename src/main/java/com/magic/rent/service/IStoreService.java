package com.magic.rent.service;

import com.github.pagehelper.PageInfo;
import com.magic.rent.pojo.SelectPoJo;
import com.magic.rent.pojo.Store;

import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/11/19
 * 类说明:
 * 更新记录：
 */
public interface IStoreService {
    /**
     * 开通门店申请
     *
     * @param store
     * @param userID
     * @return
     * @throws Exception
     */
    boolean create(Store store, int userID) throws Exception;

    /**
     * 取消门店开通
     *
     * @param storeID
     * @return
     * @throws Exception
     */
    boolean cancel(int storeID, int userID) throws Exception;

    /**
     * 审核通过
     *
     * @param storeID
     * @return
     * @throws Exception
     */
    boolean pass(int storeID) throws Exception;

    /**
     * 拒绝申请
     *
     * @param storeID
     * @return
     * @throws Exception
     */
    boolean refuse(int storeID) throws Exception;

    /**
     * 获取当前最新申请的记录状态
     *
     * @param userID
     * @return
     * @throws Exception
     */
    Store getCurrentStoreInfo(int userID) throws Exception;


    /**
     * 根据条件查询门店信息
     *
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    PageInfo<Store> getStores(Store query, int pageNum, int pageSize) throws Exception;

    /**
     * 根据地区获取商铺
     *
     * @param areaID
     * @return
     * @throws Exception
     */
    List<SelectPoJo> getStoresByArea(int areaID) throws Exception;
}

