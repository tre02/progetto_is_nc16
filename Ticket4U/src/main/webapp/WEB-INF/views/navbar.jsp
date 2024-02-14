<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section id="header">
    <a href="http://localhost:8080/progetto_is_nc16/"><img src="../../immagini/logoT4Y.png" class="logo"></a>
    <div class="search-bar">
        <form method="post" action="ricerca" autocomplete="off">
            <input type="text" name="ricerca" placeholder="Cerca...">
            <button type="submit"><i class="fas fa-search"></i></button>
        </form>
    </div>
    <div>
        <ul id="navbar" class="navbar">
            <li><a href="http://localhost:8080/progetto_is_nc16/">Home</a></li>


            <c:choose>
                <c:when test="${!empty utente && utente.admin}">
                    <li><a href="http://localhost:8080/progetto_is_nc16/utenti">Utenti</a></li>
                </c:when>

            </c:choose>
            <li><a href="http://localhost:8080/progetto_is_nc16/account.jsp"><i class="far fa-user"></i></a></li>
            <c:if test="${!empty utente}">
                <li><h5>Ciao, ${utente.nome}</h5></li>
            </c:if>
            <li class="icon"><a href="javascript:void(0);"><i class="fa-solid fa-bars fa-xl"></i></a></li>
        </ul>
    </div>
</section>
<navbar id="responsive">
    <ul class="responsive">
        <li><a href="http://localhost:8080/progetto_is_nc16/">Home</a></li>

    </ul>
</navbar>