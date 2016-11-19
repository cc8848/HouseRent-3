package com.magic.rent.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class SysUsers implements UserDetails, Serializable {
    private static final long serialVersionUID = -2056222251872727820L;
    private Integer userId;//用户id

    private String username;//账户名

    private String name;//用户姓名

    private String password;//密码

    private Date dtCreate;//创建日期

    private Date lastLogin;//最后登录日期

    private Date deadline;//截止日期

    private String loginIp;//最后登录IP

    private String vQzjgid;//所属机构id

    private String vQzjgmc;//所属机构名称

    private String depId;//地区编号

    private String depName;//地区名字

    private boolean enabled;//账户是否可用

    private boolean accountNonExpired;//账户是否过期

    private boolean accountNonLocked;//账户是否锁定

    private boolean credentialsNonExpired;//用户证书是否有效

    private Collection<? extends SysRoles> sysRoles;//用户权限

    private Collection<? extends GrantedAuthority> SysAuthorities;//权限列表

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return SysAuthorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        SysAuthorities = authorities;
    }

    public Collection<? extends SysRoles> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(Collection<? extends SysRoles> sysRoles) {
        this.sysRoles = sysRoles;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Date dtCreate) {
        this.dtCreate = dtCreate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public String getvQzjgid() {
        return vQzjgid;
    }

    public void setvQzjgid(String vQzjgid) {
        this.vQzjgid = vQzjgid == null ? null : vQzjgid.trim();
    }

    public String getvQzjgmc() {
        return vQzjgmc;
    }

    public void setvQzjgmc(String vQzjgmc) {
        this.vQzjgmc = vQzjgmc == null ? null : vQzjgmc.trim();
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId == null ? null : depId.trim();
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    /**
     * 是否具有角色
     *
     * @param role
     * @return
     */
    public boolean haveRoles(int roleID) {
        for (Object sysRoles : this.sysRoles) {
            if (roleID == ((SysRoles) sysRoles).getRoleId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取指定角色ID的角色
     *
     * @param roleID
     * @return
     */
    public SysRoles getRole(int roleID) {
        if (haveRoles(roleID)) {
            for (Object sysRoles : this.sysRoles) {
                if (roleID == ((SysRoles) sysRoles).getRoleId()) {
                    return (SysRoles) sysRoles;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "SysUsers{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", dtCreate=" + dtCreate +
                ", lastLogin=" + lastLogin +
                ", deadline=" + deadline +
                ", loginIp='" + loginIp + '\'' +
                ", vQzjgid='" + vQzjgid + '\'' +
                ", vQzjgmc='" + vQzjgmc + '\'' +
                ", depId='" + depId + '\'' +
                ", depName='" + depName + '\'' +
                ", enabled=" + enabled +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", sysRoles=" + sysRoles +
                ", Authorities=" + SysAuthorities +
                '}';
    }
}