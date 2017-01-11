/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.service;

import java.util.List;
import md.autoservice.serviceauto.model.Angajat;
import md.autoservice.serviceauto.util.ReparatiNotFoundException;

/**
 *
 * @author iucosoft4
 */
public interface ReparatieAngajatServiceDaoIntf {
    
    List<Angajat> findAngajatiByIdReparatie(int idReparatie)throws ReparatiNotFoundException;
}
