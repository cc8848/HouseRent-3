package com.magic.rent.service.impl;

import com.magic.rent.mapper.SysStoreMapper;
import com.magic.rent.pojo.SelectPoJo;
import com.magic.rent.pojo.SysRoles;
import com.magic.rent.service.ISysStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wu on 2016/11/19.
 */
@Service
public class SysStoreServiceImpl implements ISysStoreService {

    @Autowired
    private SysStoreMapper sysStoreMapper;

    public List<SelectPoJo> selectStoreNumByAreaID(String areaID) throws Exception {

        List<SelectPoJo> selectPoJoList = sysStoreMapper.selectByAreaID(areaID);

        selectPoJoList.add(0, new SelectPoJo(0, "门牌"));

        return selectPoJoList;
    }

    public List<SelectPoJo> selectRolesByStoreID(int storeID) throws Exception {

        List<SelectPoJo> selectPoJoList = sysStoreMapper.selectRolesByStoreID(storeID);

        selectPoJoList.add(0, new SelectPoJo(0, "岗位"));

        return selectPoJoList;
    }
}
