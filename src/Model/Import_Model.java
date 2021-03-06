/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Tan Hoang-Pride
 */
public class Import_Model {
    private int id,amount;
    private String medicinename;
    private long priceperunit,totalprice;
    private Date date;
    
    public Import_Model(int id,Date date,long totalprice, String medicinename, long priceperunit, int amount ){
        this.id = id;
        this.medicinename = medicinename;
        this.priceperunit = priceperunit;
        this.totalprice = totalprice;
        this.amount = amount;
        this.date = date;
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
    public int getamount() {
        return amount;
    }
    public Date getdate() {
        return date;
    } 
}
