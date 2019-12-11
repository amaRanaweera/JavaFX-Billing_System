package Billing_System;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Deshitha Hansajith
 */

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.*; 
import java.awt.event.*;
import static java.lang.Thread.sleep;
import net.proteanit.sql.DbUtils;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.*;
import java.util.ArrayList;


public class stock extends javax.swing.JFrame {
    Connection c = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    static String id;
    ArrayList name = new ArrayList();
    /**
     * Creates new form stock
     */
    public stock() {
        initComponents();
        c = DB.connecrDB();
        update_table();
        setautocomplete();
    }
    
    public boolean checknull(String s){
        if(s.length() == 0){
            return true;
        }
        return false;
    }

    public void setautocomplete(){
        try{
            String sql = "select * from product" ;
            pst = c.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
//                System.out.println(rs.getString("product_name"));
                name.add(rs.getString("product_name"));
            }
        }catch(Exception e){
                //JOptionPane.showMessageDialog(null, e);
                 e.printStackTrace();
            }
        
        
    }
    
    public void autocomplete(String txt){
//        System.out.println(txt);
        String complete ="";
        int start = txt.length();
        int last = txt.length();
        for(int i = 0;i<name.size();i++){
            if(name.get(i).toString().startsWith(txt)){
                complete = name.get(i).toString();
//                System.out.println(complete);
                last = complete.length();
                break;
            }
        }
        if(last>start){
            txt_name.setText(complete);
            txt_name.setCaretPosition(last);
            txt_name.moveCaretPosition(start);
        }
    }
    
    private void get_select(){
        try{
            int row = table_product.getSelectedRow();
            id = (table_product.getModel().getValueAt(row, 0).toString());
            String sql = "select barcode,product_name,product_price,product_stock from product where barcode= '"+id+"' ";
            pst = c.prepareStatement(sql);
            rs = pst.executeQuery(); 

            if(rs.next()){
                String add1 = rs.getString("product_name");
                txt_name.setText(add1);
                
                String add2 = rs.getString("barcode");
                txt_barcode.setText(add2);
                
                String add3 = rs.getString("product_price");
                txt_price.setText(add3);
                
//                String add4 = rs.getString("product_stock");
//                txt_stock.setText(add4);

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
             e.printStackTrace();
        }
    }
    
    private void update_table(){
        try{
            String sql = "select barcode,product_name,product_price,product_stock from product";
            pst = c.prepareStatement(sql);
            rs = pst.executeQuery();
            table_product.setModel(DbUtils.resultSetToTableModel(rs));
            
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
        txt_price = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_stock = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_barcode = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_product = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stock Entering", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calisto MT", 0, 36), new java.awt.Color(204, 204, 255))); // NOI18N

        txt_price.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        txt_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_priceKeyReleased(evt);
            }
        });

        txt_name.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });
        txt_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nameKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLabel3.setText("Product Price");

        jLabel4.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLabel4.setText("Product Stock");

        txt_stock.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        txt_stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_stockKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLabel2.setText("Product name");

        jLabel1.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLabel1.setText("Bar Code");

        txt_barcode.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        txt_barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_barcodeActionPerformed(evt);
            }
        });
        txt_barcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_barcodeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_barcode, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                    .addComponent(txt_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_price)
                    .addComponent(txt_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 880, -1));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Trajan Pro 3", 1, 18)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 450, 124, 61));

        table_product.setBackground(new java.awt.Color(204, 255, 204));
        table_product.setModel(new javax.swing.table.DefaultTableModel(
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
        table_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_productMouseClicked(evt);
            }
        });
        table_product.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table_productKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table_product);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 209, 880, 190));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );

        setBounds(150, 100, 903, 567);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            if(checknull(txt_barcode.getText()) || checknull(txt_name.getText()) || checknull(txt_price.getText()) || checknull(txt_stock.getText())){
                JOptionPane.showMessageDialog(null, "Don't Leave Data Null !"); 
            }else{
            String barcode = txt_barcode.getText();
            String name = txt_name.getText();
            String price = txt_price.getText();
            String stock = txt_stock.getText();
            
            String sql = "select product_stock from product where barcode= ?" ;
            pst = c.prepareStatement(sql);
            pst.setString(1,txt_barcode.getText());
            rs = pst.executeQuery();
            if(rs.next()){
                stock = Double.valueOf(stock) + Double.valueOf(rs.getString("product_stock")) + "";
            }
            
            sql = "update product set barcode = '"+barcode+"' ,product_name = '"+name+"' ,product_price = '"+price+"'  ,product_stock= '"+stock+"' where barcode= '"+id+"'" ;
            pst = c.prepareStatement(sql);
            pst.execute(); 
            JOptionPane.showMessageDialog(null, "Updted Successfuly");
            txt_barcode.setText("");
            txt_name.setText("");
            txt_price.setText("");
            txt_stock.setText("");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        update_table();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_barcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_barcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_barcodeActionPerformed

    private void txt_barcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_barcodeKeyReleased
        String s = txt_barcode.getText();
        StringBuilder builder = new StringBuilder(s);
        char c1;
        for(int i = 0;i<s.length();i++){
            c1 = s.charAt(i);
            if(Character.isLowerCase(c1)){
                builder.deleteCharAt(i);
                s = builder.toString();
            }
            if(Character.isUpperCase(c1)){
                builder.deleteCharAt(i);
                s = builder.toString();
            }
        }
        txt_barcode.setText(s.toString());
        
        try{
            String sql = "select * from product where barcode= ?" ;
            pst = c.prepareStatement(sql);
            pst.setString(1,txt_barcode.getText());
            rs = pst.executeQuery();
            table_product.setModel(DbUtils.resultSetToTableModel(rs));

            sql = "select * from product where barcode= ?" ;
            pst = c.prepareStatement(sql);
            pst.setString(1,txt_barcode.getText());
            rs = pst.executeQuery();
            
            if(rs.next()){
                String add1 = rs.getString("product_name");
                txt_name.setText(add1);

                String add2 = rs.getString("product_price");
                txt_price.setText(add2);
                
                txt_stock.requestFocusInWindow();
                
//                String add3 = rs.getString("product_stock");
//                txt_stock.setText(add3);
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            ////e.printStackTrace();
        }
    }//GEN-LAST:event_txt_barcodeKeyReleased

    private void table_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_productMouseClicked
        get_select();
    }//GEN-LAST:event_table_productMouseClicked

    private void table_productKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_productKeyReleased
        if((evt.getKeyCode()==KeyEvent.VK_UP) || (evt.getKeyCode()==KeyEvent.VK_DOWN)){
            get_select();
        }
    }//GEN-LAST:event_table_productKeyReleased

    private void txt_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nameKeyReleased
