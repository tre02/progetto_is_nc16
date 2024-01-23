public class Amministratore {
    private int id_am;
    private String orario_inizio_sessione;
    private String orario_fine_sessione;
    private String numero_telefono_am;


    public int getId_am() { return id_am; }


    public void setId_am(int id_am) {
        this.id_am = id_am;
    }

    public String getOrario_inizio_sessione() {
        return orario_inizio_sessione;
    }

    public void setOrario_inizio_sessione(String orario_inizio_sessione) {
        this.orario_inizio_sessione = orario_inizio_sessione; }

    public String getOrario_fine_sessione() {
        return orario_fine_sessione;
    }

    public void setOrario_fine_sessione(String orario_fine_sessione) {
        this.orario_fine_sessione = orario_fine_sessione; }


    public String getNumero_telefono_am() {
        return numero_telefono_am;
    }

    public void setNumero_telefono_am(String numero_telefono_am) {
        this.numero_telefono_am = numero_telefono_am;
    }

}