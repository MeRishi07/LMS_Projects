<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>View User</title>
</head>
<body>
    <h2>Enter User ID to View Employee Details</h2>
    <form action="editEmployee" method="get">
        <label for="userId">User ID:</label>
        <input type="text" id="userId" name="userId" required>
        <button type="submit">View Details</button>
    </form>
</body>
</html>
