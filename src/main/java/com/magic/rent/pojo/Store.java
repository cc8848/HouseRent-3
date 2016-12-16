package com.magic.rent.pojo;

import com.magic.rent.tools.DateTools;

import java.io.Serializable;
import java.util.Date;

public class Store implements Serializable {

    private static final long serialVersionUID = 4344667495909844715L;

    private Integer id;

    private String name;

    private Integer manageId;

    private Integer provinceId;
    private Province province;

    private Integer cityId;
    private City city;

    private Integer areaId;
    private Area area;

    private String address;

    private Integer sysStatus;
    private String sysStatusName;

    private Date auditingTime;
    private String auditingTimeString;

    private Date operateTime;
    private String operateTimeString;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getManageId() {
        return manageId;
    }

    public void setManageId(Integer manageId) {
        this.manageId = manageId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(Integer sysStatus) {
        this.sysStatus = sysStatus;
        this.setSysStatusName(SysStatus.idToName(this.sysStatus));
    }

    public Date getAuditingTime() {
        return auditingTime;
    }

    public void setAuditingTime(Date auditingTime) {
        this.auditingTime = auditingTime;
        this.setAuditingTimeString(DateTools.formatToYMD(this.auditingTime));
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
        this.setOperateTimeString(DateTools.formatToYMD(this.operateTime));
    }

    public String getSysStatusName() {
        return sysStatusName;
    }

    public void setSysStatusName(String sysStatusName) {
        this.sysStatusName = sysStatusName;
    }

    public String getAuditingTimeString() {
        return auditingTimeString;
    }

    public void setAuditingTimeString(String auditingTimeString) {
        this.auditingTimeString = auditingTimeString;
    }

    public String getOperateTimeString() {
        return operateTimeString;
    }

    public void setOperateTimeString(String operateTimeString) {
        this.operateTimeString = operateTimeString;
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

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manageId=" + manageId +
                ", provinceId=" + provinceId +
                ", province=" + province +
                ", cityId=" + cityId +
                ", city=" + city +
                ", areaId=" + areaId +
                ", area=" + area +
                ", address='" + address + '\'' +
                ", sysStatus=" + sysStatus +
                ", sysStatusName='" + sysStatusName + '\'' +
                ", auditingTime=" + auditingTime +
                ", auditingTimeString='" + auditingTimeString + '\'' +
                ", operateTime=" + operateTime +
                ", operateTimeString='" + operateTimeString + '\'' +
                '}';
    }
}