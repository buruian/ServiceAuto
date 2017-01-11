/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import md.autoservice.serviceauto.dao.ProprietarDaoIntf;
import md.autoservice.serviceauto.db.MyDataSource;
import md.autoservice.serviceauto.model.Proprietar;
import md.autoservice.serviceauto.util.MyUtil;
import md.autoservice.serviceauto.util.ProprietarNotFoundException;

/**
 *
 * @author valera_
 */
public class ProprietarDaoImpl implements ProprietarDaoIntf {

    private Connection conn;

    @Override
    public Proprietar save(Proprietar proprietar) throws SQLException {

        conn = MyDataSource.getInstace().getConnection();

        String saveSql = "INSERT INTO proprietar VALUES(null, ?, ?, ?, ?)";
        PreparedStatement stat = conn.prepareStatement(saveSql);

        stat.setString(1, proprietar.getNume());
        stat.setString(2, proprietar.getPrenume());
        stat.setInt(3, proprietar.getNrTelefon());
        stat.setString(4, proprietar.getEmail());

        stat.executeUpdate();

        MyUtil.closeConnection(conn);

        return proprietar;
    }

    @Override
    public Proprietar update(Proprietar proprietar) throws SQLException {

        String sqlUpdate = "UPDATE proprietar SET nume=?, prenume=?, nrTelefon=?, email=? WHERE id=?";
        conn = MyDataSource.getInstace().getConnection();
        PreparedStatement stat = conn.prepareStatement(sqlUpdate);
        stat.setString(1, proprietar.getNume());
        stat.setString(2, proprietar.getPrenume());
        stat.setInt(3, proprietar.getNrTelefon());
        stat.setString(4, proprietar.getEmail());
        stat.setInt(5, proprietar.getId());
        stat.executeUpdate();

        MyUtil.closeConnection(conn);
        return proprietar;
    }

    @Override
    public void delete(Proprietar proprietar) throws SQLException {

        String deleteSql = "DELETE FROM proprietar WHERE id=" + proprietar.getId();
        conn = MyDataSource.getInstace().getConnection();
        Statement stat = conn.createStatement();

        stat.executeUpdate(deleteSql);
        MyUtil.closeConnection(conn);
    }

    @Override
    public Proprietar findById(int id) throws ProprietarNotFoundException {

        Proprietar proprietar = null;

        String sql = "SELECT * FROM proprietar WHERE id=" + id;

        try {
            conn = MyDataSource.getInstace().getConnection();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                proprietar = new Proprietar(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5));
            }

            MyUtil.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ProprietarDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return proprietar;
    }

    @Override
    public List<Proprietar> findAll() {

        List<Proprietar> listaProprietari = new ArrayList<>();

        String sql = "SELECT * FROM proprietar";

        try {

            conn = MyDataSource.getInstace().getConnection();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            Proprietar proprietar = null;

            while (rs.next()) {

                proprietar = new Proprietar();
                proprietar.setId(rs.getInt(1));
                proprietar.setNume(rs.getString(2));
                proprietar.setPrenume(rs.getString(3));
                proprietar.setNrTelefon(rs.getInt(4));
                proprietar.setEmail(rs.getString(5));

                listaProprietari.add(proprietar);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProprietarDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaProprietari;
    }

}
