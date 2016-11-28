package com.magic.rent.pojo;

import java.io.Serializable;

public class Community implements Serializable{
    private static final long serialVersionUID = 3058190833167946059L;
    private Integer id;

    private String name;

    private Integer cityId;

    private Integer areaId;

    private Double mapX;

    private Double mapY;

    private Integer companyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public Double getMapX() {
        return mapX;
    }

    public void setMapX(Double mapX) {
        this.mapX = mapX;
    }

    public Double getMapY() {
        return mapY;
    }

    public void setMapY(Double mapY) {
        this.mapY = mapY;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cityId=" + cityId +
                ", areaId=" + areaId +
                ", mapX=" + mapX +
                ", mapY=" + mapY +
                ", companyId=" + companyId +
                '}';
    }
}