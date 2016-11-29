package com.magic.rent.pojo;

import java.io.Serializable;

public class AuditingStatus implements Serializable {

    private static final long serialVersionUID = 4696421741153001072L;

    public static final int AUDITING = 1;

    public static final int SUCCESS = 2;

    public static final int REFUSE = 3;

    public static final int CANCEL = 4;

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

    public static String idToName(int status) {
        switch (status) {
            case AUDITING:
                return "正在审核";
            case SUCCESS:
                return "审核成功";
            case REFUSE:
                return "审核失败";
            case CANCEL:
                return "申请取消";
            default:
                return "未定义状态";
        }
    }


    @Override
    public String toString() {
        return "AuditingStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}