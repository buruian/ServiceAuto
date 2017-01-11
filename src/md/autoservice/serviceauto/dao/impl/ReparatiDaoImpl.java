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
import md.autoservice.serviceauto.dao.ReparatiDaoIntf;
import md.autoservice.serviceauto.dao.ReparatieAngajatDaoIntf;
import md.autoservice.serviceauto.db.MyDataSource;
import md.autoservice.serviceauto.model.Masina;
import md.autoservice.serviceauto.model.Reparatie;
import md.autoservice.serviceauto.util.MyUtil;
import md.autoservice.serviceauto.util.ReparatiNotFoundException;

/**
 *
 * @author valera_
 */
public class ReparatiDaoImpl implements ReparatiDaoIntf{

    private Connection conn;
    
    @Override
    public Reparatie save(Reparatie reparatie) throws SQLException {
    
        conn = MyDataSource.getInstace().getConnection();

        String saveSql = "INSERT INTO reparati VALUES(null, ?, ?, ?, ?)";
        PreparedStatement stat = conn.prepareStatement(saveSql);

        stat.setTimestamp(1, (new java.sql.Timestamp(reparatie.getDataIntrare().getTime())) );
        stat.setTimestamp(2, (new java.sql.Timestamp(reparatie.getDataIesire().getTime())) );
        stat.setString(3, reparatie.getProbleme());
        stat.setInt(4, reparatie.getMasina().getId());

        stat.executeUpdate();

        MyUtil.closeConnection(conn);

        return reparatie;
    }

    @Override
    public Reparatie update(Reparatie reparatie) throws SQLException {
    
        String sqlUpdate = "UPDATE reparati SET dataIntrare=?, dataIesire=?,"
                                     + " probleme=?, idMasina=? WHERE id=?";
        
        conn = MyDataSource.getInstace().getConnection();
        PreparedStatement stat = conn.prepareStatement(sqlUpdate);
        stat.setTimestamp(1, (new java.sql.Timestamp(reparatie.getDataIntrare().getTime())) );
        stat.setTimestamp(2, (new java.sql.Timestamp(reparatie.getDataIesire().getTime())) );
        stat.setString(3, reparatie.getProbleme());
        stat.setInt(4, reparatie.getMasina().getId());
        stat.setInt(5, reparatie.getId());
        stat.executeUpdate();

        MyUtil.closeConnection(conn);
        return reparatie;
    }

    @Override
    public void delete(Reparatie reparatie) throws SQLException {

        String deleteSql = "DELETE FROM reparati WHERE id=" + reparatie.getId();
        conn = MyDataSource.getInstace().getConnection();
        Statement stat = conn.createStatement();

        stat.executeUpdate(deleteSql);
        MyUtil.closeConnection(conn);
    }

    @Override
    public Reparatie findById(int id) throws ReparatiNotFoundException {
    
        Reparatie reparatie = null;

        String sql = "SELECT * FROM reparati WHERE id=" + id;

        try {
            conn = MyDataSource.getInstace().getConnection();
      
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                reparatie = new Reparatie(rs.getInt(1),
                rs.getTimestamp(2),
                rs.getTimestamp(3),
                rs.getString(4));
                //rs.ge(5));
            }

            MyUtil.closeConnection(conn);

        } catch (SQLException ex) {
            Logger.getLogger(ReparatiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
      

        return reparatie;
    }

    @Override
    public List<Reparatie> findAll() {
    
        List<Reparatie> listaReparatii = new ArrayList<>();

        String sql = "SELECT * FROM reparati";

        try {
            conn = MyDataSource.getInstace().getConnection();

            Statement stat = conn.createStatement();

            ResultSet rs = stat.executeQuery(sql);

            Reparatie reparatie = null;
            while (rs.next()) {
                Masina masina = new Masina();
                masina.setId(rs.getInt(8));
                
                reparatie = new Reparatie();
                reparatie.setId(rs.getInt(1));
                reparatie.setDataIntrare(rs.getTimestamp(2));
                reparatie.setDataIesire(rs.getTimestamp(3));
                reparatie.setProbleme(rs.getString(4));
                reparatie.setMasina(masina);

                listaReparatii.add(reparatie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AngajatDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaReparatii;
    }

    @Override
    public List<Reparatie> findAllByMasinaId(int masinaId) {

        List<Reparatie> listaReparatii = new ArrayList<>();

        String sql = "SELECT * FROM reparati WHERE idMasina="+masinaId;

        try {
            conn = MyDataSource.getInstace().getConnection();

            Statement stat = conn.createStatement();

            ResultSet rs = stat.executeQuery(sql);

            Reparatie reparatie = null;
            while (rs.next()) {

                
//                Masini masina = new Masini();
//                masina.setId(rs.getInt(8));
//                
                reparatie = new Reparatie();
                reparatie.setId(rs.getInt(1));
                reparatie.setDataIntrare(rs.getTimestamp(2));
                reparatie.setDataIesire(rs.getTimestamp(3));
                reparatie.setProbleme(rs.getString(4));
               // reparatie.setMasini(masina);

                listaReparatii.add(reparatie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AngajatDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaReparatii;
    }

    @Override
    public void deleteAll(int masinaId) throws SQLException {
        
         conn = MyDataSource.getInstace().getConnection();
        Statement stat = conn.createStatement();
        ReparatieAngajatDaoIntf reparatieAngajatDao = new ReparatieAngajatDaoImpl();
        
        List<Reparatie> list = findAllByMasinaId(masinaId);
        
        for (Reparatie reparatie : list) {
           String deleteSql = "DELETE FROM reparati WHERE id=" + reparatie.getId();
           reparatieAngajatDao.delete(reparatie.getId());
           stat.executeUpdate(deleteSql);
        }

        MyUtil.closeConnection(conn);
    }
    
}
