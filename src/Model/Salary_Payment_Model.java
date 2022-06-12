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
public class Salary_Payment_Model {
     private int id;
    private String employeename;
    private long salary;
    private Date date;
    
    public Salary_Payment_Model(int id,Date date,long salary, String employeename ){
        this.id = id;
        this.date = date;
        this.salary = salary;
        this.employeename = employeename; 
    }    
    public int getid() {
        return id;
    }
    public Date getdate() {
        return date;
    }
    public long getsalary() {
        return salary;
    }
    public String getemployeename() {
        return employeename;
    }
}
