package com.pluralsight.week9.jdbc;

import java.sql.*;

public class NorthwindTraders {

    public static void main(String[] args) {

        // open a conenction
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "goodtry");) {
        // execute query
            Statement statement = connection.createStatement();
            String query = """
                    SELECT *
                    FROM products;
                    """;
            ResultSet rs = statement.executeQuery(query);

            // TEST
            System.out.println(rs.findColumn("productName"));
            System.out.println(rs);


            while(rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // close connection
}
