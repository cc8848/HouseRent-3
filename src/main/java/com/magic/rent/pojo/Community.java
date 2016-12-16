package com.magic.rent.pojo;

import com.magic.rent.tools.DateTools;

import java.io.Serializable;
import java.util.Date;

public class Community implements Serializable {

    private static final long serialVersionUID = 598629396944896191L;

    private Integer id;

    private String name;

    private Integer provinceId;

    private Integer cityId;

    private Integer areaId;

    private String address;

    private Double lng;

    private Double lat;

    private Integer companyId;

    private Integer status;

    private String statusName;

    private Date auditingTime;

    private String auditingTimeString;

    private Date operateTime;

    private Date openTime;

    private Date realEstateTime;

    private String estateManageCompany;

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
        this.address = address;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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
        this.setAuditingTimeString(DateTools.formatToYMD(this.auditingTime));
    }

    public String getAuditingTimeString() {
        return auditingTimeString;
    }

    public void setAuditingTimeString(String auditingTimeString) {
        this.auditingTimeString = auditingTimeString;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getRealEstateTime() {
        return realEstateTime;
    }

    public void setRealEstateTime(Date realEstateTime) {
        this.realEstateTime = realEstateTime;
    }

    public String getEstateManageCompany() {
        return estateManageCompany;
    }

    public void setEstateManageCompany(String estateManageCompany) {
        this.estateManageCompany = estateManageCompany;
    }


    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", areaId=" + areaId +
                ", address='" + address + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", companyId=" + companyId +
                ", status=" + status +
                ", statusName='" + statusName + '\'' +
                ", auditingTime=" + auditingTime +
                ", operateTime=" + operateTime +
                ", openTime=" + openTime +
                ", realEstateTime=" + realEstateTime +
                ", estateManageCompany='" + estateManageCompany + '\'' +
                '}';
    }
}