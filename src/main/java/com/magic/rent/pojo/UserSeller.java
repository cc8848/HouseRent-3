package com.magic.rent.pojo;

import java.io.Serializable;

public class UserSeller implements Serializable {

    private static final long serialVersionUID = 1801950405948724304L;

    private int id;

    private int userId;
    private SysUsers sysUsers;

    private int rolesId;
    private SysRoles sysRoles;

    private int storeId;
    private SysStore sysStore;

    private boolean enabled;

    private int statusId;
    private UserStatus userStatus;

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

    public SysStore getSysStore() {
        return sysStore;
    }

    public void setSysStore(SysStore sysStore) {
        this.sysStore = sysStore;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }
}