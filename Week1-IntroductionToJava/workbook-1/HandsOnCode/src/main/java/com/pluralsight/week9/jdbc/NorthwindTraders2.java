package com.pluralsight.week9.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class NorthwindTraders2 {

    private static Properties properties = new Properties();

    public static void main(String[] args) {
        loadProperties();

        String dbUrl = properties.getProperty("db.url");
        String dbUser = properties.getProperty("db.user");
        String dbPassword = properties.getProperty("db.password");

        String query = """
                SELECT ProductId, ProductName, UnitPrice, UnitsInStock
                FROM products;
                """;

        String queryById = """
                SELECT ProductId, ProductName, UnitPrice, UnitsInStock
                FROM products
                WHERE ProductId = ?;
                """;

        // open a connection
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            // execute query


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

            // ---- choose id
            try (
                    Scanner scanner = new Scanner(System.in);
                    PreparedStatement preparedStatement1 = connection.prepareStatement(queryById)
            ) {
                System.out.print("Choose an id: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                preparedStatement1.setInt(1, id);
                ResultSet resultSet1 = preparedStatement1.executeQuery();

                while (resultSet1.next()) {
                    System.out.printf("""
                            Product Id: %d
                            Name: %-10s
                            Price: %d
                            Stock: %d
                            --------------------------------------------------
                            
                            """, resultSet1.getInt(1), resultSet1.getString(2), resultSet1.getInt(3), resultSet1.getInt(4));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadProperties() {
        try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
