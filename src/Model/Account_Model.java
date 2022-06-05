/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tan Hoang-Pride
 */
public class Account_Model {
    private String username,password,typeofjob;
    
    public Account_Model(String username, String password, String typeofjob){
        this.username = username;
        this.password= password;
        this.typeofjob = typeofjob;
    }
    
    public String getusername() {
        return username;
    }
    public String getpassword() {
        return password;
    }
    public String gettypeofjob() {
        return typeofjob;
    } 
}
