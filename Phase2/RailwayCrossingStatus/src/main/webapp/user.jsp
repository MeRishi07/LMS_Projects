<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Railway Crossing Status - User Dashboard</title>
    <style>
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
            box-sizing: border-box;
        }
        .welcome-message {
            margin-top: 50px;
            font-size: 24px;
            text-align: center;
        }
        .crossing-list {
            margin-top: 50px;
            width: 80%;
        }
        .crossing-list-item {
            padding: 20px;
            border-bottom: 1px solid #ddd;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .crossing-name {
            font-size: 18px;
            font-weight: bold;
        }
        .crossing-details {
            margin-left: 20px;
            font-size: 16px;
        }
        .action-buttons {
            margin-top: 20px;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
    <div class="container">
        <h1 class="welcome-message">Welcome User :)</h1>
        <div class="crossing-list">
            <c:forEach var="crossing" items="${railwayCrossings}">
                <div class="crossing-list-item">
    <div>
        <div class="crossing-name">${crossing.getName()}</div>
        <div class="crossing-details">
            <p><strong>Address:</strong> ${crossing.getAddress()}</p>
            <p><strong>Landmark:</strong> ${crossing.getLandmark()}</p>
            <p><strong>Train Schedules:</strong> ${crossing.getTrainSchedules()}</p>
            <p><strong>Person in Charge:</strong> ${crossing.getPersonInCharge()}</p>
            <p><strong>Status:</strong> ${crossing.getStatus() == 1 ? 'Open' : 'Closed'}</p>
        </div>
    </div>
    <div>
        <input type="checkbox" id="favorite-${crossing.getId()}" name="favorite" value="${crossing.getId()}">
        <label for="favorite-${crossing.getId()}">Favorite</label>
    </div>
</div>

            </c:forEach>
        </div>
        <div class="action-buttons">
            <button onclick="window.location.href = 'search.jsp'">Search Railway Crossing</button>
            
        </div>
    </div>
</body>
</html>
