package com.magic.rent.pojo;

import java.io.Serializable;

public class UserSeller implements Serializable {

    private static final long serialVersionUID = 1801950405948724304L;

    private Integer id;

    private Integer userId;//对应用户信息
    private SysUsers sysUsers;

    private Integer storeId;//归属门店、机构
    private SysStore sysStore;

    private boolean enabled;

    private Integer statusId;
    private UserStatus userStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
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

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
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