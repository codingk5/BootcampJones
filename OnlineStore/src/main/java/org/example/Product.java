package org.example;

public class Product {

    private String sku;
    private String productName;
    private double price;
    private String dept;

    // constructor


    public Product(String sku, String productName, double price, String dept) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.dept = dept;
    }

    // getters setters


    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String product) {
        this.productName = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
