package com.magic.rent.pojo;

import java.io.Serializable;

public class SysScene implements Serializable {
    private static final long serialVersionUID = 4224413862180110801L;
    private Integer id;

    private String name;

    private String sceneDesc;

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

    public String getScenceDesc() {
        return sceneDesc;
    }

    public void setScenceDesc(String sceneDesc) {
        this.sceneDesc = sceneDesc == null ? null : sceneDesc.trim();
    }

    @Override
    public String toString() {
        return "SysScene{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scenceDesc='" + sceneDesc + '\'' +
                '}';
    }
}