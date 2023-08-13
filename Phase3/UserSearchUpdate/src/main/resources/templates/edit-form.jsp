<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
    <h2>Edit Employee Details</h2>
    <form action="updateEmployee" method="post">
        <label for="userId">User ID:</label>
        <input type="text" id="userId" name="user_id" value="${employee.user_id}" readonly>
        <br>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${employee.name}" required>
        <br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${employee.email}" required>
        <br>
        <label for="contactNo">Contact No.:</label>
        <input type="text" id="contactNo" name="contact_no" value="${employee.contact_no}" required>
        <br>
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="${employee.address}" required>
        <br>
        <label for="designation">Designation:</label>
        <input type="text" id="designation" name="designation" value="${employee.designation}" required>
        <br>
        <button type="submit">Update</button>
    </form>
</body>
</html>
