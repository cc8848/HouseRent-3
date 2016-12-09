package com.magic.rent.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.mapper.StoreMapper;
import com.magic.rent.mapper.UsersRelateRolesMapper;
import com.magic.rent.pojo.*;
import com.magic.rent.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/11/19
 * 类说明:
 * 更新记录：
 */
@Service
public class StoreServiceImpl implements IStoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private UsersRelateRolesMapper usersRelateRolesMapper;

    public boolean create(Store store, int userID) throws Exception {
        Store query = new Store();
        query.setManageId(userID);
        //判断是否有在途或已经成功的申请
        List<Store> storeList = storeMapper.selectBySelective(query);
        if (null != storeList && storeList.size() > 0) {
            for (Store result : storeList) {
                switch (result.getSysStatus()) {
                    case SysStatus.AUDITING:
                        throw new BusinessException("当前账户已经有在途申请！");
                    case SysStatus.SUCCESS:
                        throw new BusinessException("当前账户已经开通门店！");
                }
            }
        }

        //强制修改记录为申请状态并记录申请时间
        store.setAuditingTime(new Date());
        store.setSysStatus(SysStatus.AUDITING);
        store.setManageId(userID);
        return storeMapper.insert(store) > 0;
    }

    public boolean cancel(int storeID, int userID) throws Exception {
        Store query = new Store();
        query.setId(storeID);
        query.setSysStatus(SysStatus.AUDITING);
        query.setManageId(userID);
        List<Store> storeList = storeMapper.selectBySelective(query);
        if (null == storeList || storeList.size() == 0) {
            throw new BusinessException("此账户尚未有开通店铺的申请，无法取消！");
        }
        Store store = new Store();
        store.setId(storeID);
        store.setManageId(userID);
        store.setSysStatus(SysStatus.CANCEL);
        store.setOperateTime(new Date());

        return storeMapper.updateByPrimaryKeySelective(store) > 0;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean pass(int storeID) throws Exception {
        Store store = new Store();
        store.setId(storeID);
        store.setSysStatus(SysStatus.SUCCESS);
        store.setOperateTime(new Date());
        int row1 = storeMapper.insertSelective(store);
        if (row1 <= 0) {
            throw new BusinessException("修改店铺数据失败！请联系管理员！");
        }

        //更新角色数据
        Store query = storeMapper.selectBySelective(store).get(0);
        UsersRelateRoles usersRelateRoles = new UsersRelateRoles();
        usersRelateRoles.setUserId(query.getManageId());
        usersRelateRoles.setRoleId(SysRoles.MANAGER);

        return usersRelateRolesMapper.insert(usersRelateRoles) > 0;
    }

    public boolean refuse(int storeID) throws Exception {
        Store store = new Store();
        store.setId(storeID);
        store.setSysStatus(SysStatus.REFUSE);
        store.setOperateTime(new Date());

        return storeMapper.updateByPrimaryKeySelective(store) > 0;
    }


    public Store getCurrentStoreInfo(int userID) throws Exception {
        return storeMapper.selectCurrentStoreInfo(userID);
    }


    public PageInfo<Store> getStores(Store query, int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Store> storeList = storeMapper.selectBySelective(query);
        return new PageInfo<Store>(storeList);
    }

    public List<SelectPoJo> getStoresByArea(int areaID) throws Exception {

        List<SelectPoJo> selectPoJos = storeMapper.selectByArea(areaID);

        return selectPoJos;
    }
}
