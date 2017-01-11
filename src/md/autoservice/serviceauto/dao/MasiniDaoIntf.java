/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.dao;

import java.sql.SQLException;
import java.util.List;
import md.autoservice.serviceauto.model.Masina;
import md.autoservice.serviceauto.util.MasinaNotFoundException;

/**
 *
 * @author iucosoft5
 */
public interface MasiniDaoIntf {
    
    Masina save(Masina masina) throws SQLException;
    Masina update(Masina masina) throws SQLException;
    void delete(Masina masina) throws SQLException;
    Masina findById(int id) throws MasinaNotFoundException;
    Masina findByNrInmatriculare(String nrInmatriculare) throws MasinaNotFoundException;
    List<Masina> findAll();
}
