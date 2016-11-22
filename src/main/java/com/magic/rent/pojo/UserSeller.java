package com.magic.rent.pojo;

import java.io.Serializable;

public class UserSeller implements Serializable {

    private static final long serialVersionUID = 1801950405948724304L;

    private int id;

    private int userId;//对应用户信息
    private SysUsers sysUsers;

    private int storeId;//归属门店、机构
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

    @Override
    public String toString() {
        return "UserSeller{" +
                "id=" + id +
                ", userId=" + userId +
                ", sysUsers=" + sysUsers +
                ", storeId=" + storeId +
                ", sysStore=" + sysStore +
                ", enabled=" + enabled +
                ", statusId=" + statusId +
                ", userStatus=" + userStatus +
                '}';
    }
}