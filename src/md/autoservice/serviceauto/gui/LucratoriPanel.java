/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.gui;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import md.autoservice.serviceauto.dao.AngajatDaoIntf;
import md.autoservice.serviceauto.dao.ReparatieAngajatDaoIntf;
import md.autoservice.serviceauto.dao.impl.AngajatDaoImpl;
import md.autoservice.serviceauto.dao.impl.ReparatieAngajatDaoImpl;
import md.autoservice.serviceauto.gui.models.AngajatiTableModel;
import md.autoservice.serviceauto.model.Angajat;
import md.autoservice.serviceauto.util.AngajatNotFoundException;
import md.autoservice.serviceauto.util.ReparatiNotFoundException;

/**
 *
 * @author valera_
 */
public class LucratoriPanel extends javax.swing.JPanel {

    private Angajat angajat;
    private final MainJFrame parenFrame;
    private final AngajatDaoIntf angajatDao;
    private AngajatiTableModel angajatiTableModel;
    private ReparatieAngajatDaoIntf reparatieAngajatDao;

    /**
     * Creates new form LucratoriPanel
     * @param parenFrame
     */
    public LucratoriPanel(MainJFrame parenFrame) {

        this.parenFrame = parenFrame;
        initComponents();
        initModels();
        angajatDao = new AngajatDaoImpl();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAddLucrator = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButtonAngajatDelete = new javax.swing.JButton();
        jButtonAngajatEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAngajati = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButtonAngajatCauta = new javax.swing.JButton();
        jTextFieldCautaPrenume = new javax.swing.JTextField();
        jTextFieldCautaNume = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(600, 600));

        jButtonAddLucrator.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButtonAddLucrator.setText("Adauga lucrator");
        jButtonAddLucrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddLucratorActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tabela angajati", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        jButtonAngajatDelete.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButtonAngajatDelete.setText("Delete");
        jButtonAngajatDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAngajatDeleteActionPerformed(evt);
            }
        });

        jButtonAngajatEdit.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButtonAngajatEdit.setText("Edit");
        jButtonAngajatEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAngajatEditActionPerformed(evt);
            }
        });

        jTableAngajati.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jTableAngajati.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableAngajati);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAngajatDelete)
                    .addComponent(jButtonAngajatEdit))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAngajatDelete, jButtonAngajatEdit});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButtonAngajatEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAngajatDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(168, Short.MAX_VALUE))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cauta contributii angajat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Prenume:");

        jButtonAngajatCauta.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButtonAngajatCauta.setText("Cauta");
        jButtonAngajatCauta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAngajatCautaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Nume:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCautaPrenume)
                    .addComponent(jTextFieldCautaNume))
                .addGap(156, 156, 156)
                .addComponent(jButtonAngajatCauta, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldCautaNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldCautaPrenume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonAngajatCauta, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAddLucrator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAddLucrator)
                .addGap(38, 38, 38)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddLucratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddLucratorActionPerformed

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LucratorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LucratorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LucratorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LucratorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LucratorDialog dialog = new LucratorDialog(parenFrame, true, new Angajat());
                dialog.setVisible(true);
            }
        });

    }//GEN-LAST:event_jButtonAddLucratorActionPerformed

    private void jButtonAngajatEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAngajatEditActionPerformed

        int row = jTableAngajati.getSelectedRow();

        if (row != -1) {
            int id = (Integer) angajatiTableModel.getValueAt(row, 0);// 0 -0 prima coloana

            try {
                angajat = angajatDao.findById(id);
            } catch (AngajatNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Lucrator nu este gasit: id=" + id,
                        "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            showAngajatDialog();
        } else {
            JOptionPane.showMessageDialog(parenFrame, "Selectati lucrator!",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButtonAngajatEditActionPerformed

    private void jButtonAngajatDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAngajatDeleteActionPerformed

        int row = jTableAngajati.getSelectedRow();
        if (row != -1) {
            int angajatId = (Integer) jTableAngajati.getValueAt(row, 0);// 0 -0 prima coloana
            try {
                angajat = angajatDao.findById(angajatId);
                reparatieAngajatDao = new ReparatieAngajatDaoImpl();
                int rez = JOptionPane.showConfirmDialog(parenFrame, "esti sigur vrei sa sterg angajatul?",
                        "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                switch (rez) {
                    case JOptionPane.YES_OPTION:
                        //delete all coments of this user
                        //comentariiDao.deleteAllUserCommentsByUserId(userId)
                        List<Integer> list = reparatieAngajatDao.findAllByIdAngajat(angajatId);
                        for (Integer rep : list) {
                            reparatieAngajatDao.delete(rep);
                        }
                        angajatDao.delete(angajat);

                        JOptionPane.showMessageDialog(parenFrame, "Angajat sters cu success", "Succes",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case JOptionPane.NO_OPTION:
                    case JOptionPane.CLOSED_OPTION:
                        break;
                }
            } catch (AngajatNotFoundException ex) {
                JOptionPane.showMessageDialog(parenFrame, "Angajat ne este gasit cu id=" + angajatId,
                        "Error", JOptionPane.WARNING_MESSAGE);
                Logger.getLogger(LucratoriPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException | ReparatiNotFoundException ex) {
                Logger.getLogger(LucratoriPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            refreshAngajatiTable();
        } else {
            JOptionPane.showMessageDialog(parenFrame, "Selectati lucrator!",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAngajatDeleteActionPerformed

    private void jButtonAngajatCautaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAngajatCautaActionPerformed

        if (!jTextFieldCautaNume.getText().equals("")
                || !jTextFieldCautaPrenume.getText().equals("")) {

            try {

                angajat = angajatDao.findByNumeAndPrenume(jTextFieldCautaNume.getText(),
                        jTextFieldCautaPrenume.getText());

            } catch (AngajatNotFoundException ex) {
                Logger.getLogger(LucratoriPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            showAngajatDialog();
        } else {
            JOptionPane.showMessageDialog(parenFrame, "Introduceti numele si prenumele!",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAngajatCautaActionPerformed

    void refreshAngajatiTable() {
        initModels();

    }

    private void initModels() {

        angajatiTableModel = new AngajatiTableModel();
        jTableAngajati.setModel(angajatiTableModel);
        jTableAngajati.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void showAngajatDialog() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LucratorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LucratorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LucratorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LucratorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LucratorDialog dialog = new LucratorDialog(parenFrame, true, angajat);
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddLucrator;
    private javax.swing.JButton jButtonAngajatCauta;
    private javax.swing.JButton jButtonAngajatDelete;
    private javax.swing.JButton jButtonAngajatEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAngajati;
    private javax.swing.JTextField jTextFieldCautaNume;
    private javax.swing.JTextField jTextFieldCautaPrenume;
    // End of variables declaration//GEN-END:variables

}