package com.pluralsight.week9.jdbc.mini_exercises;

import java.sql.*;
import java.util.Scanner;

public class App {
    static final String DB_URL = DBConfig.get("db.url");
    static final String DB_USER = DBConfig.get("db.user");
    static final String DB_PASSWORD = DBConfig.get("db.password");
    static final Scanner SCANNER = new Scanner(System.in);


    public static void main(String[] args) {
//        getAllCarsQuery();
        pickDealerShip();

    }

    private static void getAllCarsQuery() {
        String query = """
                SELECT *
                FROM Dealerships d
                JOIN Inventory i
                ON d.DealershipID = i.DealershipID
                JOIN Vehicles v
                ON i.VehicleVIN = v.VehicleVIN
                """;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                System.out.printf("""
                        ---------------------------------------------------------------
                        Vehicle
                        VIN: %s
                        Color: %s
                        Sold: %s
                        ---------------------------------------------------------------
                        """, resultSet.getString("VehicleVIN"), resultSet.getString("Color"), resultSet.getDate("Sold"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void pickDealerShip() {
        System.out.println("What is the name of dealership you want to check");
        String dealershipName = SCANNER.nextLine();

        String query = """
                SELECT *
                FROM Dealerships
                WHERE dealershipName = ?
                """;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, dealershipName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.printf("""
                                Dealership
                                ID: %s
                                Name: %s
                                Address: %s
                                Phone:%s
                                """,
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );


            // new prompt
                System.out.println("\n\nWould you like to see the cars in this dealership?");
                String answer = SCANNER.nextLine();
                switch (answer){
                    case "y" -> getAllCarsFromDealership(dealershipName);
                    default -> System.out.println("BYE");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getAllCarsFromDealership(String dealershipName) {
        String query = """
                SELECT v.VehicleVIN, v.Color, v.Sold
                FROM Dealerships d
                JOIN Inventory i
                ON d.DealershipID = i.DealershipID
                JOIN Vehicles v
                ON i.VehicleVIN = v.VehicleVIN
                WHERE d.DealershipName = ?
                """;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, dealershipName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.printf("""
                        ---------------------------------------------------------------
                        Vehicle
                        VIN: %s
                        Color: %s
                        Sold: %s
                        ---------------------------------------------------------------
                        """, resultSet.getString("VehicleVIN"), resultSet.getString("Color"), resultSet.getDate("Sold"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
