package com.trungtx.poly.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Order_Table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    private Timestamp dayOrder;
    private String nameOrder;
    private double total_money;
    private String addressOrder;
    private String cusNameOrder;
    private String numbPhone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private UserTable userTable;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private List<Cart_Product> cart_productList;

    public Order() {
    }

    public Order(Integer orderId, Timestamp dayOrder, String nameOrder, double total_money, String addressOrder, String cusNameOrder, String numbPhone, UserTable userTable) {
        this.orderId = orderId;
        this.dayOrder = dayOrder;
        this.nameOrder = nameOrder;
        this.total_money = total_money;
        this.addressOrder = addressOrder;
        this.cusNameOrder = cusNameOrder;
        this.numbPhone = numbPhone;
        this.userTable = userTable;

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

    public UserTable getUserTable() {
        return userTable;
    }

    public void setUserTable(UserTable userTable) {
        this.userTable = userTable;
    }

    public List<Cart_Product> getCart_productList() {
        return cart_productList;
    }

    public void setCart_productList(List<Cart_Product> cart_productList) {
        this.cart_productList = cart_productList;
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
