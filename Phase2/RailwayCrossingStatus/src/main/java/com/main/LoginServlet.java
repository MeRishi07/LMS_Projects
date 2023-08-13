package com.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (isValidCredentials(email, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);

            boolean isAdmin = checkAdminStatus(email);
            if (isAdmin) {
                List<RailwayCrossing> railwayCrossings = getRailwayCrossingsFromDatabase();
                request.setAttribute("railwayCrossings", railwayCrossings);
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            } else {
                List<RailwayCrossing> railwayCrossings = getRailwayCrossingsFromDatabase();
                request.setAttribute("railwayCrossings", railwayCrossings);
                request.getRequestDispatcher("user.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Invalid credentials");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private boolean isValidCredentials(String email, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getDatabaseConnection();

            String query = "SELECT COUNT(*) FROM users WHERE email = ? AND password = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDatabaseResources(connection, statement, resultSet);
        }

        return false;
    }

    private boolean checkAdminStatus(String email) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getDatabaseConnection();

            String query = "SELECT isAdmin FROM users WHERE email = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, email);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getBoolean("isAdmin");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDatabaseResources(connection, statement, resultSet);
        }

        return false;
    }

    private List<RailwayCrossing> getRailwayCrossingsFromDatabase() {
        List<RailwayCrossing> railwayCrossings = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getDatabaseConnection();

            String query = "SELECT * FROM railway_crossings";
            statement = connection.prepareStatement(query);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String landmark = resultSet.getString("landmark");
                String trainSchedules = resultSet.getString("train_schedules");
                String personInCharge = resultSet.getString("person_in_charge");
                int status = resultSet.getInt("status");

                RailwayCrossing crossing = new RailwayCrossing(id, name, address, landmark, trainSchedules, personInCharge, status);
                railwayCrossings.add(crossing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDatabaseResources(connection, statement, resultSet);
        }

        return railwayCrossings;
    }

    private void closeDatabaseResources(Connection connection, PreparedStatement statement, ResultSet resultSet) {
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

    private Connection getDatabaseConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/railway_db";
            String username = "root";
            String password = "Amisanu@63";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
