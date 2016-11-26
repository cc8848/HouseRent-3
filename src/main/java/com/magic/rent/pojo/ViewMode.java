package com.magic.rent.pojo;

import java.io.Serializable;

public class ViewMode implements Serializable {

    public final static int VRMode = 1;

    public final static int thumbnailMode = 2;

    private static final long serialVersionUID = 1534902202366865204L;

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
}