<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <title>Add Crossing</title>
</head>
<body>
    <h1>Add Crossing</h1>
    <form action="AddCrossingServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required><br>
        
        <label for="landmark">Landmark:</label>
        <input type="text" id="landmark" name="landmark" required><br>
        
        <label for="trainSchedules">Train Schedules:</label>
        <input type="text" id="trainSchedules" name="trainSchedules" required><br>
        
        <label for="personInCharge">Person in Charge:</label>
        <input type="text" id="personInCharge" name="personInCharge" required><br>
        
        <button type="submit">Add Crossing</button>
    </form>
</body>
</html>
