/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Screens;
import Model.*;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
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
public class Doctor_Diagnosis_Form extends javax.swing.JInternalFrame {
    static String url = "jdbc:postgresql://localhost:5432/clinic_manage";
    static String unameDB = "postgres";
    static String passDB = "123456";
    /**
     * Creates new form Doctor_Diagnosis_Form
     */
    public Doctor_Diagnosis_Form() {
        initComponents();
        show_Medicines();
        show_Services();
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
        Object[] row = new Object[2];
        for(int i = 0; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getname();
            model.addRow(row);
        }
    }
     public ArrayList<Service_Model> serviceList(){
        String query = "select * from service";
        ArrayList<Service_Model> servicesList = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, unameDB, passDB);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            Service_Model services;
            while(rs.next()){
               services = new Service_Model(rs.getInt("id"), rs.getString("name"),rs.getLong("price"));
               servicesList.add(services);
               }
           } catch(SQLException ex){
            ex.printStackTrace();
        }
        return servicesList;
    }
    
    public void show_Services(){
        ArrayList<Service_Model> list = serviceList();
        DefaultTableModel model = (DefaultTableModel) service_table.getModel();
        Object[] row = new Object[2];
        for(int i = 0; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getname();
            model.addRow(row);
        }
    }
    public Medicine_Model draftMedicine(){
        int selected = medicine_table.getSelectedRow();
        Medicine_Model medicines;
        medicines = new Medicine_Model(Integer.valueOf(medicine_table.getValueAt(selected, 0).toString()),medicine_table.getValueAt(selected, 1).toString(),"",
                "",1000,0);
        return medicines;
    }
    
    public void show_draftMedicine(){
        Medicine_Model medicine = draftMedicine();
        DefaultTableModel model = (DefaultTableModel)draft_medicine_table.getModel();
        Object[] row = new Object[3];
        row[0] = medicine.getid();
        row[1] = medicine.getname();
        row[2] = tf_amount.getText();
        model.addRow(row);
    }
    public Service_Model draftService(){
        int selected = service_table.getSelectedRow();
        Service_Model services;
        services = new Service_Model(Integer.valueOf(service_table.getValueAt(selected, 0).toString()),service_table.getValueAt(selected, 1).toString(),1000);
        return services;
    }
    
    public void show_draftService(){
        Service_Model services = draftService();
        DefaultTableModel model = (DefaultTableModel)draft_service_table.getModel();
        Object[] row = new Object[3];
        row[0] = services.getid();
        row[1] = services.getname();
        model.addRow(row);
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
        tf_note = new javax.swing.JTextField();
        tf_diagnosis = new javax.swing.JTextField();
        tf_amount = new javax.swing.JTextField();
        tf = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        draft_service_table = new javax.swing.JTable();
        tf_doctorname = new javax.swing.JTextField();
        tf_patientname = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        draft_medicine_table = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        medicine_table = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        service_table = new javax.swing.JTable();
        bt_add_medicine = new javax.swing.JButton();
        bt_remove_medicine = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bt_finish = new javax.swing.JButton();
        bt_print = new javax.swing.JButton();
        bt_clear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tp_diagnosis = new javax.swing.JTextPane();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Diagnosis");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_note.setText("Note");
        tf_note.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_noteFocusGained(evt);
            }
        });
        jPanel1.add(tf_note, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 250, 40));

        tf_diagnosis.setText("Diagnosis");
        tf_diagnosis.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_diagnosisFocusGained(evt);
            }
        });
        jPanel1.add(tf_diagnosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 250, 40));

        tf_amount.setText("Amount");
        tf_amount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_amountFocusGained(evt);
            }
        });
        jPanel1.add(tf_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 60, -1));

        tf.setText("REMOVE");
        tf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfMouseClicked(evt);
            }
        });
        jPanel1.add(tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, -1, -1));

        jButton2.setText("ADD");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 80, -1));

        draft_service_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Service Name"
            }
        ));
        jScrollPane8.setViewportView(draft_service_table);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 250, 240));

        tf_doctorname.setText("Doctor Name");
        tf_doctorname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_doctornameFocusGained(evt);
            }
        });
        jPanel1.add(tf_doctorname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 90, -1));

        tf_patientname.setText("Patient Name");
        tf_patientname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_patientnameFocusGained(evt);
            }
        });
        jPanel1.add(tf_patientname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 90, -1));

        draft_medicine_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Medicine Name", "Amount"
            }
        ));
        jScrollPane9.setViewportView(draft_medicine_table);

        jPanel1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 250, 240));

        medicine_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Medicine Name"
            }
        ));
        jScrollPane10.setViewportView(medicine_table);

        jPanel1.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 250, 240));

        service_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Service Name"
            }
        ));
        jScrollPane11.setViewportView(service_table);

        jPanel1.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 250, 240));

        bt_add_medicine.setText("ADD");
        bt_add_medicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_add_medicineMouseClicked(evt);
            }
        });
        jPanel1.add(bt_add_medicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 80, -1));

        bt_remove_medicine.setText("REMOVE");
        bt_remove_medicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_remove_medicineMouseClicked(evt);
            }
        });
        jPanel1.add(bt_remove_medicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screens/icon/user.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 30, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screens/icon/user.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        bt_finish.setText("Finish");
        bt_finish.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_finishMouseClicked(evt);
            }
        });
        jPanel1.add(bt_finish, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 80, -1));

        bt_print.setText("Print");
        bt_print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_printMouseClicked(evt);
            }
        });
        jPanel1.add(bt_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 80, -1));

        bt_clear.setText("Clear");
        bt_clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_clearMouseClicked(evt);
            }
        });
        jPanel1.add(bt_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 80, -1));

        tp_diagnosis.setEditable(false);
        jScrollPane2.setViewportView(tp_diagnosis);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 250, 340));

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

    private void tf_patientnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_patientnameFocusGained
        tf_patientname.setText("");
    }//GEN-LAST:event_tf_patientnameFocusGained

    private void tf_doctornameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_doctornameFocusGained
        tf_doctorname.setText("");
    }//GEN-LAST:event_tf_doctornameFocusGained

    private void tf_diagnosisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_diagnosisFocusGained
        tf_diagnosis.setText("");
    }//GEN-LAST:event_tf_diagnosisFocusGained

    private void tf_noteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_noteFocusGained
        tf_note.setText("");
    }//GEN-LAST:event_tf_noteFocusGained

    private void tf_amountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_amountFocusGained
        tf_amount.setText("");
    }//GEN-LAST:event_tf_amountFocusGained

    private void bt_add_medicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_add_medicineMouseClicked
        if(!tf_amount.getText().equals("") && !tf_amount.getText().equals("Amount")){
            show_draftMedicine();
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Fill Amount");
        }
    }//GEN-LAST:event_bt_add_medicineMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        show_draftService();    
    }//GEN-LAST:event_jButton2MouseClicked

    private void bt_remove_medicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_remove_medicineMouseClicked
        ((DefaultTableModel)draft_medicine_table.getModel()).removeRow(draft_medicine_table.getSelectedRow());
    }//GEN-LAST:event_bt_remove_medicineMouseClicked

    private void tfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfMouseClicked
        ((DefaultTableModel)draft_service_table.getModel()).removeRow(draft_service_table.getSelectedRow());
    }//GEN-LAST:event_tfMouseClicked

    private void bt_finishMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_finishMouseClicked
        java.util.Date utilDate = new java.util.Date();
        tp_diagnosis.setText("                         "+"M Y C L I N I C\n");
        tp_diagnosis.setText(tp_diagnosis.getText()+"                            "+"Diagnosis\n");
        tp_diagnosis.setText(tp_diagnosis.getText()+"           "+utilDate+"\n"+" "+"\n");
        tp_diagnosis.setText(tp_diagnosis.getText()+"Patient Name: "+tf_patientname.getText()+"\n"+" "+"\n");
        tp_diagnosis.setText(tp_diagnosis.getText()+"Doctor Name: "+tf_doctorname.getText()+"\n"+" "+"\n");
        tp_diagnosis.setText(tp_diagnosis.getText()+"Diagnosis: " +tf_diagnosis.getText()+"\n"+" "+"\n");
        tp_diagnosis.setText(tp_diagnosis.getText()+"Service List: \n");       
        DefaultTableModel service_model = (DefaultTableModel)draft_service_table.getModel();
        for(int i = 0;i<draft_service_table.getRowCount();i++){
            String service = service_model.getValueAt(i, 1).toString();
            tp_diagnosis.setText(tp_diagnosis.getText()+(i+1)+". " + service +"\n");
        }
        tp_diagnosis.setText(tp_diagnosis.getText()+ " "+"\n");    
        tp_diagnosis.setText(tp_diagnosis.getText()+"Medicine List: \n"); 
        DefaultTableModel medicine_model = (DefaultTableModel)draft_medicine_table.getModel();
        for(int i = 0;i<draft_medicine_table.getRowCount();i++){
            String medicine = medicine_model.getValueAt(i, 1).toString() + " -  " + "Amount: " + medicine_model.getValueAt(i, 2).toString();
            tp_diagnosis.setText(tp_diagnosis.getText()+(i+1)+". " + medicine +"\n");
        }
        tp_diagnosis.setText(tp_diagnosis.getText()+"                                                  "+ "Doctor Sign");
    }//GEN-LAST:event_bt_finishMouseClicked

    private void bt_printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_printMouseClicked
        try{
            boolean print = tp_diagnosis.print();
            if(print){
               JOptionPane.showMessageDialog(null, "Print Complete"); 
            }else{
               JOptionPane.showMessageDialog(null, "Print Uncomplete"); 
            }
        }catch(PrinterException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_bt_printMouseClicked

    private void bt_clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_clearMouseClicked
        tp_diagnosis.setText(null);
    }//GEN-LAST:event_bt_clearMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add_medicine;
    private javax.swing.JButton bt_clear;
    private javax.swing.JButton bt_finish;
    private javax.swing.JButton bt_print;
    private javax.swing.JButton bt_remove_medicine;
    private javax.swing.JTable draft_medicine_table;
    private javax.swing.JTable draft_service_table;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable medicine_table;
    private javax.swing.JTable service_table;
    private javax.swing.JButton tf;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_diagnosis;
    private javax.swing.JTextField tf_doctorname;
    private javax.swing.JTextField tf_note;
    private javax.swing.JTextField tf_patientname;
    private javax.swing.JTextPane tp_diagnosis;
    // End of variables declaration//GEN-END:variables
}
