package com.magic.rent.pojo;

import java.util.Date;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/19
 * 类说明:
 */
public class IDInfo {

    private int id;

    private IDType idType;

    private String number;

    private Date validity;

    private String issuer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IDType getIdType() {
        return idType;
    }

    public void setIdType(IDType idType) {
        this.idType = idType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    @Override
    public String toString() {
        return "IDInfo{" +
                "id=" + id +
                ", idType=" + idType.getTypeName() +
                ", number='" + number + '\'' +
                ", validity=" + validity +
                ", issuer='" + issuer + '\'' +
                '}';
    }
}
