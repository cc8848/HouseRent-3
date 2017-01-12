package cn.com.showings.pojo;

import java.io.Serializable;
import java.util.List;

public class City implements Serializable {

    private static final long serialVersionUID = -8104849430543056653L;

    private Integer id;

    private Integer cityid;

    private String cityName;

    private Integer provinceID;

    private List<Area> areas;

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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityid=" + cityid +
                ", cityName='" + cityName + '\'' +
                ", provinceID=" + provinceID +
                ", areas=" + areas +
                ", enable=" + enable +
                '}';
    }
}