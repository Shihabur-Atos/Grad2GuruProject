package java.com.qa.gameshop;

import java.util.Scanner;

public class Menu {

    public static Scanner sc = new Scanner(System.in);

    public int crudChoice() {
        System.out.println("--------------Game Shop Management----------------");
        System.out.println("Please choose the following options by entering the number:");
        System.out.println("1. Add an entry");
        System.out.println("2. Delete an entry");
        System.out.println("3. View entries");
        System.out.println("4. Update entries");
        System.out.println("5. Quit");
        return sc.nextInt();
    }

    public void options() {
        int choice = crudChoice();
        try {
            do {
                System.out.println("Which table would you like to use?");
                System.out.println("Please choose the following options by entering the number:");
                System.out.println("1. Customers");
                System.out.println("2. Products");
                System.out.println("3. Orders");
                int tableChoice = sc.nextInt();

                switch (choice) {
                    case 1 :
                        if(tableChoice == 1) {
                            System.out.println("Customer Name:");
                            String name = sc.nextLine();
                            System.out.println("Age:");
                            int age = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Email:");
                            String email = sc.nextLine();
                            crudOptions(tableChoice, new Customer(name, age, price, quantity));
                        } else if(tableChoice == 2) {
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
                            crudOptions(tableChoice, new Product(name, genre, price, quantity));
                        } else if(tableChoice == 3) {
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
                            crudOptions(tableChoice, new Order(custID, prodID, quantity, price));
                        }
                        break;
                    case 2 :
                        break;
                    case 3 :
                        /////
                        break;
                    case 4 :
                        break;
                    case 5 :
                        break;

                }

            } while (choice != 5);
        } finally {
            System.out.println("Connection ended");
        }
    }
}
