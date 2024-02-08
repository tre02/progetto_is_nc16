package model;

import java.util.logging.Logger;

public class Organizzatore {
    private int id_or;
    private String piva;
    private String indirizzo_or;
    private String eventi_organizzati;
    private String numero_telefono_or;



    public int getId_or() { return id_or; }

    public void setId_or(int id_or) {
        this.id_or = id_or;
    }


    public String getPiva() {
        return piva;
    }

    public void setPiva(String piva) {
        this.piva = piva;
    }


    public String getIndirizzo_or() {
        return indirizzo_or;
    }

    public void setIndirizzo_or(String indirizzo_or) {
        this.indirizzo_or = indirizzo_or;
    }


    public String getEventi_organizzati() {
        return eventi_organizzati;
    }

    public void setEventi_organizzati(String eventi_organizzati) {
        this.eventi_organizzati = eventi_organizzati;
    }


    public String getNumero_telefono_or() {
        return numero_telefono_or;
    }

    public void setNumero_telefono_or(String numero_telefono_or) {
        this.numero_telefono_or = numero_telefono_or;
    }

}