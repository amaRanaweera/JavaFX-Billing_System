package Billing_System;


import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Deshitha Hansajith
 */
public class Addnewcustomer extends javax.swing.JFrame {
    Connection c = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    /**
     * Creates new form Addnewcustomer
     */
    public Addnewcustomer() {
        initComponents();
        c = DB.connecrDB();
    }
    
    public void close(){
        WindowEvent windowclose = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowclose);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_nicnumber = new javax.swing.JTextField();
        txt_firstname = new javax.swing.JTextField();
        txt_address = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_telephone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_secondname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*Note : Use Only Lower Case When Adding Data (Except for Username and Pasword)");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 36), new java.awt.Color(0, 51, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(51, 0, 51));

        jLabel1.setFont(new java.awt.Font("Square721 BdEx BT", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("First Name");

        txt_nicnumber.setFont(new java.awt.Font("Sitka Small", 0, 18)); // NOI18N
        txt_nicnumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nicnumberKeyReleased(evt);
            }
        });

        txt_firstname.setFont(new java.awt.Font("Sitka Small", 0, 18)); // NOI18N
        txt_firstname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_firstnameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_firstnameKeyReleased(evt);
            }
        });

        txt_address.setFont(new java.awt.Font("Sitka Small", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Square721 BdEx BT", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Last Name");

        jLabel5.setFont(new java.awt.Font("Square721 BdEx BT", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Full Address");

        txt_telephone.setFont(new java.awt.Font("Sitka Small", 0, 18)); // NOI18N
        txt_telephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telephoneActionPerformed(evt);
            }
        });
        txt_telephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_telephoneKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Square721 BdEx BT", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telephone Number");

        jLabel3.setFont(new java.awt.Font("Square721 BdEx BT", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NIC Number");

        txt_secondname.setFont(new java.awt.Font("Sitka Small", 0, 18)); // NOI18N
        txt_secondname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_secondnameActionPerformed(evt);
            }
        });
        txt_secondname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_secondnameKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_telephone)
                    .addComponent(txt_address)
                    .addComponent(txt_firstname)
                    .addComponent(txt_secondname)
                    .addComponent(txt_nicnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_firstname)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_secondname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nicnumber)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_telephone)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Billing_System/FormatFactory027-id.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Add Customer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*Note : Use Only Lower Case When Adding Data ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(200, 75, 792, 530);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_secondnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_secondnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_secondnameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            String sql = "Insert into customer (firstname,lastname,nicnumber,telephone,address) values (?,?,?,?,?)";
            pst = c.prepareStatement(sql);
            pst.setString(1,txt_firstname.getText());
            pst.setString(2,txt_secondname.getText());
            pst.setString(3,txt_nicnumber.getText());
            pst.setString(5,txt_address.getText());
            pst.setString(4,txt_telephone.getText());
            pst.execute(); 
            JOptionPane.showMessageDialog(null, "Added New Customer Successfuly!");
            dispose();
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
             e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_firstnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_firstnameKeyPressed
        
    }//GEN-LAST:event_txt_firstnameKeyPressed

    private void txt_firstnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_firstnameKeyReleased
        String s = txt_firstname.getText();
        StringBuilder builder = new StringBuilder(s);
        boolean hasnum = false;boolean hasupp = false;boolean haslow = false;char c;
        for(int i = 0;i<s.length();i++){
            c = s.charAt(i);
            if(Character.isDigit(c)){
                builder.deleteCharAt(i);
                s = builder.toString();
            }if(Character.isUpperCase(c)){
                builder.deleteCharAt(i);
                s = builder.toString();
            }
        }
        txt_firstname.setText(s.toString());
    }//GEN-LAST:event_txt_firstnameKeyReleased

    private void txt_secondnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_secondnameKeyReleased
        String s = txt_secondname.getText();
        StringBuilder builder = new StringBuilder(s);
        boolean hasnum = false;boolean hasupp = false;boolean haslow = false;char c;
        for(int i = 0;i<s.length();i++){
            c = s.charAt(i);
            if(Character.isDigit(c)){
                builder.deleteCharAt(i);
                s = builder.toString();
            }if(Character.isUpperCase(c)){
                builder.deleteCharAt(i);
                s = builder.toString();
            }
        }
        txt_secondname.setText(s.toString());
    }//GEN-LAST:event_txt_secondnameKeyReleased

    private void txt_nicnumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nicnumberKeyReleased
        String s = txt_nicnumber.getText();
        StringBuilder builder = new StringBuilder(s);
        boolean hasnum = false;boolean hasupp = false;boolean haslow = false;char c;
        for(int i = 0;i<s.length();i++){
            c = s.charAt(i);
            if(Character.isUpperCase(c)){
                builder.deleteCharAt(i);
                s = builder.toString();
            }
        }
        txt_nicnumber.setText(s.toString());
    }//GEN-LAST:event_txt_nicnumberKeyReleased

    private void txt_telephoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telephoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telephoneActionPerformed

    private void txt_telephoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telephoneKeyReleased
        String s = txt_telephone.getText();
        StringBuilder builder = new StringBuilder(s);
        boolean hasnum = false;boolean hasupp = false;boolean haslow = false;char c;
        for(int i = 0;i<s.length();i++){
            c = s.charAt(i);
            if(Character.isLowerCase(c)){
                builder.deleteCharAt(i);
                s = builder.toString();
            }if(Character.isUpperCase(c)){
                builder.deleteCharAt(i);
                s = builder.toString();
            }
        }
        txt_telephone.setText(s.toString());
    }//GEN-LAST:event_txt_telephoneKeyReleased

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
            java.util.logging.Logger.getLogger(Addnewcustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Addnewcustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Addnewcustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Addnewcustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Addnewcustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_firstname;
    private javax.swing.JTextField txt_nicnumber;
    private javax.swing.JTextField txt_secondname;
    private javax.swing.JTextField txt_telephone;
    // End of variables declaration//GEN-END:variables
}