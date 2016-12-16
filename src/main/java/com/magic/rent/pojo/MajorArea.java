package com.magic.rent.pojo;

import java.io.Serializable;

public class MajorArea implements Serializable {
    private static final long serialVersionUID = 5420156463630122527L;
    private Integer id;

    private Integer userId;

    private Integer areaId;
    private Area area;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "MajorArea{" +
                "id=" + id +
                ", userId=" + userId +
                ", areaId=" + areaId +
                ", area=" + area +
                '}';
    }
}