//       String s = txt_name.getText();
//        StringBuilder builder = new StringBuilder(s);
//        char c1;
//        for(int i = 0;i<s.length();i++){
//            c1 = s.charAt(i);
//            
//            if(Character.isUpperCase(c1)){
//                builder.deleteCharAt(i);
//                s = builder.toString();
//            }
//        }
//        txt_name.setText(s.toString());
    }//GEN-LAST:event_txt_nameKeyReleased

    private void txt_priceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_priceKeyReleased
        String s = txt_price.getText();
        StringBuilder builder = new StringBuilder(s);
        char c1;
        for(int i = 0;i<s.length();i++){
            c1 = s.charAt(i);
            if(Character.isLowerCase(c1)){
                builder.deleteCharAt(i);
                s = builder.toString();
            }
            if(Character.isUpperCase(c1)){
                builder.deleteCharAt(i);
                s = builder.toString();
            }
        }
        txt_price.setText(s.toString());
    }//GEN-LAST:event_txt_priceKeyReleased

    private void txt_stockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_stockKeyReleased
        String s = txt_stock.getText();
        StringBuilder builder = new StringBuilder(s);
        char c1;
        for(int i = 0;i<s.length();i++){
            c1 = s.charAt(i);
            if(Character.isLowerCase(c1)){
                builder.deleteCharAt(i);
                s = builder.toString();
            }
            if(Character.isUpperCase(c1)){
                builder.deleteCharAt(i);
                s = builder.toString();
            }
        }
        txt_stock.setText(s.toString());
    }//GEN-LAST:event_txt_stockKeyReleased

    private void txt_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nameKeyPressed
        switch(evt.getKeyCode()){
            case KeyEvent.VK_BACK_SPACE:
                break;
            case KeyEvent.VK_ENTER:
                txt_name.setText(txt_name.getText());
                break;
            default:
                EventQueue.invokeLater(new Runnable(){
                    @Override
                    
                 public void run(){
                     String txt = txt_name.getText();
                        autocomplete(txt);
                 }
                });
        }
        try{

            String sql = "select * from product where product_name= ?" ;
            pst = c.prepareStatement(sql);
            pst.setString(1,txt_name.getText());
            rs = pst.executeQuery();
            if(rs.next()){
                String add1 = rs.getString("barcode");
                txt_barcode.setText(add1);

                String add2 = rs.getString("product_price");
                txt_price.setText(add2);
                
//                String add3 = rs.getString("product_stock");
//                txt_stock.setText(add3);

            }
            sql = "select * from product where product_name= ?" ;
            pst = c.prepareStatement(sql);
            pst.setString(1,txt_name.getText());
            rs = pst.executeQuery();
            table_product.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            ////e.printStackTrace();
        }
    }//GEN-LAST:event_txt_nameKeyPressed

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
            java.util.logging.Logger.getLogger(stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_product;
    private javax.swing.JTextField txt_barcode;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_stock;
    // End of variables declaration//GEN-END:variables
}
