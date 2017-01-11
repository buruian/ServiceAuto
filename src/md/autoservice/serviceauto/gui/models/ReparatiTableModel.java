/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.gui.models;

import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import md.autoservice.serviceauto.dao.ReparatiDaoIntf;
import md.autoservice.serviceauto.dao.impl.ReparatiDaoImpl;
import md.autoservice.serviceauto.model.Reparatie;

/**
 *
 * @author iucosoft4
 */
public class ReparatiTableModel extends DefaultTableModel{
    
    private ReparatiDaoIntf reparatieDao=  new ReparatiDaoImpl();
    private String []columns = {"id","Data intrare","Data iesire","Probleme"};
    

    public ReparatiTableModel(int masinaId) {
        List<Reparatie> listaReparati = reparatieDao.findAllByMasinaId(masinaId);
        
       for(String numeColoana:columns){
           super.addColumn(numeColoana);
       }
       
       for(Reparatie reparatie:listaReparati){
           Vector rowData = new Vector();
           rowData.addElement(reparatie.getId());
           rowData.addElement(reparatie.getDataIntrare());
           rowData.addElement(reparatie.getDataIesire());
           rowData.addElement(reparatie.getProbleme());

           super.addRow(rowData);
       }
        
    }

    public void clear() {
      super.dataVector.clear();
    }
}
