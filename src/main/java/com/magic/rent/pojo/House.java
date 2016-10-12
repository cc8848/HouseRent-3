package com.magic.rent.pojo;

import java.io.Serializable;

public class House implements Serializable {

    private static final long serialVersionUID = 2962959899715937016L;
    
    private int id;

    private String address;//房屋地址

    private int expectRent;//预期租金

    private String vrPath;//VR资源地址

    private String thumbnailPath;//缩略图地址

    private int communityId;//社区ID

    private int floor;//楼层

    private int room;//房间

    private int decorationTypeId;//装修类型ID

    private int provinceId;//省份ID

    private int cityId;//城市ID

    private int areaId;//地区ID

    private boolean haveKitcken;//是否带厨房

    private boolean haveBalcony;//是否带阳台

    private int houseStatusId;//房屋状态,如:出租

    private boolean enabled;//是否可用

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getExpectRent() {
        return expectRent;
    }

    public void setExpectRent(int expectRent) {
        this.expectRent = expectRent;
    }

    public String getVrPath() {
        return vrPath;
    }

    public void setVrPath(String vrPath) {
        this.vrPath = vrPath;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getDecorationTypeId() {
        return decorationTypeId;
    }

    public void setDecorationTypeId(int decorationTypeId) {
        this.decorationTypeId = decorationTypeId;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public boolean isHaveKitcken() {
        return haveKitcken;
    }

    public void setHaveKitcken(boolean haveKitcken) {
        this.haveKitcken = haveKitcken;
    }

    public boolean isHaveBalcony() {
        return haveBalcony;
    }

    public void setHaveBalcony(boolean haveBalcony) {
        this.haveBalcony = haveBalcony;
    }

    public int getHouseStatusId() {
        return houseStatusId;
    }

    public void setHouseStatusId(int houseStatusId) {
        this.houseStatusId = houseStatusId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}