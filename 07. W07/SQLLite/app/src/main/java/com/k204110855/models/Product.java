package com.k204110855.models;

import java.io.Serializable;

public class Product implements Serializable {
    int productId;
    String productName;
    double productPrice;

    //Constructor
    public Product(int productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    //Getter and Setter
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

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    //toString
    @Override
    public String toString() {
        return productId + " - " + productName + " - " + productPrice;
    }
}
