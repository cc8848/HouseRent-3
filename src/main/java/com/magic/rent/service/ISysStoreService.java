package com.magic.rent.service;

import com.magic.rent.pojo.SelectPoJo;
import com.magic.rent.pojo.SysRoles;

import java.util.List;

/**
 * Created by wu on 2016/11/19.
 */
public interface ISysStoreService {

    List<SelectPoJo> selectStoreNumByAreaID(String areaID) throws Exception;

    List<SelectPoJo> selectRolesByStoreID(int storeID) throws Exception;
}
