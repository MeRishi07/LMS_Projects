<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.main.RailwayCrossing" %>
<%@ page import="com.main.RailwayCrossingDAO" %>

<!DOCTYPE html>
<html>
<head>
    <title>Railway Crossing Status - Search Crossing</title>
    <style>
        .container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .search-form {
            text-align: center;
        }
        .search-input {
            margin-bottom: 10px;
            padding: 5px 10px;
            font-size: 16px;
        }
        .search-button {
            margin-top: 10px;
        }
        .error-message {
            color: red;
            margin-top: 20px;
            text-align: center;
        }
        .crossing-details {
            margin-top: 20px;
            font-size: 16px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Search Railway Crossing</h1>
        <div class="search-form">
            <form action="search" method="GET">
                <input type="text" name="query" class="search-input" placeholder="Enter crossing name" required>
                <button type="submit" class="search-button">Search</button>
            </form>
        </div>

        <c:if test="${not empty param.query}">
            <%-- Perform the search operation --%>
            <%@ page import="com.main.RailwayCrossingDAO" %>
            <%@ page import="java.util.List" %>
            <%@ page import="java.util.ArrayList" %>
     
            <%-- Get the crossing name from the request parameter --%>
            <%
                String crossingName = request.getParameter("query");
                RailwayCrossingDAO dao = new RailwayCrossingDAO();
                RailwayCrossing crossing = dao.getRailwayCrossingByName(crossingName);

                if (crossing != null) {
            %>
                    <div class="crossing-details">
                        <p><strong>Address:</strong> <%= crossing.getAddress() %></p>
                        <p><strong>Landmark:</strong> <%= crossing.getLandmark() %></p>
                        <p><strong>Train Schedules:</strong> <%= crossing.getTrainSchedules() %></p>
                        <p><strong>Person in Charge:</strong> <%= crossing.getPersonInCharge() %></p>
                        <p><strong>Status:</strong> <%= crossing.getStatus() == 1 ? "Open" : "Closed" %></p>
                    </div>
            <%
                } else {
            %>
                    <div class="error-message">Crossing not found.</div>
            <%
                }
            %>
        </c:if>
    </div>
</body>
</html>
