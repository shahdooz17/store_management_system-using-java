package products;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddProduct {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Product Management System");

        while (true) {
            System.out.println("\n1. Add Product\n2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();

        // Consume the newline character
        scanner.nextLine();

        System.out.print("Enter product category: ");
        String cat = scanner.nextLine();

        // Call the function to add the product and create the file
        boolean success = saveProductToFile(name, price, quantity, cat);

        if (success) {
            System.out.println("Product added successfully!");
        } else {
            System.out.println("Failed to add product. Please try again.");
        }
    }

    private static boolean saveProductToFile(String name, double price, int quantity , String Category) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".txt"))) {
            // Write product information to the file
            writer.write("Name: " + name + "\n");
            writer.write("Price: " + price + "\n");
            writer.write("Quantity: " + quantity + "\n");
            writer.write("Category: " + Category + "\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}