package com.magic.rent.service.impl;

import com.magic.rent.mapper.SysRolesMapper;
import com.magic.rent.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by wu on 2016/11/22.
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    private SysRolesMapper sysRolesMapper;

    public boolean insertRolesByUserID(Map<String, Integer> userAndRole) {
        int isSuccess = sysRolesMapper.insertRolesByUserID(userAndRole);
        return isSuccess > 0;
    }
}
