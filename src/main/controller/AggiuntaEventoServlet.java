package controller;

import model.Evento;
import model.EventoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/AggiuntaEventoServlet"})
public class AggiuntaEventoServlet extends HttpServlet {
    public AggiuntaEventoServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Evento p = new Evento();
        p.setIdEvento(request.getParameter("ID_evento"));
        p.setPostidisponibili(request.getIntHeader("posti_disponibili"));
        p.setData(request.getParameter("data"));
        p.setLuogo(request.getParameter("luogo"));
        p.setOra(request.getIntHeader("ora"));
        p.setPrezzo(request.getIntHeader("prezzo"));
        p.setTipo(request.getParameter("tipo"));
        EventoDAO.aggiuntaEvento(p);
        RequestDispatcher dispatcher = request.getRequestDispatcher("HomeServletAmministratore");
        dispatcher.forward(request, response);
    }
}