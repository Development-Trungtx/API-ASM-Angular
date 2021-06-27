package com.trungtx.poly.Dto;

public class ProductDto {

    private Integer productId;
    private String name;
    private  double price;
    private int total;
    private int sale;
    private String image;
    private String descrition;
    private String nameTypePro;

    public ProductDto(Integer productId, String name, double price, int total, int sale, String image, String descrition, String nameTypePro) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.total = total;
        this.sale = sale;
        this.image = image;
        this.descrition = descrition;
        this.nameTypePro = nameTypePro;
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

    public String getNameTypePro() {
        return nameTypePro;
    }

    public void setNameTypePro(String nameTypePro) {
        this.nameTypePro = nameTypePro;
    }
}
