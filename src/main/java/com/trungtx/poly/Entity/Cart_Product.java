package com.trungtx.poly.Entity;

import javax.persistence.*;

@Entity
public class Cart_Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cardProductId;
    private int amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    private Product product;

    public Cart_Product() {
    }

    public Cart_Product(Integer cardProductId, int amount, Order order, Product product) {
        this.cardProductId = cardProductId;
        this.amount = amount;
        this.order = order;
        this.product = product;
    }

    public Integer getCardProductId() {
        return cardProductId;
    }

    public void setCardProductId(Integer cardProductId) {
        this.cardProductId = cardProductId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
