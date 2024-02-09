package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Amministratore;
import model.AmministratoreDAO;
import model.Utente;
import model.UtenteDAO;

import java.io.IOException;
import java.time.LocalTime;

@WebServlet(value = "/Login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("esci") != null && request.getParameter("esci").equals("1")) {
            // L'utente vuole effettuare il logout
            if(request.getSession().getAttribute("admin")!= null){
                Amministratore temp = (Amministratore) request.getSession().getAttribute("admin");
                temp.setOrario_fine_sessione(String.valueOf(LocalTime.now()));
                AmministratoreDAO dao = new AmministratoreDAO();
                dao.doUpdate(temp);
            }
            request.getSession().invalidate();
            response.sendRedirect("account.jsp");
        } else {
            // Parametri per il login
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            UtenteDAO utenteDAO = new UtenteDAO();
            Utente utente = utenteDAO.doRetrieveByEmailPassword(email, password);
            if(utente.isAdmin()){
                request.getSession().setAttribute("admin", utente);
                Amministratore temp = new Amministratore();
                AmministratoreDAO dao = new AmministratoreDAO();
                temp.setOrario_inizio_sessione(String.valueOf(LocalTime.now()));
                dao.doSave(temp);
            } else if (utente.isOrg()) {
                request.getSession().setAttribute("organizzatore", utente);
            }
            if (!utente.isAdmin() && !utente.isOrg()) {
                request.getSession().setAttribute("utente", utente);
                response.sendRedirect("index.html");
            } else {
                // Utente non trovato, reindirizzo a pagina di login con messaggio di errore
                response.sendRedirect("account.jsp?accesso=0");
            }
        }
        throw new ServletException();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}