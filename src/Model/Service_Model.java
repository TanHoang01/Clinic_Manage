/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tan Hoang-Pride
 */
public class Service_Model {
    private int id;
    private String name;
    private long price;
    
    public Service_Model(int id,String name, long price){
        this.id = id;
        this.name = name;    
        this.price = price;
    }
    
    public int getid() {
        return id;
    }
    public String getname() {
        return name;
    }
     public long getprice() {
        return price;
    }
}
