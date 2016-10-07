package com.magic.rent.service.security;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/23
 * 类说明:
 */

import com.magic.rent.mapper.SysAuthoritiesMapper;
import com.magic.rent.mapper.SysRolesMapper;
import com.magic.rent.mapper.SysUsersMapper;
import com.magic.rent.pojo.SysAuthorities;
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

import java.util.*;

@Service
public class WebUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUsersMapper sysUsersMapper;

    @Autowired
    private SysRolesMapper sysRolesMapper;

    @Autowired
    private SysAuthoritiesMapper sysAuthoritiesMapper;

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
        //用于过滤重复的权限
        List<String> preAuthorityMarks = new ArrayList<String>();
        if (sysUsers.getSysRoles() != null && !sysUsers.getSysRoles().isEmpty()) {
            //遍历用户所具有的所有角色
            for (SysRoles role : sysUsers.getSysRoles()) {
                //根据角色查询单独角色所具有的权限
                List<SysAuthorities> sysAuthoritiesList = sysAuthoritiesMapper.selectByRole(role);
                //将权限封装用于后续做判断
                for (SysAuthorities sysAuthority : sysAuthoritiesList) {
                    //过滤已经存在的权限
                    if (preAuthorityMarks.contains(sysAuthority.getAuthorityMark())) {
                        //过滤
                        continue;
                    } else {
                        //加入用于过滤的集合中
                        preAuthorityMarks.add(sysAuthority.getAuthorityMark());
                        //封装如权限集合中
                        GrantedAuthority ga = new CustomGrantedAuthority(sysAuthority.getAuthorityMark());
                        authorities.add(ga);
                    }
                }

            }
        }
        //装载权限列表
        sysUsers.setAuthorities(authorities);
        logger.info("读取用户角色:账户名[{}]-权限[{}]", s, sysUsers.getAuthorities().toString());
        //拼装SysUserLoginDetails对象
        return sysUsers;
    }
}
