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
public class Admin_Storage_Form extends javax.swing.JInternalFrame {
    static String url = "jdbc:postgresql://localhost:5432/clinic_manage";
    static String unameDB = "postgres";
    static String passDB = "123456";
    /**
     * Creates new form Admin_Storage_Form
     */
    public Admin_Storage_Form() {
        initComponents();
        show_Medicines();
        show_Imports();
    }
     public ArrayList<Medicine_Model> medicineList(){
        String query = "select * from medicine";
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
     public void clear_Medicines(){
        DefaultTableModel model = (DefaultTableModel)medicine_table.getModel();
        model.setRowCount(0);
    }
     public ArrayList<Import_Model> importList(){
        String query = "Select import.id,import.import_date,import.total_price,medicine.name,medicine.price_per_unit,import_detail.amount\n" +
"from public.import_detail inner join public.medicine \n" +
"on import_detail.medicine_id = medicine.id inner join public.import \n" +
"on import_detail.import_id = import.id;";
        ArrayList<Import_Model> importsList = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, unameDB, passDB);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            Import_Model imports;
            while(rs.next()){
               imports = new Import_Model(rs.getInt("id"), rs.getDate("import_date"),rs.getLong("total_price"),rs.getString("name"),rs.getLong("price_per_unit"),rs.getInt("amount"));
               importsList.add(imports);
               }
           } catch(SQLException ex){
            ex.printStackTrace();
        }
        return importsList;
    }
    
    public void show_Imports(){
        ArrayList<Import_Model> list = importList();
        DefaultTableModel model = (DefaultTableModel) import_table.getModel();
        Object[] row = new Object[6];
        for(int i = 0; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getdate();
            row[2] = list.get(i).gettotalprice();
            row[3] = list.get(i).getmedicinename();
            row[4] = list.get(i).getpriceperunit();
            row[5] = list.get(i).getamount();
            model.addRow(row);
        }
    }
     public void clear_Imports(){
        DefaultTableModel model = (DefaultTableModel)import_table.getModel();
        model.setRowCount(0);
    }
    public ArrayList<Medicine_Model> searchStorageList(String search){
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
    
    public void show_searchStorages(){
        String search = "'%" + tf_search.getText() + "%'";
        ArrayList<Medicine_Model> list = searchStorageList(search);
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
     public ArrayList<Import_Model> searchImportList(String search){
        ArrayList<Import_Model> searchsList = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, unameDB, passDB);
            String search_query = "Select import.id,import.import_date,import.total_price,medicine.name,medicine.price_per_unit,import_detail.amount\n" +
"from public.import_detail inner join public.medicine \n" +
"on import_detail.medicine_id = medicine.id inner join public.import \n" +
"on import_detail.import_id = import.id where medicine.name like " + search;
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(search_query);
            Import_Model imports;
            while(rs.next()){
                imports = new Import_Model(rs.getInt("id"), rs.getDate("import_date"),rs.getLong("total_price"),rs.getString("name"),rs.getLong("price_per_unit"),rs.getInt("amount"));
                searchsList.add(imports);
               }
           } catch(SQLException ex){
            ex.printStackTrace();
        }
        return searchsList;
    }
    
    public void show_searchImports(){
        String search = "'%" + tf_search.getText() + "%'";
        ArrayList<Import_Model> list = searchImportList(search);
        DefaultTableModel model = (DefaultTableModel)import_table.getModel();
        Object[] row = new Object[6];
        for(int i = 0; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getdate();
            row[2] = list.get(i).gettotalprice();
            row[3] = list.get(i).getmedicinename();
            row[4] = list.get(i).getpriceperunit();
            row[5] = list.get(i).getamount();
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        tf_search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        import_table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        medicine_table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Medicine Storage");

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

        import_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "Total Price", "Name", "Price Per Unit", "Amount"
            }
        ));
        jScrollPane1.setViewportView(import_table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 410, 440));

        medicine_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Type", "Producer", "Price Per Unit", "Amount"
            }
        ));
        jScrollPane2.setViewportView(medicine_table);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 420, 440));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Import");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 70, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Storage");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, -1));

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

    private void tf_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_searchFocusGained
        tf_search.setText("");
    }//GEN-LAST:event_tf_searchFocusGained

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if(!tf_search.getText().equals("") && !tf_search.getText().equals("Search...")){
           clear_Medicines();
           clear_Imports();
           show_searchStorages(); 
           show_searchImports(); 
        }
        else{
            JOptionPane.showMessageDialog(null, "Please fill all search space");
        }
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable import_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable medicine_table;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables
}
