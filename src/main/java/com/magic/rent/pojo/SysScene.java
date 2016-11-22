package com.magic.rent.pojo;

public class SysScene {
    private Integer id;

    private String name;

    private String scenceDesc;

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
        return scenceDesc;
    }

    public void setScenceDesc(String scenceDesc) {
        this.scenceDesc = scenceDesc == null ? null : scenceDesc.trim();
    }
}