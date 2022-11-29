package com.dinhvanan.models;

public class Product {
    int productId;
    String productName;
    String brand;
    double price;
    int image;

    public Product(int productId, String productName, String brand, double price, int image) {
        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.image = image;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String formatPrice(double price){
        String str = (int)price + "";
        int count = 0;
        for(int i = str.length() - 1; i >= 0; i--){
            count++;
            if(count == 3){
                str = str.substring(0, i) + "." + str.substring(i);
                count = 0;
            }
        }
        return str + " VND";
    }
}
