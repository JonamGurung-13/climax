<%--
  Created by IntelliJ IDEA.
  User: jonam
  Date: 5/3/2026
  Time: 2:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Climax Cinemas</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>

    <nav class="navbar">
        <div class="nav-logo">🎬 Climax Cinemas</div>
        <ul class="nav-links">
            <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
            <li><a href="#">Movies</a></li>
            <li><a href="#">Schedules</a></li>
            <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
            <li><a href="${pageContext.request.contextPath}/register" class="btn-register">Register</a></li>
        </ul>
    </nav>

    <!-- Login Form -->
    <div class="login-header">
        <div class="WelcomeMsg">
            <h2>Welcome to <span style="color: #e50914;">Climax Cinemas</span></h2>
            <p>Login to Your Account</p>
        </div>
        <form action="login" method="POST" class="login-form">
            <p style='margin:0px;color:red; display: ${not empty error ? "block" : "none"}'>${error}</p>
            <div class="email">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required placeholder="example@gmail.com">
            </div>
            <div class="password">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required placeholder="********">
            </div>

            <div class="remember-me" style="margin-top: 10px;">
                <input type="checkbox" id="rememberMe" name="rememberMe" value="true">
                <label for="rememberMe">Remember Me</label>
            </div>
            <button type="submit" class="btn-login">Sign In</button>
        </form>
        <br>
        <p class="register-link">Don't have an account? <a href="Register.html">Register here</a></p>
    </div>
<footer class="footer">
    <p>© 2026 Climax Cinemas. All rights reserved.</p>
    <p>Pokhara, Nepal</p>
</footer>

</body>
</html>
