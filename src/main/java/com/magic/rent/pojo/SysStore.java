package com.magic.rent.pojo;

import java.io.Serializable;

public class SysStore implements Serializable {

    private static final long serialVersionUID = 4969069650719938997L;

    private int id;

    private int companyId;
    private SysCompany sysCompany;

    private int provinceId;
    private Province province;

    private int cityId;
    private City city;

    private int areaId;
    private Area area;

    private String storeName;

    private String storeNumber;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber == null ? null : storeNumber.trim();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public SysCompany getSysCompany() {
        return sysCompany;
    }

    public void setSysCompany(SysCompany sysCompany) {
        this.sysCompany = sysCompany;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "SysStore{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", sysCompany=" + sysCompany +
                ", cityId=" + cityId +
                ", city=" + city +
                ", areaId=" + areaId +
                ", area=" + area +
                ", storeName='" + storeName + '\'' +
                ", storeNumber='" + storeNumber + '\'' +
                ", provinceId=" + provinceId +
                ", province=" + province +
                '}';
    }
}