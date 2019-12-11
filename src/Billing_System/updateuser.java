package Billing_System;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.*; 
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Deshitha Hansajith
 */
public class updateuser extends javax.swing.JFrame {
    Connection c = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    static String id;

    /**
     * Creates new form updateuser
     */
    public updateuser() {
        initComponents();
        c = DB.connecrDB();
        update_table();
        cmd_delete.setVisible(false);
        cbox_accesstype.setVisible(false);
        cmd_update.setVisible(false);
        jLabel1.setVisible(false);
    }
    
    private void get_select(){
        try{
            int row = table_employee.getSelectedRow();
            id = (table_employee.getModel().getValueAt(row, 0).toString());
            String sql = "select * from employee where employeeid = '"+id+"' ";
            pst = c.prepareStatement(sql);
            rs = pst.executeQuery(); 
            cmd_delete.setVisible(true);
            cbox_accesstype.setVisible(true);
            jLabel1.setVisible(true);
            if(rs.next()){
                String add1 = rs.getString("acces_type");
                cbox_accesstype.setSelectedItem(add1);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
             e.printStackTrace();
        }
    }
    
    private void update_table(){
        try{
            String sql = "select * from employee";
            pst = c.prepareStatement(sql);
            rs = pst.executeQuery();
            table_employee.setModel(DbUtils.resultSetToTableModel(rs));
            System.out.println(rs);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
             e.printStackTrace();
        }
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_employee = new javax.swing.JTable();
        cbox_accesstype = new javax.swing.JComboBox();
        cmd_update = new javax.swing.JButton();
        cmd_delete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Update Authority Access", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 36), new java.awt.Color(153, 255, 153))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Square721 BdEx BT", 0, 18)); // NOI18N
        jLabel1.setText("Account Type");

        table_employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_employeeMouseClicked(evt);
            }
        });
        table_employee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table_employeeKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table_employee);

        cbox_accesstype.setFont(new java.awt.Font("Square721 BdEx BT", 0, 18)); // NOI18N
        cbox_accesstype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "user", "admin", " " }));
        cbox_accesstype.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbox_accesstypePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbox_accesstype, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbox_accesstype))
                .addContainerGap())
        );

        cmd_update.setBackground(new java.awt.Color(255, 0, 0));
        cmd_update.setFont(new java.awt.Font("Source Sans Pro ExtraLight", 1, 18)); // NOI18N
        cmd_update.setText("Update");
        cmd_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_updateActionPerformed(evt);
            }
        });

        cmd_delete.setBackground(new java.awt.Color(255, 0, 0));
        cmd_delete.setFont(new java.awt.Font("Source Sans Pro ExtraLight", 1, 18)); // NOI18N
        cmd_delete.setText("Delete User");
        cmd_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_deleteActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Billing_System/FormatFactory012-lock.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmd_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(cmd_update, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmd_update, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmd_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(175, 50, 883, 670);
    }// </editor-fold>//GEN-END:initComponents

    private void table_employeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_employeeMouseClicked
        get_select();
    }//GEN-LAST:event_table_employeeMouseClicked

    private void cbox_accesstypePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbox_accesstypePopupMenuWillBecomeInvisible
        cmd_update.setVisible(true);
    }//GEN-LAST:event_cbox_accesstypePopupMenuWillBecomeInvisible

    private void cmd_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_updateActionPerformed
        try{
            String accestype = (String)cbox_accesstype.getSelectedItem();
            String sql = "update employee set acces_type = '"+accestype+"'  where employeeid = '"+id+"'" ;
            pst = c.prepareStatement(sql);
            pst.execute(); 
            JOptionPane.showMessageDialog(null, "Updted Successfuly");
            cmd_delete.setVisible(false);
            cbox_accesstype.setVisible(false);
            cmd_update.setVisible(false);
            jLabel1.setVisible(false);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        update_table();
    }//GEN-LAST:event_cmd_updateActionPerformed

    private void cmd_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_deleteActionPerformed
        int p = JOptionPane.showConfirmDialog(null,"Do You Really Want To Delete?","Delete",JOptionPane.YES_NO_OPTION);
        if(p == 0){
            try{
                int count = 0;
                String sql = "select * from employee where employeeid = ?";
                pst = c.prepareStatement(sql);
                pst.setString(1, id);
                rs = pst.executeQuery();
                if (rs.next()) {
                    if(rs.getString("acces_type").equals("admin")){
                        sql = "select acces_type from employee where acces_type = ?";
                        pst = c.prepareStatement(sql);
                        pst.setString(1,"admin");
                        rs = pst.executeQuery();

                        while(rs.next()){
                            count++;
                        }
                    }
                }
                 
                if(count == 1 ){
                    JOptionPane.showMessageDialog(null, "You Cannot Delete All Admin Accounts ! ");
                }else{
                    sql = "delete from employee where employeeid = ? ";
                    pst = c.prepareStatement(sql);
                    pst.setString(1,id);
                    pst.execute(); 
                    JOptionPane.showMessageDialog(null, "Deleted Successfuly");
                    cmd_delete.setVisible(false);
                    cbox_accesstype.setVisible(false);
                    cmd_update.setVisible(false);
                    jLabel1.setVisible(false);

                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                 e.printStackTrace();
            }
            update_table();
        }
    }//GEN-LAST:event_cmd_deleteActionPerformed

    private void table_employeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_employeeKeyReleased
        if((evt.getKeyCode()==KeyEvent.VK_UP) || (evt.getKeyCode()==KeyEvent.VK_DOWN)){
            get_select();
        }
    }//GEN-LAST:event_table_employeeKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(updateuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateuser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbox_accesstype;
    private javax.swing.JButton cmd_delete;
    private javax.swing.JButton cmd_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_employee;
    // End of variables declaration//GEN-END:variables
}
