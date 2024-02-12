<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
          integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="CSS/style.css" type="text/css">
    <title>Ticket4You</title>
    <script src="codici.js"></script>
</head>
<body>
<div class="content">
    <jsp:include page="navbar.jsp"/>

    <main>
        <div class="evento">
            <c:choose>
                <c:when test="${empty ricerca || ricerca == null}">
                    <div class="ricercaVuota">
                        <i class="fa-regular fa-face-frown"></i>
                        <h3>La tua ricerca non ha prodotto risultati</h3>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${ricerca}" var="evento">
                        <div class="bordo">
                            <a href="http://localhost:8080/progetto_is_nc16/visualizza?id=${evento.id_evento}" style="text-decoration: none">
                                <div class="evento">

                                    <img src="img/${evento.luogo}${evento.id_evento}.jpg"><br>
                                </div>
                                <h3 style="color: black">${evento.luogo}</h3>
                                <p style="color: #393E46">${evento.data_evento} - ${evento.ora}</p>
                            </a>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
    </main>
    <button onclick="scrollToTop()" id="scrollToTop"><i class="fa-solid fa-arrow-up fa-2xl"></i></button>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
