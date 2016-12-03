package com.magic.rent.pojo;

import com.magic.rent.util.DateUtil;

import java.io.Serializable;
import java.util.Date;

public class Company implements Serializable {
    private static final long serialVersionUID = 858996675606879242L;

    private Integer id;

    private String companyName;

    private String address;

    private String phone;

    private Integer developerId;

    private Integer status;

    private Date auditingTime;

    private Date operateTime;

    private String operateTimeString;

    private String statusName;

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
        this.setStatusName(SysStatus.idToName(this.status));
    }

    public Date getAuditingTime() {
        return auditingTime;
    }

    public void setAuditingTime(Date auditingTime) {
        this.auditingTime = auditingTime;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
        this.setOperateTimeString(DateUtil.formatToYMD(this.operateTime));
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        this.setStatusName(SysStatus.idToName(this.status));
        return statusName;
    }

    public String getOperateTimeString() {
        return operateTimeString;
    }

    public void setOperateTimeString(String operateTimeString) {
        this.operateTimeString = operateTimeString;
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
                ", auditingTime=" + auditingTime +
                ", operateTime=" + operateTime +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}