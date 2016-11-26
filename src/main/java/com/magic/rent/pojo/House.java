package com.magic.rent.pojo;

public class House {
    private Integer id;

    private String tittle;

    private String description;

    private Integer faceId;

    private Double floorArea;

    private Double poolArea;

    private Double expectPrice;

    private Boolean thumbnailMode;

    private Boolean vrMode;

    private Integer communityId;

    private Integer floor;

    private Integer layoutId;

    private Integer decorationTypeId;

    private Integer provinceId;

    private Integer cityId;

    private Integer areaId;

    private String address;

    private Integer houseStatusId;

    private Boolean enabled;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Double getExpectPrice() {
        return expectPrice;
    }

    public void setExpectPrice(Double expectPrice) {
        this.expectPrice = expectPrice;
    }

    public Boolean getThumbnailMode() {
        return thumbnailMode;
    }

    public void setThumbnailMode(Boolean thumbnailMode) {
        this.thumbnailMode = thumbnailMode;
    }

    public Boolean getVrMode() {
        return vrMode;
    }

    public void setVrMode(Boolean vrMode) {
        this.vrMode = vrMode;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}