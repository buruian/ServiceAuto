/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.gui.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import md.autoservice.serviceauto.dao.AngajatDaoIntf;
import md.autoservice.serviceauto.dao.impl.AngajatDaoImpl;
import md.autoservice.serviceauto.model.Angajat;
import md.autoservice.serviceauto.model.Reparatie;
import md.autoservice.serviceauto.service.ReparatieAngajatServiceDaoIntf;
import md.autoservice.serviceauto.service.impl.ReparatieAngajatServiceDaoImpl;
import md.autoservice.serviceauto.util.ReparatiNotFoundException;

/**
 *
 * @author iucosoft4
 */
public class AngajatiCheckBoxTableModel extends DefaultTableModel{
    
    private AngajatDaoIntf angajatiDao = new AngajatDaoImpl();
    private String []columns = {"id","Nume","Functia","Select"};
    List<Angajat> listaAngajati = new ArrayList<>();
    ReparatieAngajatServiceDaoIntf serv=new ReparatieAngajatServiceDaoImpl();
    List<Angajat> listaAngajatiSelectati ;

    Reparatie reparatie;
    
    
    public AngajatiCheckBoxTableModel(Reparatie reparati) throws ReparatiNotFoundException {
      
       
        this.reparatie=reparati;
        listaAngajati = angajatiDao.findAll();
        listaAngajatiSelectati =serv.findAngajatiByIdReparatie(reparati.getId());
      //  reparatie.setListaReparatori(serv.findAngajatiByIdReparatie(reparati.getId()));
       // listaAngajatiSelectati = reparatie.getListaReparatori();
       for(String numeColoana:columns){
           super.addColumn(numeColoana);
       }
       
       for(Angajat angajat:listaAngajati){
           Vector rowData = new Vector();
           rowData.addElement(angajat.getId());
           rowData.addElement(angajat.getNume());
           rowData.addElement(angajat.getFunctia());
           
           //if(listaAngajatiSelectati.contains(angajat)){
             
           boolean found=false;
           
           
           
           for (Angajat angajatSelectat:listaAngajatiSelectati) {
               
               if(angajatSelectat.getId() == angajat.getId()){
                  rowData.add(Boolean.valueOf("true"));
                  found =true;
                  break;
               }
               
           }
           
           
           if(found==false){
                  rowData.add(Boolean.valueOf("false"));
           }
            
           
           
           super.addRow(rowData);
        //   fireTableDataChanged();
            
//           List<Angajat> list = new ArrayList<>();
//           for (int i = 0; i < getRowCount(); i++) {
//          
//          if((Boolean)getValueAt(i, 3) == true){
//              list.add((listaAngajati.get(i)));
//              
//          }              
//        }
  
           
       }
    }

   

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==3) {
            return Boolean.class;
        } else {
            return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column==3;
    }

    @Override
    public int getRowCount() {
        return super.getRowCount(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void saveSelected(boolean isSelected, int selectedRow){
        
        super.setValueAt(isSelected, selectedRow, 3);
        super.fireTableDataChanged();
        
    }

    public List<Angajat> getAngajatiSelectati() {
   
        List<Angajat> list = new ArrayList<>();
        
         for (int i = 0; i < getRowCount(); i++) {
          
          if((Boolean)getValueAt(i, 3) == true){
              list.add((listaAngajati.get(i)));
              
          }            
            
        }
         return list;
        
    }
}
