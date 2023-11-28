package products;

import java.io.File;
import java.util.Scanner;

public class DeleteProduct {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String productNameToDelete=input.nextLine();

        boolean success = deleteProduct(productNameToDelete);

        if (success) {
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Failed to delete product. Product not found.");
        }
    }

    private static boolean deleteProduct(String productName) {
        File fileToDelete = new File(productName + ".txt");

        if (fileToDelete.exists()) {
            return fileToDelete.delete();
        } else {
            return false; // Product not found
        }
    }
}
//generate reports and statistics for product or category of products