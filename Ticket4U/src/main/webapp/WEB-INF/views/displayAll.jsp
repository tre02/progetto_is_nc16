<%@ page import="model.Evento" %>
<%@ page import="java.util.List" %>
<%@ page import="model.EventoDAO" %>
<%@ page import="model.EventoDAOObserverJSP" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="navbar.jsp" %>
<%@ page language="java" %>
<html>
<head>
    <title>Tutti gli eventi</title>
</head>
<body style=" background-image: none" >

<%
    EventoDAOObserverJSP observer = (EventoDAOObserverJSP) session.getAttribute("observer");

    if (observer == null) {
        observer = new EventoDAOObserverJSP(request);
        EventoDAO dao = new EventoDAO();
        dao.addObserver(observer);
        session.setAttribute("observer", observer);
    }
%>

<%
    Boolean refreshPage = (Boolean) request.getAttribute("refreshPage");
    if (refreshPage != null && refreshPage) {
        EventoDAO dao = new EventoDAO();
        List<Evento> tuttiEventi = dao.doRetrieveAll();
%>
<% if (tuttiEventi != null) { %>
<% for (int i = 0; i < tuttiEventi.size(); i++) {
    String val = String.valueOf(tuttiEventi.get(i).getId_evento());
    int x = Integer.parseInt(val);
    String directory = "immagini/" + tuttiEventi.get(i).getId_evento() + ".png";
    if (x > 54) {
        directory = "immagini/fotoNonDisponibile.jpg";
    }
%>
<div class="box-container">
    <div class="box">
        <div class="image">
            <a href="eventoinformationservlet?id=<%=tuttiEventi.get(i).getId_evento()%>">
                <img src="<%=directory%>">
            </a>
        </div>
        <div class="info">
            <p><%=tuttiEventi.get(i).getNomeEvento()%></p>
            <p>Prezzo:<%=tuttiEventi.get(i).getPrezzo()%></p>
            <% if(tuttiEventi.get(i).getPosti_disponibili() != 0) { %>
            <p>In magazzino:<%=tuttiEventi.get(i).getPosti_disponibili()%></p>
            <% } else { %>
            <p style="color: red">Evento Esaurito</p>
            <% } %>
        </div>
    </div>
</div>
<% } %>
<% } %>
<% } %>

</body>
</html>
