package com.magic.rent.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/25
 * 类说明:
 * 更新记录：
 */
public class HouseImageListForm implements Serializable {

    private static final long serialVersionUID = 6301177391061043164L;

    private List<HouseImage> houseImages;

    public List<HouseImage> getHouseImages() {
        return houseImages;
    }

    public void setHouseImages(List<HouseImage> houseImages) {
        this.houseImages = houseImages;
    }

    @Override
    public String toString() {
        return "HouseImageListForm{" +
                "houseImages=" + houseImages +
                '}';
    }
}
