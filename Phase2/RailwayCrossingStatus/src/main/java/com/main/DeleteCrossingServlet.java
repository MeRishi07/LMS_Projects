package com.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteCrossingServlet")
public class DeleteCrossingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/railway_db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Amisanu@63";

    public DeleteCrossingServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the crossing ID to delete
        int crossingId = Integer.parseInt(request.getParameter("crossingId"));

        // Delete the crossing from the database
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String sql = "DELETE FROM railway_crossings WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, crossingId);

            int rowsAffected = statement.executeUpdate();

            statement.close();
            conn.close();

            if (rowsAffected > 0) {
                // Display success message
                response.getWriter().println("Records deleted successfully.");
            } else {
                // Display error message for invalid credentials
                response.getWriter().println("Wrong credentials. Deletion failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any database errors
            response.getWriter().println("An error occurred while deleting the crossing. Please try again later.");
        }
    }
}
