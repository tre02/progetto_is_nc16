<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ticket4You</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="header">
    <a href="index.jsp"><img src="logo.png" alt="Logo T4Y"></a>
    <button onclick="window.location.href='eventi.jsp'">Eventi</button>
    <button onclick="window.location.href='località.jsp'">Eventi</button>
    <form action="WEB-INF/ricerca.jsp" method="get">
        <input type="text" name="query" placeholder="Cerca...">
        <button type="submit" class="search-button"></button>
    </form>
    <button id="loginButton">
        <img src="omino.png" alt="Icona Omino">
    </button>
</div>
<div class="slideshow-container">
    <div class="slides">
        <a href="evento1.jsp"><img src="evento1.jpg" style="width:33.33%"></a>
        <a href="evento2.jsp"><img src="evento2.jpg" style="width:33.33%"></a>
        <a href="evento3.jsp"><img src="evento3.jpg" style="width:33.33%"></a>
    </div>
    <div class="slides">
        <a href="evento4.jsp"><img src="evento4.jpg" style="width:33.33%"></a>
        <a href="evento5.jsp"><img src="evento5.jpg" style="width:33.33%"></a>
        <a href="evento6.jsp"><img src="evento6.jpg" style="width:33.33%"></a>
    </div>
    <a class="prev" onclick="plusSlides(-1)"><img src="arrowLeft.png" alt="Indietro"></a>
    <a class="next" onclick="plusSlides(1)"><img src="arrowRight.png" alt="Avanti"></a>
</div>
<div class="footer">
    <div class="social-links">
        <a href="https://www.facebook.com/" target="da mettere finto">Facebook</a>
        <a href="https://twitter.com/" target="da mettere finto">Twitter</a>
        <a href="https://www.instagram.com/" target="da mettere finto">Instagram</a>
    </div>
    <div class="phone-number">
        <p>Supporto Telefonico: 801 4574</p>
    </div>
</div>
<script src="WEB-INF/WEB-INF/js/script.js"></script>
<script src="WEB-INF/WEB-INF/js/script.js"></script>
</body>
</html>
