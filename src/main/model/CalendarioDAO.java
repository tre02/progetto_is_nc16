package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CalendarioDAO {
    //COME ACCEDO AI DAO SENZA COSTRUTTORE RAGA AIUTO
    public Calendario doRetrieveById(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_calendario, id_evento, data_calendario FROM calendario WHERE id_calendario=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Calendario calendario = new Calendario();
                calendario.setId_calendario(rs.getInt(1));
                calendario.setId_evento(rs.getInt(2));
                calendario.setData_calendario(rs.getString(3));
                return calendario;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Calendario calendario){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO calendario (id_evento, data_calendario) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, calendario.getId_evento());
            ps.setString(2, calendario.getData_calendario());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            calendario.setId_calendario(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Calendario> doRetrieveAll(){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_calendario, id_evento, data_calendario FROM calendario");
            ResultSet rs = ps.executeQuery();
            List<Calendario> calendari = new ArrayList<>();
            while(rs.next()){
                Calendario calendario = new Calendario();
                calendario.setId_calendario(rs.getInt(1));
                calendario.setId_evento(rs.getInt(2));
                calendario.setData_calendario(rs.getString(3));
                calendari.add(calendario);
            }
            return calendari;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Calendario calendario){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE calendario SET id_evento=?, data_calendario=? WHERE id_calendario=?");
            ps.setInt(1, calendario.getId_evento());
            ps.setString(2, calendario.getData_calendario());
            ps.setInt(3, calendario.getId_calendario());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDelete(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM calendario WHERE id_calendario=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
