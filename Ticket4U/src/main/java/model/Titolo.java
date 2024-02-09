package model;
public class Titolo {
    private int id_titolo;
    private double prezzo;
    private String nome_t;
    private String cognome_t;
    private String posto_prenotato;
    private Pagamento pagamento;

    public Titolo(int id_titolo, double prezzo, String nome_t, String cognome_t, String posto_prenotato, String metodoDiPagamento){
        this.id_titolo = id_titolo;
        this.prezzo = prezzo;
        this.nome_t = nome_t;
        this.cognome_t = cognome_t;
        this.posto_prenotato = posto_prenotato;
        this.pagamento = new Pagamento(id_titolo, metodoDiPagamento, prezzo);
    }
    public Titolo(){}



    public int getId_titolo() {
        return id_titolo;
    }

    public void setId_titolo(int id_titolo) {
        this.id_titolo = id_titolo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getNome_t() {
        return nome_t;
    }

    public void setNome_t(String nome_t) {
        this.nome_t = nome_t;
    }

    public String getCognome_t() {
        return cognome_t;
    }

    public void setCognome_t(String cognome_t) {
        this.cognome_t = cognome_t;
    }

    public String getPosto_prenotato() {
        return posto_prenotato;
    }

    public void setPosto_prenotato(String posto_prenotato) {
        this.posto_prenotato = posto_prenotato;
    }
}