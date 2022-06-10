/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.Timestamp;
/**
 *
 * @author Tan Hoang-Pride
 */
public class Appointment_Model {
    private int patient_id,doctor_id; 
    private Timestamp timestamp;
    private String patient_name,doctor_name,note;
    
    public Appointment_Model(Timestamp timestamp,int patient_id, String  patient_name,int doctor_id,String  doctor_name,String  note){
        this.timestamp = timestamp;
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.note = note;
    }
    
    public Timestamp gettimestamp() {
        return timestamp;
    }
    public String getpatient_name() {
        return patient_name;
    }
     public String getdoctor_name() {
        return doctor_name;
    }
      public String getnote() {
        return note;
    }
    public int getpatient_id() {
        return patient_id;
    }
    public int getdoctor_id() {
        return doctor_id;
    }
}
