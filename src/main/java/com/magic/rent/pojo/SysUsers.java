package com.magic.rent.pojo;

import java.util.Date;

public class SysUsers {
    private Integer userId;

    private String username;

    private String name;

    private String password;

    private Date dtCreate;

    private Date lastLogin;

    private Date deadline;

    private String loginIp;

    private String vQzjgid;

    private String vQzjgmc;

    private String depId;

    private String depName;

    private Integer enabled;

    private Integer accountNonExpired;

    private Integer accountNonLocked;

    private Integer credentialsNonExpired;

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

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Integer accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Integer getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Integer accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Integer getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Integer credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }
}