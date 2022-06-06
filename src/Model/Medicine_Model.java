/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tan Hoang-Pride
 */
public class Medicine_Model {
    private int id,amount;
    private String name,typeofmedicine,producer;
    private long priceperunit;
    
    public Medicine_Model(int id,String name, String typeofmedicine, String producer, long priceperunit, int amount){
        this.id = id;
        this.name = name;
        this.typeofmedicine = typeofmedicine;
        this.producer = producer;
        this.priceperunit = priceperunit;
        this.amount = amount;
    }
    
    public int getid() {
        return id;
    }
    public String getname() {
        return name;
    }
    public String gettypeofmedicine() {
        return typeofmedicine;
    }
    public String getproducer() {
        return producer;
    }
     public long getpriceperunit() {
        return priceperunit;
    }
    public int getamount() {
        return amount;
    } 
}
