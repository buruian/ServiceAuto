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
import md.autoservice.serviceauto.dao.MasiniDaoIntf;
import md.autoservice.serviceauto.db.MyDataSource;
import md.autoservice.serviceauto.model.Masina;
import md.autoservice.serviceauto.model.Proprietar;
import md.autoservice.serviceauto.util.MasinaNotFoundException;
import md.autoservice.serviceauto.util.MyUtil;

/**
 *
 * @author valera_
 */
public class MasiniDaoImpl implements MasiniDaoIntf {

    private Connection conn;

    @Override
    public Masina save(Masina masina) throws SQLException {

        conn = MyDataSource.getInstace().getConnection();

        String saveSql = "INSERT INTO masini VALUES(null, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stat = conn.prepareStatement(saveSql);

        stat.setString(1, masina.getNrInmatriculare());
        stat.setString(2, masina.getMarca());
        stat.setString(3, masina.getModel());
        stat.setInt(4, masina.getAnu());
        stat.setString(5, masina.getCombustibil());
        stat.setString(6, masina.getModelMotor());
        stat.setInt(7, masina.getProprietar().getId());

        stat.executeUpdate();

        MyUtil.closeConnection(conn);

        return masina;
    }

    @Override
    public Masina update(Masina masina) throws SQLException {

        String sqlUpdate = "UPDATE masini SET nrInmatriculare=?, marca=?, model=?, "
                + "anu=?, combustibil=?, modelMotor=? WHERE id=?";
        conn = MyDataSource.getInstace().getConnection();
        PreparedStatement stat = conn.prepareStatement(sqlUpdate);

        stat.setString(1, masina.getNrInmatriculare());
        stat.setString(2, masina.getMarca());
        stat.setString(3, masina.getModel());
        stat.setInt(4, masina.getAnu());
        stat.setString(5, masina.getCombustibil());
        stat.setString(6, masina.getModelMotor());
        stat.setInt(7, masina.getId());
        stat.executeUpdate();

        MyUtil.closeConnection(conn);
        return masina;
    }

    @Override
    public void delete(Masina masina) throws SQLException {

        String deleteSql = "DELETE FROM masini WHERE id=" + masina.getId();
        conn = MyDataSource.getInstace().getConnection();
        Statement stat = conn.createStatement();

        stat.executeUpdate(deleteSql);
        MyUtil.closeConnection(conn);
    }

    @Override
    public Masina findById(int id) throws MasinaNotFoundException {

        Masina masina = null;
        String sql = "SELECT * FROM masini WHERE id=" + id;

        try {
            conn = MyDataSource.getInstace().getConnection();

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                Proprietar proprietar = new Proprietar();
                proprietar.setId(rs.getInt(8));

                masina = new Masina(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        proprietar);
            }

            MyUtil.closeConnection(conn);

        } catch (SQLException ex) {
            Logger.getLogger(MasiniDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return masina;

    }

    @Override
    public Masina findByNrInmatriculare(String nrInmatriculare) throws MasinaNotFoundException {

        Masina masina = null;
        String sql = "SELECT * FROM masini WHERE nrInmatriculare='" + nrInmatriculare + "'";

        try {
            conn = MyDataSource.getInstace().getConnection();

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                Proprietar proprietar = new Proprietar();
                proprietar.setId(rs.getInt(8));

                masina = new Masina(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        proprietar);
            }

            MyUtil.closeConnection(conn);

        } catch (SQLException ex) {
            Logger.getLogger(MasiniDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return masina;

    }

    @Override
    public List<Masina> findAll() {

        List<Masina> listaMasini = new ArrayList<>();

        String sql = "SELECT * FROM masini";

        try {
            conn = MyDataSource.getInstace().getConnection();

            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            Masina masina = null;
            while (rs.next()) {
                Proprietar proprietar = new Proprietar();
                proprietar.setId(rs.getInt(8));

                masina = new Masina();
                masina.setId(rs.getInt(1));
                masina.setNrInmatriculare(rs.getString(2));
                masina.setMarca(rs.getString(3));
                masina.setModel(rs.getString(4));
                masina.setAnu(rs.getInt(5));
                masina.setCombustibil(rs.getString(6));
                masina.setModelMotor(rs.getString(7));
                masina.setProprietar(proprietar);

                listaMasini.add(masina);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MasiniDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaMasini;

    }

}
