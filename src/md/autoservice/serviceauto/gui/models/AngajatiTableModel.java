/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.gui.models;

import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import md.autoservice.serviceauto.dao.AngajatDaoIntf;
import md.autoservice.serviceauto.dao.impl.AngajatDaoImpl;
import md.autoservice.serviceauto.model.Angajat;

/**
 *
 * @author iucosoft5
 */
public class AngajatiTableModel extends DefaultTableModel{
    
    private AngajatDaoIntf angajatiDao = new AngajatDaoImpl();
    private String []columns = {"id","Nume","Prenume","Functia","Telefon"};
    

    public AngajatiTableModel() {
        List<Angajat> lista = angajatiDao.findAll();
        
       for(String numeColoana:columns){
           super.addColumn(numeColoana);
       }
       
       for(Angajat angajat:lista){
           Vector rowData = new Vector();
           rowData.addElement(angajat.getId());
           rowData.addElement(angajat.getNume());
           rowData.addElement(angajat.getPrenume());
           rowData.addElement(angajat.getFunctia());
           rowData.addElement(angajat.getNrTelefon());
           
           super.addRow(rowData);
       }
        
    }
    
    
}
