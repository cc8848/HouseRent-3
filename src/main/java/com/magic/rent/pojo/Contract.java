package com.magic.rent.pojo;

import java.io.Serializable;
import java.util.Date;

public class Contract implements Serializable {

    private static final long serialVersionUID = -8322305622900321278L;

    private int id;

    private String contractId;//合同编号

    private double contractRent;//合同租金

    private Date startDate;//租期起始日期

    private Date endData;//租期到期日志

    private int lesseeId;//租客id
    private SysUsers lessee;//租客对象

    private int lessorId;//房东ID
    private SysUsers lessor;


    private boolean includeUtilities;//是否包水电

    private int paymentId;//付租方式
    private Payment payment;

    private boolean enabled;//是否可用

    private boolean expired;//是否过期

    private Date payDate;//付租日期

    private double deposit;//押金

    private int roomId;//房间ID
    private Rooms rooms;//对应房间

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public double getContractRent() {
        return contractRent;
    }

    public void setContractRent(double contractRent) {
        this.contractRent = contractRent;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndData() {
        return endData;
    }

    public void setEndData(Date endData) {
        this.endData = endData;
    }

    public int getLesseeId() {
        return lesseeId;
    }

    public void setLesseeId(int lesseeId) {
        this.lesseeId = lesseeId;
    }

    public int getLessorId() {
        return lessorId;
    }

    public void setLessorId(int lessorId) {
        this.lessorId = lessorId;
    }

    public boolean isIncludeUtilities() {
        return includeUtilities;
    }

    public void setIncludeUtilities(boolean includeUtilities) {
        this.includeUtilities = includeUtilities;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public SysUsers getLessee() {
        return lessee;
    }

    public void setLessee(SysUsers lessee) {
        this.lessee = lessee;
    }

    public SysUsers getLessor() {
        return lessor;
    }

    public void setLessor(SysUsers lessor) {
        this.lessor = lessor;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}