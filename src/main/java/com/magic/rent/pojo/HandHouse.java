package com.magic.rent.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class HandHouse implements Serializable {

    private static final long serialVersionUID = 5898646479038916136L;

    private Integer houseId;//ID

    private Integer userId;//对应用户

    static final String UNDEFINED = "未定义";

    //朝向
    static Map<Integer, String> ORIENTATION_MAP = new HashMap<Integer, String>();

    //装修情况
    static Map<Integer, String> DECORATION_MAP = new HashMap<Integer, String>();

    //房屋类型
    static Map<Integer, String> TYPE_MAP = new HashMap<Integer, String>();

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    static {
        ORIENTATION_MAP.put(1, "东");
        ORIENTATION_MAP.put(2, "西");
        ORIENTATION_MAP.put(3, "南");
        ORIENTATION_MAP.put(4, "北");
        ORIENTATION_MAP.put(5, "东南");
        ORIENTATION_MAP.put(6, "西南");
        ORIENTATION_MAP.put(7, "东北");
        ORIENTATION_MAP.put(8, "西北");
    }

    static {
        DECORATION_MAP.put(1, "毛坯");
        DECORATION_MAP.put(2, "简单装修");
        DECORATION_MAP.put(3, "中等装修");
        DECORATION_MAP.put(4, "精装修");
        DECORATION_MAP.put(5, "豪华装修");
    }

    static {
        TYPE_MAP.put(1, "普通住宅");
        TYPE_MAP.put(2, "公寓");
        TYPE_MAP.put(3, "别墅");
        TYPE_MAP.put(4, "平方/四合院");
        TYPE_MAP.put(5, "其他");
    }

    @Override
    public String toString() {
        return "HandHouse{" +
                "houseId=" + houseId +
                ", userId=" + userId +
                '}';
    }
}