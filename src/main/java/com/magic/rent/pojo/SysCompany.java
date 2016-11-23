package com.magic.rent.pojo;

import java.io.Serializable;

public class SysCompany implements Serializable {

    private static final long serialVersionUID = -234051079996807683L;

    private Integer id;

    private String companyName;//公司名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    @Override
    public String toString() {
        return "SysCompany{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}