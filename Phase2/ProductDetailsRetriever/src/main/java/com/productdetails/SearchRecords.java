package com.productdetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchRecords")
public class SearchRecords extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Call Connection method
            Connection con = DBConnector.getConnection();
            // Get the product ID from the request parameter
            int productId = Integer.parseInt(request.getParameter("product_id"));
            // Write SQL command
            String query = "SELECT * FROM electronic_products WHERE product_id = " + productId;
            // Create a Statement object to execute the SQL command
            Statement stmt = con.createStatement();
            // Get the result
            ResultSet rs = stmt.executeQuery(query);

            // Display the result in an HTML page
            PrintWriter out = response.getWriter();
            out.println("<table border=2>");
            out.println("<tr>" + "<th>Product ID</th>" + "<th>Product Name</th>" + "<th>Price</th>" + "</tr>");
            if (rs.next()) {
                out.println("<tr>");
                out.print("<td>" + rs.getInt("product_id") + "</td>");
                out.print("<td>" + rs.getString("product_name") + "</td>");
                out.print("<td>" + rs.getFloat("price") + "</td>");
                out.println("</tr>");
            } else {
                out.println("<tr>");
                out.print("<td colspan='3'>Record not found.</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
