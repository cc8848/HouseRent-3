package com.magic.rent.pojo;

import java.io.Serializable;

public class Rooms implements Serializable {

    private static final long serialVersionUID = 2016121030063969681L;

    private Integer id;

    private Integer roomNo;//房间号

    private double areaNumber;//房间面积

    private boolean haveWashroom;//是否带独立厕所

    private boolean haveKitcken;//是否带独立厨房

    private boolean haveDesk;//是否带书桌

    private boolean haveWardrobe;//是否有衣橱

    private boolean haveAirConditioning;//是否有空调

    private boolean haveWaterHeater;//是否有热水器

    private boolean haveWLAN;//是否有宽带

    private Integer houseId;//房屋ID

    private double expectPrice;//预期租金

    private Integer houseStatusId;
    private HouseStatus houseStatus;//房屋状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public double getAreaNumber() {
        return areaNumber;
    }

    public void setAreaNumber(double areaNumber) {
        this.areaNumber = areaNumber;
    }

    public boolean isHaveWashroom() {
        return haveWashroom;
    }

    public void setHaveWashroom(boolean haveWashroom) {
        this.haveWashroom = haveWashroom;
    }

    public boolean isHaveKitcken() {
        return haveKitcken;
    }

    public void setHaveKitcken(boolean haveKitcken) {
        this.haveKitcken = haveKitcken;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public double getExpectPrice() {
        return expectPrice;
    }

    public void setExpectPrice(double expectPrice) {
        this.expectPrice = expectPrice;
    }

    public Integer getHouseStatusId() {
        return houseStatusId;
    }

    public void setHouseStatusId(Integer houseStatusId) {
        this.houseStatusId = houseStatusId;
    }

    public HouseStatus getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(HouseStatus houseStatus) {
        this.houseStatus = houseStatus;
    }

    public boolean isHaveDesk() {
        return haveDesk;
    }

    public void setHaveDesk(boolean haveDesk) {
        this.haveDesk = haveDesk;
    }

    public boolean isHaveWardrobe() {
        return haveWardrobe;
    }

    public void setHaveWardrobe(boolean haveWardrobe) {
        this.haveWardrobe = haveWardrobe;
    }

    public boolean isHaveAirConditioning() {
        return haveAirConditioning;
    }

    public void setHaveAirConditioning(boolean haveAirConditioning) {
        this.haveAirConditioning = haveAirConditioning;
    }

    public boolean isHaveWaterHeater() {
        return haveWaterHeater;
    }

    public void setHaveWaterHeater(boolean haveWaterHeater) {
        this.haveWaterHeater = haveWaterHeater;
    }

    public boolean isHaveWLAN() {
        return haveWLAN;
    }

    public void setHaveWLAN(boolean haveWLAN) {
        this.haveWLAN = haveWLAN;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "id=" + id +
                ", roomNo=" + roomNo +
                ", areaNumber=" + areaNumber +
                ", haveWashroom=" + haveWashroom +
                ", haveKitcken=" + haveKitcken +
                ", haveDesk=" + haveDesk +
                ", haveWardrobe=" + haveWardrobe +
                ", haveAirConditioning=" + haveAirConditioning +
                ", haveWaterHeater=" + haveWaterHeater +
                ", haveWLAN=" + haveWLAN +
                ", houseId=" + houseId +
                ", expectPrice=" + expectPrice +
                ", houseStatusId=" + houseStatusId +
                ", houseStatus=" + houseStatus +
                '}';
    }
}