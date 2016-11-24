package com.magic.rent.pojo;

import java.io.Serializable;

public class House implements Serializable {
    private static final long serialVersionUID = -2530142620440534117L;
    private Integer id;

    private String tittle;

    private String desc;

    private Integer faceId;

    private Double areaNumber;

    private Double expectPrice;

    private Integer viewMode;

    private Integer communityId;

    private Integer floor;

    private Integer layoutId;

    private Integer decorationTypeId;

    private Integer provinceId;

    private Integer cityId;

    private Integer areaId;

    private String address;

    private Integer houseStatusId;

    private Byte enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle == null ? null : tittle.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Integer getFaceId() {
        return faceId;
    }

    public void setFaceId(Integer faceId) {
        this.faceId = faceId;
    }

    public Double getAreaNumber() {
        return areaNumber;
    }

    public void setAreaNumber(Double areaNumber) {
        this.areaNumber = areaNumber;
    }

    public Double getExpectPrice() {
        return expectPrice;
    }

    public void setExpectPrice(Double expectPrice) {
        this.expectPrice = expectPrice;
    }

    public Integer getViewMode() {
        return viewMode;
    }

    public void setViewMode(Integer viewMode) {
        this.viewMode = viewMode;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(Integer layoutId) {
        this.layoutId = layoutId;
    }

    public Integer getDecorationTypeId() {
        return decorationTypeId;
    }

    public void setDecorationTypeId(Integer decorationTypeId) {
        this.decorationTypeId = decorationTypeId;
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

    public Integer getHouseStatusId() {
        return houseStatusId;
    }

    public void setHouseStatusId(Integer houseStatusId) {
        this.houseStatusId = houseStatusId;
    }

    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", desc='" + desc + '\'' +
                ", faceId=" + faceId +
                ", areaNumber=" + areaNumber +
                ", expectPrice=" + expectPrice +
                ", viewMode=" + viewMode +
                ", communityId=" + communityId +
                ", floor=" + floor +
                ", layoutId=" + layoutId +
                ", decorationTypeId=" + decorationTypeId +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", areaId=" + areaId +
                ", address='" + address + '\'' +
                ", houseStatusId=" + houseStatusId +
                ", enabled=" + enabled +
                '}';
    }
}