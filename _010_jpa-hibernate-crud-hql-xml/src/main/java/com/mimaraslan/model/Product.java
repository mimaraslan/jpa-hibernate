package com.mimaraslan.model;

import java.util.Date;

public class Product {

    private int productId;
    private String productName;
    private int quantity;
    private Float unitPrice;
    private Boolean discontinued;
    private Date modifiedDate;

    public Product() {
    }

    public Product(String productName, int quantity, Float unitPrice,
                   Boolean discontinued, Date modifiedDate) {
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discontinued = discontinued;
        this.modifiedDate = modifiedDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Boolean getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(Boolean discontinued) {
        this.discontinued = discontinued;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}