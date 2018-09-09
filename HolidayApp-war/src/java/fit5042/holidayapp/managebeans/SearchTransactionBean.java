/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.managebeans;

import fit5042.holidayapp.entities.HolidayTransaction;
import fit5042.holidayapp.entities.TransactionType;
import fit5042.holidayapp.management.TransactionManagement;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author fengcilin
 */
@SessionScoped
@Named(value = "searchTransactionBean")
public class SearchTransactionBean implements Serializable{
    
    private String tname;
    private int tno;
    private TransactionType type;
    @EJB
    private TransactionManagement tm;
    private List<HolidayTransaction> transactions;

    public SearchTransactionBean() {
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public TransactionType getType() {
        return type;
    }
    
    public TransactionType[] getTypes(){
        return TransactionType.values();
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public TransactionManagement getTm() {
        return tm;
    }

    public void setTm(TransactionManagement tm) {
        this.tm = tm;
    }

    public List<HolidayTransaction> getTransaction() {
        return transactions;
    }

    public void setTransaction(List<HolidayTransaction> transactions) {
        this.transactions = transactions;
    }
    
    public String searchTransaction(){
        try{
            transactions = tm.findTransactions(tno, tname, type);
        }
        catch(Exception ex){
            Logger.getLogger(SearchTransactionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "transactionsearchresult";
        
    }
    
    
}
