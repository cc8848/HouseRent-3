package com.magic.rent.pojo;

import com.magic.rent.util.DateFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class HouseRecommend implements Serializable {

    private static final long serialVersionUID = 1670061855587290816L;

    private int id;

    private String date;

    private List<House> houseList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = DateFormat.FormatToYMD(date);
    }

    public List<House> getHouseList() {
        return houseList;
    }

    public void setHouseList(List<House> houseList) {
        this.houseList = houseList;
    }

    @Override
    public String toString() {
        return "HouseRecommend{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", houseList=" + houseList +
                '}';
    }
}