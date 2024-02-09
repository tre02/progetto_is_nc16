package model;
public class Pagamento {
    private int id_pagamento;
    private String tipo_pagamento;
    private boolean stato_pagamento;
    private double somma;

    public Pagamento(int id_pagamento, String tipo_pagamento, double somma){
        this.id_pagamento = id_pagamento;
        this.tipo_pagamento = tipo_pagamento;
        this.stato_pagamento = false;
        this.somma = somma;
    }

    public Pagamento(){}

    public int getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public String getTipo_pagamento() {
        return tipo_pagamento;
    }

    public void setTipo_pagamento(String tipo_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
    }

    public boolean getStato_pagamento() {
        return stato_pagamento;
    }

    public void setStato_pagamento(boolean stato_pagamento) {
        this.stato_pagamento = stato_pagamento;
    }

    public double getSomma() {
        return somma;
    }

    public void setSomma(double somma) {
        this.somma = somma;
    }
}
