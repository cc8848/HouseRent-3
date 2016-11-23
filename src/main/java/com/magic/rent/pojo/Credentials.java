package com.magic.rent.pojo;

import java.io.Serializable;
import java.util.Date;

public class Credentials implements Serializable {
    private static final long serialVersionUID = -853063805366700176L;
    private Integer id;//记录编号

    private Integer typeId;//类型ID

    private String number;//证件号码

    private String address;//证件地址

    private String issuingAuthority;//发证机关

    private Date validityDate;//有效期

    private boolean validity;//是否有效?

    private Integer userId;//用户ID

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority == null ? null : issuingAuthority.trim();
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public boolean isValidity() {
        return validity;
    }

    public void setValidity(boolean validity) {
        this.validity = validity;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", issuingAuthority='" + issuingAuthority + '\'' +
                ", validityDate=" + validityDate +
                ", validity=" + validity +
                ", userId=" + userId +
                '}';
    }
}