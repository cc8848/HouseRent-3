package com.magic.rent.pojo;

import java.io.Serializable;

public class HouseRelateUser implements Serializable {
    private static final long serialVersionUID = 120789025467935312L;
    private Integer id;

    private Integer houseId;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "HouseRelateUser{" +
                "id=" + id +
                ", houseId=" + houseId +
                ", userId=" + userId +
                '}';
    }
}