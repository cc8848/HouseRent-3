package com.magic.rent.pojo;

import java.util.Date;
import java.util.List;

public class SysUsers {
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

    private List<SysRoles> sysRoles;//用户权限

    public List<SysRoles> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(List<SysRoles> sysRoles) {
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
}