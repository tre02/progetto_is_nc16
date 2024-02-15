package controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UtenteDAO;
import model.Utente;
import model.UtenteRegistratoDAO;
import model.UtenteRegistrato;

import java.io.IOException;

public class RimozioneAccountServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Utente usr = (Utente) request.getSession().getAttribute("utente");
        UtenteDAO daoUtente = new UtenteDAO();
        if(!request.getParameter("password").isEmpty() && request.getParameter("password").equals(usr.getPassword())){
            daoUtente.doDelete(usr);
            request.getSession().invalidate();
            response.sendRedirect("account.jsp");
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}
