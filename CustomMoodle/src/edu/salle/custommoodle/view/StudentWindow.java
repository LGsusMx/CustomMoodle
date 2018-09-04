/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.salle.custommoodle.view;

import edu.salle.custommoodle.businesslogic.StudentBLO;
import edu.salle.custommoodle.model.Student;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Red
 */
public class StudentWindow extends javax.swing.JFrame {

    /**
     * Creates new form StudentWindow
     */
    private StudentBLO studentBLO= new StudentBLO();
    public StudentWindow() {
        
        initComponents();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        tfLastName = new javax.swing.JTextField();
        bSave = new javax.swing.JButton();
        bSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        bUpdate = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tStudents = new javax.swing.JTable();
        bRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel2.setText("Last name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));
        getContentPane().add(tfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 140, -1));

        tfLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLastNameActionPerformed(evt);
            }
        });
        getContentPane().add(tfLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 140, -1));

        bSave.setText("Save");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });
        getContentPane().add(bSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        bSearch.setText("Search");
        bSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSearchActionPerformed(evt);
            }
        });
        getContentPane().add(bSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        jLabel3.setText("ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));
        getContentPane().add(tfID, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 100, -1));

        bUpdate.setText("Update");
        bUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(bUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        bDelete.setText("Delete");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(bDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        tStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Last Name"
            }
        ));
        jScrollPane1.setViewportView(tStudents);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 310, 130));

        bRefresh.setText("Show");
        bRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(bRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLastNameActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed

String name = tfName.getText();
String lastName= tfLastName.getText();
String namex= name.replaceAll(" ","");
String lastNamex= lastName.replaceAll(" ", "");
        if (namex.equals("") ) {
            
            
        }
        else
        {if(lastNamex.equals(""))
        {
        }
        else
        {
            Student student = new Student(name,lastName);
studentBLO.save(student);
tfName.setText("");
tfLastName.setText("");
        }
        }

    }//GEN-LAST:event_bSaveActionPerformed

    private void bSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSearchActionPerformed

        String id= tfID.getText();
        Student student= studentBLO.find(id);
        if (student!=null) {
            tfName.setText(student.getName());
            tfLastName.setText(student.getLastname());
            tfID.setText("");
        }
    }//GEN-LAST:event_bSearchActionPerformed
private void refreshTable()
{
    clearTable();
    List<Student> studentList= studentBLO.findAll();
    DefaultTableModel dtm= (DefaultTableModel)tStudents.getModel();
    Object[] emptyRow={""};
    for (int i = 0; i < studentList.size();i++) {
        dtm.addRow(emptyRow);
        dtm.setValueAt(studentList.get(i).getId(),i,0);
        dtm.setValueAt(studentList.get(i).getName(),i,1);
        dtm.setValueAt(studentList.get(i).getLastname(),i,2);
    }
}
private void clearTable(){
    DefaultTableModel dtm= (DefaultTableModel)tStudents.getModel();
    while(dtm.getRowCount()>0)
    {
        dtm.removeRow(0);
    }
}
    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bUpdateActionPerformed

    private void bRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefreshActionPerformed
        // TODO add your handling code here:
        refreshTable();
    }//GEN-LAST:event_bRefreshActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        // TODO add your handling code here:
        Student reprobado= new Student();
        reprobado.setId(tfID.getText());
        reprobado.setName(tfName.getText());
        reprobado.setLastname(tfLastName.getText());
        studentBLO.delete(reprobado);
    }//GEN-LAST:event_bDeleteActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bRefresh;
    private javax.swing.JButton bSave;
    private javax.swing.JButton bSearch;
    private javax.swing.JButton bUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tStudents;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfLastName;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
