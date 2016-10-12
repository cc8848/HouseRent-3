package com.magic.rent.pojo;

import java.io.Serializable;

public class HouseStatus implements Serializable {
    private static final long serialVersionUID = 343533354168364809L;
    private int id;

    private String statusName;//房屋状态名

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName == null ? null : statusName.trim();
    }
}