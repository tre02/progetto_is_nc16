package model;

public class Evento {
    private int id_evento;
    private int posti_disponibili;
    private String data_evento;
    private String luogo;
    private String ora;
    private String tipo;

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
}

