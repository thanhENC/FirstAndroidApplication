package com.k204110855.models;

public class Beer {
    int productThumb;
    String productName;
    double productPrice;

    public Beer(int productThumb, String productName, double productPrice) {
        this.productThumb = productThumb;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getProductThumb() {
        return productThumb;
    }

    public void setProductThumb(int productThumb) {
        this.productThumb = productThumb;
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
}
