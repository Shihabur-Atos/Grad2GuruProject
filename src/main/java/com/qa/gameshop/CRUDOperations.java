package com.qa.gameshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CRUDOperations {
    private Connection connection;
    private Statement statement;
    private ResultSet results;

    public CRUDOperations() {
        try {
            connection = DriverManager.getConnection(DBConfig.URL,DBConfig.USER, DBConfig.PASS);
            statement = connection.createStatement();
            System.out.println("Connection Successful!");
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Closed!");
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public Customer create(Customer customer) {
        String createStatement = "INSERT INTO customers(customerName, age, email) VALUES ('" + customer.getCustomerName()
                + "', " + customer.getAge() + ", '" + customer.getEmail() + "');";
        int pk = 0;
        try{
            statement.executeUpdate(createStatement, Statement.RETURN_GENERATED_KEYS);
            System.out.println(customer.getCustomerName() + " field has been added");
            results = statement.getGeneratedKeys();
            results.next();
            pk = results.getInt(1);
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        return this.findCustomerByID(pk);
    }

    public Product create(Product product) {
        String createStatement = "INSERT INTO products(productName, genre, price, quantity) VALUES ('" + product.getProductName()
                + "', '" + product.getGenre() + "', " + product.getPrice() +  ", " + product.getQuantity() + ");";
        int pk = 0;
        try {
            statement.executeUpdate(createStatement, Statement.RETURN_GENERATED_KEYS);
            results = statement.getGeneratedKeys();
            results.next();
            pk = results.getInt(1);
            System.out.println(product.getProductName() + " field has been added");
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        return this.findProductByID(pk);
    }

    public Order create(Order order) {
        String createStatement = "INSERT INTO orders(customerID, productID, quantity, price) VALUES ("  + order.getCustomerID()
                + ", " + order.getProductID() + ", " + order.getQuantity() + ", " + order.getPrice() + ");";
        int pk = 0;
        try {
            statement.executeUpdate(createStatement, Statement.RETURN_GENERATED_KEYS);
            System.out.println(order.getCustomerID() + " field has been added");
            results = statement.getGeneratedKeys();
            results.next();
            pk = results.getInt(1);
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        return this.findOrderByID(pk);
    }

    public void deleteAll() {
        String deleteStmt = "DELETE FROM orders;";
        String deleteStmt2 = "DELETE FROM customers;";
        String deleteStmt3 = "DELETE FROM products;";
        try {
            statement.executeUpdate(deleteStmt);
            statement.executeUpdate(deleteStmt2);
            statement.executeUpdate(deleteStmt3);
            System.out.println("All tables has been removed");
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public void delete(int tableChoice, int id) {
        String deleteStatement = "DELETE FROM ";
        switch (tableChoice) {
            case 1:
                deleteStatement += "customers WHERE customerID = " + id + ";";
                break;
            case 2:
                deleteStatement += "products WHERE productID = " + id + ";";
                break;
            case 3:
                deleteStatement += "orders WHERE orderID = " + id + ";";
                break;
        }
        try {
            statement.executeUpdate(deleteStatement);
            System.out.println("The field has been removed");
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public ArrayList<Customer> viewCustomers() {
        String selectStatement = "SELECT * FROM customers;";
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            results = statement.executeQuery(selectStatement);
            while (results.next()) {
                customers.add(new Customer(results.getInt("customerID"), results.getString("customerName"),
                        results.getInt("age"), results.getString("email")));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        System.out.println(customers);
        return customers;
    }

    public Customer findCustomerByID(int id) {
        String selectStatement = "SELECT * FROM customers WHERE customerID = " + id + ";";
        Customer customer = null;
        try {
            results = statement.executeQuery(selectStatement);
            while (results.next()) {
                customer = new Customer(results.getInt("customerID"), results.getString("customerName"),
                        results.getInt("age"), results.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        return customer;
    }

    public ArrayList<Product> viewProducts() {
        String selectStatement = "SELECT * FROM products;";
        ArrayList<Product> products = new ArrayList<>();
        try {
            results = statement.executeQuery(selectStatement);
            while (results.next()) {
                products.add(new Product(results.getInt("productID"), results.getString("productName"),
                        results.getString("genre"), results.getFloat("price"),
                        results.getInt("quantity")));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        System.out.println(products);
        return products;
    }

    public Product findProductByID(int id) {
        String selectStatement = "SELECT * FROM products WHERE productID = " + id + ";";
        Product product = null;
        try {
            results = statement.executeQuery(selectStatement);
            while (results.next()) {
                product = new Product(results.getInt("productID"), results.getString("productName"),
                        results.getString("genre"), results.getFloat("price"),
                        results.getInt("quantity"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        return product;
    }

    public ArrayList<Order> viewOrders() {
        String selectStatement = "SELECT * FROM orders;";
        ArrayList<Order> orders = new ArrayList<>();
        try {
            results = statement.executeQuery(selectStatement);
            while (results.next()) {
                orders.add(new Order(results.getInt("orderID"), results.getInt("customerID"),
                        results.getInt("productID"), results.getInt("quantity"),
                        results.getFloat("price")));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        System.out.println(orders);
        return orders;
    }

    public Order findOrderByID(int id) {
        String selectStatement = "SELECT * FROM orders WHERE orderID = " + id + ";";
        Order order = null;
        try {
            results = statement.executeQuery(selectStatement);
            while (results.next()) {
                order = new Order(results.getInt("orderID"), results.getInt("productID"), results.getInt("customerID"),
                        results.getInt("quantity"), results.getFloat("price"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        return order;
    }

    public void update(int tableChoice, int uid, String column, String newValue) {
        String updateStatement = null;
        String tableName = null;
        int pk = 0;
        switch(tableChoice) {
            case 1:
                if(column.equals("customerName") || column.equals("email")) {
                    updateStatement = "UPDATE customers SET " + column + " = '" + newValue + "' WHERE customerID = " + uid + ";";
                } else {
                    updateStatement = "UPDATE customers SET " + column + " = " + newValue + " WHERE customerID = " + uid + ";";
                }
                tableName = "Customers";
                break;
            case 2:
                updateStatement = "UPDATE products SET " + column + " = " + newValue + " WHERE productID = " + uid + ";";
                tableName = "Products";
                break;
            case 3:
                if(column.equals("productName") || column.equals("genre")) {
                    updateStatement = "UPDATE orders SET " + column + " = '" + newValue + "' WHERE orderID = " + uid + ";";
                } else {
                    updateStatement = "UPDATE orders SET " + column + " = " + newValue + " WHERE orderID = " + uid + ";";
                }
                tableName = "Orders";
                break;
        }

        try {
            statement.executeUpdate(updateStatement);
            System.out.println("At ID: " + uid + ", the field " + column + " in " + tableName + " has been updated");
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
}

