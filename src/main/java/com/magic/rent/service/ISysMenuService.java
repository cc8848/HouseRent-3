package com.magic.rent.service;

import com.magic.rent.pojo.SysMenu;

import java.util.List;

/**
 * Created by wu on 2016/11/23.
 */
public interface ISysMenuService {

    List<SysMenu> selectSysMenusByUserID(int userID);
}
