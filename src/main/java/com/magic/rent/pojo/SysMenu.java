package com.magic.rent.pojo;

import java.io.Serializable;

public class SysMenu implements Serializable {

    private static final long serialVersionUID = -2962234817522611186L;
    private Integer id;

    private String href;//链接

    private String menuDesc;//菜单名称

    private Integer sceneId;//场景码

    private Integer orderNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc == null ? null : menuDesc.trim();
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "id=" + id +
                ", href='" + href + '\'' +
                ", menuDesc='" + menuDesc + '\'' +
                ", sceneId=" + sceneId +
                ", orderNum=" + orderNum +
                '}';
    }
}