package com.magic.rent.pojo;

import java.io.Serializable;

public class House implements Serializable {
    private static final long serialVersionUID = -2530142620440534117L;
    private Integer id;

    private String tittle;

    private String desc;

    private Integer faceId;
    private HouseFaceKey houseFaceKey;

    private Double floorArea;

    private Double poolArea;

    private Double expectPrice;

    private Integer viewModeID;
    private ViewMode viewMode;

    private Integer communityId;
    private Community community;

    private Integer floor;

    private Integer layoutId;
    private HouseLayout houseLayout;

    private Integer decorationTypeId;
    private DecorationType decorationType;

    private Integer provinceId;
    private Province province;

    private Integer cityId;
    private City city;

    private Integer areaId;
    private Area area;

    private String address;

    private Integer houseStatusId;
    private HouseStatus houseStatus;

    private boolean enabled;

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

    public Double getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Double floorArea) {
        this.floorArea = floorArea;
    }


    public Double getExpectPrice() {
        return expectPrice;
    }

    public void setExpectPrice(Double expectPrice) {
        this.expectPrice = expectPrice;
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

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
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

    public HouseFaceKey getHouseFaceKey() {
        return houseFaceKey;
    }

    public void setHouseFaceKey(HouseFaceKey houseFaceKey) {
        this.houseFaceKey = houseFaceKey;
    }

    public Integer getViewModeID() {
        return viewModeID;
    }

    public void setViewModeID(Integer viewModeID) {
        this.viewModeID = viewModeID;
    }

    public ViewMode getViewMode() {
        return viewMode;
    }

    public void setViewMode(ViewMode viewMode) {
        this.viewMode = viewMode;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public HouseLayout getHouseLayout() {
        return houseLayout;
    }

    public void setHouseLayout(HouseLayout houseLayout) {
        this.houseLayout = houseLayout;
    }

    public DecorationType getDecorationType() {
        return decorationType;
    }

    public void setDecorationType(DecorationType decorationType) {
        this.decorationType = decorationType;
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

    public HouseStatus getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(HouseStatus houseStatus) {
        this.houseStatus = houseStatus;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", desc='" + desc + '\'' +
                ", faceId=" + faceId +
                ", houseFaceKey=" + houseFaceKey +
                ", areaNumber=" + floorArea +
                ", expectPrice=" + expectPrice +
                ", viewModeID=" + viewModeID +
                ", viewMode=" + viewMode +
                ", communityId=" + communityId +
                ", community=" + community +
                ", floor=" + floor +
                ", layoutId=" + layoutId +
                ", houseLayout=" + houseLayout +
                ", decorationTypeId=" + decorationTypeId +
                ", decorationType=" + decorationType +
                ", provinceId=" + provinceId +
                ", province=" + province +
                ", cityId=" + cityId +
                ", city=" + city +
                ", areaId=" + areaId +
                ", area=" + area +
                ", address='" + address + '\'' +
                ", houseStatusId=" + houseStatusId +
                ", houseStatus=" + houseStatus +
                ", enabled=" + enabled +
                '}';
    }
}