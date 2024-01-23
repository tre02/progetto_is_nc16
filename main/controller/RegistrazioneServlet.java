package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Utente;
import model.UtenteDAO;

import java.io.IOException;

@WebServlet(value = "/Registrazione")

//questa servlet serve per registrare il nuovo utente nel database
public class RegistrazioneServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //prendo prima tutti i parametri del form
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(nome.isEmpty()|| cognome.isEmpty()|| username.isEmpty()||email.isEmpty() || password.isEmpty() ){
            response.sendRedirect("http://localhost:8080/progetto_is_nc16/registrazione.html?errore=1");
        }else {

            //creo l'utente con i parametri
            UtenteDAO utenteDAO = new UtenteDAO();
            Utente utente = new Utente();
            utente.setNome(nome);
            utente.setCognome(cognome);
            utente.setEmail(email);
            utente.setPassword(password);
            utente.setAdmin(false);

            //salvo l'utente nel database
            utenteDAO.doSave(utente);
            response.sendRedirect("http://localhost:8080/progetto_is_nc16/account.jsp"); //una volta salvato nel database lo reindirizzo alla pagina di login
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}