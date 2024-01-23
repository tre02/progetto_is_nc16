package model;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utente {
    private int id_utente;
    private String nome;
    private String cognome;
    private String passwordhash;
    private String email;
    private String admin;


    public int getId_utente() {
        return id_utente;
    }

    public void setId(int id_utente) {
        this.id = id_utente;
    }


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }


    public String getCognome() { return cognome; }

    public void setCognome(String cognome) { this.cognome = cognome; }



    public String getPassword() {
        return passwordhash;
    }

    public void setPassword(String password) {
        try {
            MessageDigest digest =
                    MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(password.getBytes(StandardCharsets.UTF_8));
            this.passwordhash = String.format("%040x", new
                    BigInteger(1, digest.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

}

