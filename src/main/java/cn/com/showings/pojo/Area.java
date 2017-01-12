package cn.com.showings.pojo;

import java.io.Serializable;

public class Area implements Serializable {

    private static final long serialVersionUID = 3533014946638583863L;

    private Integer id;

    private Integer areaid;

    private String areaName;

    private Integer cityid;

    private boolean enable;

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

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", areaid=" + areaid +
                ", areaName='" + areaName + '\'' +
                ", cityid=" + cityid +
                ", enable=" + enable +
                '}';
    }
}