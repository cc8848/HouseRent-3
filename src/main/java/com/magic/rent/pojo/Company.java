package com.magic.rent.pojo;

import java.io.Serializable;

public class Company implements Serializable {
    private static final long serialVersionUID = 4700876825684740601L;

    public final static int AUDITING = 1;

    public final static int SUCCESS = 2;

    public final static int FAIL = 3;

    public final static int EXPIRE = 4;//过期

    private Integer id;

    private String companyName;

    private String address;

    private String phone;

    private Integer developerId;

    private Integer status;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", developerId=" + developerId +
                ", status=" + status +
                '}';
    }
}