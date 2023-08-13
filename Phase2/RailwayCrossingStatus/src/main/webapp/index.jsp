<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to Railway Crossing Status</title>
    <style>
        .container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .message-container {
            text-align: center;
            margin-top: 50px;
        }
        .top-message {
            font-size: 24px;
        }
        .bottom-message {
            font-size: 18px;
        }
        .left-section,
        .right-section {
            flex: 1;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="message-container">
        <p class="top-message">Welcome to Railway Crossing Status</p>
        <p class="bottom-message">Developed By James Tech</p>
    </div>
    <div class="container">
        <div class="left-section">
            <h1>Login</h1>
            <form action="login" method="POST">
                <input type="email" name="email" placeholder="Email" required><br><br>
                <input type="password" name="password" placeholder="Password" required><br><br>
                <button type="submit">Login</button>
            </form>
        </div>
        <div class="right-section">
            <h1>New User</h1>
            <a href="register.jsp">Create an Account</a>
        </div>
    </div>
</body>
</html>


    