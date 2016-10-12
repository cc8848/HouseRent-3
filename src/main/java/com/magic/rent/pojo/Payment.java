package com.magic.rent.pojo;

import java.io.Serializable;

public class Payment implements Serializable {

    private static final long serialVersionUID = 6790816431357886054L;
    private int id;

    private String paymentName;//付款方式名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName == null ? null : paymentName.trim();
    }
}