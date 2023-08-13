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

@WebServlet("/UpdateStatusServlet")
public class UpdateStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/railway_db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Amisanu@63";

    public UpdateStatusServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the crossing ID and status from the request parameters
        int crossingId;
        try {
            crossingId = Integer.parseInt(request.getParameter("crossingId"));
        } catch (NumberFormatException e) {
            response.sendRedirect("update_status.jsp?error=invalid_id");
            return;
        }
        String status = request.getParameter("status");

        // Update the status of the crossing in the database
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String sql = "UPDATE railway_crossings SET status=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, status);
            statement.setInt(2, crossingId);

            int rowsAffected = statement.executeUpdate();

            statement.close();
            conn.close();

            if (rowsAffected > 0) {
                // Status update successful
                response.sendRedirect("update_status.jsp?success=true");
            } else {
                // Handle the case when no rows were affected (crossing with the given ID not found)
                response.sendRedirect("update_status.jsp?error=invalid_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any database errors
            response.sendRedirect("update_status.jsp?error=database_error");
        }
    }
}
