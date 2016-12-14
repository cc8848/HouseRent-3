package com.magic.rent.pojo;

import com.magic.rent.util.DateUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class SysUsers implements Serializable, UserDetails {
    private static final long serialVersionUID = 7757250372112303787L;

    private Integer userId;

    private String username;

    private String name;

    private String password;

    private Boolean sex;

    private String license;

    private Integer job;

    private String companyAbbr;

    private Date dtCreate;

    private Date lastLogin;
    private String lastLoginString;

    private Date deadline;

    private String loginIp;

    private boolean enabled;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private Integer major;

    private Collection<? extends SysRoles> sysRoles;//用户权限

    private Collection<? extends GrantedAuthority> SysAuthorities;//权限列表

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

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license == null ? null : license.trim();
    }

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }

    public String getCompanyAbbr() {
        return companyAbbr;
    }

    public void setCompanyAbbr(String companyAbbr) {
        this.companyAbbr = companyAbbr == null ? null : companyAbbr.trim();
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
        this.setLastLoginString(DateUtil.formatToYMD(this.lastLogin));
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

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }


    public boolean isEnabled() {
        return enabled;
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

    public Collection<? extends SysRoles> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(Collection<? extends SysRoles> sysRoles) {
        this.sysRoles = sysRoles;
    }

    public Collection<? extends GrantedAuthority> getSysAuthorities() {
        return SysAuthorities;
    }

    public void setSysAuthorities(Collection<? extends GrantedAuthority> sysAuthorities) {
        SysAuthorities = sysAuthorities;
    }

    public String getLastLoginString() {
        return lastLoginString;
    }

    public void setLastLoginString(String lastLoginString) {
        this.lastLoginString = lastLoginString;
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getSysAuthorities();
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.setSysAuthorities(authorities);
    }


    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }


}