/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.service.impl;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import md.autoservice.serviceauto.dao.MasiniDaoIntf;
import md.autoservice.serviceauto.dao.ProprietarDaoIntf;
import md.autoservice.serviceauto.dao.impl.MasiniDaoImpl;
import md.autoservice.serviceauto.dao.impl.ProprietarDaoImpl;
import md.autoservice.serviceauto.db.MyDataSource;
import md.autoservice.serviceauto.model.Masina;
import md.autoservice.serviceauto.model.Proprietar;
import md.autoservice.serviceauto.util.MasinaNotFoundException;
import md.autoservice.serviceauto.util.MyUtil;
import md.autoservice.serviceauto.util.ProprietarNotFoundException;

/**
 *
 * @author iucosoft4
 */
public class MasinaProprietarDaoImpl implements md.autoservice.serviceauto.service.MasinaProprietarDaoIntf {

    @Override
    public Masina findByIdMasina(int idMasina) throws MasinaNotFoundException {

        MasiniDaoIntf masiniDao = new MasiniDaoImpl();
        ProprietarDaoIntf proprietarDao = new ProprietarDaoImpl();
        Masina masina = masiniDao.findById(idMasina);
        
        try {

            Proprietar proprietar = proprietarDao.findById(masina.getProprietar().getId());

            masina.setProprietar(proprietar);

        } catch (ProprietarNotFoundException ex) {
            Logger.getLogger(MasinaProprietarDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return masina;

    }

    @Override
    public void save(Masina masina) throws Exception {

        MasiniDaoIntf masinaDao = new MasiniDaoImpl();
        ProprietarDaoIntf proprietarDao = new ProprietarDaoImpl();
        proprietarDao.save(masina.getProprietar());

        int idProprietar = MyUtil.getMaxId(MyDataSource.getInstace().getConnection(), "proprietar");
        masina.getProprietar().setId(idProprietar);

        try {
            masinaDao.save(masina);
        } catch (SQLException ex) {
            Logger.getLogger(MasinaProprietarDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Masina masina) throws Exception {
        MasiniDaoIntf masinaDao = new MasiniDaoImpl();
        ProprietarDaoIntf proprietarDao = new ProprietarDaoImpl();
        Proprietar proprietar = masina.getProprietar();
        proprietar.setId(masina.getId());

        proprietarDao.update(proprietar);

        try {
            masinaDao.update(masina);
        } catch (SQLException ex) {
            Logger.getLogger(MasinaProprietarDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Masina findByIdNrInmatriculare(String nrInmatriculare) throws MasinaNotFoundException {

        MasiniDaoIntf masiniDao = new MasiniDaoImpl();
        ProprietarDaoIntf proprietarDao = new ProprietarDaoImpl();
        Masina masina = masiniDao.findByNrInmatriculare(nrInmatriculare);
        
        try {

            Proprietar proprietar = proprietarDao.findById(masina.getProprietar().getId());

            masina.setProprietar(proprietar);

        } catch (ProprietarNotFoundException ex) {
            Logger.getLogger(MasinaProprietarDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return masina;
    }
}
