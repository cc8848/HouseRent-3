package cn.com.showings.pojo;

import java.io.Serializable;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/22
 * 类说明:
 * 更新记录：
 */
public class HandHousePrice extends HandHouse implements Serializable {

    private static final long serialVersionUID = 2686104426608936992L;

    private Boolean propertyRightsForTwoYears;//产权满两年

    private Boolean onlyHousing;//唯一性住房

    private Integer price;//售价

    public Boolean getPropertyRightsForTwoYears() {
        return propertyRightsForTwoYears;
    }

    public void setPropertyRightsForTwoYears(Boolean propertyRightsForTwoYears) {
        this.propertyRightsForTwoYears = propertyRightsForTwoYears;
    }

    public Boolean getOnlyHousing() {
        return onlyHousing;
    }

    public void setOnlyHousing(Boolean onlyHousing) {
        this.onlyHousing = onlyHousing;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "HandHousePrice{" +
                "propertyRightsForTwoYears=" + propertyRightsForTwoYears +
                ", onlyHousing=" + onlyHousing +
                ", price=" + price +
                '}';
    }
}
