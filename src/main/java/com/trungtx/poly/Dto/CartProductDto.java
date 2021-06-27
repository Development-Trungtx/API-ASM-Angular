package com.trungtx.poly.Dto;

public class CartProductDto {

    private Integer cardProductId;
    private String imges;
    private double price;
    private int amount;
    private String orderNumber;
    private String proName;
    private Integer productID;

    public CartProductDto(Integer cardProductId, String imges, double price, int amount, String orderNumber, String proName) {
        this.cardProductId = cardProductId;
        this.imges = imges;
        this.price = price;
        this.amount = amount;
        this.orderNumber = orderNumber;
        this.proName = proName;
    }

    public Integer getCardProductId() {
        return cardProductId;
    }

    public void setCardProductId(Integer cardProductId) {
        this.cardProductId = cardProductId;
    }

    public String getImges() {
        return imges;
    }

    public void setImges(String imges) {
        this.imges = imges;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }
}
