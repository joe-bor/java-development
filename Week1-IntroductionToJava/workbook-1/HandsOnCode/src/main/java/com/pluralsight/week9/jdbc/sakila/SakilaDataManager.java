package com.pluralsight.week9.jdbc.sakila;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SakilaDataManager {
    private BasicDataSource basicDataSource;

    public SakilaDataManager(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

    public void displayAllActorsWithGivenName(String firstName, String lastName) {
        String query = """
                SELECT *
                FROM actor
                WHERE first_name LIKE '%%%s%%'
                AND last_name LIKE '%%%s%%'
                """.formatted(firstName, lastName);


        try (Connection connection = basicDataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                System.out.printf("""
                        --------------------------------------------------------
                        Actor ID: %d
                        Actor name: %s %s
                        --------------------------------------------------------
                        """, resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Actor> getAllActorsWithGivenName(String firstName, String lastName) {
        List<Actor> actorList = new ArrayList<>();

        String query = """
                SELECT *
                FROM actor
                WHERE first_name LIKE '%%%s%%'
                AND last_name LIKE '%%%s%%'
                """.formatted(firstName, lastName);

        try (Connection connection = basicDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()
        ) {

            while (resultSet.next()) {
                actorList.add(new Actor(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return actorList;
    }

    public List<Film> getAllFilmsViaActorID(int actorID) {
        List<Film> films = new ArrayList<>();

        String query = """
                SELECT f.film_id, f.title, f.description, f.release_year, f.length
                FROM film f
                JOIN film_actor fa
                ON f.film_id = fa.film_id
                JOIN actor a
                ON fa.actor_id = a.actor_id
                WHERE a.actor_id = %d
                """.formatted(actorID);

        try (Connection connection = basicDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                films.add(new Film(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return films;
    }

}
