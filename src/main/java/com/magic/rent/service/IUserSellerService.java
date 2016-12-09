package com.magic.rent.service;

import com.github.pagehelper.PageInfo;
import com.magic.rent.pojo.Store;
import com.magic.rent.pojo.UserSeller;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: Wu   创建时间: 16/10/6
 * 类说明:销售员服务
 */
public interface IUserSellerService {


    /**
     * 发起加入门店申请
     *
     * @param userSeller
     * @return
     * @throws Exception
     */
    boolean create(UserSeller userSeller) throws Exception;

    /**
     * 取消在途的加入申请
     *
     * @param userID
     * @return
     * @throws Exception
     */
    boolean cancel(int userID) throws Exception;

    /**
     * 门店审批通过
     *
     * @param userID
     * @return
     * @throws Exception
     */
    boolean pass(int userID) throws Exception;

    /**
     * 门店审批拒绝
     *
     * @param userID
     * @return
     * @throws Exception
     */
    boolean refuse(int userID) throws Exception;

    /**
     * 销售员退出门店
     *
     * @param userID
     * @return
     * @throws Exception
     */
    boolean quit(int userID) throws Exception;

    /**
     * 查询我的店铺信息
     *
     * @param userID
     * @return
     * @throws Exception
     */
    Store myStore(int userID) throws Exception;

    /**
     * 查询本店铺下的业务员数据
     * @param userSeller
     * @param userID
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    PageInfo<UserSeller> getByStore(UserSeller userSeller, int userID,int pageNum, int pageSize) throws Exception;
}
