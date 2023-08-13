<%@ page import="com.example.Product" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Details</title>
</head>
<body>
    <h1>Product Details</h1>
    <%-- Retrieve product from session --%>
    <%
        Product product = (Product) session.getAttribute("product");
    %>
    <table>
        <tr>
            <td>Name:</td>
            <td><%= product.getName() %></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><%= product.getDescription() %></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><%= product.getPrice() %></td>
        </tr>
    </table>
</body>
</html>
