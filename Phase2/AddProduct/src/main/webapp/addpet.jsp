<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Add Pet</title>
<script src="addproduct.js"></script>
</head>
<body>


    <form action="PetsServlet" method="post" name="form_name" id="form_id"
        class="form_class">
        <label for="name">Name:</label><br> <input type="text" id="name"
            name="name"><br> <label for="color">Color:</label><br>
        <input type="text" id="color" name="color"><br> <label
            for="price">Price:</label><br> <input type="number" id="price"
            name="price"><br>
        <br> <input type="submit" value="Submit"
            onclick="addpet_onclick()">
    </form>

    <p style="text-align: center">
        <a href="index.jsp">Back to Home Page</a>
    </p>

</body>
</html>
