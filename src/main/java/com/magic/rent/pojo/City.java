package com.magic.rent.pojo;

import java.io.Serializable;
import java.util.List;

public class City implements Serializable, Address {

    private static final long serialVersionUID = -8104849430543056653L;

    private Integer id;

    private Integer cityid;

    private String cityname;

    private Integer provinceID;

    List<Area> areas;

    private boolean enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname == null ? null : cityname.trim();
    }

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public int getAddressID() {
        return getCityid();
    }

    public String getAddressName() {
        return getCityname();
    }
}