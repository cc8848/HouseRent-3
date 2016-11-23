package com.magic.rent.service.impl;

import com.magic.rent.mapper.SysMenuMapper;
import com.magic.rent.pojo.SysMenu;
import com.magic.rent.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/11/23
 * 类说明: 提供后台操作菜单的相关服务
 * 更新记录：
 */
@Service
public class SysMenuService implements ISysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    public List<SysMenu> selectSysMenusByUserID(int userID) {

        return sysMenuMapper.selectMenusByUserID(userID);
    }
}
