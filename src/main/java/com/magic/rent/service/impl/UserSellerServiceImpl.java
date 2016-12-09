package com.magic.rent.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.mapper.StoreMapper;
import com.magic.rent.mapper.UserSellerMapper;
import com.magic.rent.pojo.Store;
import com.magic.rent.pojo.SysStatus;
import com.magic.rent.pojo.UserSeller;
import com.magic.rent.service.IUserSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/11/17
 * 类说明:
 * 更新记录：
 */
@Service
public class UserSellerServiceImpl implements IUserSellerService {

    @Autowired
    private UserSellerMapper userSellerMapper;

    @Autowired
    private StoreMapper storeMapper;


    public boolean create(UserSeller userSeller) throws Exception {

        List<UserSeller> userSellerList = userSellerMapper.selectBySelective(userSeller);

        if (null != userSellerList && userSellerList.size() != 0) {
            for (UserSeller DBUserSeller : userSellerList) {
                switch (DBUserSeller.getSysStatus()) {
                    case SysStatus.AUDITING:
                    case SysStatus.SUCCESS:
                        throw new BusinessException("当前已经有在途申请或已经加入了门店！");
                }
            }
        }
        userSeller.setSysStatus(SysStatus.AUDITING);
        userSeller.setAuditingTime(new Date());
        int row = userSellerMapper.insert(userSeller);
        return row > 0;
    }

    public boolean cancel(int userID) throws Exception {
        UserSeller query = new UserSeller();
        query.setUserId(userID);
        query.setSysStatus(SysStatus.AUDITING);

        List<UserSeller> userSellerList = userSellerMapper.selectBySelective(query);

        if (null == userSellerList || userSellerList.size() == 0) {
            throw new BusinessException("当前未查询到有在途的申请，无法取消！");
        } else {
            UserSeller userSeller = userSellerList.get(0);//获取此申请数据
            return userSellerMapper.deleteByPrimaryKey(userSeller.getId()) > 0;
        }
    }

    public boolean pass(int userID) throws Exception {
        UserSeller query = new UserSeller();
        query.setUserId(userID);
        query.setSysStatus(SysStatus.AUDITING);

        List<UserSeller> userSellerList = userSellerMapper.selectBySelective(query);

        if (null == userSellerList || userSellerList.size() == 0) {
            throw new BusinessException("当前未查询到有在途的申请，无法审批通过！");
        } else {
            UserSeller userSeller = userSellerList.get(0);//获取此申请数据
            userSeller.setSysStatus(SysStatus.SUCCESS);//修改系统状态
            userSeller.setOperateTime(new Date());//设置操作时间
            return userSellerMapper.updateByPrimaryKeySelective(userSeller) > 0;
        }
    }

    public boolean refuse(int userID) throws Exception {
        UserSeller query = new UserSeller();
        query.setUserId(userID);
        query.setSysStatus(SysStatus.AUDITING);

        List<UserSeller> userSellerList = userSellerMapper.selectBySelective(query);

        if (null == userSellerList || userSellerList.size() == 0) {
            throw new BusinessException("当前未查询到有在途的申请，无法审批拒绝！");
        } else {
            UserSeller userSeller = userSellerList.get(0);//获取此申请数据
            userSeller.setSysStatus(SysStatus.REFUSE);//修改系统状态
            userSeller.setOperateTime(new Date());//设置操作时间
            return userSellerMapper.updateByPrimaryKeySelective(userSeller) > 0;
        }
    }

    public boolean quit(int userID) throws Exception {
        UserSeller query = new UserSeller();
        query.setUserId(userID);
        query.setSysStatus(SysStatus.SUCCESS);

        List<UserSeller> userSellerList = userSellerMapper.selectBySelective(query);

        if (null == userSellerList || userSellerList.size() == 0) {
            throw new BusinessException("当前未查询到有加入门店的记录，无法退出！");
        } else {
            UserSeller userSeller = userSellerList.get(0);//获取此申请数据
            userSeller.setSysStatus(SysStatus.CANCEL);//修改系统状态
            userSeller.setOperateTime(new Date());//设置操作时间
            return userSellerMapper.updateByPrimaryKeySelective(userSeller) > 0;
        }
    }

    public Store myStore(int userID) throws Exception {
        UserSeller query1 = new UserSeller();
        query1.setUserId(userID);
        query1.setSysStatus(SysStatus.SUCCESS);

        List<UserSeller> userSellerList = userSellerMapper.selectBySelective(query1);

        if (null == userSellerList || userSellerList.size() == 0) {
            //记录不存在说明并没有加入任何门店
            return null;
        } else {
            return storeMapper.selectByPrimaryKey(userSellerList.get(0).getStoreId());
        }
    }

    public PageInfo<UserSeller> getByStore(UserSeller userSeller, int manageID, int pageNum, int pageSize) throws Exception {
        //校验查询的合法性
        Store query = new Store();
        query.setId(userSeller.getStoreId());
        query.setManageId(manageID);
        List<Store> storeList = storeMapper.selectBySelective(query);
        if (null == storeList || storeList.size() == 0) {
            throw new BusinessException("只能查询本账号下的门店销售员信息！");
        } else {
            PageHelper.startPage(pageNum, pageSize);
            List<UserSeller> userSellerList = userSellerMapper.selectBySelective(userSeller);
            return new PageInfo<UserSeller>(userSellerList);
        }
    }
}
