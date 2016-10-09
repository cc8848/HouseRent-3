package com.magic.rent.pojo;

import java.io.Serializable;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/10/9
 * 类说明:
 */
public class SelectPoJo implements Serializable {

    private static final long serialVersionUID = -8960062139243870972L;

    private int id;

    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "SelectPoJo{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
