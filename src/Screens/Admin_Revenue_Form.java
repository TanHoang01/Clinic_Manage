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
public class Admin_Revenue_Form extends javax.swing.JInternalFrame {
    static String url = "jdbc:postgresql://localhost:5432/clinic_manage";
    static String unameDB = "postgres";
    static String passDB = "123456";
    /**
     * Creates new form Admin_Revenue_Form
     */
    public Admin_Revenue_Form() {
        initComponents();
        show_Imports();
        show_Prescriptions();
        show_Services();
        show_Salarys();
    }
    public ArrayList<Import_Model> importList(){
        String query = "select * from import order by id desc";
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
               imports = new Import_Model(rs.getInt("id"), rs.getDate("import_date"),rs.getLong("total_price"),"",0,0);
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
        Object[] row = new Object[3];
        for(int i = 0; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getdate();
            row[2] = list.get(i).gettotalprice();
            model.addRow(row);
        }
    }
    public ArrayList<Prescription_Bill_Model> prescriptionList(){
        String query = "select prescription_bill.id,prescription_bill.date_time,prescription_bill.total_price,prescription_bill_detail.amount,medicine.name,medicine.price_per_unit \n" +
"from public.prescription_bill_detail \n" +
"inner join public.prescription_bill\n" +
"on prescription_bill.id = prescription_bill_detail.prescription_id\n" +
"inner join public.medicine \n" +
"on prescription_bill_detail.medicine_id = medicine.id order by prescription_bill.id desc";
        ArrayList<Prescription_Bill_Model> prescriptionsList = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, unameDB, passDB);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            Prescription_Bill_Model prescriptions;
            while(rs.next()){
               prescriptions = new Prescription_Bill_Model(rs.getInt("id"), rs.getTimestamp("date_time"),rs.getLong("total_price"),rs.getString("name"),rs.getLong("price_per_unit"),rs.getInt("amount"));
               prescriptionsList.add(prescriptions);
               }
           } catch(SQLException ex){
            ex.printStackTrace();
        }
        return prescriptionsList;
    }
    
    public void show_Prescriptions(){
        ArrayList<Prescription_Bill_Model> list = prescriptionList();
        DefaultTableModel model = (DefaultTableModel) prescription_table.getModel();
        Object[] row = new Object[6];
        for(int i = 0; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).gettimestamp();
            row[2] = list.get(i).gettotalprice();
            row[3] = list.get(i).getmedicinename();
            row[4] = list.get(i).getpriceperunit();
            row[5] = list.get(i).getamount();
            model.addRow(row);
        }
    }
    public ArrayList<Service_Bill_Model> serviceList(){
        String query = "select service_bill.id,service_bill.date_time,service_bill.total_price,service.name,service.price \n" +
"from public.service_bill_detail \n" +
"inner join public.service_bill\n" +
"on service_bill.id = service_bill_detail.service_id\n" +
"inner join public.service\n" +
"on service_bill_detail.service_id = service.id order by service_bill.id desc";
        ArrayList<Service_Bill_Model> servicesList = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, unameDB, passDB);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            Service_Bill_Model services;
            while(rs.next()){
               services = new Service_Bill_Model(rs.getInt("id"), rs.getTimestamp("date_time"),rs.getLong("total_price"),rs.getString("name"),rs.getLong("price"));
               servicesList.add(services);
               }
           } catch(SQLException ex){
            ex.printStackTrace();
        }
        return servicesList;
    }
    
    public void show_Services(){
        ArrayList<Service_Bill_Model> list = serviceList();
        DefaultTableModel model = (DefaultTableModel) service_table.getModel();
        Object[] row = new Object[5];
        for(int i = 0; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).gettimestamp();
            row[2] = list.get(i).gettotalprice();
            row[3] = list.get(i).getmedicinename();
            row[4] = list.get(i).getpriceperunit();
            model.addRow(row);
        }
    }
    public ArrayList<Salary_Payment_Model> salaryList(){
        String query = "select salary_payment.id,salary_payment.date,employee.salary,employee.full_name\n" +
"from public.salary_payment inner join public.employee \n" +
"on salary_payment.employee_id = employee.id order by salary_payment.id desc";
        ArrayList<Salary_Payment_Model> salarysList = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, unameDB, passDB);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            Salary_Payment_Model salarys;
            while(rs.next()){
               salarys = new Salary_Payment_Model(rs.getInt("id"), rs.getDate("date"),rs.getLong("salary"),rs.getString("full_name"));
               salarysList.add(salarys);
               }
           } catch(SQLException ex){
            ex.printStackTrace();
        }
        return salarysList;
    }
    
    public void show_Salarys(){
        ArrayList<Salary_Payment_Model> list = salaryList();
        DefaultTableModel model = (DefaultTableModel) salary_payment_table.getModel();
        Object[] row = new Object[4];
        for(int i = 0; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getdate();
            row[2] = list.get(i).getsalary();
            row[3] = list.get(i).getemployeename();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        salary_payment_table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        service_table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        import_table = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        prescription_table = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Revenue");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salary_payment_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DateTime", "Salary", "Employee Name"
            }
        ));
        jScrollPane1.setViewportView(salary_payment_table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 400, 220));

        service_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DateTime", "Total Price", "Service Name", "Price"
            }
        ));
        jScrollPane2.setViewportView(service_table);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 420, 220));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Outcome (Import BIill + Salary Payment)");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 290, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Imcome (Prescription Bill + Service Biill)");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 280, -1));

        import_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DateTime", "Total Price"
            }
        ));
        jScrollPane3.setViewportView(import_table);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 400, 220));

        prescription_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DateTime", "Total Price", "Medicine Name", "Price Per Unit", "Amount"
            }
        ));
        jScrollPane4.setViewportView(prescription_table);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 420, 220));

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable import_table;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable prescription_table;
    private javax.swing.JTable salary_payment_table;
    private javax.swing.JTable service_table;
    // End of variables declaration//GEN-END:variables
}
