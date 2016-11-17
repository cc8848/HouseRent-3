package com.magic.rent.pojo;

import java.io.Serializable;

public class SysStore implements Serializable {

    private static final long serialVersionUID = -323609581087723492L;

    private int id;

    private int companyId;
    private SysCompany sysCompany;//公司

    private int areaId;
    private Area area;//地区

    private String storeName;

    private String storeNumber;

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

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

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

    public SysCompany getSysCompany() {
        return sysCompany;
    }

    public void setSysCompany(SysCompany sysCompany) {
        this.sysCompany = sysCompany;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "SysStore{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", sysCompany=" + sysCompany +
                ", areaId=" + areaId +
                ", area=" + area +
                ", storeName='" + storeName + '\'' +
                ", storeNumber='" + storeNumber + '\'' +
                '}';
    }
}