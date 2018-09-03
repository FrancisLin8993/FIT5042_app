/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author fengcilin
 */
@Entity
@NamedQueries({@NamedQuery(name = HolidayTransaction.FIND_ALL, query = "SELECT t FROM HolidayTransaction t"),
@NamedQuery(name = HolidayTransaction.FIND_BY_NAME, query = "SELECT t FROM HolidayTransaction t WHERE t.name=:name"),
@NamedQuery(name = HolidayTransaction.FIND_BY_TYPE, query = "SELECT t FROM HolidayTransaction t WHERE t.type=:type")
})
public class HolidayTransaction implements Serializable{
    public final static String FIND_ALL = "Transaction.findAll";
    public final static String FIND_BY_NAME = "Transaction.findByName";
    public final static String FIND_BY_ID = "Transaction.findById";
    public final static String FIND_BY_TYPE = "Transaction.findByType";
    private int transactionNo;
    private String name;
    private HolidayPublic customer;
    private String description;
    private TransactionStatus status;
    private TransactionType type;
    private Product product;

    public HolidayTransaction(int transactionNo, String name, HolidayPublic customer, String description, TransactionStatus status, TransactionType type, Product product) {
        this.transactionNo = transactionNo;
        this.name = name;
        this.customer = customer;
        this.description = description;
        this.status = status;
        this.type = type;
        this.product = product;
    }

    


    public HolidayTransaction() {
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



    @ManyToOne(optional = false)
    @JoinColumn(name = "public_id")
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
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    
    
}
