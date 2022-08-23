package com.qa.gameshop;

import com.qa.gameshop.entities.Customer;
import com.qa.gameshop.entities.Order;
import com.qa.gameshop.entities.Product;

import java.util.Scanner;

public class Menu {

    public static Scanner sc = new Scanner(System.in);

    public int getCRUDChoice() {
        System.out.println("--------------Game Shop Management System----------------");
        System.out.println("Please choose the following options by entering the number:");
        System.out.println("1. Add an entry");
        System.out.println("2. Delete an entry");
        System.out.println("3. View entries");
        System.out.println("4. Update entries");
        System.out.println("5. Quit");
        return sc.nextInt();
    }

    public int getTableChoice() {
        int tableChoice = 0;
        do  {
            System.out.println("Which table would you like to use?");
            System.out.println("Please choose the following options by entering the number:");
            System.out.println("1. Customers");
            System.out.println("2. Products");
            System.out.println("3. Orders");
            tableChoice = sc.nextInt();
            sc.nextLine();
            if(tableChoice < 0 || tableChoice > 3) {
                System.out.println("Invalid choice");
            }
        } while ((tableChoice < 0 || tableChoice > 3));

        return tableChoice;
    }

    public void options() {
        CRUDOperations crud = new CRUDOperations();
        int choice = getCRUDChoice();
        try {
            while (choice != 5) {
                int tableChoice = getTableChoice();
                switch (choice) {
                    case 1:
                        if (tableChoice == 1) {
                            System.out.println("Customer Name:");
                            String name = sc.nextLine();
                            System.out.println("Age:");
                            int age = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Email:");
                            String email = sc.nextLine();
                            crud.create(new Customer(name, age, email));
                        } else if (tableChoice == 2) {
                            System.out.println("Product Name:");
                            String name = sc.nextLine();
                            System.out.println("Genre:");
                            String genre = sc.nextLine();
                            System.out.println("Price:");
                            float price = sc.nextFloat();
                            sc.nextLine();
                            System.out.println("Quantity:");
                            int quantity = sc.nextInt();
                            sc.nextLine();
                            crud.create(new Product(name, genre, price, quantity));
                        } else if (tableChoice == 3) {
                            System.out.println("CustomerID:");
                            int custID = sc.nextInt();
                            sc.nextLine();
                            System.out.println("ProductID:");
                            int prodID = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Quantity:");
                            int quantity = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Price:");
                            float price = sc.nextFloat();
                            sc.nextLine();
                            crud.create(new Order(prodID, custID, price, quantity));
                        }
                        break;
                    case 2:
                        System.out.println("Enter the id of the record to delete");
                        int id = sc.nextInt();
                        sc.nextLine();
                        crud.delete(tableChoice, id);
                    case 3:
                        if(tableChoice == 1) {
                            crud.viewCustomers();
                        } else if(tableChoice == 2) {
                            crud.viewProducts();
                        } else if(tableChoice == 3) {
                            crud.viewOrders();
                        }
                        break;
                    case 4:
                        System.out.println("Enter the ID of the record to update");
                        int uid = sc.nextInt();
                        sc.nextLine();
                        System.out.println("What column would you like to update?");
                        String column = sc.nextLine();
                        System.out.println("What do you want to replace the column value to?");
                        String newValue = sc.nextLine();
                        crud.update(tableChoice, uid, column, newValue);
                        break;
                    default:
                        System.out.println("Invalid option");
                }
                System.out.println("Would you like to continue? (y/n)");
                String quit = sc.nextLine();
                if (quit.equalsIgnoreCase("y")) {
                    choice = getCRUDChoice();
                } else if (quit.equalsIgnoreCase("n")) {
                    choice = 5;
                } else {
                    System.out.println("Please enter 'y' or 'n'");
                }
            }
        } finally {
            System.out.println("Connection ended");
            crud.closeConnection();
        }
    }
}
