package com.magic.rent.pojo;

import java.io.Serializable;

public class SysRoles implements Serializable {

    private static final long serialVersionUID = -9186978677768047958L;

    public static int MEMBER = 1;//会员角色
    public static int MANAGER = 3;//门店经理角色
    public static int SELLER = 6;//经纪人角色

    private Integer roleId; //角色ID

    private String roleName;//角色名

    private String roleDesc;//角色描述

    private boolean enable;//是否可用

    private boolean system;//是否系统权限

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

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }


    @Override
    public String toString() {
        return "SysRoles{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", enable=" + enable +
                ", isSys=" + system +
                '}';
    }
}