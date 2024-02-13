package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtenteRegistratoDAO extends Utente{

    public UtenteRegistratoDAO(){
        super();
    }

    public void doSave(UtenteRegistrato utente){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO utente_registrato (ticket4you.utente_registrato.data_nascita, ticket4you.utente_registrato.indirizzo_utr, ticket4you.utente_registrato.numero_telefono_utr) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, utente.getData_nascita());
            ps.setString(2, utente.getIndirizzo_utr());
            ps.setString(3, utente.getNumero_telefono_utr());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            utente.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<UtenteRegistrato> doRetrieveAll(){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT ID_utente, ticket4you.utente_registrato.data_nascita, indirizzo_utr, numero_telefono_utr FROM utente_registrato");
            ResultSet rs = ps.executeQuery();
            List<UtenteRegistrato> utenti = new ArrayList<>();
            while(rs.next()){
                UtenteRegistrato utente = new UtenteRegistrato();
                utente.setId(rs.getInt(1));
                utente.setData_nascita(rs.getString(2));
                utente.setIndirizzo_utr(rs.getString(3));
                utente.setNumero_telefono_utr(rs.getString(4));
                utente.setEmail(rs.getString(5));
                utenti.add(utente);
            }
            return utenti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UtenteRegistrato doRetrieveById(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT ID_utente, data_nascita, indirizzo_utr, numero_telefono_utr FROM utente_registrato WHERE ID_utente=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                UtenteRegistrato utente = new UtenteRegistrato();
                utente.setId(rs.getInt(1));
                utente.setData_nascita(rs.getString(2));
                utente.setIndirizzo_utr(rs.getString(3));
                utente.setNumero_telefono_utr(rs.getString(4));
                utente.setEmail(rs.getString(5));
                return utente;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(UtenteRegistrato utente){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE utente_registrato SET data_nascita=?, indirizzo_utr=?, numero_telefono_utr=? WHERE ID_utente=?");
            ps.setString(1, utente.getData_nascita());
            ps.setString(2, utente.getIndirizzo_utr());
            ps.setString(3, utente.getNumero_telefono_utr());
            ps.setInt(4, utente.getId_utente());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
