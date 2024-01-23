import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import model.Titolo;
import model.TitoloDAO;

@WebServlet("/titoloservlet")
public class TitoloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

// Recupera l'ID del titolo dalla richiesta
        String idTitolo = request.getParameter("id");
        if (idTitolo == null || idTitolo.isEmpty()) {
            out.println("Errore: ID titolo mancante nella richiesta");
            return;

            // Converte l'ID titolo da stringa a intero
            int idEvento = Integer.parseInt(idTitoloString);

            // Richiede le informazioni sul titolo dal database
            TitoloDAO titoloDAO = new TitoloDAO();
            Titolo titolo = titoloDAO.doRetrieveById(idTitolo);

            // Mostra le informazioni del titolo o un messaggio se non trovato
            if (titolo != null) {
                out.println("Informazioni sul titolo:");
                out.println("ID: " + titolo.getId_titolo());
                out.println("Prezzo: " + titolo.getPrezzo());
                out.println("Nome: " + titolo.getNome_t());
                out.println("Cognome: " + titolo.getCognome_t());
                out.println("Posto prenotato: " + titolo.getPosto_prenotato());
            } else {
                out.println("Titolo non trovato");
            }
        }
    }