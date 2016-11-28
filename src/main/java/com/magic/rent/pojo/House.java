package com.magic.rent.pojo;

import com.magic.rent.util.DecimalUtil;

import java.io.Serializable;
import java.text.DecimalFormat;

public class House implements Serializable {
    private static final long serialVersionUID = -6956703009417525418L;
    private Integer id;

    private String tittle;

    private String description;

    private Integer faceId;
    private HouseFace houseFace;

    private Double floorArea;

    private Double poolArea;

    private Double expectPrice;

    private Double propertyFee;

    private Boolean thumbnailMode;

    private Boolean vrMode;

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

    private Integer houseStatusId;
    private HouseStatus houseStatus;

    private Boolean enabled;

    private Integer age;

    private Integer elevatorTypeId;
    private HouseElevator houseElevator;

    private String unitPrice;

    public String getUnitPrice() {
        double money = this.expectPrice / this.floorArea;

        this.unitPrice = DecimalUtil.formateMoney(money);

        return unitPrice;
    }

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

    public Double getPropertyFee() {
        return propertyFee;
    }

    public void setPropertyFee(Double propertyFee) {
        this.propertyFee = propertyFee;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public HouseFace getHouseFace() {
        return houseFace;
    }

    public void setHouseFace(HouseFace houseFace) {
        this.houseFace = houseFace;
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

    public HouseStatus getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(HouseStatus houseStatus) {
        this.houseStatus = houseStatus;
    }

    public Integer getElevatorTypeId() {
        return elevatorTypeId;
    }

    public void setElevatorTypeId(Integer elevatorTypeId) {
        this.elevatorTypeId = elevatorTypeId;
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
                ", houseFace=" + houseFace +
                ", floorArea=" + floorArea +
                ", poolArea=" + poolArea +
                ", expectPrice=" + expectPrice +
                ", propertyFee=" + propertyFee +
                ", thumbnailMode=" + thumbnailMode +
                ", vrMode=" + vrMode +
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
                ", houseStatusId=" + houseStatusId +
                ", houseStatus=" + houseStatus +
                ", enabled=" + enabled +
                ", age=" + age +
                ", elevatorTypeId=" + elevatorTypeId +
                ", houseElevator=" + houseElevator +
                ", unitPrice='" + unitPrice + '\'' +
                '}';
    }
}