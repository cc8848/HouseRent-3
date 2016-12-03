package com.magic.rent.pojo;

import java.io.Serializable;
import java.util.Date;

public class House implements Serializable {
    private static final long serialVersionUID = 8725709612109250370L;
    private Integer id;

    private String tittle;

    private String description;

    private Integer faceId;
    private String faceName;


    private Double floorArea;

    private Double poolArea;

    private Double expectPrice;

    private Double unitPrice;

    private Double brokerage;

    private Integer communityId;
    private Community community;

    private Integer floor;

    private Integer layoutId;
    private HouseLayout houseLayout;

    private Integer houseDecorationId;
    private HouseDecoration houseDecoration;

    private Integer provinceId;
    private Province province;

    private Integer cityId;
    private City city;

    private Integer areaId;
    private Area area;

    private String address;

    private Integer elevatorTypeId;
    private HouseElevator houseElevator;

    private Integer age;

    private Integer houseStatus;

    private Integer sysStatus;

    private String sysStatusName;

    private Date auditingTime;

    private Date operateTime;

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
        this.setFaceName(HouseFace.idToName(this.faceId));
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

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(Double brokerage) {
        this.brokerage = brokerage;
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

    public Integer getHouseDecorationId() {
        return houseDecorationId;
    }

    public void setHouseDecorationId(Integer houseDecorationId) {
        this.houseDecorationId = houseDecorationId;
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

    public Integer getElevatorTypeId() {
        return elevatorTypeId;
    }

    public void setElevatorTypeId(Integer elevatorTypeId) {
        this.elevatorTypeId = elevatorTypeId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(Integer houseStatus) {
        this.houseStatus = houseStatus;
    }

    public Integer getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(Integer sysStatus) {
        this.sysStatus = sysStatus;
        this.setSysStatusName(SysStatus.idToName(this.sysStatus));
    }

    public String getSysStatusName() {
        return sysStatusName;
    }

    public void setSysStatusName(String sysStatusName) {
        this.sysStatusName = sysStatusName;
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

    public String getFaceName() {
        return faceName;
    }

    public void setFaceName(String faceName) {
        this.faceName = faceName;
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

    public HouseDecoration getHouseDecoration() {
        return houseDecoration;
    }

    public void setHouseDecoration(HouseDecoration houseDecoration) {
        this.houseDecoration = houseDecoration;
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

    public HouseElevator getHouseElevator() {
        return houseElevator;
    }

    public void setHouseElevator(HouseElevator houseElevator) {
        this.houseElevator = houseElevator;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                ", faceId=" + faceId +
                ", faceName='" + faceName + '\'' +
                ", floorArea=" + floorArea +
                ", poolArea=" + poolArea +
                ", expectPrice=" + expectPrice +
                ", brokerage=" + brokerage +
                ", communityId=" + communityId +
                ", community=" + community +
                ", floor=" + floor +
                ", layoutId=" + layoutId +
                ", houseLayout=" + houseLayout +
                ", houseDecorationId=" + houseDecorationId +
                ", houseDecoration=" + houseDecoration +
                ", provinceId=" + provinceId +
                ", province=" + province +
                ", cityId=" + cityId +
                ", city=" + city +
                ", areaId=" + areaId +
                ", area=" + area +
                ", address='" + address + '\'' +
                ", elevatorTypeId=" + elevatorTypeId +
                ", houseElevator=" + houseElevator +
                ", age=" + age +
                ", houseStatus=" + houseStatus +
                ", sysStatus=" + sysStatus +
                ", sysStatusName='" + sysStatusName + '\'' +
                ", auditingTime=" + auditingTime +
                ", operateTime=" + operateTime +
                '}';
    }
}