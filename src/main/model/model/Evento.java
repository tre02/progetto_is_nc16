package model;
public class Evento {
    private String nomeEvento;
    private int id_evento;
    private int posti_disponibili;
    private double prezzo;
    private String data_evento;
    private String luogo;
    private String ora;
    private String tipo;

    public Evento(String nomeEvento,int id_evento, int posti_disponibili, String data_evento, String luogo, String ora, String tipo, double prezzo) {
        this.nomeEvento = nomeEvento;
        this.prezzo = prezzo;
        this.id_evento = id_evento;
        this.posti_disponibili = posti_disponibili;
        this.data_evento = data_evento;
        this.luogo = luogo;
        this.ora = ora;
        this.tipo = tipo;
    }

    public Evento(){}

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public int getPosti_disponibili() {
        return posti_disponibili;
    }

    public void setPosti_disponibili(int posti_disponibili) {
        this.posti_disponibili = posti_disponibili;
    }

    public String getData_evento() {
        return data_evento;
    }

    public void setData_evento(String data_evento) {
        this.data_evento = data_evento;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }
}

