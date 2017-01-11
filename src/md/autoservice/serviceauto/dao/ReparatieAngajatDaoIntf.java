/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.dao;

import java.sql.SQLException;
import java.util.List;
import md.autoservice.serviceauto.model.Angajat;
import md.autoservice.serviceauto.model.Reparatie;
import md.autoservice.serviceauto.util.AngajatNotFoundException;
import md.autoservice.serviceauto.util.ReparatiNotFoundException;

/**
 *
 * @author iucosoft4
 */
public interface ReparatieAngajatDaoIntf {
    
    void save(int idReparatie, int reparatoriId) throws SQLException;
    public void update(int idReparatie, List<Angajat> lista)  throws SQLException;
    void delete(int idReparatie) throws SQLException;
    List<Integer> findAllByIdReparati(int idReparati) throws AngajatNotFoundException;
    List<Integer> findAllByIdAngajat(int idAngajat) throws ReparatiNotFoundException;
}
