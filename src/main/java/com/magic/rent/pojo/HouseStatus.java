package com.magic.rent.pojo;

import java.io.Serializable;

public class HouseStatus implements Serializable {
    private static final long serialVersionUID = 343533354168364809L;

    private static final int WAITING = 1;//待租
    private static final int RENTING = 2;//待租
    private static final int FUTURE = 3;//期房
    private static final int COMPLETE = 4;//现房

    private Integer id;

    private String statusName;//房屋状态名

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName == null ? null : statusName.trim();
    }


    public static String idToName(int id) {
        switch (id) {
            case WAITING:
                return "待租";
            case RENTING:
                return "出租中";
            case FUTURE:
                return "期房";
            case COMPLETE:
                return "现房";
            default:
                return "未定义方向";
        }
    }

    @Override
    public String toString() {
        return "HouseStatus{" +
                "id=" + id +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}