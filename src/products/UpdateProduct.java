package products;

import java.io.*;
import java.util.Scanner;

public class UpdateProduct {

    public static void main(String[] args) {
        // Assuming you know the product name you want to update

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product to be updated name: ");
        String productNameToUpdate = scanner.nextLine();

        System.out.print("Enter new product price: ");
        double newPrice = scanner.nextDouble();

        System.out.print("Enter new product quantity: ");
        int newQuantity = scanner.nextInt();

        boolean success = updateProduct(productNameToUpdate, newPrice, newQuantity);

        if (success) {
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Failed to update product. Product not found.");
        }
    }

    private static boolean updateProduct(String productName, double newPrice, int newQuantity) {
        File fileToUpdate = new File(productName + ".txt");

        if (fileToUpdate.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToUpdate))) {
                // Write updated product information to the file
                writer.write("Name: " + productName + "\n");
                writer.write("Price: " + newPrice + "\n");
                writer.write("Quantity: " + newQuantity + "\n");
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false; // Product not found
        }
    }
}
