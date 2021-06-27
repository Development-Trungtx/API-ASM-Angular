package com.trungtx.poly.Entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class TypeProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer typeId;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "typeId")
    private List<Product> productList;

    public TypeProduct() {
    }

    public TypeProduct(Integer typeId, String name) {
        this.typeId = typeId;
        this.name = name;
    }

    public TypeProduct(Integer typeId, String name,List<Product> productList) {
        this.typeId = typeId;
        this.name = name;
        this.productList = productList;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
