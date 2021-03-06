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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Tan Hoang-Pride
 */
public class Staff_Appointment_Form extends javax.swing.JInternalFrame {
    static String url = "jdbc:postgresql://localhost:5432/clinic_manage";
    static String unameDB = "postgres";
    static String passDB = "123456";
    /**
     * Creates new form Staff_Appointment_Form
     */
    public Staff_Appointment_Form() {
        initComponents();
        show_Appointments();
    }
    public ArrayList<Appointment_Model> appointmentList(){
        String query = "Select appointment.appointment_datetime,patient.patient_full_name,employee.full_name,appointment.note,patient.patient_id,employee.id\n" +
"from public.appointment inner join public.patient \n" +
"on appointment.patient_id = patient.patient_id inner join public.employee \n" +
"on appointment.doctor_id = employee.id;";
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
        tf_timestamp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf_patientid = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bt_add = new javax.swing.JButton();
        bt_update = new javax.swing.JButton();
        bt_remove = new javax.swing.JButton();
        tf_note = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tf_doctorid = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Appointment Schehule");

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 830, 410));

        tf_timestamp.setText("Appontment DateTime");
        tf_timestamp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_timestampFocusGained(evt);
            }
        });
        jPanel1.add(tf_timestamp, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 210, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screens/icon/notes.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 30, 40));

        tf_patientid.setText("Patient ID");
        tf_patientid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_patientidFocusGained(evt);
            }
        });
        jPanel1.add(tf_patientid, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 210, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screens/icon/id.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 30, 40));

        jLabel1.setText("Example: 2014-04-04 10:10");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        jLabel2.setText("Format: Year-Month-Day Hour:Minute");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));

        bt_add.setText("ADD");
        bt_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_addMouseClicked(evt);
            }
        });
        jPanel1.add(bt_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 80, -1));

        bt_update.setText("UPDATE");
        bt_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_updateMouseClicked(evt);
            }
        });
        jPanel1.add(bt_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 50, -1, -1));

        bt_remove.setText("REMOVE");
        bt_remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_removeMouseClicked(evt);
            }
        });
        jPanel1.add(bt_remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, -1, -1));

        tf_note.setText("Note");
        tf_note.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_noteFocusGained(evt);
            }
        });
        jPanel1.add(tf_note, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 270, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screens/icon/clock.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 30, 40));

        tf_doctorid.setText("Doctor ID");
        tf_doctorid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_doctoridFocusGained(evt);
            }
        });
        jPanel1.add(tf_doctorid, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 210, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screens/icon/id.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 30, 40));

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

    private void tf_patientidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_patientidFocusGained
        tf_patientid.setText("");
    }//GEN-LAST:event_tf_patientidFocusGained

    private void tf_timestampFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_timestampFocusGained
        tf_timestamp.setText("");
    }//GEN-LAST:event_tf_timestampFocusGained

    private void tf_noteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_noteFocusGained
        tf_note.setText("");
    }//GEN-LAST:event_tf_noteFocusGained

    private void bt_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_addMouseClicked
        if((!tf_patientid.getText().equals("")) && (!tf_patientid.getText().equals("Patient ID")) && (!tf_timestamp.getText().equals("")) 
            && (!tf_timestamp.getText().equals("Appontment DateTime")) && (!tf_doctorid.getText().equals("")) 
            && (!tf_doctorid.getText().equals("Doctor ID"))){
            try{
                Class.forName("org.postgresql.Driver");
            }catch (ClassNotFoundException ex){
                ex.printStackTrace();
            }
            try{
                Connection con = DriverManager.getConnection(url, unameDB, passDB);             
                // Add new patient query
                String appointment_query = "INSERT INTO public.appointment(\n" +"	appointment_datetime, patient_id, doctor_id, note)\n" +"	VALUES (?, ?, ?, ?);";
                PreparedStatement appointment_pst = con.prepareStatement(appointment_query);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                    Date parsedDate = dateFormat.parse(tf_timestamp.getText());
                    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
                    appointment_pst.setTimestamp(1, timestamp);
                } catch(Exception e) { //this generic but you can control another types of exception
                    e.printStackTrace();
                }
                appointment_pst.setInt(2, Integer.valueOf(tf_patientid.getText()));
                appointment_pst.setInt(3, Integer.valueOf(tf_doctorid.getText()));
                appointment_pst.setString(4, tf_note.getText());
                appointment_pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Add Appointment Successfully");
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error Something Go Wrong");
                ex.printStackTrace();
            }          
            clear_Appointments();
            show_Appointments();
        }else{
            JOptionPane.showMessageDialog(null, "Please fill all blank space");
        }
    }//GEN-LAST:event_bt_addMouseClicked

    private void tf_doctoridFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_doctoridFocusGained
        tf_doctorid.setText("");
    }//GEN-LAST:event_tf_doctoridFocusGained

    private void bt_removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_removeMouseClicked
        //get selected row 
        int selected = appointment_table.getSelectedRow();
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to delete this appointment?","Warning",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            try{
                Class.forName("org.postgresql.Driver");
            }catch (ClassNotFoundException ex){
                ex.printStackTrace();
            }
            try{
                    Connection con = DriverManager.getConnection(url, unameDB, passDB);
                    // delete employee query
                    String appointment_query ="DELETE FROM public.appointment\n" +"	WHERE appointment_datetime = ?;";
                    PreparedStatement appointment_pst = con.prepareStatement(appointment_query);
                    appointment_pst.setTimestamp(1, Timestamp.valueOf(appointment_table.getValueAt(selected, 0).toString()));
                    appointment_pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Delete Appointment Successfully");
            }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error Something Go Wrong");
                }
                clear_Appointments();
                show_Appointments();
        }else{
            
        }
    }//GEN-LAST:event_bt_removeMouseClicked

    private void bt_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_updateMouseClicked
        //get selected row 
        int selected = appointment_table.getSelectedRow();
         try{
                Class.forName("org.postgresql.Driver");
            }catch (ClassNotFoundException ex){
                ex.printStackTrace();
            }
            try{
                    Connection con = DriverManager.getConnection(url, unameDB, passDB);             
                    // update account query
                    String appointment_query ="UPDATE public.appointment\n" +"	SET appointment_datetime=?, patient_id=?, doctor_id=?, note=?\n" +"	WHERE appointment_datetime = ?;";
                    PreparedStatement appointment_pst = con.prepareStatement(appointment_query);               
                    appointment_pst.setTimestamp(1, Timestamp.valueOf(appointment_table.getValueAt(selected, 0).toString())); //not work
                    appointment_pst.setInt(2, Integer.valueOf(appointment_table.getValueAt(selected, 1).toString()));
                    appointment_pst.setInt(3, Integer.valueOf(appointment_table.getValueAt(selected, 3).toString()));
                    appointment_pst.setString(4, appointment_table.getValueAt(selected, 5).toString());
                    appointment_pst.setTimestamp(5,Timestamp.valueOf(appointment_table.getValueAt(selected, 0).toString()));
                    appointment_pst.executeUpdate();              
                    JOptionPane.showMessageDialog(null, "Update Appointment Successfully");
            }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error Something Go Wrong");
                    ex.printStackTrace();
                }
                clear_Appointments();
                show_Appointments();
    }//GEN-LAST:event_bt_updateMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable appointment_table;
    private javax.swing.JButton bt_add;
    private javax.swing.JButton bt_remove;
    private javax.swing.JButton bt_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tf_doctorid;
    private javax.swing.JTextField tf_note;
    private javax.swing.JTextField tf_patientid;
    private javax.swing.JTextField tf_timestamp;
    // End of variables declaration//GEN-END:variables
}
