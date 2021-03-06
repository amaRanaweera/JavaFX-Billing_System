package Billing_System;


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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Deshitha Hansajith
 */
public class loansettlement extends javax.swing.JFrame {
    Connection c = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    static String paymethod ;
    static boolean cardset = true;
    static String cusid;
    static int billnumber;
    static String time;
    static String date;
    
    
    /**
     * Creates new form loansettlement
     */
    public loansettlement() {
        initComponents();
        c = DB.connecrDB();
        fillcombo();
        update_table();
        txt_cardnumber.setVisible(false);
        jLabel5.setVisible(false);
        txt_balance.setVisible(false);
        set_bill_number();
        
    }
    
    private void fillcombo(){
        cbox_paymethod.addItem("Cash");
        cbox_paymethod.addItem("Card Payment");

     }
     public void currentdatetime() {
        Thread clock = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Calendar cal = new GregorianCalendar();
                        String month = (cal.get(Calendar.MONTH)+1)+"";
                        String year = cal.get(Calendar.YEAR)+"";
                        String day = cal.get(Calendar.DAY_OF_MONTH)+"";
                        String second = cal.get(Calendar.SECOND)+"";
                        String minutes = cal.get(Calendar.MINUTE)+"";
                        String hour = cal.get(Calendar.HOUR)+"";
                        if(day.length()==1){
                            day ="0"+day;
                        }
                        if( month.length()==1){
                            month ="0"+month;
                        }
                        if(year.length()==1){
                            year="0" + year;
                        }
                        if(second.length()==1){
                            second ="0"+second;
                        }
                        if(hour.length()==1){
                            hour="0"+hour;
                        }
                        if(minutes.length()==1){
                            minutes="0"+minutes;
                        }
                        time = hour + ":" + minutes + ":" + second;
                        date = year + "-" + (month + 1) + "-" + day;
                        sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(login_frame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        clock.start();
    }
    
    private void set_bill_number(){
        try{
            String sql = "select receiptid from bill";
            pst = c.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                billnumber = Integer.valueOf(rs.getString("receiptid")) + 1;
                txt_billnumber.setText("  Bill Number  :"+billnumber);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
     }
    
    private void update_table(){
        try{
            String sql = "select customerid,firstname,lastname,telephone,nicnumber from customer";
            pst = c.prepareStatement(sql);
            rs = pst.executeQuery();
            table_customer.setModel(DbUtils.resultSetToTableModel(rs));
            
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

        txt_balance = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_payamount = new javax.swing.JTextField();
        txt_cardnumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbox_paymethod = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        txt_search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nicnumber = new javax.swing.JLabel();
        txt_customername = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_loan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_customer = new javax.swing.JTable();
        txt_billnumber = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txt_balance.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txt_balance.setForeground(new java.awt.Color(255, 0, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_payamount.setFont(new java.awt.Font("Square721 Ex BT", 1, 24)); // NOI18N
        txt_payamount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_payamountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_payamountKeyReleased(evt);
            }
        });
        jPanel2.add(txt_payamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 460, 101, 31));

        txt_cardnumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cardnumberKeyReleased(evt);
            }
        });
        jPanel2.add(txt_cardnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 510, 69, -1));

        jLabel6.setFont(new java.awt.Font("Square721 Ex BT", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("Enter Pay Amount");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, -1, 39));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Billing_System/FormatFactory009-price.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 150, 150));

        cbox_paymethod.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbox_paymethodPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel2.add(cbox_paymethod, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 113, 28));

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loan Settlement", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 0, 36), new java.awt.Color(153, 0, 153))); // NOI18N

        txt_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Search...");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Loan Amount");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Customer Name");

        txt_nicnumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_nicnumber.setForeground(new java.awt.Color(255, 255, 255));

        txt_customername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_customername.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NIC Number");

        txt_loan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_loan.setForeground(new java.awt.Color(255, 255, 255));

        table_customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Customer Id", "First Name", "Last Name", "Telephone Number", "NIC Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_customerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_customer);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_customername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_nicnumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_loan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt_billnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txt_billnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_search)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_customername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nicnumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_loan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 1000, 380));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Enter Last Four Digit of Card Number :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 510, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        setSize(new java.awt.Dimension(1051, 643));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void table_customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_customerMouseClicked
        try{
            //txt_balance.setVisible(false);
            int row = table_customer.getSelectedRow();
            cusid = (table_customer.getModel().getValueAt(row, 0).toString());
            String sql = "select firstname,lastname,nicnumber,loan from customer where customerid = '"+cusid+"' ";
            pst = c.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                String add1 = rs.getString("firstname");
                String add2 = rs.getString("lastname");
                txt_customername.setText(add1 + " " +  add2);
                
                String add3 = rs.getString("nicnumber");
                txt_nicnumber.setText(add3);
                
                String add4 = rs.getString("loan");
                txt_loan.setText(add4);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
             e.printStackTrace();
        }
    }//GEN-LAST:event_table_customerMouseClicked

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        String sql = "select  customerid,firstname,lastname,telephone,nicnumber from customer where firstname = ? or customerid = ? or lastname = ? or nicnumber = ? or telephone = ?" ;
        try {
            //txt_balance.setVisible(false);
            pst = c.prepareStatement(sql);
            pst.setString(1,txt_search.getText());
            pst.setString(2,txt_search.getText());
            pst.setString(3,txt_search.getText());
            pst.setString(4,txt_search.getText());
            pst.setString(5,txt_search.getText());
            rs = pst.executeQuery(); 
        table_customer.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
             e.printStackTrace();
        }
        
    }//GEN-LAST:event_txt_searchKeyReleased

    private void txt_payamountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_payamountKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            String cardnumber = txt_cardnumber.getText();
            if(((4 == cardnumber.length()) && (cardset == false)) || (cardset==true) ){
                try{
                    double payamount = Double.valueOf(txt_payamount.getText());
                    double loan = Double.valueOf(txt_loan.getText());
                    double balance = loan - payamount;
                    if(balance >0){
                        String sql = "update customer set loan = '"+balance+"'  where customerid = '"+cusid+"'" ;
                        pst = c.prepareStatement(sql);
                        pst.execute(); 
                        JOptionPane.showMessageDialog(null, balance + "  Have Left To Pay");
                        sql = "Insert into bill (receiptid,productid,quantity, price,time,date) values (?,?,?,?,?,?)";
                        pst = c.prepareStatement(sql);
                        pst.setString(1,billnumber+"");
                        pst.setString(2,"0");
                        pst.setString(3,"1");
                        pst.setString(4,txt_payamount.getText());
                        pst.setString(5,time);
                        pst.setString(6,date);
                        pst.execute();
                        txt_loan.setText("");
                        txt_customername.setText("");
                        txt_nicnumber.setText("");
                        txt_payamount.setText("");
                        txt_search.setText("");
                    }else {
                        JOptionPane.showMessageDialog(null, "Loan Settled Successfuly !");
                        txt_balance.setVisible(true);
                        txt_balance.setText("Balance :"+balance );
                        balance = 0;
                        String sql = "update customer set loan = '"+balance+"'  where customerid = '"+cusid+"'" ;
                        pst = c.prepareStatement(sql);
                        pst.execute();
                        txt_loan.setText("");
                        txt_customername.setText("");
                        txt_nicnumber.setText("");
                        txt_payamount.setText("");
                        txt_search.setText("");
                    }
     
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                    e.printStackTrace();
            }
            }
            
        }
    }//GEN-LAST:event_txt_payamountKeyPressed

    private void cbox_paymethodPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbox_paymethodPopupMenuWillBecomeInvisible
       paymethod = (String) cbox_paymethod.getSelectedItem();
        if("Card Payment" == paymethod){
            txt_cardnumber.setVisible(true);
            jLabel5.setVisible(true);
            cardset = false;
        }else if("Cash" == paymethod){
            txt_cardnumber.setVisible(false);
            jLabel5.setVisible(false);
            cardset=true;
        }
    }//GEN-LAST:event_cbox_paymethodPopupMenuWillBecomeInvisible

    private void txt_payamountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_payamountKeyReleased
        String s = txt_payamount.getText();
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
        txt_payamount.setText(s.toString());
    }//GEN-LAST:event_txt_payamountKeyReleased

    private void txt_cardnumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cardnumberKeyReleased
        String s = txt_cardnumber.getText();
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
        txt_cardnumber.setText(s.toString());
        if(s.length()==4){
            txt_payamount.requestFocusInWindow();
        }
    }//GEN-LAST:event_txt_cardnumberKeyReleased

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
            java.util.logging.Logger.getLogger(loansettlement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loansettlement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loansettlement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loansettlement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loansettlement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbox_paymethod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_customer;
    private javax.swing.JLabel txt_balance;
    private javax.swing.JLabel txt_billnumber;
    private javax.swing.JTextField txt_cardnumber;
    private javax.swing.JLabel txt_customername;
    private javax.swing.JLabel txt_loan;
    private javax.swing.JLabel txt_nicnumber;
    private javax.swing.JTextField txt_payamount;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
