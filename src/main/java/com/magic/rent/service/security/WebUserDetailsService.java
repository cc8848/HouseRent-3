package com.magic.rent.service.security;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/23
 * 类说明:
 */

import com.magic.rent.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        boolean enabled = true;

        User user = null;
        try {
            user = iUserService.getUserByUsername(s);
        } catch (Exception e) {
            e.printStackTrace();ff


        }

        if(user == null){
            throw new UsernameNotFoundException("User account : " + s + " not found!");
        }

        //封装该用户具有什么角色
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        if(user.getRoles() != null && !user.getRoles().isEmpty()){
            for(Role role : user.getRoles()){
                GrantedAuthority ga = new SimpleGrantedAuthority(role.getName());
                authorities.add(ga);
            }
        }

        UserLoginDetails userLoginDetails =  new UserLoginDetails(user.getUsername(), user.getPassword(), authorities, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled);

        return userLoginDetails;
    }
}
