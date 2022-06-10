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
public class Doctor_Patient_Form extends javax.swing.JInternalFrame {
    static String url = "jdbc:postgresql://localhost:5432/clinic_manage";
    static String unameDB = "postgres";
    static String passDB = "123456";
    static String query = "select * from patient";
    /**
     * Creates new form Doctor_Patient_Form
     */
    public Doctor_Patient_Form() {
        initComponents();
        show_Patients();
    }
    
    public ArrayList<Patient_Model> patientList(){
        ArrayList<Patient_Model> patientsList = new ArrayList<>();
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
               patients = new Patient_Model(rs.getInt("patient_id"), rs.getString("patient_full_name"),rs.getString("address"),rs.getString("email"),rs.getString("phone_number"),rs.getString("gender"),rs.getInt("age"));
               patientsList.add(patients);
               }
           } catch(SQLException ex){
            ex.printStackTrace();
        }
        return patientsList;
    }
    
    public void show_Patients(){
        ArrayList<Patient_Model> list = patientList();
        DefaultTableModel model = (DefaultTableModel)patient_table.getModel();
        Object[] row = new Object[7];
        for(int i = 0; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getfullname();
            row[2] = list.get(i).getaddress();
            row[3] = list.get(i).getemail();
            row[4] = list.get(i).getphonenumber();
            row[5] = list.get(i).getgender();
            row[6] = list.get(i).getage();
            model.addRow(row);
        }
    }
    
    public ArrayList<Patient_Model> searchList(String search){
        ArrayList<Patient_Model> searchsList = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, unameDB, passDB);
            String search_query = "select * from patient where patient_full_name like " + search;
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(search_query);
            Patient_Model patients;
            while(rs.next()){
               patients = new Patient_Model(rs.getInt("patient_id"), rs.getString("patient_full_name"),rs.getString("address"),rs.getString("email"),rs.getString("phone_number"),rs.getString("gender"),rs.getInt("age"));
               searchsList.add(patients);
               }
           } catch(SQLException ex){
            ex.printStackTrace();
        }
        return searchsList;
    }
    
    public void show_searchPatients(){
        String search = "'%" + tf_search.getText() + "%'";
        ArrayList<Patient_Model> list = searchList(search);
        DefaultTableModel model = (DefaultTableModel)patient_table.getModel();
        Object[] row = new Object[7];
        for(int i = 0; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getfullname();
            row[2] = list.get(i).getaddress();
            row[3] = list.get(i).getemail();
            row[4] = list.get(i).getphonenumber();
            row[5] = list.get(i).getgender();
            row[6] = list.get(i).getage();
            model.addRow(row);
        }
    }
    
    // clear data in table 
     public void clear_Patients(){
        DefaultTableModel model = (DefaultTableModel)patient_table.getModel();
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
        patient_table = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Patients");

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

        patient_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Full Name", "Address", "Email", "Phone Number", "Gender", "Age"
            }
        ));
        jScrollPane1.setViewportView(patient_table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 850, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_searchFocusGained
        tf_search.setText("");
    }//GEN-LAST:event_tf_searchFocusGained

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if(!tf_search.getText().equals("") && !tf_search.getText().equals("Search...")){
           clear_Patients();
           show_searchPatients(); 
        }
        else{
            JOptionPane.showMessageDialog(null, "Please fill all search space");
        }
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable patient_table;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables
}
