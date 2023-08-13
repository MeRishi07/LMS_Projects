<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Crossing Status</title>
</head>
<body>
    <h1>Update Crossing Status</h1>
    <form action="UpdateStatusServlet" method="POST">
        <label for="crossingId">Crossing ID:</label>
        <input type="number" id="crossingId" name="crossingId" required><br><br>

        <label for="status">Status:</label>
        <select id="status" name="status" required>
            <option value="1">Open</option>
            <option value="0">Close</option>
        </select><br><br>

        <input type="submit" value="Update Status">
    </form>
    <%
        String error = request.getParameter("error");
        String success = request.getParameter("success");
        if (error != null) {
            if (error.equals("invalid_id")) {
                out.println("<p>Error: Invalid crossing ID.</p>");
            } else if (error.equals("database_error")) {
                out.println("<p>Error: Database error occurred.</p>");
            }
        }
        if (success != null && success.equals("true")) {
            out.println("<p>Status updated successfully.</p>");
        }
    %>
</body>
</html>
