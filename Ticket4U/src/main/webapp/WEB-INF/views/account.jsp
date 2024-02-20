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
    <script src="src/main/webapp/js/script.js"></script>

</head>
<body>
<div class="content">

    <jsp:include page="navbar.jsp" />

    <main>
        <c:choose> <%-- Questo if invece serve per vedere se l'utente ha fatto l'accesso. Se ha fatto l'accesso non mostro più form--%>
            <c:when test="${empty utente || utente == null}">
                <c:if test="${param.accesso == 0}">
                    <script>alert("Email o Password errati!")</script>
                </c:if>
                <section class="section-logIn">
                    <div class="form-box">
                        <form action="Login" method="get" autocomplete="off">
                            <h1>ACCEDI</h1>
                            <div class="input-box">
                                <i class="fa-solid fa-envelope"></i>
                                <label>Email</label>
                                <input type="email" name="email" id="email" required>
                            </div>
                            <div class="input-box">
                                <i class="fa-solid fa-lock"></i>
                                <label>Password</label>
                                <input type="password" name="password" id="password" required>
                            </div>
                            <button type="submit" name="submit" value="Accedi" class="login-button">Accedi</button>
                            <div class="register">
                                <p>Non hai un account?<a href="http://localhost:8080/progetto_is_nc16/registrazione.jsp"> Registrati</a> </p>
                            </div>
                        </form>
                    </div>
                </section>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${utente.admin != true}"> <%--Se l'utente che ha fatto l'accesso non è l'admin aggiungo i link per vedere gli ordini e i dati personali --%>
                        <section class="section-user">
                            <div class="form-box-user">
                                <h2> Bentornato <b>${utente.nome}</b>, questa &egrave la tua pagina riservata</h2>
                                <ul>
                                    <li><a href="http://localhost:8080/progetto_is_nc16/ordini">I tuoi ordini</a></li>
                                    <li><a href="http://localhost:8080/progetto_is_nc16/info">Le tue informazioni personali</a></li>
                                </ul>
                                <form action="Login?esci=1" method="post">
                                    <button type="submit" name="submit" value="Esci">Esci</button>
                                </form>
                            </div>
                        </section>
                    </c:when>
                    <c:otherwise>
                        <section class="section-user">
                            <div class="form-box-user">
                                <ul>
                                    <li><a href="http://localhost:8080/progetto_is_nc16/Add">Aggiungi Prodotto</a></li>
                                </ul>
                                <form action="Login?esci=1" method="post">
                                    <button type="submit" name="submit" value="Esci">Esci</button>
                                </form>
                            </div>
                        </section>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </main>
    <button onclick="scrollToTop()" id="scrollToTop"><i class="fa-solid fa-arrow-up fa-2xl"></i></button>
</div>

<jsp:include page="footer.jsp" />
</body>

</html>