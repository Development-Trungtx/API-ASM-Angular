package com.trungtx.poly.Dto;

import java.sql.Timestamp;

public class OrderDto {

    private Integer orderId;
    private Timestamp dayOrder;
    /*Insert Order*/
    private String nameOrder;
    private double total_money;
    private String emailUser;
    private String addressOrder;
    private String cusNameOrder;
    private String numbPhone;

    public OrderDto(Integer orderId, Timestamp dayOrder, String nameOrder, double total_money, String emailUser, String addressOrder, String cusNameOrder, String numbPhone) {
        this.orderId = orderId;
        this.dayOrder = dayOrder;
        this.nameOrder = nameOrder;
        this.total_money = total_money;
        this.emailUser = emailUser;
        this.addressOrder = addressOrder;
        this.cusNameOrder = cusNameOrder;
        this.numbPhone = numbPhone;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Timestamp getDayOrder() {
        return dayOrder;
    }

    public void setDayOrder(Timestamp dayOrder) {
        this.dayOrder = dayOrder;
    }

    public String getNameOrder() {
        return nameOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder = nameOrder;
    }

    public double getTotal_money() {
        return total_money;
    }

    public void setTotal_money(double total_money) {
        this.total_money = total_money;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getAddressOrder() {
        return addressOrder;
    }

    public void setAddressOrder(String addressOrder) {
        this.addressOrder = addressOrder;
    }

    public String getCusNameOrder() {
        return cusNameOrder;
    }

    public void setCusNameOrder(String cusNameOrder) {
        this.cusNameOrder = cusNameOrder;
    }

    public String getNumbPhone() {
        return numbPhone;
    }

    public void setNumbPhone(String numbPhone) {
        this.numbPhone = numbPhone;
    }
}
