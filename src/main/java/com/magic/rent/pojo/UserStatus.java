package com.magic.rent.pojo;

import java.io.Serializable;

public class UserStatus implements Serializable {

    public final static int AUDITING = 1;

    public final static int REFUSE = 2;

    public final static int SUCCESS = 3;

    private static final long serialVersionUID = -5668399590745615969L;
    private Integer id;

    private String statusName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName == null ? null : statusName.trim();
    }

    @Override
    public String toString() {
        return "UserStatus{" +
                "id=" + id +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}