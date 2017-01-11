/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.dao;

import java.sql.SQLException;
import java.util.List;
import md.autoservice.serviceauto.model.Reparatie;
import md.autoservice.serviceauto.util.ReparatiNotFoundException;


/**
 *
 * @author iucosoft5
 */
public interface ReparatiDaoIntf {
    Reparatie save(Reparatie reparatie) throws SQLException;
    Reparatie update(Reparatie reparatie) throws SQLException;
    void delete(Reparatie reparatie) throws SQLException;
    void deleteAll(int masinaId) throws SQLException;
    Reparatie findById(int id) throws ReparatiNotFoundException;
    List<Reparatie> findAll();
    List<Reparatie> findAllByMasinaId(int masinaId);
}
