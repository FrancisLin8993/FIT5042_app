/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.managebeans;

import fit5042.holidayapp.entities.HolidayTransaction;
import fit5042.holidayapp.management.TransactionManagement;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author fengcilin
 */
@Named(value = "transactionBean")
@RequestScoped
public class TransactionBean implements Serializable{
    
    @EJB
    private TransactionManagement tm;
    private HolidayTransaction transaction;
    private int tno;
    
    

    public TransactionBean()  {
        
    }
    
    
    @PostConstruct
    public void init(){
        try{
            tno = Integer.valueOf(FacesContext.getCurrentInstance() 
                         .getExternalContext()
                         .getRequestParameterMap()
                         .get("tno"));
            transaction = getTransactionById(tno);
        }
        catch(Exception ex){
            Logger.getLogger(TransactionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public TransactionManagement getTm() {
        return tm;
    }

    public void setTm(TransactionManagement tm) {
        this.tm = tm;
    }

    public HolidayTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(HolidayTransaction transaction) {
        this.transaction = transaction;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }
    
    
    
    public HolidayTransaction getTransactionById(int id) throws Exception{
        return tm.findTransactionById(id);
    }
}
