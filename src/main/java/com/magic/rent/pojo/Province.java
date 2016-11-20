package com.magic.rent.pojo;

import java.io.Serializable;
import java.util.List;

public class Province implements Serializable, Address {

    private static final long serialVersionUID = -1754868368289735835L;

    private Integer id;

    private Integer provinceID;

    private String provinceName;

    private List<City> cities;

    private boolean enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public int getAddressID() {
        return getProvinceID();
    }

    public String getAddressName() {
        return getProvinceName();
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", provinceID=" + provinceID +
                ", provinceName='" + provinceName + '\'' +
                ", cities=" + cities +
                ", enable=" + enable +
                '}';
    }
}