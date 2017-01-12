package cn.com.showings.pojo;

import java.io.Serializable;

public class HouseImage implements Serializable{

    private static final long serialVersionUID = 5191423614501289639L;

    private Integer imageId;

    private Integer houseId;

    private Integer userId;

    private String imageSrc;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

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

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc == null ? null : imageSrc.trim();
    }

    @Override
    public String toString() {
        return "HouseImage{" +
                "imageId=" + imageId +
                ", houseId=" + houseId +
                ", userId=" + userId +
                ", imageSrc='" + imageSrc + '\'' +
                '}';
    }
}