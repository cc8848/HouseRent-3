package com.magic.rent.pojo;

import java.io.Serializable;

public class UserSeller implements Serializable {
    private static final long serialVersionUID = 4833265754924379213L;
    private int id;

    private int userId;
    private SysUsers sysUsers;

    private int rolesId;
    private SysRoles sysRoles;

    private int companyId;
    private SysCompany sysCompany;

    private int storeId;
    private SysStore sysStore;

    private boolean enabled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRolesId() {
        return rolesId;
    }

    public void setRolesId(int rolesId) {
        this.rolesId = rolesId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public SysUsers getSysUsers() {
        return sysUsers;
    }

    public void setSysUsers(SysUsers sysUsers) {
        this.sysUsers = sysUsers;
    }

    public SysRoles getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(SysRoles sysRoles) {
        this.sysRoles = sysRoles;
    }

    public SysCompany getSysCompany() {
        return sysCompany;
    }

    public void setSysCompany(SysCompany sysCompany) {
        this.sysCompany = sysCompany;
    }

    public SysStore getSysStore() {
        return sysStore;
    }

    public void setSysStore(SysStore sysStore) {
        this.sysStore = sysStore;
    }

    @Override
    public String toString() {
        return "UserSeller{" +
                "id=" + id +
                ", userId=" + userId +
                ", sysUsers=" + sysUsers +
                ", rolesId=" + rolesId +
                ", sysRoles=" + sysRoles +
                ", companyId=" + companyId +
                ", sysCompany=" + sysCompany +
                ", storeId=" + storeId +
                ", sysStore=" + sysStore +
                ", enabled=" + enabled +
                '}';
    }
}