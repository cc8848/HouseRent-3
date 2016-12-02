package com.magic.rent.pojo;

import java.io.Serializable;

public class HouseFace implements Serializable {

    private static final long serialVersionUID = 4469264477570602481L;

    public static final int EAST = 1;//东
    public static final int SOUTH = 2;//南
    public static final int WEST = 3;//西
    public static final int NORTH = 4;//北

    public static final int SOUTHEAST = 5;//东南
    public static final int NORTHEAST = 6;//东北
    public static final int SOUTHWEST = 7;//西南
    public static final int NORTHWEST = 8;//西北


    private Integer id;

    private String name;

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

    public static String idToName(int id) {
        switch (id) {
            case EAST:
                return "东";
            case SOUTH:
                return "南";
            case WEST:
                return "西";
            case NORTH:
                return "北";
            case SOUTHEAST:
                return "东南";
            case NORTHEAST:
                return "东北";
            case SOUTHWEST:
                return "西南";
            case NORTHWEST:
                return "西北";
            default:
                return "未定义方向";
        }
    }

    @Override
    public String toString() {
        return "HouseFace{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}