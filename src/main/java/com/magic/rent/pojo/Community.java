package com.magic.rent.pojo;

import java.io.Serializable;

public class Community implements Serializable {

    private static final long serialVersionUID = 7151070886336480461L;

    private int id;

    private String name;//社区名

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
        return "Community{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}