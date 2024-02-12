package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {

    public EventoDAO(){}
    public Evento doRetrieveById(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_evento, nome_evento,posti_disponibili, data, luogo, ora, tipo FROM evento WHERE id_evento=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Evento evento = new Evento();
                evento.setId_evento(rs.getInt(1));
                evento.setNomeEvento(rs.getString(2));
                evento.setPosti_disponibili(rs.getInt(3));
                evento.setData_evento(rs.getString(4));
                evento.setLuogo(rs.getString(5));
                evento.setOra(rs.getString(6));
                evento.setTipo(rs.getString(7));
                return evento;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Evento evento){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO evento (posti_disponibili,nome_evento, data, luogo, ora, tipo, prezzo) VALUES (?,?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, evento.getPosti_disponibili());
            ps.setString(2, evento.getNomeEvento());
            ps.setString(3, evento.getData_evento());
            ps.setString(4, evento.getLuogo());
            ps.setString(5, evento.getOra());
            ps.setString(6, evento.getTipo());
            ps.setDouble(7, evento.getPrezzo());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            evento.setId_evento(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Evento> doRetrieveAll(){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_evento, posti_disponibili, data, luogo, ora, tipo FROM evento");
            ResultSet rs = ps.executeQuery();
            List<Evento> eventi = new ArrayList<>();
            while(rs.next()){
                Evento evento = new Evento();
                evento.setId_evento(rs.getInt(1));
                evento.setPosti_disponibili(rs.getInt(2));
                evento.setData_evento(rs.getString(3));
                evento.setLuogo(rs.getString(4));
                evento.setOra(rs.getString(5));
                evento.setTipo(rs.getString(6));
                eventi.add(evento);
            }
            return eventi;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Evento evento){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE evento SET posti_disponibili=?,nome_evento=?, data=?, luogo=?, ora=?, tipo=?, prezzo=? WHERE id_evento=?");
            ps.setInt(1, evento.getPosti_disponibili());
            ps.setString(2, evento.getNomeEvento());
            ps.setString(3, evento.getData_evento());
            ps.setString(4, evento.getLuogo());
            ps.setString(5, evento.getOra());
            ps.setString(6, evento.getTipo());
            ps.setDouble(7, evento.getPrezzo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDelete(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM evento WHERE id_evento=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Evento> doRetriveByRicerca(String searchString) throws SQLException {
        String query = "SELECT * FROM evento WHERE nome_evento LIKE ? OR data LIKE ? OR luogo LIKE ? OR tipo LIKE ?";
        List<Evento> eventi = new ArrayList<>();
        Connection con = ConPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(query);
        ResultSet rs = null;
        try {
            // Connessione al database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nome_database", "username", "password");
            // Impostazione dei parametri della query
            String searchParam = "%" + searchString + "%";
            pstmt.setString(1, searchParam);
            pstmt.setString(2, searchParam);
            pstmt.setString(3, searchParam);
            pstmt.setString(4, searchParam);

            // Esecuzione della query
            rs = pstmt.executeQuery();

            // Elabora i risultati della query
            while (rs.next()) {
                // Recupero dei dati dell'evento dal risultato
                String nomeEvento = rs.getString("nomeEvento");
                String dataEvento = rs.getString("data_evento");
                String luogo = rs.getString("luogo");
                String tipo = rs.getString("tipo");

                // Crea un oggetto Evento con i dati recuperati
                Evento evento = new Evento();
                evento.setNomeEvento(nomeEvento);
                evento.setData_evento(dataEvento);
                evento.setLuogo(luogo);
                evento.setTipo(tipo);
                eventi.add(evento);
            }
        } finally {
            // Chiusura delle risorse
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }

        return eventi;
    }

}
