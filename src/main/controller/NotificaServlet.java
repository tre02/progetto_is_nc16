import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import model.Evento;
import model.EventoDAO;

@WebServlet("/notificaservlet")
public class NotificaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        // Recupera l'ID dell'evento dalla richiesta
        String idEvento = request.getParameter("id");
        if (idEvento == null || idEvento.isEmpty()) {
            out.println("Errore: ID evento mancante nella richiesta");
            return;
        }

        // Converte l'ID da stringa a intero
        int eventoId = Integer.parseInt(idEvento);

        // Richiede le informazioni sull'evento dal database
        EventoDAO eventoDAO = new EventoDAO();
        Evento evento = eventoDAO.doRetrieveById(idEvento);

        // Mostra le informazioni dell'evento o un messaggio se non trovato
        if (evento != null) {
            out.println("Notifica per l'evento:");
            out.println("ID: " + evento.getId_evento());
            out.println("Posti disponibili: " + evento.getPosti_disponibili());
            out.println("Data: " + evento.getData_evento());
            out.println("Luogo: " + evento.getLuogo());
            out.println("Ora: " + evento.getOra());
            out.println("Tipo: " + evento.getTipo());
        } else {
            out.println("Evento non trovato");
        }
    }