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
public class Service_Bill_Model {
     private int id;
    private String medicinename;
    private long priceperunit,totalprice;
    private Timestamp timestamp;
    
    public Service_Bill_Model(int id,Timestamp timestamp,long totalprice, String medicinename, long priceperunit ){
        this.id = id;
        this.medicinename = medicinename;
        this.priceperunit = priceperunit;
        this.totalprice = totalprice;
        this.timestamp = timestamp ;
    }    
    public int getid() {
        return id;
    }
    public String getmedicinename() {
        return medicinename;
    }
    public long getpriceperunit() {
        return priceperunit;
    }
    public long gettotalprice() {
        return totalprice;
    }
    public Timestamp  gettimestamp () {
        return timestamp ;
    } 
}
