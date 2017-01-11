/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.dao;

import java.sql.SQLException;
import java.util.List;
import md.autoservice.serviceauto.model.Proprietar;
import md.autoservice.serviceauto.util.ProprietarNotFoundException;

/**
 *
 * @author iucosoft5
 */
public interface ProprietarDaoIntf {
    
     
    Proprietar save(Proprietar proprietar) throws SQLException;
    Proprietar update(Proprietar proprietar) throws SQLException;
    void delete(Proprietar proprietar) throws SQLException;
    Proprietar findById(int id) throws ProprietarNotFoundException;
    List<Proprietar> findAll();
}
