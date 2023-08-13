<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Railway Crossing Status - Registration</title>
    <style>
        .container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .registration-form {
            text-align: center;
        }
        .error-message {
            color: red;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Registration</h1>
        <div class="registration-form">
            <form action="register" method="POST">
                <input type="email" name="email" placeholder="Email" required><br><br>
                <input type="text" name="username" placeholder="Username" required><br><br>
                <input type="password" name="password" placeholder="Password" required><br><br>
                <button type="submit">Register</button>
            </form>
            <p class="error-message">${errorMessage}</p>
        </div>
    </div>
</body>
</html>
