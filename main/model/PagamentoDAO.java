package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO {
    public Pagamento doRetrieveById(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_pagamento, tipo_pagamento, stato_pagamento, somma FROM pagamento WHERE id_pagamento=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.setId_pagamento(rs.getInt(1));
                pagamento.setTipo_pagamento(rs.getString(2));
                pagamento.setStato_pagamento(rs.getString(3));
                pagamento.setSomma(rs.getDouble(4));
                return pagamento;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Pagamento pagamento){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO pagamento (tipo_pagamento, stato_pagamento, somma) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pagamento.getTipo_pagamento());
            ps.setString(2, pagamento.getStato_pagamento());
            ps.setDouble(3, pagamento.getSomma());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            pagamento.setId_pagamento(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Pagamento> doRetrieveAll(){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id_pagamento, tipo_pagamento, stato_pagamento, somma FROM pagamento");
            ResultSet rs = ps.executeQuery();
            List<Pagamento> pagamenti = new ArrayList<>();
            while(rs.next()){
                Pagamento pagamento = new Pagamento();
                pagamento.setId_pagamento(rs.getInt(1));
                pagamento.setTipo_pagamento(rs.getString(2));
                pagamento.setStato_pagamento(rs.getString(3));
                pagamento.setSomma(rs.getDouble(4));
                pagamenti.add(pagamento);
            }
            return pagamenti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Pagamento pagamento){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE pagamento SET tipo_pagamento=?, stato_pagamento=?, somma=? WHERE id_pagamento=?");
            ps.setString(1, pagamento.getTipo_pagamento());
            ps.setString(2, pagamento.getStato_pagamento());
            ps.setDouble(3, pagamento.getSomma());
            ps.setInt(4, pagamento.getId_pagamento());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDelete(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM pagamento WHERE id_pagamento=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
