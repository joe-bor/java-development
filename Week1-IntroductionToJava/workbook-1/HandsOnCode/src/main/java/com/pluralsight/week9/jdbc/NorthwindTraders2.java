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

        // open a connection
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            // execute query

            String query = """
                    SELECT ProductId, ProductName
                    FROM products;
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.printf("""
                        Product Id: %d --- Product Name: %s
                        """, resultSet.getInt(1), resultSet.getString(2));
            }

            // ---- choose id
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose an id: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM products WHERE ProductId = ?");
            preparedStatement1.setInt(1, id);
            ResultSet resultSet1 = preparedStatement1.executeQuery();

            while (resultSet1.next()) {
                System.out.printf("""
                        You chose:
                        Product Id: %d --- Product Name: %s
                        
                        """, resultSet1.getInt(1), resultSet1.getString(2));
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
