package com.magic.rent.pojo;

import java.io.Serializable;

public class Rooms implements Serializable {

    private static final long serialVersionUID = 2016121030063969681L;

    private int id;

    private int roomNo;//房间号

    private double areaNumber;//房间面积

    private boolean haveWashroom;//是否带独立厕所

    private boolean haveKitcken;//是否带独立厨房

    private int houseId;//房屋ID

    private double expectRent;//预期租金

    private int houseStatusId;
    private HouseStatus houseStatus;//房屋状态

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
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

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public double getExpectRent() {
        return expectRent;
    }

    public void setExpectRent(double expectRent) {
        this.expectRent = expectRent;
    }

    public int getHouseStatusId() {
        return houseStatusId;
    }

    public void setHouseStatusId(int houseStatusId) {
        this.houseStatusId = houseStatusId;
    }

    public HouseStatus getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(HouseStatus houseStatus) {
        this.houseStatus = houseStatus;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "id=" + id +
                ", roomNo=" + roomNo +
                ", areaNumber=" + areaNumber +
                ", haveWashroom=" + haveWashroom +
                ", haveKitcken=" + haveKitcken +
                ", houseId=" + houseId +
                ", expectRent=" + expectRent +
                ", houseStatusId=" + houseStatusId +
                ", houseStatus=" + houseStatus +
                '}';
    }
}