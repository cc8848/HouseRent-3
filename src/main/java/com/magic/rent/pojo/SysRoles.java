package com.magic.rent.pojo;

import java.io.Serializable;

public class SysRoles implements Serializable {
    private static final long serialVersionUID = -9186978677768047958L;
    private Integer roleId; //角色ID

    private String roleName;//角色名

    private String roleDesc;//角色描述

    private boolean enable;//是否可用

    private boolean isSys;//是否系统权限

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isSys() {
        return isSys;
    }

    public void setSys(boolean sys) {
        isSys = sys;
    }


    @Override
    public String toString() {
        return "SysRoles{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", enable=" + enable +
                ", isSys=" + isSys +
                '}';
    }
}