
<%@ page import="model.Evento" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
          integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <title>Ticket4U</title>
    <script src="script.js"></script>

</head>
<body>
<div class="content">
    <jsp:include page="navbar.jsp" />
    <main>
        <!-- Il contenuto della pagina va qui -->
        <%
            List<boolean> esisteEvento = (List<boolean>) request.getAttribute("esiste");
           Evento ordine = (Evento) request.getAttribute("evento");
            List<Integer> idevento = ordine.getId_evento();
            List<String> nome = ordine.getNomeEvento();
            List<Double> prezzoEvento = ordine.getPrezzo();
            List<Integer> data_evento = ordine.getData_evento();
            int i = 0;%>
        <div class="ordine">
            <h1>Riepilogo Ordine N: <%=ordine.getNumeroOrdine()%></h1>
            <div class="evento">
                <%
                    for(Integer id: idevento){%>
                <div class="bordo">
                    <%if(esisteEvento.get(i)){%>
                    <a href="http://localhost:8080/Ticket4U_war_exploded/visualizza?id=<%=id%>" style="text-decoration: none"><img src="img/<%=nomeProdotti.get(i)%><%=id%>.jpg"></a>
                    <%}else{%>
                    <img src="img/<%=nomeEvento.get(i)%><%=id%>.jpg">
                    <%}%>
                    <h3><%=nomeEvento.get(i)%></h3>
                    <div class="info">
                        <h6><%=prezziProdotti.get(i)%>€</h6>
                        <h6>Quantità: <%=quantita.get(i)%></h6>
                    </div>
                </div>
                <%i++;}
                %>
            </div>
            <div class="riepilogo">
                <h4>Totale: <%=ordine.getTotale()%>€</h4>
            </div>
        </div>
    </main>
    <button onclick="scrollToTop()" id="scrollToTop"><i class="fa-solid fa-arrow-up fa-2xl"></i></button>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>