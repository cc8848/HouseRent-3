package com.magic.rent.pojo;

import java.io.Serializable;

public class RentMode implements Serializable {

    private static final long serialVersionUID = -3589841467376517812L;

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
        return "RentMode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}