package com.magic.rent.pojo;

import java.io.Serializable;

public class Rooms implements Serializable {

    private static final long serialVersionUID = 2016121030063969681L;

    private int id;

    private int roomNo;//房间号

    private double area;//房间面积

    private boolean haveWashroom;//是否带独立厕所

    private boolean haveKitcken;//是否带独立厨房

    private int houseId;//房屋ID

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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
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
}