package com.magic.rent.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by wuxinzhe on 16/9/24.
 */
public class SysUserLoginDetails implements UserDetails {

    private Collection<? extends GrantedAuthority> grantedAuthority;//权限列表

    private String password;//密码

    private String userName;//账户名

    private boolean accountNonExpired;//账户是否过期

    private boolean accountNonLocked;//账户是否锁定

    private boolean credentialsNonExpired;//用户证书是否有效

    private boolean enabled;//账户是否可用

    public SysUserLoginDetails(Collection<? extends GrantedAuthority> grantedAuthority, String password, String userName, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
        this.grantedAuthority = grantedAuthority;
        this.password = password;
        this.userName = userName;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthority;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return userName;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }


}
