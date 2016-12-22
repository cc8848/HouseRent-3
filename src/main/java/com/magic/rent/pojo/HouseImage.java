package com.magic.rent.pojo;

import java.io.Serializable;

public class HouseImage implements Serializable {

    private static final long serialVersionUID = 1910267041702457611L;

    private Integer imageId;

    private Integer houseId;

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

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc == null ? null : imageSrc.trim();
    }
}