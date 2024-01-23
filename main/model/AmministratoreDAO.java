package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AmministratoreDAO {
    public Amministratore doRetrieveByEmailPassword(String email, String password){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_am, orario_inizio_sessione, orario_fine_sessione, numero_telefono_am FROM amministratore WHERE email = ? AND passwordhash = SHA1(?)");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Amministratore amministratore = new Amministratore();
                amministratore.setId_am(rs.getInt(1));
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

    public void doSave(Amministratore amministratore){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO amministratore (orario_inizio_sessione, orario_fine_sessione, numero_telefono_am, email, passwordhash) VALUES (?, ?, ?, ?, SHA1(?))",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, amministratore.getOrario_inizio_sessione());
            ps.setString(2, amministratore.getOrario_fine_sessione());
            ps.setString(3, amministratore.getNumero_telefono_am());
            ps.setString(4, amministratore.getEmail());
            ps.setString(5, amministratore.getPassword());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            amministratore.setId_am(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Amministratore> doRetrieveAll(){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_am, orario_inizio_sessione, orario_fine_sessione, numero_telefono_am FROM amministratore");
            ResultSet rs = ps.executeQuery();
            List<Amministratore> amministratori = new ArrayList<>();
            while(rs.next()){
                Amministratore amministratore = new Amministratore();
                amministratore.setId_am(rs.getInt(1));
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
                    con.prepareStatement("SELECT id_am, orario_inizio_sessione, orario_fine_sessione, numero_telefono_am FROM amministratore WHERE id_am=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Amministratore amministratore = new Amministratore();
                amministratore.setId_am(rs.getInt(1));
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
                    "UPDATE amministratore SET orario_inizio_sessione=?, orario_fine_sessione=?, numero_telefono_am=?, email=? WHERE id_am=?");
            ps.setString(1, amministratore.getOrario_inizio_sessione());
            ps.setString(2, amministratore.getOrario_fine_sessione());
            ps.setString(3, amministratore.getNumero_telefono_am());
            ps.setString(4, amministratore.getEmail());
            ps.setInt(5, amministratore.getId_am());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Amministratore doRetrieveByEmail(String email){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_am, orario_inizio_sessione, orario_fine_sessione, numero_telefono_am FROM amministratore WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Amministratore amministratore = new Amministratore();
                amministratore.setId_am(rs.getInt(1));
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
}