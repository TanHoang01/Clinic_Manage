/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tan Hoang-Pride
 */
public class Employee_Model {
    private int id,accountid;
    private String typeofjob,fullname,address,email,phonenumber,username,password;
    private long salary;
    
    public Employee_Model(int id,String typeofjob, String fullname, String address, String email, String phonenumber, long salary, int accountid, String username, String password){
        this.id = id;
        this.typeofjob = typeofjob;
        this.fullname = fullname;
        this.address = address;
        this.email = email;
        this.phonenumber = phonenumber;
        this.salary = salary;
        this.accountid = accountid;
        this.username = username;
        this.password = password;
    }
    
    public int getid() {
        return id;
    }
    public String gettypeofjob() {
        return typeofjob;
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
     public long getsalary() {
        return salary;
    }
    public int getacountid() {
        return accountid;
    } 
    public String getusername() {
        return username;
    }
      public String getpassword() {
        return password;
    } 
}
