package com.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCrossingServlet")
public class AddCrossingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/railway_db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Amisanu@63";

    public AddCrossingServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the form data
        String crossingName = request.getParameter("name");
        String crossingAddress = request.getParameter("address");
        String crossingLandmark = request.getParameter("landmark");
        String trainSchedules = request.getParameter("trainSchedules");
        String personInCharge = request.getParameter("personInCharge");

        // Save the new crossing to the database
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String sql = "INSERT INTO railway_crossings (name, address, landmark, train_schedules, person_in_charge, status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, crossingName);
            statement.setString(2, crossingAddress);
            statement.setString(3, crossingLandmark);
            statement.setString(4, trainSchedules);
            statement.setString(5, personInCharge);
            statement.setInt(6, 1); // Set the initial status as Open (1)

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    // Use the generated ID in your code
                    System.out.println("Generated ID: " + generatedId);
                }

                statement.close();
                conn.close();

                // Send the response as "Record Added"
                response.getWriter().write("Record Added");
            } else {
                throw new SQLException("Failed to add crossing. No rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "An error occurred while adding the crossing. Please try again later.");
        }
    }
}
