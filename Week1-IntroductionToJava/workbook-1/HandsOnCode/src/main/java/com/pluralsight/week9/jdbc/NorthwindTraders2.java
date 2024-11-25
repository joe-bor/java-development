package com.pluralsight.week9.jdbc;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serial;
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


        String queryById = """
                SELECT ProductId, ProductName, UnitPrice, UnitsInStock
                FROM products
                WHERE ProductId = ?;
                """;
    }

    private static Connection initConnection() {
        loadProperties();

        String dbUrl = "jdbc:mysql://localhost:3306/northwind";
        String dbUser = PROPERTIES.getProperty("db.user");
        String dbPassword = PROPERTIES.getProperty("db.password");

        try {
            return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
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
                0 - Exit
                
                Select an option:
                """);
        String answer = SCANNER.nextLine();

        switch (answer) {
            case "1" -> displayAllProducts();
            case "2" -> displayAllCustomers();
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
}
