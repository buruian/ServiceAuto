/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.gui.models;

import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import md.autoservice.serviceauto.dao.MasiniDaoIntf;
import md.autoservice.serviceauto.dao.impl.MasiniDaoImpl;
import md.autoservice.serviceauto.model.Masina;

/**
 *
 * @author iucosoft4
 */
public class MasiniTableModel extends DefaultTableModel{
    
    private MasiniDaoIntf masiniDao=  new MasiniDaoImpl();
    private String []columns = {"id","Nr inmatriculare","Marca","Model","Anu",
                                "Combustibil", "Model motor"};
    

    public MasiniTableModel() {
        List<Masina> listaMasini = masiniDao.findAll();
        
       for(String numeColoana:columns){
           super.addColumn(numeColoana);
       }
       
       for(Masina masina:listaMasini){
           Vector rowData = new Vector();
           rowData.addElement(masina.getId());
           rowData.addElement(masina.getNrInmatriculare());
           rowData.addElement(masina.getMarca());
           rowData.addElement(masina.getModel());
           rowData.addElement(masina.getAnu());
           rowData.addElement(masina.getCombustibil());
           rowData.addElement(masina.getModelMotor());
           
           super.addRow(rowData);
       }
        
    }
    
}
