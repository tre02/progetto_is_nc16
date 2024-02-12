package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AmministratoreDAO {

    public void doSave(Amministratore amministratore){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO amministratore (orario_inizio_sessione, orario_fine_sessione, numero_telefono_am) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, amministratore.getOrario_inizio_sessione());
            ps.setString(2, amministratore.getOrario_fine_sessione());
            ps.setString(3, amministratore.getNumero_telefono_am());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Amministratore> doRetrieveAll(){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT ID_utente, orario_inizio_sessione, orario_fine_sessione, numero_telefono_am FROM amministratore");
            ResultSet rs = ps.executeQuery();
            List<Amministratore> amministratori = new ArrayList<>();
            while(rs.next()){
                Amministratore amministratore = new Amministratore();
                amministratore.setId(rs.getInt(1));
                amministratore.setOrario_inizio_sessione(rs.getString(2));
                amministratore.setOrario_fine_sessione(rs.getString(3));
                amministratore.setNumero_telefono_am(rs.getString(4));
                amministratori.add(amministratore);
            }
            return amministratori;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Amministratore doRetrieveById(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT ID_Utente, orario_inizio_sessione, orario_fine_sessione, numero_telefono_am FROM amministratore WHERE ID_utente=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Amministratore amministratore = new Amministratore();
                amministratore.setId(rs.getInt(1));
                amministratore.setOrario_inizio_sessione(rs.getString(2));
                amministratore.setOrario_fine_sessione(rs.getString(3));
                amministratore.setNumero_telefono_am(rs.getString(4));
                return amministratore;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Amministratore amministratore){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE amministratore SET orario_inizio_sessione=?, orario_fine_sessione=?, numero_telefono_am=? WHERE ID_utente=?");
            ps.setString(1, amministratore.getOrario_inizio_sessione());
            ps.setString(2, amministratore.getOrario_fine_sessione());
            ps.setString(3, amministratore.getNumero_telefono_am());
            ps.setInt(4, amministratore.getId_utente());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
