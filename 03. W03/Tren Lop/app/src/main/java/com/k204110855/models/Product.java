package com.k204110855.models;

public class Product {
    String productName;
    String productColor;

    public Product(String productName, String productColor) {
        this.productName = productName;
        this.productColor = productColor;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    @Override
    public String toString() {
        return this.productName + " - " + this.productColor;
    }
}
