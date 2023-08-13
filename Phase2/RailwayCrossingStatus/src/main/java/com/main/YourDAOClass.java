package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class YourDAOClass {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/railway_db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Amisanu@63";

    public RailwayCrossing getRailwayCrossingByName(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        RailwayCrossing crossing = null;

        try {
            connection = getConnection();

            String query = "SELECT * FROM railway_crossings WHERE name = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String address = resultSet.getString("address");
                String landmark = resultSet.getString("landmark");
                String trainSchedules = resultSet.getString("train_schedules");
                String personInCharge = resultSet.getString("person_in_charge");
                int status = resultSet.getInt("status");

                crossing = new RailwayCrossing(id, name, address, landmark, trainSchedules, personInCharge, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, resultSet);
        }

        return crossing;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
    public List<RailwayCrossing> getFavoriteCrossings() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<RailwayCrossing> favoriteCrossings = new ArrayList<>();

        try {
            connection = getConnection();

            String query = "SELECT * FROM railway_crossings WHERE favorite = true";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Retrieve crossing data from the result set
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String landmark = resultSet.getString("landmark");
                String trainSchedules = resultSet.getString("train_schedules");
                String personInCharge = resultSet.getString("person_in_charge");
                int status = resultSet.getInt("status");

                // Create a RailwayCrossing object
                RailwayCrossing crossing = new RailwayCrossing(id, name, address, landmark, trainSchedules,
                        personInCharge, status);

                // Add the crossing to the list of favorite crossings
                favoriteCrossings.add(crossing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, resultSet);
        }

        return favoriteCrossings;
    }

    private void closeResources(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
