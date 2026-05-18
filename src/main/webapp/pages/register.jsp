<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Climax Cinemas - Register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>
<nav class="navbar">
    <div class="nav-logo">🎬 Climax Cinemas</div>
    <ul class="nav-links">
        <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
        <li><a href="#">About Us</a></li>
        <li><a href="#">Contact Us</a></li>
        <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
        <li><a href="${pageContext.request.contextPath}/register" class="btn-register">Register</a></li>
    </ul>
</nav>

<main class="signup-header">
    <div class="WelcomeMsg">
        <h2>Create Your <span style="color: #e50914;">Climax Cinemas</span> Account</h2>
        <p>Register now to book your favorite movies.</p>
    </div>

    <form action="register" method="POST" class="login-form">
        <p style='margin:0px;color:red; display: ${not empty error ? "block" : "none"}'>${error}</p>
        <div class="name">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${empty erName ? param.name:''}" required>
        </div>

        <div class="phone_number">
            <label for="phone_number">Phone Number:</label>
            <input type="tel" id="phone_number" name="phoneNumber" value="${empty erPhone ? param.phoneNumber:''}" required placeholder="98********">
        </div>

        <div class="date_of_birth">
            <label for="date_of_birth">Date of Birth:</label>
            <input type="date" name="dateOfBirth" id="date_of_birth" value="${empty erDateOfBirth ? param.dateOfBirth:''}" required>
        </div>


        <div class="email">
            <label for="email">Email Address:</label>
            <input type="email" id="email" name="email" value="${empty erMail ? param.email:''}" required placeholder="example@email.com">
        </div>

        <div class="password">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="${empty erPassword ? param.password:''}" required placeholder="********">
        </div>

        <div class="confirm-password">
            <label for="cfPassword">Confirm Password:</label>
            <input type="password" id="confirm-password" name="cfPassword" value="${empty erCfPassword ? param.cfPassword:''}" required placeholder="********">
        </div>

        <button type="submit" class="btn-login">Sign Up</button>
    </form>

    <p class="register-link">Already have an account? <a href="${pageContext.request.contextPath}/login">Login here</a></p>
</main>

<footer class="footer">
    <p>© 2026 Climax Cinemas. All rights reserved.</p>
    <p>Pokhara, Nepal</p>
</footer>
</body>
</html>