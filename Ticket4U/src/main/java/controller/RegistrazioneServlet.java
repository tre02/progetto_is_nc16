package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Utente;
import model.UtenteDAO;
import model.UtenteRegistrato;
import model.UtenteRegistratoDAO;

import java.io.IOException;

@WebServlet(value = "/Registrazione")

public class RegistrazioneServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //prendo prima tutti i parametri del form
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String data_nascita = request.getParameter("data_nascita");
        String indirizzo_utr = request.getParameter("indirizzo_utr");
        String numero_telefono_utr = request.getParameter("numero_telefono_utr");
        if(!nome.isEmpty() &&!cognome.isEmpty() && !email.isEmpty() && !password.isEmpty() && !data_nascita.isEmpty() && !indirizzo_utr.isEmpty() && numero_telefono_utr.isEmpty() ){
            //creo l'utente con i parametri
            UtenteRegistrato utenteRegistrato = new UtenteRegistrato();
            UtenteRegistratoDAO utenteRegistratoDAO = new UtenteRegistratoDAO();
            UtenteDAO utenteDAO = new UtenteDAO();
            Utente utente = new Utente();
            utente.setNome(nome);
            utente.setCognome(cognome);
            utente.setEmail(email);
            utente.setPassword(password);
            utente.setAdmin(false);
            utente.setOrg(false);
            utenteRegistrato.setData_nascita(data_nascita);
            utenteRegistrato.setIndirizzo_utr(indirizzo_utr);
            utenteRegistrato.setNumero_telefono_utr(numero_telefono_utr);
            //salvo l'utente nel database
            utenteDAO.doSave(utente);
            utenteRegistratoDAO.doSave(utenteRegistrato);
            response.sendRedirect("http://localhost:8080/progetto_is_nc16/account.jsp"); //una volta salvato nel database lo reindirizzo alla pagina di login
        }
        if(nome.isEmpty()|| cognome.isEmpty()||email.isEmpty() || password.isEmpty()){
            response.sendRedirect("http://localhost:8080/progetto_is_nc16/registrazione.html?errore=1");
        }else {
            UtenteDAO utenteDAO = new UtenteDAO();
            Utente utente = new Utente();
            utente.setNome(nome);
            utente.setCognome(cognome);
            utente.setEmail(email);
            utente.setPassword(password);
            utente.setAdmin(false);
            utente.setOrg(false);
            utenteDAO.doSave(utente);
            response.sendRedirect("http://localhost:8080/progetto_is_nc16/account.jsp"); //una volta salvato nel database lo reindirizzo alla pagina di login
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}