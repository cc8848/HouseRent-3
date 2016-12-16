package com.magic.rent.pojo;

import com.magic.rent.tools.DateTools;

import java.io.Serializable;
import java.util.Date;

public class Company implements Serializable {
    private static final long serialVersionUID = 7120974156730495345L;
    private Integer id;

    private String companyName;

    private String address;

    private String phone;

    private Integer developerId;

    private Integer status;
    private String statusName;

    private Date operateTime;
    private String operateTimeString;

    private Date auditingTime;
    private String auditingTimeString;

    private Integer provinceId;
    private Province province;

    private Integer cityId;
    private City city;

    private Integer areaId;
    private Area area;

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

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
        this.setOperateTimeString(DateTools.formatToYMD(this.operateTime));
    }

    public Date getAuditingTime() {
        return auditingTime;
    }

    public void setAuditingTime(Date auditingTime) {
        this.auditingTime = auditingTime;
        this.setAuditingTimeString(DateTools.formatToYMD(this.auditingTime));
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getOperateTimeString() {
        return operateTimeString;
    }

    public void setOperateTimeString(String operateTimeString) {
        this.operateTimeString = operateTimeString;
    }

    public String getAuditingTimeString() {
        return auditingTimeString;
    }

    public void setAuditingTimeString(String auditingTimeString) {
        this.auditingTimeString = auditingTimeString;
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
                ", statusName='" + statusName + '\'' +
                ", operateTime=" + operateTime +
                ", operateTimeString='" + operateTimeString + '\'' +
                ", auditingTime=" + auditingTime +
                ", auditingTimeString='" + auditingTimeString + '\'' +
                ", provinceId=" + provinceId +
                ", province=" + province +
                ", cityId=" + cityId +
                ", city=" + city +
                ", areaId=" + areaId +
                ", area=" + area +
                '}';
    }
}