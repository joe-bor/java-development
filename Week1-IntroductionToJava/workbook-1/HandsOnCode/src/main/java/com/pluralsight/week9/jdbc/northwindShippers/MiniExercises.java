package com.pluralsight.week9.jdbc.northwindShippers;

import com.pluralsight.week9.jdbc.mini_exercises.DBConfig;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MiniExercises {
    private static final BasicDataSource BASIC_DATA_SOURCE = initBSD();

    private static BasicDataSource initBSD() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        basicDataSource.setUsername(DBConfig.get("db.user"));
        basicDataSource.setPassword(DBConfig.get("db.password"));
        return basicDataSource;
    }

    public static void main(String[] args) {

    }

    private static void insertNewCategory(BasicDataSource basicDataSource){
        String query = """
                INSERT INTO Categories
                ("CategoryName", "Description")
                VALUES
                ("Seasonal Products", "Limited time offers:)
                """;

        try (Connection connection = basicDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
