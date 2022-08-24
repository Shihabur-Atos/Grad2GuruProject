package com.qa.gameshop;

import com.qa.gameshop.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    Product prod = new Product("","",0f,0);
    Product prod2 = new Product(1,"Fifa 23","Sports",59.99f,500);

    @Test
    public void getProductID() {
        assertEquals(1,prod2.getProductID());
    }

    @Test
    public void setProductID() {
        prod.setProductID(2);
        assertEquals(2,prod.getProductID());
    }

    @Test
    public void getProductName() {
        assertEquals("Fifa 23", prod2.getProductName());
    }

    @Test
    public void setProductName() {
        prod.setProductName("COD Vanguard");
        assertEquals("COD Vanguard",prod.getProductName());
    }

    @Test
    public void getGenre() {
        assertEquals("Sports",prod2.getGenre());
    }

    @Test
    public void setGenre() {
        prod.setGenre("FPS");
        assertEquals("FPS",prod.getGenre());
    }

    @Test
    public void getPrice() {
        assertEquals( 59.99, prod2.getPrice(),1f);
    }

    @Test
    public void setPrice() {
        prod.setPrice(69.99f);
        assertEquals(69.99, prod.getPrice(), 1f);
    }

    @Test
    public void getQuantity() {
        assertEquals(500, prod2.getQuantity());
    }

    @Test
    public void setQuantity() {
        prod.setQuantity(1000);
        assertEquals(1000,prod.getQuantity());
    }
}