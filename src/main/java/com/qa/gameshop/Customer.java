package com.qa.gameshop;

public class Customer {

    private int customerID;
    private String customerName;
    private int age;
    private String email;

    public Customer(String customerName, int age, String email) {
        this.customerName = customerName;
        this.age = age;
        this.email = email;
    }

    public Customer(int customerID, String customerName, int age, String email) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.age = age;
        this.email = email;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
