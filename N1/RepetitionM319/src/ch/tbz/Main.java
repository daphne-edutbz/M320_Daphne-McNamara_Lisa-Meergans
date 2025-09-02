package ch.tbz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GroceryList groceryList = new GroceryList();

        boolean running = true;

        while (running) {
            System.out.println("---- Grocery List -----");
            System.out.println("1. Add Grocery");
            System.out.println("2. Remove Grocery");
            System.out.println("3. Display Grocery List");
            System.out.println("4. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Enter Product name: ");
                    String productName = scanner.nextLine();

                    System.out.println("Enter Price: ");
                    int productPrice = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    Product product = new Product(productName, productPrice, quantity);
                    groceryList.addProduct(product);
                    break;

                case "2":
                    System.out.println("Enter Product name to delete: ");
                    String removeProductName = scanner.nextLine();
                    groceryList.removeProduct(removeProductName);
                    break;

                case "3":
                    groceryList.showProducts();
                    break;

                case "4":
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}