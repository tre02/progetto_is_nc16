package controller;

import model.Evento;
import model.EventoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/ModificaEventiServlet"})
public class ModificaEventiServlet extends HttpServlet {
    public ModificaEventiServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessione = request.getSession();
        Evento p = (Evento) sessione.getAttribute("idModificaPrezzo");
        EventoDAO dao = new EventoDAO();
        double prezzo;
        if (!request.getParameter("nuovoPrezzo").isEmpty() && !request.getParameter("quantitaTotale").isEmpty()) {
            prezzo = Double.parseDouble(request.getParameter("nuovoPrezzo"));
            p.setPrezzo(prezzo);
            dao.doUpdate(p);
            int q = Integer.parseInt(request.getParameter("quantitaTotale"));
            int quantita = p.getPosti_disponibili() + q;
            p.setPosti_disponibili(quantita);
            dao.doUpdate(p);
            RequestDispatcher ds = request.getRequestDispatcher("HomeServletAmministratore");
            ds.forward(request, response);
        } else {
            RequestDispatcher ds;
            if (!request.getParameter("nuovoPrezzo").isEmpty()) {
                prezzo = Double.parseDouble(request.getParameter("nuovoPrezzo"));
                p.setPrezzo(prezzo);
                dao.doUpdate(p);
                ds = request.getRequestDispatcher("HomeServletAmministratore");
                ds.forward(request, response);
            } else if (request.getParameter("quantitaTotale") != null) {
                int q = Integer.parseInt(request.getParameter("quantitaTotale"));
                int quantita = p.getPosti_disponibili() + q;
                p.setPrezzo(quantita);
                dao.doUpdate(p);
                ds = request.getRequestDispatcher("HomeServlet");
                ds.forward(request, response);
            }
        }

    }
}