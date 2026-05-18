<%@ page import="com.icp.climax.model.User" %>

<%--
  Created by IntelliJ IDEA.
  User: jonam
  Date: 5/9/2026
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Climax Cinemas</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>

<nav class="navbar">
    <div class="nav-logo">Climax Cinemas</div>
    <ul class="nav-links">
        <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
        <li><a href="#">About Us</a></li>
        <li><a href="#">Contact Us</a></li>
        <%
            HttpSession s = request.getSession(false);
            User loggedInUser = (s != null) ? (User) s.getAttribute("loggedInUser") : null;
        %>

        <%if (loggedInUser !=null){ %>

        <li><a href="${pageContext.request.contextPath}/logout" class="btn-register">Logout</a></li>
        <%} else {%>
        <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
        <li><a href="${pageContext.request.contextPath}/register" class="btn-register">Register</a></li>
        <% } %>
    </ul>
</nav>

<section class="hero">
    <div class="hero-slides">
        <div class="slide active" style="background-image: url('${pageContext.request.contextPath}/resources/images/AvatarFireAsh.png')"></div>
        <div class="slide" style="background-image: url('${pageContext.request.contextPath}/resources/images/AvengerEndGame.png')"></div>
        <div class="slide" style="background-image: url('${pageContext.request.contextPath}/resources/images/Lali bajar.jpeg')"></div>
        <div class="slide" style="background-image: url('${pageContext.request.contextPath}/resources/images/Life Dyamage.png')"></div>
        <div class="slide" style="background-image: url('${pageContext.request.contextPath}/resources/images/Lucky the Racer.jpg')"></div>
    </div>
    <div class="hero-overlay"></div>
    <button class="hero-btn left" onclick="prevSlide()">&#8249;</button>
    <button class="hero-btn right" onclick="nextSlide()">&#8250;</button>
    <div class="hero-dots" id="heroDots"></div>
</section>

<section class="movies">
    <h2>Now Showing</h2>
    <div class="movie-grid">

        <div class="movie-card">
            <img class="movie-poster" src="images/Avatar.jpg" alt="Avatar">
            <div class="movie-info">
                <span class="badge">PG</span>
                <h3>Avatar</h3>
                <p>Sci-Fi | 2h 42m</p>
                <a href="#" class="btn-ticket">Get Tickets</a>
            </div>
        </div>

        <div class="movie-card">
            <img class="movie-poster" src="images/Endgame.avif" alt="Avengers Endgame">
            <div class="movie-info">
                <span class="badge">PG</span>
                <h3>Avengers: Endgame</h3>
                <p>Action | 3h 2m</p>
                <a href="#" class="btn-ticket">Get Tickets</a>
            </div>
        </div>

        <div class="movie-card">
            <img class="movie-poster" src="images/Fight Club.jpg" alt="Fight Club">
            <div class="movie-info">
                <span class="badge">R</span>
                <h3>Fight Club</h3>
                <p>Thriller | 2h 19m</p>
                <a href="#" class="btn-ticket">Get Tickets</a>
            </div>
        </div>

        <div class="movie-card">
            <img class="movie-poster" src="images/Houseful.jpg" alt="Houseful">
            <div class="movie-info">
                <span class="badge">U</span>
                <h3>Houseful</h3>
                <p>Comedy | 2h 15m</p>
                <a href="#" class="btn-ticket">Get Tickets</a>
            </div>
        </div>

        <div class="movie-card">
            <img class="movie-poster" src="images/Jerry on Top.jpg" alt="Jerry on Top">
            <div class="movie-info">
                <span class="badge">U</span>
                <h3>Jerry on Top</h3>
                <p>Comedy | 2h 5m</p>
                <a href="#" class="btn-ticket">Get Tickets</a>
            </div>
        </div>

        <div class="movie-card">
            <img class="movie-poster" src="images/Kabir_Singh.jpg" alt="Kabir Singh">
            <div class="movie-info">
                <span class="badge">R</span>
                <h3>Kabir Singh</h3>
                <p>Romance | 2h 53m</p>
                <a href="#" class="btn-ticket">Get Tickets</a>
            </div>
        </div>

        <div class="movie-card">
            <img class="movie-poster" src="images/Lucky the Racer.jpg" alt="Lucky the Racer">
            <div class="movie-info">
                <span class="badge">U</span>
                <h3>Lucky the Racer</h3>
                <p>Action | 2h 30m</p>
                <a href="#" class="btn-ticket">Get Tickets</a>
            </div>
        </div>

    </div>
</section>

<footer class="footer">
    <div class="footer-content">
        <div class="footer-col">
            <h4>Climax Cinemas</h4>
            <p>Your ultimate movie experience in Pokhara</p>
        </div>
        <div class="footer-col">
            <h4>Quick Links</h4>
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Contact Us</a></li>
            </ul>
        </div>
        <div class="footer-col">
            <h4>Contact</h4>
            <p>Pokhara, Nepal</p>
            <p>info@climaxcinemas.com</p>
            <p>+977 061-123456</p>
        </div>
    </div>
    <div class="footer-bottom">
        <p>© 2026 Climax Cinemas. All rights reserved.</p>
    </div>
</footer>

<script src="${pageContext.request.contextPath}/javascript/index.js"></script>

</body>
</html>
