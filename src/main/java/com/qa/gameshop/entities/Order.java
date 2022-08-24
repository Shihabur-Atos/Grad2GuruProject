package com.qa.gameshop.entities;

public class Order {
    private int orderID;
    private int productID;
    private int customerID;
    private float price;
    private int quantity;

    public Order(int orderID, int productID, int customerID, int quantity, float price) {
        this.orderID = orderID;
        this.productID = productID;
        this.customerID = customerID;
        this.quantity = quantity;
        this.price = price;
    }

    public Order(int productID, int customerID, float price, int quantity) {
        this.productID = productID;
        this.customerID = customerID;
        this.price = price;
        this.quantity = quantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
