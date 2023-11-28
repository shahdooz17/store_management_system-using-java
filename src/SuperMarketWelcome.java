

import java.util.Scanner;

public class SuperMarketWelcome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Supermarket");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Customer");
            System.out.println("2. Supplier");
            System.out.println("3. Admin");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    customerMenu();
                    break;
                case 2:
                    supplierMenu();
                    break;
                case 3:
                    adminMenu();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void customerMenu() {
        System.out.println("\nCustomer Menu");
        // Add customer-related functionality here
    }

    private static void supplierMenu() {
        System.out.println("\nSupplier Menu");
        // Add supplier-related functionality here
    }

    private static void adminMenu() {
        System.out.println("\nAdmin Menu");
        // Add admin-related functionality here
    }
}
