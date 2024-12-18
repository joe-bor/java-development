package com.pluralsight.week9.jdbc;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class NorthwindTraders2 {

    private static final Properties PROPERTIES = new Properties();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Connection CONNECTION = initConnection();
    @Getter
    @Setter
    private static boolean appRunning;

    public static void main(String[] args) {

        do {
            displayHomeScreen();
        } while (isAppRunning());

        closeResources();
    }

    private static Connection initConnection() {
        loadProperties();

        String dbUrl = "jdbc:mysql://localhost:3306/northwind";
        String dbUser = PROPERTIES.getProperty("db.user");
        String dbPassword = PROPERTIES.getProperty("db.password");

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(dbUser);
        basicDataSource.setPassword(dbPassword);

        try {
            return basicDataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadProperties() {
        try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
            PROPERTIES.load(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void displayHomeScreen() {
        System.out.println("""
                
                What do you want to do?
                1 - Display al products
                2 - Display all customers
                3 - Display all categories
                0 - Exit
                
                Select an option:
                """);
        String answer = SCANNER.nextLine();

        switch (answer) {
            case "1" -> displayAllProducts();
            case "2" -> displayAllCustomers();
            case "3" -> displayAllCategories();
            case "0" -> closeApp();
            default -> System.out.println("Invalid Option");
        }
    }

    private static void closeApp() {
        System.out.println("Terminating the app...");
        setAppRunning(false);
    }

    private static void displayAllProducts() {
        String query = """
                SELECT ProductId, ProductName, UnitPrice, UnitsInStock
                FROM products;
                """;

        try (PreparedStatement preparedStatement = CONNECTION.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            while (resultSet.next()) {
                System.out.printf("""
                        --------------------------------------------------
                        Product Id: %d
                        Name: %-10s
                        Price: %d
                        Stock: %d
                        --------------------------------------------------
                        
                        """, resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void displayAllCustomers() {
        String query = """
                SELECT ContactName, CompanyName, City, Country, Phone
                FROM Customers
                ORDER BY Country;
                """;

        try (PreparedStatement preparedStatement = CONNECTION.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            while (resultSet.next()) {
                System.out.printf("""
                        --------------------------------------------------
                        Name: %-10s
                        Company: %-10s
                        City: %-10s Country: %-10s
                        Phone: %s
                        --------------------------------------------------
                        
                        """, resultSet.getString("ContactName"), resultSet.getString("CompanyName"), resultSet.getString("City"), resultSet.getString("Country"), resultSet.getString("Phone"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void displayAllCategories() {
        String query = """
                SELECT *
                FROM Categories
                ORDER BY CategoryID
                """;

        try (PreparedStatement preparedStatement = CONNECTION.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                System.out.printf("""
                        --------------------------------------------------
                        Category Id: %d
                        Category Name: %-10s
                        --------------------------------------------------
                        
                        """, resultSet.getInt("CategoryID"), resultSet.getString("CategoryName"));
            }

            // new prompt
            System.out.println("Pick a category ID to see all its products");
            String categoryId = SCANNER.nextLine();
            displayAllProductsFromCategory(categoryId);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void displayAllProductsFromCategory(String categoryID) {
        String query = """
                SELECT p.ProductID, p.ProductName, p.UnitPrice, p.UnitsInStock
                FROM Categories c
                JOIN Products p
                ON c.CategoryID = p.CategoryID
                WHERE c.CategoryID = ?
                """;

        try (PreparedStatement preparedStatement = CONNECTION.prepareStatement(query)) {
            preparedStatement.setString(1, categoryID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.printf("""
                            --------------------------------------------------
                            Product ID: %-10s
                            Product Name: %-10s
                            Unit Price: %.2f
                            Units in Stock: %.2f
                            --------------------------------------------------
                            
                            """, resultSet.getString("ProductID"), resultSet.getString("ProductName"), resultSet.getFloat("UnitPrice"), resultSet.getFloat("UnitsInStock"));

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static void closeResources(){
        try {
            SCANNER.close();
            CONNECTION.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
