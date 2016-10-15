package com.magic.rent.pojo;

import java.io.Serializable;

public class DecorationType implements Serializable {
    private static final long serialVersionUID = -4636714336615136727L;

    private int id;

    private String name;//装修种类名称

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

    @Override
    public String toString() {
        return "DecorationType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}