package com.magic.rent.pojo;

import java.io.Serializable;
import java.util.List;

public class House implements Serializable {

    private static final long serialVersionUID = 2962959899715937016L;

    private Integer id;

    private String address;//房屋地址

    private String name;//房屋名字

    private double expectPrice;//预期租金

    private String vrPath;//VR资源地址

    private String thumbnailPath;//缩略图地址

    private Integer communityId;//社区ID
    private Community community;

    private Integer floor;//楼层

    private Integer layoutID;//房间布局
    private HouseLayout houseLayout;//房间布局

    private Integer decorationTypeId;//装修类型ID
    private DecorationType decorationType;

    private Integer provinceId;//省份ID
    private Province province;

    private Integer cityId;//城市ID
    private City city;

    private Integer areaId;//地区ID
    private Area area;

    private boolean haveKitcken;//是否带厨房

    private boolean haveBalcony;//是否带阳台

    private Integer houseStatusId;//房屋状态,如:出租
    private HouseStatus houseStatus;

    private Integer expectPaymentId;//预期付租方式
    private Payment expectPayment;

    private double areaNumber;

    private boolean enabled;//是否可用

    private List<Rooms> roomsList;//房间列表

    private List<RentMode> rentModeList;//出租模式

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getExpectPrice() {
        return expectPrice;
    }

    public void setExpectPrice(double expectPrice) {
        this.expectPrice = expectPrice;
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

    public Integer getLayoutID() {
        return layoutID;
    }

    public void setLayoutID(Integer layoutID) {
        this.layoutID = layoutID;
    }

    public Integer getExpectPaymentId() {
        return expectPaymentId;
    }

    public void setExpectPaymentId(Integer expectPaymentId) {
        this.expectPaymentId = expectPaymentId;
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

    public Integer getHouseStatusId() {
        return houseStatusId;
    }

    public void setHouseStatusId(Integer houseStatusId) {
        this.houseStatusId = houseStatusId;
    }

    public HouseLayout getHouseLayout() {
        return houseLayout;
    }

    public void setHouseLayout(HouseLayout houseLayout) {
        this.houseLayout = houseLayout;
    }

    public double getAreaNumber() {
        return areaNumber;
    }

    public void setAreaNumber(double areaNumber) {
        this.areaNumber = areaNumber;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public DecorationType getDecorationType() {
        return decorationType;
    }

    public void setDecorationType(DecorationType decorationType) {
        this.decorationType = decorationType;
    }

    public HouseStatus getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(HouseStatus houseStatus) {
        this.houseStatus = houseStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Payment getExpectPayment() {
        return expectPayment;
    }

    public void setExpectPayment(Payment expectPayment) {
        this.expectPayment = expectPayment;
    }

    public Integer getExpectPaymentID() {
        return expectPaymentId;
    }

    public void setExpectPaymentID(Integer expectPaymentID) {
        this.expectPaymentId = expectPaymentID;
    }

    public List<Rooms> getRoomsList() {
        return roomsList;
    }

    public void setRoomsList(List<Rooms> roomsList) {
        this.roomsList = roomsList;
    }

    public List<RentMode> getRentModeList() {
        return rentModeList;
    }

    public void setRentModeList(List<RentMode> rentModeList) {
        this.rentModeList = rentModeList;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", expectPrice=" + expectPrice +
                ", vrPath='" + vrPath + '\'' +
                ", thumbnailPath='" + thumbnailPath + '\'' +
                ", communityId=" + communityId +
                ", community=" + community +
                ", floor=" + floor +
                ", layoutID=" + layoutID +
                ", houseLayout=" + houseLayout +
                ", decorationTypeId=" + decorationTypeId +
                ", decorationType=" + decorationType +
                ", provinceId=" + provinceId +
                ", province=" + province +
                ", cityId=" + cityId +
                ", city=" + city +
                ", areaId=" + areaId +
                ", area=" + area +
                ", haveKitcken=" + haveKitcken +
                ", haveBalcony=" + haveBalcony +
                ", houseStatusId=" + houseStatusId +
                ", houseStatus=" + houseStatus +
                ", expectPaymentId=" + expectPaymentId +
                ", expectPayment=" + expectPayment +
                ", areaNumber=" + areaNumber +
                ", enabled=" + enabled +
                ", roomsList=" + roomsList +
                ", rentModeList=" + rentModeList +
                '}';
    }
}