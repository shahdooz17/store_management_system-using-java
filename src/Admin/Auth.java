package Admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Auth {

    private static final String USER_FOLDER_PATH = "user_files";

    public static void main(String[] args) {
        createFolderIfNotExists(USER_FOLDER_PATH);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Login System");

        while (true) {
            System.out.println("\n1. Login\n2. Register\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void createFolderIfNotExists(String folderPath) {
        Path folder = Paths.get(folderPath);
        if (Files.notExists(folder)) {
            try {
                Files.createDirectory(folder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (validateUser(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static void register() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a new username: ");
        String username = scanner.nextLine();

        if (isUsernameTaken(username)) {
            System.out.println("Username already taken. Please choose another.");
            return;
        }

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        createUserFile(username, password);

        System.out.println("Registration successful!");
    }

    private static boolean validateUser(String username, String password) {
        Path userFilePath = Paths.get(USER_FOLDER_PATH, username + ".txt");

        if (Files.exists(userFilePath)) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(userFilePath.toFile()));
                String storedPassword = reader.readLine();
                reader.close();

                return storedPassword != null && storedPassword.equals(password);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    private static void createUserFile(String username, String password) {
        Path userFilePath = Paths.get(USER_FOLDER_PATH, username + ".txt");

        try {
            FileWriter writer = new FileWriter(userFilePath.toFile());
            writer.write(password);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isUsernameTaken(String username) {
        Path userFilePath = Paths.get(USER_FOLDER_PATH, username + ".txt");
        return Files.exists(userFilePath);
    }
}
