package com.magic.rent.pojo;

import java.io.Serializable;

public class HouseDecoration implements Serializable {
    private static final long serialVersionUID = 6246723456026324371L;
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
        return "HouseDecoration{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}