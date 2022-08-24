package com.qa.gameshop;

import com.qa.gameshop.Customer;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class CustomerTest {

    Customer customer = new Customer("",0,"");
    Customer cust2 = new Customer(1,"x",22,"xyz@gmail");
    @BeforeEach
    public void setUp() {
        System.out.println("Am I running?");
    }
    @Test
    public void getCustomerID() {
        assertEquals(1,cust2.getCustomerID());
    }

    @Test
    public void setCustomerID() {
        customer.setCustomerID(5);
        assertEquals(5,customer.getCustomerID());
    }

    @Test
    public void getCustomerName() {
        assertEquals("x",cust2.getCustomerName());
    }

    @Test
    public void setCustomerName() {
        customer.setCustomerName("jerry");
        assertEquals("jerry",customer.getCustomerName());
    }

    @Test
    public void getAge() {
        assertEquals(22,cust2.getAge());
    }

    @Test
    public void setAge() {
        customer.setAge(33);
        assertEquals(33,customer.getAge());
    }

    @Test
    public void getEmail() {
        assertEquals("xyz@gmail",cust2.getEmail());
    }

    @Test
    public void setEmail() {
        customer.setEmail("jerry@gmail.com");
        assertEquals("jerry@gmail.com",customer.getEmail());
    }
}