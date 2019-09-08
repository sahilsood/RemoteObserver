/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package foa;

import foa.alpha.DBOperations;
import foa.alpha.UserRegBean;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author xxx
 */
public class SearchRegistration extends javax.swing.JPanel {
    
    List<UserRegBean> alst;

    /**
     * Creates new form SearchRegistration
     */
    public SearchRegistration() {
        initComponents();
        
    }

    public void generateTable() {
        alst=new DBOperations().SearchRegistrationDetail("name","registration_id","mobile","registration_id") ;
        Object data[][] = new Object[alst.size()][7];
        for (int i = 0; i < alst.size(); i++) {
            UserRegBean objBean = (UserRegBean) alst.get(i);
            data[i][0] = objBean.getUserId();
            data[i][1] = objBean.getName();
            data[i][2] = objBean.getTrainingtype();
           data[i][3] = objBean.getQualification();
            data[i][4] = objBean.getCollege();
            data[i][5] = objBean.getMobile();
            data[i][6] = objBean.getRegistrationdate();
            
        }
        String headers[] = {"UserId", "Name","Training","Qualification","College","Mobile","RegistrationDate"   };
        tblRegistrationMaster = new JTable(data, headers);
        jScrollPane1.setViewportView(tblRegistrationMaster);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtMobile = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRegistrationDate = new javax.swing.JTextField();
        ddlTraining = new javax.swing.JComboBox();
        btnList = new javax.swing.JButton();
        btnListAll = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistrationMaster = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Searching Criteria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(51, 0, 51))); // NOI18N
        jLayeredPane1.setForeground(new java.awt.Color(0, 51, 51));

        jLabel1.setText("Name");
        jLabel1.setBounds(20, 30, 33, 16);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setText("Mobile");
        jLabel2.setBounds(20, 60, 37, 16);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        txtName.setBounds(80, 30, 130, 22);
        jLayeredPane1.add(txtName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtMobile.setBounds(80, 60, 130, 22);
        jLayeredPane1.add(txtMobile, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setText("Registration Date");
        jLabel3.setBounds(250, 30, 110, 16);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setText("Training");
        jLabel4.setBounds(250, 60, 50, 16);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtRegistrationDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRegistrationDateActionPerformed(evt);
            }
        });
        txtRegistrationDate.setBounds(370, 30, 120, 22);
        jLayeredPane1.add(txtRegistrationDate, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ddlTraining.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Any", "Course Based", "Project Based", "Industrial Training" }));
        ddlTraining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddlTrainingActionPerformed(evt);
            }
        });
        ddlTraining.setBounds(370, 60, 120, 22);
        jLayeredPane1.add(ddlTraining, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnList.setText("List");
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });
        btnList.setBounds(150, 100, 51, 25);
        jLayeredPane1.add(btnList, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnListAll.setText("ListAll");
        btnListAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListAllActionPerformed(evt);
            }
        });
        btnListAll.setBounds(250, 100, 65, 25);
        jLayeredPane1.add(btnListAll, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblRegistrationMaster.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Training", "Qualification", "College", "Mobile", "Registration Date"
            }
        ));
        jScrollPane1.setViewportView(tblRegistrationMaster);

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Search  Registration");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed
    
    private void txtRegistrationDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRegistrationDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRegistrationDateActionPerformed
    
    private void ddlTrainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddlTrainingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ddlTrainingActionPerformed
    
    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed
        // TODO add your handling code here:
        generateTable();
    }//GEN-LAST:event_btnListActionPerformed

    private void btnListAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListAllActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnListAll;
    private javax.swing.JComboBox ddlTraining;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblRegistrationMaster;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRegistrationDate;
    // End of variables declaration//GEN-END:variables
}