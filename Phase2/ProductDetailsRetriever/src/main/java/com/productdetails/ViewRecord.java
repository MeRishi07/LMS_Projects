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

@WebServlet("/ViewRecord")
public class ViewRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Call Connection method
			Connection con = DBConnector.getConnection();
			// Write SQL command
			String query = "select* from electronic_products";
			// Create a Statement object to execute the SQL command
			Statement stmt = con.createStatement();
			// Get the result
			ResultSet rs = stmt.executeQuery(query);

			// Display the result in an HTML page
			PrintWriter out = response.getWriter();
			out.println("<table border=2>");
			out.println("<tr>" + "<th>Product ID</th>" + "<th>Product Name</th>" + "<th>Price</th>" + "</tr>");
			while (rs.next()) {
				out.println("<tr>");
				out.print("<td>" + rs.getInt("product_id") + "</td>");
				out.print("<td>" + rs.getString("product_name") + "</td>");
				out.print("<td>" + rs.getFloat("price") + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
