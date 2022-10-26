package com.k204110855.models;

import java.io.Serializable;

public class Product implements Serializable { //thêm implements Serializable để code bên IntentEx.java k bị lỗi
    String productName;
    double productPrice;

    //Contructor
    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    //Getter and Setter
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

}
