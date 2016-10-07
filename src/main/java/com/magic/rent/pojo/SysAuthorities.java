package com.magic.rent.pojo;

import java.io.Serializable;

public class SysAuthorities implements Serializable {
    private static final long serialVersionUID = 7358097993806107543L;

    private Integer authorityId;//权限ID

    private String authorityMark;//权限标识(主要,用于判断的)

    private String authorityName;//权限名

    private String authorityDesc;//权限描述

    private String message;//提示信息

    private boolean enable;//是否可用

    private boolean isSys;//是否系统级

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityMark() {
        return authorityMark;
    }

    public void setAuthorityMark(String authorityMark) {
        this.authorityMark = authorityMark == null ? null : authorityMark.trim();
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName == null ? null : authorityName.trim();
    }

    public String getAuthorityDesc() {
        return authorityDesc;
    }

    public void setAuthorityDesc(String authorityDesc) {
        this.authorityDesc = authorityDesc == null ? null : authorityDesc.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
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
}