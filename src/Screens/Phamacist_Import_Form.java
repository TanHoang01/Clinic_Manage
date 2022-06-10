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
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Tan Hoang-Pride
 */
public class Phamacist_Import_Form extends javax.swing.JInternalFrame {
    static String url = "jdbc:postgresql://localhost:5432/clinic_manage";
    static String unameDB = "postgres";
    static String passDB = "123456";
    
    /**
     * Creates new form Phamacist_Import_Form
     */
    public Phamacist_Import_Form() {
        initComponents();
    }
    
    public Medicine_Model newMedicine(){
        Medicine_Model medicines;
        medicines = new Medicine_Model(Integer.valueOf(tf_medicine_id.getText()),tf_name.getText(),tf_type.getText(),tf_producer.getText()
                ,Long.valueOf(tf_price_per_unit.getText()),Integer.valueOf(tf_quantity.getText()));
        return medicines;
    }
    
    public void show_newMedicine(){
        Medicine_Model medicine = newMedicine();
        DefaultTableModel model = (DefaultTableModel)draft_table.getModel();
        Object[] row = new Object[7];
        row[0] = medicine.getid();
        row[1] = medicine.getname();
        row[2] = medicine.gettypeofmedicine();
        row[3] = medicine.getproducer();
        row[5] = medicine.getpriceperunit();
        row[4] = medicine.getamount();
        row[6] = "new";
        model.addRow(row);
    }
    
     public Import_Detail_Model oldMedicine(){
        Import_Detail_Model imports;
        imports = new Import_Detail_Model(Integer.valueOf(tf_medicine_id.getText()),Integer.valueOf(tf_quantity.getText()));
        return imports;
    }
    
