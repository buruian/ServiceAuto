/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.gui;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import md.autoservice.serviceauto.dao.AngajatDaoIntf;
import md.autoservice.serviceauto.dao.impl.AngajatDaoImpl;
import md.autoservice.serviceauto.model.Angajat;

/**
 *
 * @author valera_
 */
public class LucratorDialog extends javax.swing.JDialog {

    MainJFrame parenFrame;
    Angajat angajat;
    AngajatDaoIntf angajatDao;

    public LucratorDialog(MainJFrame parentFrame, boolean modal, Angajat angajat) {
        setTitle("LUCRATORI");

        this.angajat = angajat;
        this.parenFrame = parentFrame;
        angajatDao = new AngajatDaoImpl();

        setModal(true);
        initComponents();
        fillForm();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldAngajatFunctia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldAngajatNume = new javax.swing.JTextField();
        jTextFieldAngajatPrenume = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldAngajatTelefon = new javax.swing.JTextField();
        jButtonAngajatSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adauga angajat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Functia");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Prenume");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Nume");

        jLabel4.setText("Nr. telefon");

        jTextFieldAngajatTelefon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAngajatTelefonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldAngajatTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jTextFieldAngajatNume)
                    .addComponent(jTextFieldAngajatPrenume)
                    .addComponent(jTextFieldAngajatFunctia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextFieldAngajatFunctia, jTextFieldAngajatNume, jTextFieldAngajatPrenume, jTextFieldAngajatTelefon});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldAngajatNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldAngajatPrenume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldAngajatFunctia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldAngajatTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextFieldAngajatFunctia, jTextFieldAngajatNume, jTextFieldAngajatPrenume, jTextFieldAngajatTelefon});

        jButtonAngajatSave.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButtonAngajatSave.setText("Save");
        jButtonAngajatSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAngajatSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAngajatSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAngajatSave)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAngajatSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAngajatSaveActionPerformed

        angajat.setNume(jTextFieldAngajatNume.getText());
        angajat.setPrenume(jTextFieldAngajatPrenume.getText());
        angajat.setNrTelefon(Integer.valueOf(jTextFieldAngajatTelefon.getText()));
        angajat.setFunctia(jTextFieldAngajatFunctia.getText());
        try {

            String word = "";
            if (angajat.getId() < 1) {//save add new user
                angajatDao.save(angajat);
                word = "adaugat";
            } else {// update
                angajatDao.update(angajat);
                word = "editat";
            }
            JOptionPane.showMessageDialog(this, "Angajat " + word + " cu success", "Info",
                    JOptionPane.INFORMATION_MESSAGE);

            parenFrame.lucratoriPanel.refreshAngajatiTable();
            this.dispose();

        } catch (SQLException ex) {
            Logger.getLogger(LucratorDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAngajatSaveActionPerformed

    private void jTextFieldAngajatTelefonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAngajatTelefonActionPerformed
        jTextFieldAngajatTelefon.setText("");
    }//GEN-LAST:event_jTextFieldAngajatTelefonActionPerformed

    private void fillForm() {

        jTextFieldAngajatNume.setText(angajat.getNume());
        jTextFieldAngajatPrenume.setText(angajat.getPrenume());
        if (angajat.getNrTelefon() == 0) {
            jTextFieldAngajatNume.setText("");
        } else {
            jTextFieldAngajatTelefon.setText(String.valueOf(angajat.getNrTelefon()));

        }
        jTextFieldAngajatFunctia.setText(angajat.getFunctia());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAngajatSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldAngajatFunctia;
    private javax.swing.JTextField jTextFieldAngajatNume;
    private javax.swing.JTextField jTextFieldAngajatPrenume;
    private javax.swing.JTextField jTextFieldAngajatTelefon;
    // End of variables declaration//GEN-END:variables

}
