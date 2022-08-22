package com.qa.gameshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}
