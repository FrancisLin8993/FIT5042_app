/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.managebeans;


import fit5042.holidayapp.entities.HolidayTransaction;
import fit5042.holidayapp.management.TransactionManagement;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author fengcilin
 */
@Named(value = "transactionListBean")
@RequestScoped
public class TransactionListBean implements Serializable{
    
    @EJB
    private TransactionManagement tm;

    public TransactionListBean()  {
        
    }

    public List<HolidayTransaction> getAllTransactions(){
        try{
            return tm.findAllTransaction();
        }catch(Exception ex){
            Logger.getLogger(TransactionListBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public TransactionManagement getTm() {
        return tm;
    }

    public void setTm(TransactionManagement tm) {
        this.tm = tm;
    }
    
    
}
