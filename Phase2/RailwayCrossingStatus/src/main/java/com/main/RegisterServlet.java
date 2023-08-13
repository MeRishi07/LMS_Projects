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


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (isUserExists(email)) {
            request.setAttribute("errorMessage", "User already exists!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            registerUser(email, username, password);
            response.sendRedirect("login.jsp");
        }
    }
    
    private boolean isUserExists(String email) {
        boolean exists = false;
        
        // Use JDBC or Hibernate to check if the user already exists in the database
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            // Set up database connection
            connection = getDatabaseConnection();

            // Prepare the SQL query
            String query = "SELECT COUNT(*) FROM users WHERE email = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, email);

            // Execute the query
            resultSet = statement.executeQuery();

            // Check the result
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                exists = (count > 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            closeDatabaseResources(connection, statement, resultSet);
        }
        
        return exists;
    }
    
    private void registerUser(String email, String username, String password) {
        // Use JDBC or Hibernate to register the user in the database
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Set up database connection
            connection = getDatabaseConnection();

            // Prepare the SQL query
            String query = "INSERT INTO users (username, password, email, isAdmin) VALUES (?, ?, ?, FALSE)";
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);

            // Execute the query
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Registration successful!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            closeDatabaseResources(connection, statement, null);
        }
    }

    private Connection getDatabaseConnection() throws SQLException {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Replace the following with your database connection details
        String url = "jdbc:mysql://localhost:3306/railway_db";
        String username = "root";
        String password = "Amisanu@63";

        return DriverManager.getConnection(url, username, password);
    }
    
    private void closeDatabaseResources(Connection connection, Statement statement, ResultSet resultSet) {
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