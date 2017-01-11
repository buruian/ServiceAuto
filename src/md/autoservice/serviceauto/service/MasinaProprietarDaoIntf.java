/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.service;

import md.autoservice.serviceauto.model.Masina;
import md.autoservice.serviceauto.util.MasinaNotFoundException;

/**
 *
 * @author iucosoft4
 */
public interface MasinaProprietarDaoIntf {
    
    Masina findByIdMasina(int idMsina)throws MasinaNotFoundException;
    Masina findByIdNrInmatriculare(String nrInmatriculare)throws MasinaNotFoundException;
    void save(Masina masina)throws Exception;
    void update(Masina masina)throws Exception;
}
