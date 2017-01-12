package cn.com.showings.pojo;

import java.io.Serializable;

public class HandHouse implements Serializable {

    private static final long serialVersionUID = 5898646479038916136L;

    private Integer houseId;//ID

    private Integer userId;//对应用户

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



    @Override
    public String toString() {
        return "HandHouse{" +
                "houseId=" + houseId +
                ", userId=" + userId +
                '}';
    }
}