package com.magic.rent.pojo;

import java.io.Serializable;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/22
 * 类说明:
 * 更新记录：
 */
public class HandHouseBase extends HandHousePrice implements Serializable {

    private static final long serialVersionUID = -2675783518156859490L;

    private Integer serialNum;//公司内编号

    private Integer provinceId;//省份

    private Integer cityId;//城市

    private Integer areaId;//地区

    private String communityName;//社区名称

    private Integer roomQuantity;//房间数量

    private Integer hallQuantity;//厅数量

    private Integer bathroomQuantity;//卫生间数量

    private Integer type;//房屋类型

    private Integer decoration;//装修类型

    private Integer orientation;//朝向

    private Integer currentFloor;//当前楼层

    private Integer totalFloor;//总层数

    private Double floorArea;//建筑面积

    private Integer buildAge;//建设年份

    private String panoramaSrc;//全景资源地址

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
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

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName == null ? null : communityName.trim();
    }

    public Integer getRoomQuantity() {
        return roomQuantity;
    }

    public void setRoomQuantity(Integer roomQuantity) {
        this.roomQuantity = roomQuantity;
    }

    public Integer getHallQuantity() {
        return hallQuantity;
    }

    public void setHallQuantity(Integer hallQuantity) {
        this.hallQuantity = hallQuantity;
    }

    public Integer getBathroomQuantity() {
        return bathroomQuantity;
    }

    public void setBathroomQuantity(Integer bathroomQuantity) {
        this.bathroomQuantity = bathroomQuantity;
    }

    public Integer getType() {
        return type;
    }

    public String getTypeName() {
        if (null == this.type) {
            return HandHouse.UNDEFINED;
        } else {
            return HandHouse.TYPE_MAP.get(this.type);
        }
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDecoration() {
        return decoration;
    }

    public String getDecorationName() {
        if (null == this.decoration) {
            return HandHouse.UNDEFINED;
        } else {
            return HandHouse.DECORATION_MAP.get(this.decoration);
        }
    }

    public void setDecoration(Integer decoration) {
        this.decoration = decoration;
    }

    public Integer getOrientation() {
        return orientation;
    }

    public String getOrientationName() {
        if (null == this.orientation) {
            return HandHouse.UNDEFINED;
        } else {
            return HandHouse.ORIENTATION_MAP.get(this.orientation);
        }
    }

    public void setOrientation(Integer orientation) {
        this.orientation = orientation;
    }

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Integer currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Integer getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    public Double getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Double floorArea) {
        this.floorArea = floorArea;
    }

    public Integer getBuildAge() {
        return buildAge;
    }

    public void setBuildAge(Integer buildAge) {
        this.buildAge = buildAge;
    }

    public String getPanoramaSrc() {
        return panoramaSrc;
    }

    public void setPanoramaSrc(String panoramaSrc) {
        this.panoramaSrc = panoramaSrc == null ? null : panoramaSrc.trim();
    }


    @Override
    public String toString() {
        return "HandHouseBase{" +
                "serialNum=" + serialNum +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", areaId=" + areaId +
                ", communityName='" + communityName + '\'' +
                ", roomQuantity=" + roomQuantity +
                ", hallQuantity=" + hallQuantity +
                ", bathroomQuantity=" + bathroomQuantity +
                ", type=" + type +
                ", decoration=" + decoration +
                ", orientation=" + orientation +
                ", currentFloor=" + currentFloor +
                ", totalFloor=" + totalFloor +
                ", floorArea=" + floorArea +
                ", buildAge=" + buildAge +
                ", panoramaSrc='" + panoramaSrc + '\'' +
                '}';
    }
}
