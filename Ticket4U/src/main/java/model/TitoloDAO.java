package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TitoloDAO {
    //COME ACCEDO AI DAO SENZA COSTRUTTORE RAGA AIUTO
    public Titolo doRetrieveById(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_titolo, prezzo, nome_t, cognome_t, posto_prenotato FROM titolo WHERE id_titolo=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Titolo titolo = new Titolo();
                titolo.setId_titolo(rs.getInt(1));
                titolo.setPrezzo(rs.getDouble(2));
                titolo.setNome_t(rs.getString(3));
                titolo.setCognome_t(rs.getString(4));
                titolo.setPosto_prenotato(rs.getString(5));
                return titolo;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Titolo titolo){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO titolo (prezzo, nome_t, cognome_t, posto_prenotato) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, titolo.getPrezzo());
            ps.setString(2, titolo.getNome_t());
            ps.setString(3, titolo.getCognome_t());
            ps.setString(4, titolo.getPosto_prenotato());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            titolo.setId_titolo(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Titolo> doRetrieveAll(){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_titolo, prezzo, nome_t, cognome_t, posto_prenotato FROM titolo");
            ResultSet rs = ps.executeQuery();
            List<Titolo> titoli = new ArrayList<>();
            while(rs.next()){
                Titolo titolo = new Titolo();
                titolo.setId_titolo(rs.getInt(1));
                titolo.setPrezzo(rs.getDouble(2));
                titolo.setNome_t(rs.getString(3));
                titolo.setCognome_t(rs.getString(4));
                titolo.setPosto_prenotato(rs.getString(5));
                titoli.add(titolo);
            }
            return titoli;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Titolo titolo){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE titolo SET prezzo=?, nome_t=?, cognome_t=?, posto_prenotato=? WHERE id_titolo=?");
            ps.setDouble(1, titolo.getPrezzo());
            ps.setString(2, titolo.getNome_t());
            ps.setString(3, titolo.getCognome_t());
            ps.setString(4, titolo.getPosto_prenotato());
            ps.setInt(5, titolo.getId_titolo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDelete(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM titolo WHERE id_titolo=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
