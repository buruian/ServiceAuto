/*
 * To change this template, choose Tools | Templates
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
import md.autoservice.serviceauto.dao.AngajatDaoIntf;
import md.autoservice.serviceauto.db.MyDataSource;
import md.autoservice.serviceauto.model.Angajat;
import md.autoservice.serviceauto.util.AngajatNotFoundException;
import md.autoservice.serviceauto.util.MyUtil;

/**
 *
 * @author iucosoft5
 */
public class AngajatDaoImpl implements AngajatDaoIntf {

    private Connection conn;

    @Override
    public Angajat save(Angajat angajat) throws SQLException {
        conn = MyDataSource.getInstace().getConnection();

        String saveSql = "INSERT INTO Angajat VALUES(null, ?, ?, ?, ?)";
        PreparedStatement stat = conn.prepareStatement(saveSql);

        stat.setString(1, angajat.getNume());
        stat.setString(2, angajat.getPrenume());
        stat.setInt(3, angajat.getNrTelefon());
        stat.setString(4, angajat.getFunctia());

        stat.executeUpdate();

        MyUtil.closeConnection(conn);

        return angajat;
    }

    @Override
    public Angajat update(Angajat angajat) throws SQLException {

        String sqlUpdate = "UPDATE Angajat SET nume=?, prenume=?, nrTelefon=?, functia=? WHERE id=?";
        conn = MyDataSource.getInstace().getConnection();
        PreparedStatement stat = conn.prepareStatement(sqlUpdate);
        stat.setString(1, angajat.getNume());
        stat.setString(2, angajat.getPrenume());
        stat.setInt(3, angajat.getNrTelefon());
        stat.setString(4, angajat.getFunctia());
        stat.setInt(5, angajat.getId());
        stat.executeUpdate();

        MyUtil.closeConnection(conn);
        return angajat;
    }

    @Override
    public void delete(Angajat angajat) throws SQLException {

        String deleteSql = "DELETE FROM Angajat WHERE id=" + angajat.getId();
        conn = MyDataSource.getInstace().getConnection();
        Statement stat = conn.createStatement();

        stat.executeUpdate(deleteSql);
        MyUtil.closeConnection(conn);
    }

    @Override
    public Angajat findById(int id) throws AngajatNotFoundException {

        Angajat angajat = null;

        String sql = "SELECT * FROM Angajat WHERE id=" + id;
        try {
            conn = MyDataSource.getInstace().getConnection();

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                angajat = new Angajat(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5));
            }

            MyUtil.closeConnection(conn);

        } catch (SQLException ex) {
            Logger.getLogger(AngajatDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return angajat;
    }

    @Override
    public Angajat findByNumeAndPrenume(String nume,String prenume) throws AngajatNotFoundException {

         Angajat angajat = null;

        String sql = "SELECT * FROM Angajat where nume ='"+nume+"' AND prenume='" + prenume +"'";
        try {
            conn = MyDataSource.getInstace().getConnection();

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                angajat = new Angajat(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5));
            }

            MyUtil.closeConnection(conn);

        } catch (SQLException ex) {
            Logger.getLogger(AngajatDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return angajat;
    }
    @Override
    public List<Angajat> findAll() {

        List<Angajat> listaAngajati = new ArrayList<>();

        String sql = "SELECT * FROM Angajat";

        try {
           
            conn = MyDataSource.getInstace().getConnection();

            Statement stat = conn.createStatement();

            ResultSet rs = stat.executeQuery(sql);

            Angajat angajat = null;
            while (rs.next()) {

                angajat = new Angajat();
                angajat.setId(rs.getInt(1));
                angajat.setNume(rs.getString(2));
                angajat.setPrenume(rs.getString(3));
                angajat.setNrTelefon(rs.getInt(4));
                angajat.setFunctia(rs.getString(5));

                listaAngajati.add(angajat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AngajatDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showMessageDialog(new JFrame(), "Nu este conexiune la baza de date",
             //           "Error", JOptionPane.ERROR_MESSAGE);
           // System.exit(-2);
        }

        return listaAngajati;

    }
}
