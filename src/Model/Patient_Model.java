/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tan Hoang-Pride
 */
public class Patient_Model {
    private int id,age;
    private String fullname,address,email,phonenumber,gender;
    
    public Patient_Model(int id, String fullname, String address, String email, String phonenumber, String gender, int age){
        this.id = id;
        this.fullname = fullname;
        this.address = address;
        this.email = email;
        this.phonenumber = phonenumber;
        this.gender = gender;
        this.age = age;
    }
    
    public int getid() {
        return id;
    }
    public String getfullname() {
        return fullname;
    }
    public String getaddress() {
        return address;
    }
    public String getemail() {
        return email;
    }
    public String getphonenumber() {
        return phonenumber;
    }
     public String getgender() {
        return gender;
    }
    public int getage() {
        return age;
    } 
}
