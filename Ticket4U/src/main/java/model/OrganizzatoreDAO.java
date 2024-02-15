package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrganizzatoreDAO {

    public void doSave(Organizzatore organizzatore){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO organizzatore (piva, indirizzo_or, eventi_organizzati, numero_telefono_or) VALUES (?, ?, ?, ?, ?, SHA1(?))",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, organizzatore.getPiva());
            ps.setString(2, organizzatore.getIndirizzo_or());
            ps.setString(3, organizzatore.getEventi_organizzati());
            ps.setString(4, organizzatore.getNumero_telefono_or());
            ps.setString(5, organizzatore.getEmail());
            ps.setString(6, organizzatore.getPassword());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            organizzatore.setId_or(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Organizzatore> doRetrieveAll(){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT ID_utente, piva, indirizzo_or, eventi_organizzati, numero_telefono_or FROM organizzatore");
            ResultSet rs = ps.executeQuery();
            List<Organizzatore> organizzatori = new ArrayList<>();
            while(rs.next()){
                Organizzatore organizzatore = new Organizzatore();
                organizzatore.setId_or(rs.getInt(1));
                organizzatore.setPiva(rs.getString(2));
                organizzatore.setIndirizzo_or(rs.getString(3));
                organizzatore.setEventi_organizzati(rs.getString(4));
                organizzatore.setNumero_telefono_or(rs.getString(5));
                organizzatori.add(organizzatore);
            }
            return organizzatori;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Organizzatore doRetrieveById(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT ID_utente, piva, indirizzo_or, eventi_organizzati, numero_telefono_or FROM organizzatore WHERE ID_utente=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Organizzatore organizzatore = new Organizzatore();
                organizzatore.setId_or(rs.getInt(1));
                organizzatore.setPiva(rs.getString(2));
                organizzatore.setIndirizzo_or(rs.getString(3));
                organizzatore.setEventi_organizzati(rs.getString(4));
                organizzatore.setNumero_telefono_or(rs.getString(5));
                return organizzatore;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Organizzatore organizzatore){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE organizzatore SET piva=?, indirizzo_or=?, eventi_organizzati=?, numero_telefono_or=? WHERE ID_utente=?");
            ps.setString(1, organizzatore.getPiva());
            ps.setString(2, organizzatore.getIndirizzo_or());
            ps.setString(3, organizzatore.getEventi_organizzati());
            ps.setString(4, organizzatore.getNumero_telefono_or());
            ps.setInt(5, organizzatore.getId_or());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
