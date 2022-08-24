package com.qa.gameshop;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CRUDOperationsTest {

    CRUDOperations crud = new CRUDOperations();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void createCustomer() {
        Customer newCustomer = new Customer("Lisa",33,"lisa@gmail.com");
        Customer customer2 = crud.create(newCustomer);
        assertEquals(newCustomer.getCustomerName(), customer2.getCustomerName());
        assertEquals(newCustomer.getEmail(), customer2.getEmail());
        assertEquals(newCustomer.getAge(), customer2.getAge());

    }

    @Test
    public void createProduct() {
        Product newProduct = new Product("Tekken 7", "Fighting", 39.99f,600);
        Product product = crud.create(newProduct);
        assertEquals(newProduct.getProductName(), product.getProductName());
        assertEquals(newProduct.getGenre(), product.getGenre());
        assertEquals(newProduct.getPrice(), product.getPrice(), 1f);
        assertEquals(newProduct.getQuantity(), product.getQuantity());
    }

    @Test
    public void createOrder() {
        int productID = crud.create(new Product("Tekken 7", "Fighting", 39.99f,600)).getProductID();
        int customerID = crud.create(new Customer("Lisa",33,"lisa@gmail.com")).getCustomerID();
        Order newOrder = new Order(productID,customerID,50.00f,45);
        Order order = crud.create(newOrder);
        assertEquals(newOrder.getProductID(), order.getProductID());
        assertEquals(newOrder.getCustomerID(), order.getCustomerID());
        assertEquals(newOrder.getPrice(), order.getPrice(), 1f);
        assertEquals(newOrder.getQuantity(), order.getQuantity());
    }

    @Test
    public void delete() {
        int productID = crud.create(new Product("Tekken 7", "Fighting", 39.99f,600)).getProductID();
        int customerID = crud.create(new Customer("Lisa",33,"lisa@gmail.com")).getCustomerID();
        Order newOrder = new Order(productID,customerID,50.00f,45);
        crud.delete(1,customerID);
        crud.delete(2,productID);
        crud.delete(3,newOrder.getOrderID());
        assertEquals("The field has been removed",outContent.toString());
    }

    @Test
    public void viewCustomers() {
        crud.deleteAll();
        crud.create(new Customer("Lisa",33,"lisa@gmail.com"));
        crud.create(new Customer("Jenny",33,"Jen@gmail.com"));
        crud.create(new Customer("Tom",33,"Tom@gmail.com"));
        assertEquals(3,crud.viewCustomers().size());

    }

    @Test
    public void findCustomerByID() {
        Customer newCustomer = new Customer("Lisa",33,"lisa@gmail.com");
        Customer customer2 = crud.create(newCustomer);
        assertEquals(newCustomer.getCustomerName(), customer2.getCustomerName());
        assertEquals(newCustomer.getEmail(), customer2.getEmail());
        assertEquals(newCustomer.getAge(), customer2.getAge());
    }

    @Test
    public void viewProducts() {
        crud.deleteAll();
        crud.create(new Product("Tekken 7", "Fighting", 39.99f,600));
        assertEquals(1,crud.viewProducts().size());
    }

    @Test
    public void findProductByID() {
        Product newProduct = new Product("Tekken 7", "Fighting", 39.99f,600);
        Product product = crud.create(newProduct);
        assertEquals(newProduct.getProductName(), product.getProductName());
        assertEquals(newProduct.getGenre(), product.getGenre());
        assertEquals(newProduct.getPrice(), product.getPrice(), 1f);
        assertEquals(newProduct.getQuantity(), product.getQuantity());
    }

    @Test
    public void viewOrders() {
        crud.deleteAll();
        int productID = crud.create(new Product("Tekken 7", "Fighting", 39.99f,600)).getProductID();
        int customerID = crud.create(new Customer("Lisa",33,"lisa@gmail.com")).getCustomerID();
        Order newOrder = new Order(productID,customerID,50.00f,45);
        crud.create(newOrder);
        assertEquals(1,crud.viewOrders().size());
    }

    @Test
    public void findOrderByID() {
        int productID = crud.create(new Product("Tekken 7", "Fighting", 39.99f,600)).getProductID();
        int customerID = crud.create(new Customer("Lisa",33,"lisa@gmail.com")).getCustomerID();
        Order newOrder = new Order(productID,customerID,50.00f,45);
        Order order = crud.create(newOrder);
        assertEquals(newOrder.getProductID(), order.getProductID());
        assertEquals(newOrder.getCustomerID(), order.getCustomerID());
        assertEquals(newOrder.getPrice(), order.getPrice(), 1f);
        assertEquals(newOrder.getQuantity(), order.getQuantity());
    }

    @Test
    public void update() {
        crud.deleteAll();
        int productID = crud.create(new Product("Tekken 7", "Fighting", 39.99f,600)).getProductID();
        int customerID = crud.create(new Customer("Lisa",33,"lisa@gmail.com")).getCustomerID();
        Order newOrder = new Order(productID,customerID,50.00f,45);
        crud.update(1,customerID,"customerName","Jessica");
        assertEquals("Jessica", crud.findCustomerByID(customerID).getCustomerName());

    }
}