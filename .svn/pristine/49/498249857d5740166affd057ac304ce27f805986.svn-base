/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.dao;

import java.sql.SQLException;
import java.util.List;
import md.autoservice.serviceauto.model.Angajat;
import md.autoservice.serviceauto.util.AngajatNotFoundException;

/**
 *
 * @author iucosoft5
 */
public interface AngajatDaoIntf {
    
    Angajat save(Angajat angajat) throws SQLException;
    Angajat update(Angajat angajat) throws SQLException;
    void delete(Angajat angajat) throws SQLException;
    Angajat findById(int id) throws AngajatNotFoundException;
    Angajat findByNumeAndPrenume(String nume, String prenume) throws AngajatNotFoundException;
    List<Angajat> findAll();
}
