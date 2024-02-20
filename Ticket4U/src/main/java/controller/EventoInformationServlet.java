package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/eventoinformationservlet")
public class EventoInformationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idEvento = request.getParameter("id");
        if (idEvento == null || idEvento.isEmpty()) {
            response.getWriter().println("Errore: ID evento mancante nella richiesta");
            return;
        }
        response.sendRedirect(request.getContextPath() + "/evento.jsp?id=" + idEvento);
    }
}
