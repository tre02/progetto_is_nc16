package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {

    public EventoDAO(){}
    public Evento doRetrieveById(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_evento, posti_disponibili, data, luogo, ora, tipo FROM evento WHERE id_evento=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Evento evento = new Evento();
                evento.setId_evento(rs.getInt(1));
                evento.setPosti_disponibili(rs.getInt(2));
                evento.setData_evento(rs.getString(3));
                evento.setLuogo(rs.getString(4));
                evento.setOra(rs.getString(5));
                evento.setTipo(rs.getString(6));
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
                    "INSERT INTO evento (posti_disponibili, data, luogo, ora, tipo, prezzo) VALUES (?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, evento.getPosti_disponibili());
            ps.setString(2, evento.getData_evento());
            ps.setString(3, evento.getLuogo());
            ps.setString(4, evento.getOra());
            ps.setString(5, evento.getTipo());
            ps.setDouble(6, evento.getPrezzo());
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
                    "UPDATE evento SET posti_disponibili=?, data=?, luogo=?, ora=?, tipo=?, prezzo=? WHERE id_evento=?");
            ps.setInt(1, evento.getPosti_disponibili());
            ps.setString(2, evento.getData_evento());
            ps.setString(3, evento.getLuogo());
            ps.setString(4, evento.getOra());
            ps.setString(5, evento.getTipo());
            ps.setDouble(6, evento.getPrezzo());
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
}
