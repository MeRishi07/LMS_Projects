package com.login;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final String VALID_USERNAME = "admin";
	    private static final String VALID_PASSWORD = "password";

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
	            // Valid credentials, create a session
	            HttpSession session = request.getSession();
	            session.setAttribute("username", username);
	            response.sendRedirect("dashboard.jsp");
	        } else {
	            // Invalid credentials, redirect to error page
	            response.sendRedirect("error.jsp");
	        }
	    }
	}