/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author fengcilin
 */
@Entity
public class HolidayTransaction implements Serializable{
    private int transactionNo;
    private String name;
    private String type;
    private HolidayPublic customer;
    private String description;

    public HolidayTransaction() {
    }

    public HolidayTransaction(int transactionNo, String name, String type, HolidayPublic customer, String description) {
        this.transactionNo = transactionNo;
        this.name = name;
        this.type = type;
        this.customer = customer;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(int transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HolidayPublic getCustomer() {
        return customer;
    }

    public void setCustomer(HolidayPublic customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    
}
