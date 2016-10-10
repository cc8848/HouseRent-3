package com.magic.rent.pojo;

import java.io.Serializable;

public class Area implements Serializable, Address {

    private static final long serialVersionUID = 3533014946638583863L;

    private Integer id;

    private Integer areaid;

    private String areaname;

    private Integer cityid;

    private boolean enable;

    public int getAddressID() {
        return getAreaid();
    }

    public String getAddressName() {
        return getAreaname();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname == null ? null : areaname.trim();
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}