    public void show_oldMedicine(){
        Import_Detail_Model imports = oldMedicine();
        Medicine_Model medicines = medicine(imports.getid());
        DefaultTableModel model = (DefaultTableModel)draft_table.getModel();
        Object[] row = new Object[7];
        row[0] = imports.getid();
        row[1] = medicines.getname();
        row[5] = medicines.getpriceperunit();
        row[4] = imports.getamount();
        row[6] = "old";
            model.addRow(row);
    }
     public Medicine_Model medicine(int id){
        Medicine_Model medicines = new Medicine_Model(0,"","","",0,0);
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, unameDB, passDB);
            Statement stm = con.createStatement();
            String query = "select * from medicine where id = " + id;
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
               medicines = new Medicine_Model(rs.getInt("id"), rs.getString("name"),rs.getString("type_of_medicine"),rs.getString("producer"),rs.getLong("price_per_unit"),rs.getInt("amount"));
               }
           } catch(SQLException ex){
            ex.printStackTrace();
        }
        return medicines;
    }
    // clear data in table 
     public void clear_Patients(){
        DefaultTableModel model = (DefaultTableModel)draft_table.getModel();
        model.setRowCount(0);
    }
    
    public int countImport(){
        int count = 0;
        String query = "select * from import";
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, unameDB, passDB);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            Patient_Model patients;
            while(rs.next()){
               count = count + 1;
               }
           } catch(SQLException ex){
            ex.printStackTrace();
        }
        return count;
    }
    
    public int getAmount(int id){
        int amount = 0;
        String query = "SELECT amount\n" +"	FROM public.medicine WHERE id = " + id + ";";
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, unameDB, passDB);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
             amount = rs.getInt("amount");
            }
           } catch(SQLException ex){
            ex.printStackTrace();
        }
        return amount;
    }
     public ArrayList<Integer> idList(){
        String query = "select id from medicine";
        ArrayList<Integer> idList = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, unameDB, passDB);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            int id;
            while(rs.next()){
               id = rs.getInt("id");
               idList.add(id);
               }
           } catch(SQLException ex){
            ex.printStackTrace();
        }
        return idList;
    }
    public boolean check_id(int id){
        ArrayList<Integer> list = idList();
        for(int i = 0; i<list.size();i++){
            if(list.get(i).equals(id)){
                return false;
            }
        }
        return true;
    }
    public long countTotalPrice(int id){
        long count = 0;
        String query = "Select import_detail.amount, medicine.price_per_unit from public.import_detail inner join public.medicine \n" +"on import_detail.medicine_id = medicine.id where import_id = " + id;
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, unameDB, passDB);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
               count = count + (rs.getLong("price_per_unit")*rs.getInt("amount"));
               }
           } catch(SQLException ex){
            ex.printStackTrace();
        }
        return count;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        tf_medicine_id = new javax.swing.JTextField();
        tf_type = new javax.swing.JTextField();
        tf_producer = new javax.swing.JTextField();
        tf_price_per_unit = new javax.swing.JTextField();
        tf_quantity = new javax.swing.JTextField();
        tf_import = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        draft_table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        bt_add = new javax.swing.JButton();
        bt_remove = new javax.swing.JButton();
        rbt_old = new javax.swing.JRadioButton();
        rbt_new = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_name = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Import");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_medicine_id.setText("Medicine ID");
        tf_medicine_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_medicine_idFocusGained(evt);
            }
        });
        jPanel1.add(tf_medicine_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 220, -1));

        tf_type.setText("Type ");
        tf_type.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_typeFocusGained(evt);
            }
        });
        jPanel1.add(tf_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 220, -1));

        tf_producer.setText("Producer");
        tf_producer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_producerFocusGained(evt);
            }
        });
        jPanel1.add(tf_producer, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 220, -1));

        tf_price_per_unit.setText("Price Per Unit");
        tf_price_per_unit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_price_per_unitFocusGained(evt);
            }
        });
        jPanel1.add(tf_price_per_unit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 220, -1));

        tf_quantity.setText("Quantity");
        tf_quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_quantityFocusGained(evt);
            }
        });
        jPanel1.add(tf_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 220, -1));

        tf_import.setText("Import");
        tf_import.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_importMouseClicked(evt);
            }
        });
        jPanel1.add(tf_import, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 490, 80, -1));

        draft_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine ID", "Medicine Name", "Type", "Producer", "Quantity", "Price Per Unit", "Old or New"
            }
        ));
        jScrollPane1.setViewportView(draft_table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 560, 370));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 270, 340));

        bt_add.setText("ADD");
        bt_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_addMouseClicked(evt);
            }
        });
        jPanel1.add(bt_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 80, -1));

        bt_remove.setText("REMOVE");
        bt_remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_removeMouseClicked(evt);
            }
        });
        jPanel1.add(bt_remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, 80, -1));

        buttonGroup1.add(rbt_old);
        rbt_old.setText("Old");
        jPanel1.add(rbt_old, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, 50, -1));

        buttonGroup1.add(rbt_new);
        rbt_new.setText("New");
        jPanel1.add(rbt_new, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screens/icon/user.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 30, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screens/icon/quantity.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 30, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screens/icon/medicine.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 30, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screens/icon/user.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 30, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screens/icon/price-tag.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 30, 40));

        tf_name.setText("Name");
        tf_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_nameFocusGained(evt);
            }
        });
        jPanel1.add(tf_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 220, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screens/icon/id.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_medicine_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_medicine_idFocusGained
        tf_medicine_id.setText("");
    }//GEN-LAST:event_tf_medicine_idFocusGained

    private void tf_typeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_typeFocusGained
        tf_type.setText("");
    }//GEN-LAST:event_tf_typeFocusGained

    private void tf_producerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_producerFocusGained
        tf_producer.setText("");
    }//GEN-LAST:event_tf_producerFocusGained

    private void tf_price_per_unitFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_price_per_unitFocusGained
        tf_price_per_unit.setText("");
    }//GEN-LAST:event_tf_price_per_unitFocusGained

    private void tf_quantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_quantityFocusGained
        tf_quantity.setText("");
    }//GEN-LAST:event_tf_quantityFocusGained

    private void bt_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_addMouseClicked
        if(rbt_new.isSelected()){
            //make sure all textfield is filled
            if((!tf_name.getText().equals("")) && (!tf_name.getText().equals("Name")) 
                && (!tf_type.getText().equals("")) && (!tf_type.getText().equals("Type")) && (!tf_producer.getText().equals("")) && (!tf_producer.getText().equals("Producer")) 
                && (!tf_quantity.getText().equals("")) && (!tf_quantity.getText().equals("Quantity")) && (!tf_medicine_id.getText().equals("")) 
                && (!tf_medicine_id.getText().equals("Medicine ID")) && (!tf_price_per_unit.getText().equals(""))  && (!tf_price_per_unit.getText().equals("Price Per Unit"))){
               show_newMedicine();
            }else{
                JOptionPane.showMessageDialog(null, "Please fill all blank space");
            }
        }
        if(rbt_old.isSelected()){
            if((!tf_medicine_id.getText().equals("")) && (!tf_medicine_id.getText().equals("Medicine ID")) 
                && (!tf_quantity.getText().equals(""))  && (!tf_quantity.getText().equals("Quantity"))){
               show_oldMedicine();
            }else{
                JOptionPane.showMessageDialog(null, "Please fill all blank space");
            }
        }
    }//GEN-LAST:event_bt_addMouseClicked

    private void tf_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_nameFocusGained
        tf_name.setText("");
    }//GEN-LAST:event_tf_nameFocusGained

    private void bt_removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_removeMouseClicked
        ((DefaultTableModel)draft_table.getModel()).removeRow(draft_table.getSelectedRow());
    }//GEN-LAST:event_bt_removeMouseClicked

    private void tf_importMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_importMouseClicked
        for(int i = 0; i < draft_table.getRowCount();i++){
            if(draft_table.getValueAt(i, 6).equals("new") && check_id(Integer.valueOf(draft_table.getValueAt(i, 0).toString()))){
                try{
                Class.forName("org.postgresql.Driver");
                }catch (ClassNotFoundException ex){
                    ex.printStackTrace();
                }
                try{
                    Connection con = DriverManager.getConnection(url, unameDB, passDB);             
                    // Add new patient query
                    String newMedicine_query = "INSERT INTO public.medicine(\n" +"	id, name, type_of_medicine, producer, price_per_unit, amount)\n" +"	VALUES (?, ?, ?, ?, ?, ?);";
                    PreparedStatement newMedicine_pst = con.prepareStatement(newMedicine_query);
                    newMedicine_pst.setInt(1, Integer.valueOf(draft_table.getValueAt(i, 0).toString()));
                    newMedicine_pst.setString(2, draft_table.getValueAt(i, 1).toString());
                    newMedicine_pst.setString(3, draft_table.getValueAt(i, 2).toString());
                    newMedicine_pst.setString(4, draft_table.getValueAt(i, 3).toString());
                    newMedicine_pst.setLong(5, Long.valueOf(draft_table.getValueAt(i, 5).toString()));
                    newMedicine_pst.setInt(6, Integer.valueOf(draft_table.getValueAt(i, 4).toString()));
                    newMedicine_pst.executeUpdate();
                    String import_query = "INSERT INTO public.import_detail(\n" +"	import_id, medicine_id, amount)\n" +"	VALUES (?, ?, ?);";
                    PreparedStatement import_pst = con.prepareStatement(import_query);
                    import_pst.setInt(1, countImport() + 1);
                    import_pst.setInt(2, Integer.valueOf(draft_table.getValueAt(i, 0).toString()));
                    import_pst.setInt(3, Integer.valueOf(draft_table.getValueAt(i, 4).toString()));
                    import_pst.executeUpdate();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error Something Go Wrong");
                }
            }
            else if(draft_table.getValueAt(i, 6).equals("old") && !draft_table.getValueAt(i, 1).equals("")){
                try{
                Class.forName("org.postgresql.Driver");
                }catch (ClassNotFoundException ex){
                    ex.printStackTrace();
                }
                try{
                    Connection con = DriverManager.getConnection(url, unameDB, passDB);             
                    // Add new patient query
                    String oldMedicine_query = "UPDATE public.medicine\n" +"	SET amount=?\n" +"	WHERE id = ?;";
                    PreparedStatement oldMedicine_pst = con.prepareStatement(oldMedicine_query);
                    oldMedicine_pst.setInt(1, getAmount(Integer.valueOf(draft_table.getValueAt(i, 0).toString())) + Integer.valueOf(draft_table.getValueAt(i, 4).toString()));
                    oldMedicine_pst.setInt(2, Integer.valueOf(draft_table.getValueAt(i, 0).toString()));
                    oldMedicine_pst.executeUpdate();
                    String import_query = "INSERT INTO public.import_detail(\n" +"	import_id, medicine_id, amount)\n" +"	VALUES (?, ?, ?);";
                    PreparedStatement import_pst = con.prepareStatement(import_query);
                    import_pst.setInt(1, countImport() + 1);
                    import_pst.setInt(2, Integer.valueOf(draft_table.getValueAt(i, 0).toString()));
                    import_pst.setInt(3, Integer.valueOf(draft_table.getValueAt(i, 4).toString()));
                    import_pst.executeUpdate();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error Something Go Wrong");
                } 
            }
            else {
                JOptionPane.showMessageDialog(null, "Error Something Go Wrong");
            }
        }
            //Convert uitlDate to sqlDate for storing
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
             try{
                Class.forName("org.postgresql.Driver");
                }catch (ClassNotFoundException ex){
                    ex.printStackTrace();
                }
                try{
                    Connection con = DriverManager.getConnection(url, unameDB, passDB);             
                    // Add new patient query
                    String import_query = "INSERT INTO public.import(\n" +"	id, total_price, import_date)\n" +"	VALUES (?, ?, ?);";
                    PreparedStatement import_pst = con.prepareStatement(import_query);
                    import_pst.setInt(1, countImport() + 1);
                    import_pst.setLong(2, countTotalPrice(countImport() + 1));
                    import_pst.setDate(3, sqlDate);
                    import_pst.executeUpdate();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error Something Go Wrong");
                    ex.printStackTrace();
                } 
        JOptionPane.showMessageDialog(null, "Import Finish");
    }//GEN-LAST:event_tf_importMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add;
    private javax.swing.JButton bt_remove;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable draft_table;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton rbt_new;
    private javax.swing.JRadioButton rbt_old;
    private javax.swing.JButton tf_import;
    private javax.swing.JTextField tf_medicine_id;
    private javax.swing.JTextField tf_name;
    private javax.swing.JTextField tf_price_per_unit;
    private javax.swing.JTextField tf_producer;
    private javax.swing.JTextField tf_quantity;
    private javax.swing.JTextField tf_type;
    // End of variables declaration//GEN-END:variables
}
