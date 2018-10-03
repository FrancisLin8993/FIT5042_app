/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.managebeans;

import fit5042.holidayapp.entities.HolidayTransaction;
import fit5042.holidayapp.entities.HolidayUser;
import fit5042.holidayapp.entities.TransactionType;
import fit5042.holidayapp.management.TransactionManagement;
import fit5042.holidayapp.management.UserManagement;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
//import javax.faces.bean.SessionScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
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
    @EJB
    private UserManagement um;
    private HolidayUser currentUser;
    private List<HolidayTransaction> transactionList;

    public SearchTransactionBean() {
    }

    public UserManagement getUm() {
        return um;
    }

    public void setUm(UserManagement um) {
        this.um = um;
    }

    public HolidayUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(HolidayUser currentUser) {
        this.currentUser = currentUser;
    }

    public List<HolidayTransaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<HolidayTransaction> transactionList) {
        this.transactionList = transactionList;
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

    /*public List<HolidayTransaction> getTransaction() {
        return transactions;
    }

    public void setTransaction(List<HolidayTransaction> transactions) {
        this.transactions = transactions;
    }*/
    
    public String searchTransaction(){
        try{
            transactionList = tm.findTransactions(tno, tname, type, currentUser.getUserId());
        }
        catch(Exception ex){
            Logger.getLogger(SearchTransactionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "transactionsearchresult?faces-redirect=true.xhtml";
        
    }
    
    @PostConstruct
    public void init(){
        String email = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        this.currentUser = um.findUserByEmail(email);
        
        
    }
}
