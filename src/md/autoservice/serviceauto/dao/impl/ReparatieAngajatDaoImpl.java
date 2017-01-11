/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import md.autoservice.serviceauto.dao.ReparatieAngajatDaoIntf;
import md.autoservice.serviceauto.db.MyDataSource;
import md.autoservice.serviceauto.model.Angajat;
import md.autoservice.serviceauto.util.AngajatNotFoundException;
import md.autoservice.serviceauto.util.MyUtil;
import md.autoservice.serviceauto.util.ReparatiNotFoundException;

/**
 *
 * @author iucosoft4
 */
public class ReparatieAngajatDaoImpl implements ReparatieAngajatDaoIntf {

    private Connection conn;

    @Override
    public void save(int idReparatie, int reparatoriId) throws SQLException {

         conn = MyDataSource.getInstace().getConnection();
        // Create statement object
        Statement stmt = conn.createStatement();

        try {

            // Set auto-commit to false
            conn.setAutoCommit(false);

                    
          // (int i = 0; i < reparatoriId.length; i++) {
                // Create SQL statement
                String SQL = "INSERT INTO reparatiAngajat VALUES(" + idReparatie + "," + reparatoriId + " )";
                // Add above SQL statement in the batch.
                stmt.addBatch(SQL);
            //}

            // Create an int[] to hold returned values
            int[] count = stmt.executeBatch();

            //Explicitly commit statements to apply changes
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw new SQLException(e.getMessage());
        }

        MyUtil.closeConnection(conn);
    }

    @Override
    public void update(int idReparatie, List<Angajat> lista) throws SQLException {
        
          conn = MyDataSource.getInstace().getConnection();
        // Create statement object
        Statement stmt = conn.createStatement();

        try {

            // Set auto-commit to false
            conn.setAutoCommit(false);

            
            String deleteSql = "DELETE  FROM reparatiAngajat WHERE idReparati="+idReparatie;
            stmt.executeUpdate(deleteSql);
            
           // int reparatoriId=0;

            for (Angajat angajat : lista) {
                
            
          
                // Create SQL statement
                String SQL = "INSERT INTO reparatiAngajat VALUES(" + idReparatie + "," + angajat.getId() + " )";
                // Add above SQL statement in the batch.
                stmt.addBatch(SQL);
            }

            // Create an int[] to hold returned values
            int[] count = stmt.executeBatch();

            //Explicitly commit statements to apply changes
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw new SQLException(e.getMessage());
        }

        MyUtil.closeConnection(conn);
    }

    @Override
    public void delete(int idReparatie) throws SQLException {
   
        String deleteSql = "DELETE FROM reparatiAngajat WHERE idReparati="+idReparatie;
        conn = MyDataSource.getInstace().getConnection();
        Statement stat = conn.createStatement();

        stat.executeUpdate(deleteSql);
        MyUtil.closeConnection(conn);
    }

    @Override
    public List<Integer> findAllByIdReparati(int idReparati) throws AngajatNotFoundException {
    
        List<Integer> listaInteger = new ArrayList<>();

        String sql = "SELECT * FROM reparatiAngajat WHERE idReparati="+idReparati;
        try {
     
            conn = MyDataSource.getInstace().getConnection();
            Statement stat = conn.createStatement();

            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
               
                listaInteger.add(rs.getInt(2));
            }
            } catch (SQLException ex) {
            Logger.getLogger(ReparatieAngajatDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaInteger;
    }

    @Override
    public List<Integer> findAllByIdAngajat(int idAngajat) throws ReparatiNotFoundException {
    
        List<Integer> listaInteger = new ArrayList<>();

        String sql = "SELECT * FROM reparatiAngajat WHERE idAngajat="+idAngajat;
        try {
     
            conn = MyDataSource.getInstace().getConnection();
    

            Statement stat = conn.createStatement();

            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
               
                listaInteger.add(rs.getInt(1));
            }
            } catch (SQLException ex) {
            Logger.getLogger(ReparatieAngajatDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaInteger;
    }
}
