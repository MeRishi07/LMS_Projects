<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Railway Crossing</title>
</head>
<body>
    <h1>Delete Railway Crossing</h1>
    <form action="DeleteCrossingServlet" method="post">
        <label for="crossingId">Crossing ID:</label>
        <input type="text" id="crossingId" name="crossingId" required>
        <input type="submit" value="Delete">
    </form>
</body>
</html>
