package com.magic.rent.pojo;

import java.io.Serializable;

public class SysCompany implements Serializable {

    private static final long serialVersionUID = -234051079996807683L;

    private int id;

    private String companyName;//公司名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }
}