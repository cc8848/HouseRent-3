package com.magic.rent.service.security;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/23
 * 类说明:
 */

import com.magic.rent.pojo.SysRoles;
import com.magic.rent.pojo.SysUserLoginDetails;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.IUserService;
import com.magic.rent.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Role;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class WebUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private MessageSource messageSource;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        SysUsers sysUsers = null;

        //此处后续需要加入从缓存中获取User信息

        try {
            sysUsers = iUserService.findSysUserByUserName(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (sysUsers == null) {
            throw new UsernameNotFoundException(this.messageSource.getMessage(
                    "UserDetailsService.userNotFount", new Object[]{s}, null));
        }

        //封装该用户具有什么角色
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        if (sysUsers.getSysRoles() != null && !sysUsers.getSysRoles().isEmpty()) {
            for (SysRoles role : sysUsers.getSysRoles()) {
                GrantedAuthority ga = new SimpleGrantedAuthority(role.getRoleName());
                authorities.add(ga);
            }
        }
        Log.info(WebUserDetailsService.class, "获取用户角色", "账户名:" + s+sysUsers.getSysRoles().toString());
        SysUserLoginDetails userLoginDetails = new SysUserLoginDetails(authorities, sysUsers.getPassword(), sysUsers.getUserName(), sysUsers.isAccountNonExpired(), sysUsers.isAccountNonLocked(), sysUsers.isCredentialsNonExpired(), sysUsers.isEnabled());
        return userLoginDetails;
    }
}
