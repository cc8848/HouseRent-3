package com.magic.rent.pojo;

import java.io.Serializable;

public class CredentialsType implements Serializable {

    private static final long serialVersionUID = 561435259090654960L;

    private int id;

    private String name;//证件类型名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}