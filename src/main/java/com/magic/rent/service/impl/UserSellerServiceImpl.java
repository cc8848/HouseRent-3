package com.magic.rent.service.impl;

import com.magic.rent.mapper.SysRolesMapper;
import com.magic.rent.mapper.SysUsersMapper;
import com.magic.rent.mapper.UserSellerMapper;
import com.magic.rent.pojo.SysRoles;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.pojo.UserSeller;
import com.magic.rent.service.ISysRoleService;
import com.magic.rent.service.IUserSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wu on 2016/11/17.
 */
@Service
public class UserSellerServiceImpl implements IUserSellerService {

    @Autowired
    private UserSellerMapper userSellerMapper;

    @Autowired
    private SysRolesMapper sysRolesMapper;

    public UserSeller selectSellerInfoByUserID(int userID) throws Exception {

        return userSellerMapper.selectByUserID(userID);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean auditingSecede(int userID) throws Exception {
        boolean flag = true;
        List<Integer> roleIDList = sysRolesMapper.selectRolesIDByUserID(userID);
        for (int id : roleIDList) {//遍历其所具有的所有角色
            switch (id) {
                case SysRoles.SELLER://当存在职业经纪人角色时
                    Map<String, Integer> deleteSeller = new HashMap<String, Integer>();
                    deleteSeller.put("userID", userID);
                    deleteSeller.put("roleID", SysRoles.SELLER);
                    //删除职业经纪人角色
                    int isSuccessForSeller = sysRolesMapper.deleteUsersRoleByUserIDAndRoleID(deleteSeller);
                    if (!(isSuccessForSeller > 0)) {
                        flag = false;
                    }
                    break;
                case SysRoles.MANAGER://当存在经理人角色时
                    Map<String, Integer> deleteManager = new HashMap<String, Integer>();
                    deleteManager.put("userID", userID);
                    deleteManager.put("roleID", SysRoles.SELLER);
                    //删除经理人角色
                    int isSuccessForManager = sysRolesMapper.deleteUsersRoleByUserIDAndRoleID(deleteManager);
                    if (!(isSuccessForManager > 0)) {
                        flag = false;
                    }
                    break;
                default:
                    break;
            }
        }
        if (flag) {
            int deleteSellerInfo = userSellerMapper.deleteByUserID(userID);
            if (!(deleteSellerInfo > 0)) {
                flag = false;
            }
        }
        //上面的逻辑是，当用户退出团队时，先去查询其具有的所有角色，再把经理、职业经纪人的角色删掉，
        //当所有都删除成功之后，再删除其在UserSeller表的其他数据，以表示其目前退出机构
        //方法本身具有事务，如果有任何一个环节出错，则所有操作回滚,同时抛出异常。

        return flag;
    }

    public boolean auditingSubmit(UserSeller userSeller) throws Exception {

        int isSuccess = userSellerMapper.insertSelective(userSeller);

        return isSuccess > 0;

    }

    public boolean auditingUpdate(UserSeller userSeller) throws Exception {

        int isSuccess = userSellerMapper.updateByPrimaryKeySelective(userSeller);

        return isSuccess > 0;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean auditingPass(UserSeller userSeller) throws Exception {

        int isSuccessForSeller = userSellerMapper.updateByUserIDSelective(userSeller);

        Map<String, Integer> userAndRole = new HashMap<String, Integer>();
        userAndRole.put("userID", userSeller.getUserId());
        userAndRole.put("roleID", SysRoles.SELLER);

        int isSuccessForRole = sysRolesMapper.insertRolesByUserID(userAndRole);

        return isSuccessForSeller > 0 && isSuccessForRole > 0;
    }

    public boolean auditingRefuse(UserSeller userSeller) throws Exception {

        int isSuccess = userSellerMapper.updateByUserIDSelective(userSeller);

        return isSuccess > 0;
    }

    public List<UserSeller> getAuditingSellersByStoreID() throws Exception {
        return null;
    }
}
