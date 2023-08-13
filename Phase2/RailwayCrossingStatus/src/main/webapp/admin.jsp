<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Railway Crossing Status - Admin Panel</title>
    <style>
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 100px;
        }
        h1 {
            text-align: center;
        }
        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 50px;
        }
        th, td {
            padding: 10px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        .action-buttons {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }
        .action-buttons button {
            margin: 0 10px;
            padding: 10px 20px;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Hello Admin !!</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Landmark</th>
                    <th>Train Schedules</th>
                    <th>Person in Charge</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="crossing" items="${railwayCrossings}" varStatus="loop">
                    <c:if test="${loop.index != railwayCrossings.size() - 1}">
                        <tr>
                            <td>${crossing.id}</td>
                            <td>${crossing.name}</td>
                            <td>${crossing.address}</td>
                            <td>${crossing.landmark}</td>
                            <td>${crossing.trainSchedules}</td>
                            <td>${crossing.personInCharge}</td>
                            <td>${crossing.status == 1 ? 'Open' : 'Closed'}</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>
        <div class="action-buttons">
            <button onclick="window.location.href = 'add_crossing.jsp'">Add Railway Crossing</button>
            <button onclick="window.location.href = 'delete_crossing.jsp'">Delete Railway Crossing</button>
            <button onclick="window.location.href = 'search.jsp'">Search Railway Crossing</button>
            <button onclick="window.location.href = 'update_status.jsp'">Update Crossing Status</button>
        </div>
    </div>
</body>
</html>
