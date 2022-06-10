/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tan Hoang-Pride
 */
public class Import_Detail_Model {
    private int id, amount;
    
    public Import_Detail_Model(int id, int amount){
        this.id = id;
        this.amount = amount;
    }
    
    public int getid() {
        return id;
    }
    public int getamount() {
        return amount;
    }
}
