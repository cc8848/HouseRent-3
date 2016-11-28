package com.magic.rent.pojo;

import java.io.Serializable;

public class HouseFace implements Serializable{
    private static final long serialVersionUID = 4469264477570602481L;
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

    @Override
    public String toString() {
        return "HouseFace{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}