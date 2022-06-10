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
public class Doctor_OnCall_Form extends javax.swing.JInternalFrame {
    static String url = "jdbc:postgresql://localhost:5432/clinic_manage";
    static String unameDB = "postgres";
    static String passDB = "123456";
    /**
     * Creates new form Doctor_OnCall_Form
     */
    public Doctor_OnCall_Form() {
        initComponents();
        show_Appointments();
    }
    public ArrayList<Appointment_Model> appointmentList(){
        String query = "Select appointment.appointment_datetime,patient.patient_full_name,employee.full_name,appointment.note,patient.patient_id,employee.id\n" +
"from public.appointment inner join public.patient \n" +
"on appointment.patient_id = patient.patient_id inner join public.employee \n" +
"on appointment.doctor_id = employee.id order by appointment.appointment_datetime desc;";
        ArrayList<Appointment_Model> appointmentsList = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, unameDB, passDB);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            Appointment_Model appointments;
            while(rs.next()){
               appointments = new Appointment_Model(rs.getTimestamp("appointment_datetime"),rs.getInt("patient_id"), rs.getString("patient_full_name"),rs.getInt("id"),rs.getString("full_name"),rs.getString("note"));
               appointmentsList.add(appointments);
               }
           } catch(SQLException ex){
            ex.printStackTrace();
        }
        return appointmentsList;
    }
    
    public void show_Appointments(){
        ArrayList<Appointment_Model> list = appointmentList();
        DefaultTableModel model = (DefaultTableModel)appointment_table.getModel();
        Object[] row = new Object[6];
        for(int i = 0; i < list.size();i++){
            row[0] = list.get(i).gettimestamp();
            row[1] = list.get(i).getpatient_id();
            row[2] = list.get(i).getpatient_name();
            row[3] = list.get(i).getdoctor_id();
            row[4] = list.get(i).getdoctor_name();
            row[5] = list.get(i).getnote();
            model.addRow(row);
        }
    }
     public ArrayList<Appointment_Model> searchList(String search){
        ArrayList<Appointment_Model> searchsList = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, unameDB, passDB);
            String search_query = "Select appointment.appointment_datetime,patient.patient_full_name,employee.full_name,appointment.note,patient.patient_id,employee.id\n" +
"from public.appointment inner join public.patient \n" +
"on appointment.patient_id = patient.patient_id inner join public.employee \n" +
"on appointment.doctor_id = employee.id where employee.full_name like " + search + "order by appointment.appointment_datetime desc";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(search_query);
            Appointment_Model appointments;
            while(rs.next()){
               appointments = new Appointment_Model(rs.getTimestamp("appointment_datetime"),rs.getInt("patient_id"), rs.getString("patient_full_name"),rs.getInt("id"),rs.getString("full_name"),rs.getString("note"));
               searchsList.add(appointments);
               }
           } catch(SQLException ex){
            ex.printStackTrace();
        }
        return searchsList;
    }
    
    public void show_searchAppointments(){
        String search = "'%" + tf_search.getText() + "%'";
        ArrayList<Appointment_Model> list = searchList(search);
        DefaultTableModel model = (DefaultTableModel)appointment_table.getModel();
         Object[] row = new Object[6];
        for(int i = 0; i < list.size();i++){
            row[0] = list.get(i).gettimestamp();
            row[1] = list.get(i).getpatient_id();
            row[2] = list.get(i).getpatient_name();
            row[3] = list.get(i).getdoctor_id();
            row[4] = list.get(i).getdoctor_name();
            row[5] = list.get(i).getnote();
            model.addRow(row);
        }
    }
    // clear data in table 
     public void clear_Appointments(){
        DefaultTableModel model = (DefaultTableModel)appointment_table.getModel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        appointment_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("On-Call Schedule");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appointment_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DateTime", "Patient ID", "Patient Name", "Doctor ID", "Doctor Name", "Note"
            }
        ));
        jScrollPane1.setViewportView(appointment_table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 850, 460));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screens/icon/search.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 30, 30));

        tf_search.setText("Search...");
        tf_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_searchFocusGained(evt);
            }
        });
        jPanel1.add(tf_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 267, 30));

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

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if(!tf_search.getText().equals("") && !tf_search.getText().equals("Search...")){
            clear_Appointments();
            show_searchAppointments();
        }
        else{
            JOptionPane.showMessageDialog(null, "Please fill all search space");
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void tf_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_searchFocusGained
        tf_search.setText("");
    }//GEN-LAST:event_tf_searchFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable appointment_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables
}
