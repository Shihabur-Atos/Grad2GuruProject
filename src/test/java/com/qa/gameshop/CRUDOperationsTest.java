package com.qa.gameshop;

import com.qa.gameshop.entities.Customer;
import com.qa.gameshop.entities.Order;
import com.qa.gameshop.entities.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CRUDOperationsTest {

    CRUDOperations crud = new CRUDOperations();


    @Test
    public void createCustomer() {
        Customer newCustomer = new Customer("Lisa",33,"lisa@gmail.com");
        assertEquals(newCustomer, crud.create(newCustomer));
    }

    @Test
    public void createProduct() {
        Product newProduct = new Product("Tekken 7", "Fighting", 39.99f,600);
        assertEquals(newProduct, crud.create(newProduct));
    }

    @Test
    public void createOrder() {
        Order newOrder = new Order(3,2,2,50,50.00f);
        assertEquals(newOrder, crud.create(newOrder));
    }

    @Test
    public void delete() {

    }

    @Test
    public void viewCustomers() {

    }

    @Test
    public void findCustomerByID() {
    }

    @Test
    public void viewProducts() {
    }

    @Test
    public void findProductByID() {
    }

    @Test
    public void viewOrders() {
    }

    @Test
    public void findOrderByID() {
    }

    @Test
    public void update() {
    }
}