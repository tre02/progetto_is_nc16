package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAO {
    //COME ACCEDO AI DAO SENZA COSTRUTTORE RAGA AIUTO
    public Utente doRetrieveByEmailPassword(String email, String password){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_utente, nome, cognome, password, email, admin FROM utente WHERE email = ? AND password =SHA1(?)");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Utente user = new Utente();
                user.setId(rs.getInt(1));
                user.setNome(rs.getString(2));
                user.setCognome(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setAdmin(rs.getBoolean(6));
                return user;
            }else
                return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Utente utente){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO utente (nome,cognome, password, email, admin, org) VALUES(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, utente.getNome());
            ps.setString(2, utente.getCognome());
            ps.setString(3, utente.getPassword());
            ps.setString(4, utente.getEmail());
            ps.setBoolean(5,utente.isAdmin());
            ps.setBoolean(6, utente.isOrg());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id_utente = rs.getInt(1);
            utente.setId(id_utente);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Utente> doRetriveAll(){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_utente, nome, cognome, password,email,admin FROM utente");
            ResultSet rs = ps.executeQuery();
            List<Utente> utenti = new ArrayList<>();
            while(rs.next()){
                Utente user = new Utente();
                user.setId(rs.getInt(1));
                user.setNome(rs.getString(2));
                user.setCognome(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setAdmin(rs.getBoolean(6));
                utenti.add(user);
            }
            return utenti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Utente doRetrieveById_utente(int id_utente){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_utente, nome, cognome, password, email, admin FROM utente WHERE id_utente=?");
            ps.setInt(1, id_utente);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Utente user = new Utente();
                user.setId(rs.getInt(1));
                user.setNome(rs.getString(2));
                user.setCognome(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setAdmin(rs.getBoolean(16));
                return user;
            }else
                return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Utente utente){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE utente SET nome=?, cognome=?, email=? WHERE id_utente=?");
            ps.setString(1, utente.getNome());
            ps.setString(2, utente.getCognome());
            ps.setString(4, utente.getEmail());
            ps.setInt(3,utente.getId_utente());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Utente doRetriveByEmail(String email){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_utente, nome, cognome, password, email, admin FROM utente WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Utente user = new Utente();
                user.setId(rs.getInt(1));
                user.setNome(rs.getString(2));
                user.setCognome(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setAdmin(rs.getBoolean(6));
                return user;
            }else
                return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void doDelete(Utente utente) {
        try {
            Connection connection = ConPool.getConnection();
            PreparedStatement st = connection.prepareStatement("DELETE FROM ticket4you.utente WHERE ID_utente = " + utente.getId_utente() + ";");
            st.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
