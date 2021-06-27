package com.trungtx.poly.Entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    private String name;
    private double price;
    private int total;
    private int sale;
    private String image;
    private String descrition;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeId")
    private TypeProduct typeId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private List<Cart_Product> cart_productList;

    public Product() {
    }

    public Product(Integer productId, String name, double price, int total, int sale, String image, String descrition, TypeProduct typeId) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.total = total;
        this.sale = sale;
        this.image = image;
        this.descrition = descrition;
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", total=" + total +
                ", sale=" + sale +
                ", image='" + image + '\'' +
                ", descrition='" + descrition + '\'' +
                '}';
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public TypeProduct getTypeId() {
        return typeId;
    }

    public void setTypeId(TypeProduct typeId) {
        this.typeId = typeId;
    }

    public List<Cart_Product> getCart_productList() {
        return cart_productList;
    }

    public void setCart_productList(List<Cart_Product> cart_productList) {
        this.cart_productList = cart_productList;
    }
}
