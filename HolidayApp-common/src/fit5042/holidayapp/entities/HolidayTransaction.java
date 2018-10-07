/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A class of transactions created by publics
 * @author fengcilin
 */
@Entity
@NamedQueries({@NamedQuery(name = HolidayTransaction.FIND_ALL, query = "SELECT t FROM HolidayTransaction t"),
@NamedQuery(name = HolidayTransaction.FIND_BY_CONDITION, query = "SELECT t FROM HolidayTransaction t WHERE t.customer.userId=:uid AND (t.transactionNo=:id OR t.name LIKE :name OR t.type=:type)"),
})
@XmlRootElement
public class HolidayTransaction implements Serializable{
    public final static String FIND_ALL = "Transaction.findAll";
    public final static String FIND_BY_CONDITION = "Transaction.findByCondition";
    private int transactionNo;
    private String name;
    private HolidayPublic customer;
    private String description;
    private TransactionStatus status;
    private TransactionType ttype;
    private Product product;

    public HolidayTransaction() {
    }

    public HolidayTransaction(int transactionNo, String name, HolidayPublic customer, String description, TransactionType type, Product product) {
        this.transactionNo = transactionNo;
        this.name = name;
        this.customer = customer;
        this.description = description;
        this.status = TransactionStatus.Created;
        this.ttype = type;
        this.product = product;
    }

    
    /**
     * Unique ID number of a transaction
     * @return 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(int transactionNo) {
        this.transactionNo = transactionNo;
    }

    /**
     * Name of the transaction.
     * @return 
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    
    /**
     * The public creating the transaction.
     * @return 
     */
    @ManyToOne
    @JoinColumn(name = "public_id", nullable= false)
    public HolidayPublic getCustomer() {
        return customer;
    }

    public void setCustomer(HolidayPublic customer) {
        this.customer = customer;
    }

    /**
     * The description of the transaction.
     * @return 
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * The status of the transaction.
     * @return 
     */
    @Enumerated(EnumType.STRING)
    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    /**
     * The type of the transaction.
     * @return 
     */
    @Enumerated(EnumType.STRING)
    @Column(name="TRANSACTIONTYPE")
    public TransactionType getType() {
        return ttype;
    }

    public void setType(TransactionType type) {
        this.ttype = type;
    }
    
    /**
     * The booking product in the transaction.
     * @return 
     */
    @ManyToOne
    @JoinColumn(name = "product_id", nullable= false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    
    
}
