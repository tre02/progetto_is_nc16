package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.EventoDAO;
import model.Evento;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet (value="/ricerca")
public class RicercaServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ricerca = "%" + request.getParameter("ricerca") + "%";
        EventoDAO eventoDAO = new EventoDAO();
        List<Evento> risultatoRicerca;
        try {
            risultatoRicerca = eventoDAO.doRetriveByRicerca(ricerca);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("ricerca",risultatoRicerca);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/ricerca.jsp");
        dispatcher.forward(request,response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}