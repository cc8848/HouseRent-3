package com.magic.rent.service.security;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/23
 * 类说明:
 */

import com.magic.rent.mapper.SysRolesMapper;
import com.magic.rent.mapper.SysUsersMapper;
import com.magic.rent.pojo.SysRoles;
import com.magic.rent.pojo.SysUsers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class WebUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUsersMapper sysUsersMapper;

    @Autowired
    private SysRolesMapper sysRolesMapper;

    @Autowired
    private MessageSourceAccessor messageSourceAccessor;

    private static Logger logger = LoggerFactory.getLogger(WebUserDetailsService.class);


    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUsers sysUsers = null;
        try {
            //从数据中查找数据
            sysUsers = sysUsersMapper.selectByUserName(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果查找不到用户信息,则抛出异常
        if (sysUsers == null) {
            throw new UsernameNotFoundException(
                    messageSourceAccessor.getMessage("UserDetailsService.userNotFount", "用户未找到!"));
        }
        //查询用户角色
        sysUsers.setSysRoles(sysRolesMapper.selectRolesByUserId(sysUsers.getUserId()));

        //查询并封装该用户具有什么权限
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        if (sysUsers.getSysRoles() != null && !sysUsers.getSysRoles().isEmpty()) {
            for (SysRoles role : sysUsers.getSysRoles()) {
                GrantedAuthority ga = new SimpleGrantedAuthority(role.getRoleName());
                authorities.add(ga);
            }
        }
        //装载权限列表
        sysUsers.setAuthorities(authorities);
        logger.info("读取用户角色:账户名[{}]-权限[{}]", s, sysUsers.getAuthorities().toString());
        //拼装SysUserLoginDetails对象
        return sysUsers;
    }
}
