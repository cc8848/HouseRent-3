package com.magic.rent.pojo;

import java.io.Serializable;

public class HouseLayout implements Serializable {

    private static final long serialVersionUID = 4618160301633644716L;

    private int id;

    private String name;

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
        return "HouseLayout{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}