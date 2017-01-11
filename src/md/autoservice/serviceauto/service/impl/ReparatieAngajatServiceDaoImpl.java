/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import md.autoservice.serviceauto.dao.AngajatDaoIntf;
import md.autoservice.serviceauto.dao.ReparatieAngajatDaoIntf;
import md.autoservice.serviceauto.dao.impl.AngajatDaoImpl;
import md.autoservice.serviceauto.dao.impl.ReparatieAngajatDaoImpl;
import md.autoservice.serviceauto.model.Angajat;
import md.autoservice.serviceauto.service.ReparatieAngajatServiceDaoIntf;
import md.autoservice.serviceauto.util.AngajatNotFoundException;
import md.autoservice.serviceauto.util.ReparatiNotFoundException;

/**
 *
 * @author iucosoft4
 */
public class ReparatieAngajatServiceDaoImpl implements ReparatieAngajatServiceDaoIntf {

    @Override
    public List<Angajat> findAngajatiByIdReparatie(int idReparatie) throws ReparatiNotFoundException {

        ReparatieAngajatDaoIntf reparatieAngajatDao = new ReparatieAngajatDaoImpl();
        AngajatDaoIntf angajatDao = new AngajatDaoImpl();
        Angajat angajat = new Angajat();
        List<Angajat> listaAngajati = new ArrayList<>();
        List<Integer> listaId = new ArrayList<>();

        try {
            listaId = reparatieAngajatDao.findAllByIdReparati(idReparatie);
            for (Integer id : listaId) {
                angajat = angajatDao.findById(id);
                listaAngajati.add(angajat);
            }

        } catch (AngajatNotFoundException ex) {
            Logger.getLogger(ReparatieAngajatServiceDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaAngajati;
    }
    
}
