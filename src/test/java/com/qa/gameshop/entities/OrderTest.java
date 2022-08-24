package com.qa.gameshop.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest {

    Order order1 = new Order(1,3,5,7,39.99f);
    Order order2 = new Order(0,0,0f,0);

    @Test
    public void getOrderID() {
        assertEquals(1,order1.getOrderID());
    }

    @Test
    public void setOrderID() {
        order2.setOrderID(2);
        assertEquals(2,order2.getOrderID());
    }

    @Test
    public void getProductID() {
        assertEquals(3,order1.getProductID());
    }

    @Test
    public void setProductID() {
        order2.setProductID(4);
        assertEquals(4,order2.getProductID());
    }

    @Test
    public void getCustomerID() {
        assertEquals(5,order1.getCustomerID());
    }

    @Test
    public void setCustomerID() {
        order2.setCustomerID(6);
        assertEquals(6, order2.getCustomerID());
    }

    @Test
    public void getPrice() {
        assertEquals(39.99, order1.getPrice(),1f);
    }

    @Test
    public void setPrice() {
        order2.setPrice(49.99f);
        assertEquals(49.99,order2.getPrice(),1f);
    }

    @Test
    public void getQuantity() {
        assertEquals(7,order1.getQuantity());
    }

    @Test
    public void setQuantity() {
        order2.setQuantity(8);
        assertEquals(8,order2.getQuantity());
    }
}