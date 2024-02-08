import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtenteRegistratoDAO {
    //COME ACCEDO AI DAO SENZA COSTRUTTORE RAGA AIUTO
    public UtenteRegistrato doRetrieveByEmailPassword(String email, String password){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_utr, data_nascita, indirizzo_utr, numero_telefono_utr, email FROM utente WHERE email = ? AND passwordhash = SHA1(?)");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                UtenteRegistrato utente = new UtenteRegistrato();
                utente.setId_utr(rs.getInt(1));
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

    public void doSave(UtenteRegistrato utente){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO utente (data_nascita, indirizzo_utr, numero_telefono_utr, email, passwordhash) VALUES (?, ?, ?, ?, SHA1(?))",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, utente.getData_nascita());
            ps.setString(2, utente.getIndirizzo_utr());
            ps.setString(3, utente.getNumero_telefono_utr());
            ps.setString(4, utente.getEmail());
            ps.setString(5, utente.getPassword());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            utente.setId_utr(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<UtenteRegistrato> doRetrieveAll(){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_utr, data_nascita, indirizzo_utr, numero_telefono_utr, email FROM utente");
            ResultSet rs = ps.executeQuery();
            List<UtenteRegistrato> utenti = new ArrayList<>();
            while(rs.next()){
                UtenteRegistrato utente = new UtenteRegistrato();
                utente.setId_utr(rs.getInt(1));
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
                    con.prepareStatement("SELECT id_utr, data_nascita, indirizzo_utr, numero_telefono_utr, email FROM utente WHERE id_utr=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                UtenteRegistrato utente = new UtenteRegistrato();
                utente.setId_utr(rs.getInt(1));
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
                    "UPDATE utente SET data_nascita=?, indirizzo_utr=?, numero_telefono_utr=?, email=? WHERE id_utr=?");
            ps.setString(1, utente.getData_nascita());
            ps.setString(2, utente.getIndirizzo_utr());
            ps.setString(3, utente.getNumero_telefono_utr());
            ps.setString(4, utente.getEmail());
            ps.setInt(5, utente.getId_utr());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UtenteRegistrato doRetrieveByEmail(String email){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_utr, data_nascita, indirizzo_utr, numero_telefono_utr, email FROM utente WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                UtenteRegistrato utente = new UtenteRegistrato();
                utente.setId_utr(rs.getInt(1));
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
}
