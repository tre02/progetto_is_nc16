package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Utente;
import model.UtenteDAO;
import java.io.IOException;

@WebServlet(value = "/Login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("esci") != null && request.getParameter("esci").equals("1")) {
            // L'utente vuole effettuare il logout
            request.getSession().invalidate();
            response.sendRedirect("account.jsp");
        } else {
            // Parametri per il login
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            UtenteDAO utenteDAO = new UtenteDAO();
            Utente utente = utenteDAO.doRetrieveByEmailPassword(email, password);

            if (utente != null) {
                request.getSession().setAttribute("utente", utente);
                response.sendRedirect("index.html");
            } else {
                // Utente non trovato, reindirizzo a pagina di login con messaggio di errore
                response.sendRedirect("account.jsp?accesso=0");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}