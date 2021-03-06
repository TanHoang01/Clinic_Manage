/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Screens;
import Model.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Tan Hoang-Pride
 */
public class Phamacist_Storage_Form extends javax.swing.JInternalFrame {
     static String url = "jdbc:postgresql://localhost:5432/clinic_manage";
    static String unameDB = "postgres";
    static String passDB = "123456";
    static String query = "select * from medicine";
    /**
     * Creates new form Phamacist_Storage_Form
     */
    public Phamacist_Storage_Form() {
        initComponents();
        show_Medicines();
    }
    
    public ArrayList<Medicine_Model> medicineList(){
        ArrayList<Medicine_Model> medicinesList = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, unameDB, passDB);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            Medicine_Model medicines;
            while(rs.next()){
               medicines = new Medicine_Model(rs.getInt("id"), rs.getString("name"),rs.getString("type_of_medicine"),rs.getString("producer"),rs.getLong("price_per_unit"),rs.getInt("amount"));
               medicinesList.add(medicines);
               }
           } catch(SQLException ex){
            ex.printStackTrace();
        }
        return medicinesList;
    }
    
    public void show_Medicines(){
        ArrayList<Medicine_Model> list = medicineList();
        DefaultTableModel model = (DefaultTableModel) medicine_table.getModel();
        Object[] row = new Object[6];
        for(int i = 0; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getname();
            row[2] = list.get(i).gettypeofmedicine();
            row[3] = list.get(i).getproducer();
            row[4] = list.get(i).getpriceperunit();
            row[5] = list.get(i).getamount();
            model.addRow(row);
        }
    }
    
    public ArrayList<Medicine_Model> searchList(String search){
        ArrayList<Medicine_Model> searchsList = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, unameDB, passDB);
            String search_query = "select * from medicine where name like " + search;
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(search_query);
            Medicine_Model medicines;
            while(rs.next()){
               medicines = new Medicine_Model(rs.getInt("id"), rs.getString("name"),rs.getString("type_of_medicine"),rs.getString("producer"),rs.getLong("price_per_unit"),rs.getInt("amount"));
               searchsList.add(medicines);
               }
           } catch(SQLException ex){
            ex.printStackTrace();
        }
        return searchsList;
    }
    
    public void show_searchMedicines(){
        String search = "'%" + tf_search.getText() + "%'";
        ArrayList<Medicine_Model> list = searchList(search);
        DefaultTableModel model = (DefaultTableModel)medicine_table.getModel();
        Object[] row = new Object[6];
        for(int i = 0; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getname();
            row[2] = list.get(i).gettypeofmedicine();
            row[3] = list.get(i).getproducer();
            row[4] = list.get(i).getpriceperunit();
            row[5] = list.get(i).getamount();
            model.addRow(row);
        }
    }
    
    // clear data in table 
     public void clear_Medicines(){
        DefaultTableModel model = (DefaultTableModel)medicine_table.getModel();
        model.setRowCount(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tf_search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicine_table = new javax.swing.JTable();
        bt_update = new javax.swing.JButton();
        bt_remove = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Medical Storage");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_search.setText("Search...");
        tf_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_searchFocusGained(evt);
            }
        });
        jPanel1.add(tf_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 267, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screens/icon/search.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 30, 30));

        medicine_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Type", "Producer", "Price Per Unit", "Amount"
            }
        ));
        jScrollPane1.setViewportView(medicine_table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 850, 450));

        bt_update.setText("UPDATE");
        bt_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_updateMouseClicked(evt);
            }
        });
        jPanel1.add(bt_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        bt_remove.setText("REMOVE");
        bt_remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_removeMouseClicked(evt);
            }
        });
        jPanel1.add(bt_remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_searchFocusGained
        tf_search.setText("");
    }//GEN-LAST:event_tf_searchFocusGained

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if(!tf_search.getText().equals("") && !tf_search.getText().equals("Search...")){
           clear_Medicines();
           show_searchMedicines();
        }
        else{
            JOptionPane.showMessageDialog(null, "Please fill all search space");
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void bt_removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_removeMouseClicked
        //get selected row 
        int selected = medicine_table.getSelectedRow();
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to delete this patient?","Warning",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            try{
                Class.forName("org.postgresql.Driver");
            }catch (ClassNotFoundException ex){
                ex.printStackTrace();
            }
            try{
                    Connection con = DriverManager.getConnection(url, unameDB, passDB);
                    // delete employee query
                    String medicine_query ="DELETE FROM public.medicine\n" +"	WHERE id = ?;";
                    PreparedStatement medicine_pst = con.prepareStatement(medicine_query);
                    medicine_pst.setInt(1, Integer.valueOf(medicine_table.getValueAt(selected, 0).toString()));
                    medicine_pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Delete Medicine Successfully");
            }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error Something Go Wrong");
                }
                clear_Medicines();
                show_Medicines();
        }else{
            
        }
    }//GEN-LAST:event_bt_removeMouseClicked

    private void bt_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_updateMouseClicked
        //get selected row 
        int selected = medicine_table.getSelectedRow();
         try{
                Class.forName("org.postgresql.Driver");
            }catch (ClassNotFoundException ex){
                ex.printStackTrace();
            }
            try{
                    Connection con = DriverManager.getConnection(url, unameDB, passDB);             
                    // update account query
                    String medicine_query ="UPDATE public.medicine\n" +"	SET id=?, name=?, type_of_medicine=?, producer=?, price_per_unit=?, amount=?\n" +"	WHERE id = ?;";
                    PreparedStatement medicine_pst = con.prepareStatement(medicine_query);
                    medicine_pst.setInt(1, Integer.valueOf(medicine_table.getValueAt(selected, 0).toString()));
                    medicine_pst.setString(2, medicine_table.getValueAt(selected, 1).toString());
                    medicine_pst.setString(3,medicine_table.getValueAt(selected, 2).toString());
                    medicine_pst.setString(4, medicine_table.getValueAt(selected, 3).toString());
                    medicine_pst.setLong(5, Long.valueOf(medicine_table.getValueAt(selected, 4).toString()));
                    medicine_pst.setInt(6, Integer.valueOf(medicine_table.getValueAt(selected, 5).toString()));
                    medicine_pst.setInt(7, Integer.valueOf(medicine_table.getValueAt(selected, 0).toString()));
                    medicine_pst.executeUpdate();              
                    JOptionPane.showMessageDialog(null, "Update Medicine Successfully");
            }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error Something Go Wrong");
                    ex.printStackTrace();
                }
                clear_Medicines();
                show_Medicines();
    }//GEN-LAST:event_bt_updateMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_remove;
    private javax.swing.JButton bt_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable medicine_table;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables
}
