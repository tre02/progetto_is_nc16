package model;

public class UtenteRegistrato extends Utente{
    private int id_utr;
    private String data_nascita;
    private String indirizzo_utr;
    private String numero_telefono_utr;

    public UtenteRegistrato(){}
    public int getId_utr() {
        return id_utr;
    }

    public void setId_utr(int id_utr) {
        this.id_utr = id_utr;
    }


    public String getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(String data_nascita) {
        this.data_nascita = data_nascita;
    }


    public String getIndirizzo_utr() {
        return indirizzo_utr;
    }

    public void setIndirizzo_utr(String indirizzo_utr) {
        this.indirizzo_utr = indirizzo_utr;
    }


    public String getNumero_telefono_utr() {
        return numero_telefono_utr;
    }

    public void setNumero_telefono_utr(String numero_telefono_utr) {
        this.numero_telefono_utr = numero_telefono_utr;
    }



    //Da fare funzione di "pagamento" che avviene in contemporanea al tasto "acquista"
}
