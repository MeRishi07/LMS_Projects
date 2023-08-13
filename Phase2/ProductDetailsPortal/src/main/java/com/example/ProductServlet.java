package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProductServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5460260007064207011L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        // Create a new Product object
        Product product = new Product(name, description, price);

        // Store the product in the session
        HttpSession session = request.getSession();
        session.setAttribute("product", product);

        // Redirect to productDetails.jsp
        response.sendRedirect("productDetails.jsp");
    }
}
