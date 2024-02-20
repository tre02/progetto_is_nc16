<%@ page import="java.io.PrintWriter" %>
<%@ page import="model.Evento" %>
<%@ page import="model.EventoDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navbar.jsp" %>

<html>
<head>
    <title>Dettagli Evento</title>
</head>
<body>

<%
    PrintWriter writer = response.getWriter();
    String idEvento = request.getParameter("id");
    if (idEvento == null || idEvento.isEmpty()) {
        writer.println("Errore: ID evento mancante nella richiesta");
        return;
    }
    EventoDAO eventoDAO = new EventoDAO();
    Evento evento = eventoDAO.doRetrieveById(Integer.parseInt(idEvento));
    if (evento != null) {
%>

<div>
    <h1>Dettagli Evento</h1>
    <img src="immagini/<%= evento.getId_evento() %>.png" alt="Immagine di copertina">
    <p>ID: <%= evento.getId_evento() %></p>
    <p>Nome: <%= evento.getNomeEvento() %></p>
    <p>Data: <%= evento.getData_evento() %></p>
    <p>Luogo: <%= evento.getLuogo() %></p>
    <p>Ora: <%= evento.getOra() %></p>
    <p>Tipo: <%= evento.getTipo() %></p>
    <p>Posti Disponibili: <%= evento.getPosti_disponibili() %></p>
    <p>Prezzo: <%= evento.getPrezzo() %></p>
</div>

<%
    } else {
        writer.println("Evento non trovato");
    }
%>

</body>
</html>
