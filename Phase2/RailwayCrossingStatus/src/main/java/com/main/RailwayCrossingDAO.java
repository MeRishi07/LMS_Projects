package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RailwayCrossingDAO {
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

    public List<RailwayCrossing> getAllRailwayCrossings() {
        return getRailwayCrossingsFromDatabase("SELECT * FROM railway_crossings");
    }

    public List<RailwayCrossing> searchRailwayCrossings(String query) {
        String searchQuery = "SELECT * FROM railway_crossings WHERE name LIKE ?";
        return getRailwayCrossingsFromDatabase(searchQuery, "%" + query + "%");
    }

    public void markAsFavorite(int crossingId, boolean isFavorite) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();

            String query = "UPDATE railway_crossings SET favorite = ? WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setBoolean(1, isFavorite);
            statement.setInt(2, crossingId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, null);
        }
    }

    private List<RailwayCrossing> getRailwayCrossingsFromDatabase(String query, Object... parameters) {
        List<RailwayCrossing> crossings = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            statement = connection.prepareStatement(query);

            for (int i = 0; i < parameters.length; i++) {
                statement.setObject(i + 1, parameters[i]);
            }

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String landmark = resultSet.getString("landmark");
                String trainSchedules = resultSet.getString("train_schedules");
                String personInCharge = resultSet.getString("person_in_charge");
                int status = resultSet.getInt("status");

                RailwayCrossing crossing = new RailwayCrossing(id, name, address, landmark, trainSchedules,
                        personInCharge, status);
                crossings.add(crossing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, resultSet);
        }

        return crossings;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
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
