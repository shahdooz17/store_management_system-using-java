package Admin;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class GenerateReports {

    public static void main(String[] args) {
        // Example usage
        Scanner in = new Scanner(System.in);
        String category = in.nextLine();
        generateProductReports();
        generateCategoryReports(category);
    }

    public static void generateProductReports() {
        // Specify the directory where product files are stored
        String productDirectory = "products/";

        // List all files in the directory that end with ".txt"
        File[] productFiles = new File(productDirectory).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });

        if (productFiles != null) {
            for (File file : productFiles) {
                generateReportFromFile(file);
            }
        } else {
            System.out.println("No products found.");
        }
    }

    public static void generateCategoryReports(String category) {
        // Specify the directory where product files are stored
        String productDirectory = "products/";

        // List all files in the directory that end with ".txt" and belong to the specified category
        File[] categoryFiles = new File(productDirectory).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt") && getCategoryFromFile(dir.getAbsolutePath() + "/" + name).equals(category);
            }
        });

        if (categoryFiles != null && categoryFiles.length > 0) {
            for (File file : categoryFiles) {
                generateReportFromFile(file);
            }
        } else {
            System.out.println("No products found in the specified category.");
        }
    }

    private static void generateReportFromFile(File file) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));

            System.out.println("\nProduct Report for: " + file.getName().replace(".txt", ""));

            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getCategoryFromFile(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                if (line.startsWith("Category:")) {
                    return line.substring("Category: ".length()).trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}