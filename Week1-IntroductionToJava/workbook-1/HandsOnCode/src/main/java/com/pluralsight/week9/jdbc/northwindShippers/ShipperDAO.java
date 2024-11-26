package com.pluralsight.week9.jdbc.northwindShippers;

import lombok.RequiredArgsConstructor;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ShipperDAO {
    private final BasicDataSource basicDataSource;

    public List<Shipper> getAllShippers() {
        List<Shipper> shippers = new ArrayList<>();

        String query = """
                SELECT * FROM Shippers
                """;

        try (Connection connection = basicDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
             ResultSet resultSet = preparedStatement.executeQuery();) {

            while (resultSet.next()) {
                shippers.add(new Shipper(resultSet.getInt("ShipperID"), resultSet.getString("CompanyName"), resultSet.getString("Phone")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return shippers;
    }

    public void addNewShipper(String companyName, String phoneNumber) {

        String query = """
                INSERT INTO Shippers
                (CompanyName, Phone)
                VALUES
                (?, ?)
                """;

        try (Connection connection = basicDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, companyName);
            preparedStatement.setString(2, phoneNumber);

            preparedStatement.executeUpdate();

            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                while (keys.next()) {
                    System.out.printf("#%d key was added \n", keys.getLong(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateShipper(int shipperID, String updatedPhoneNumber) {
        String query = """
                UPDATE shippers
                SET Phone = ?
                WHERE ShipperID = ?
                """;

        try (Connection connection = basicDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, updatedPhoneNumber);
            preparedStatement.setLong(2, shipperID);

            int rows = preparedStatement.executeUpdate();
            System.out.printf("%d rows updated\n", rows);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteShipper(int shipperID){
        String query = """
                DELETE FROM Shippers
                WHERE ShipperID = ?
                """;

        try (Connection connection = basicDataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, shipperID);
            int rows = preparedStatement.executeUpdate();

            System.out.printf("%d row(s) deleted. \n", rows);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
