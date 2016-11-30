package com.magic.rent.pojo;

import java.util.Date;

public class Community {
    private Integer id;

    private String name;

    private Integer provinceId;

    private Integer cityId;

    private Integer areaId;

    private Double mapX;

    private Double mapY;

    private Integer companyId;

    private Integer status;

    private Date auditingTime;

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

    public Double getMapX() {
        return mapX;
    }

    public void setMapX(Double mapX) {
        this.mapX = mapX;
    }

    public Double getMapY() {
        return mapY;
    }

    public void setMapY(Double mapY) {
        this.mapY = mapY;
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
        this.estateManageCompany = estateManageCompany == null ? null : estateManageCompany.trim();
    }
}