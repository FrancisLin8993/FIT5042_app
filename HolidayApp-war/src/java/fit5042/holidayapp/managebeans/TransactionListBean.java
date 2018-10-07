/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.managebeans;


import fit5042.holidayapp.entities.HolidayTransaction;
import fit5042.holidayapp.entities.HolidayUser;
import fit5042.holidayapp.management.TransactionManagement;
import fit5042.holidayapp.management.UserManagement;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
//import javax.faces.bean.RequestScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
//import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 * Manage Bean of Transaction List page.
 * @author fengcilin
 */
@Named(value = "transactionListBean")
@RequestScoped
public class TransactionListBean implements Serializable{
    
    @EJB
    private TransactionManagement tm;
    @EJB
    private UserManagement um;
    private HolidayUser currentUser;
    private HolidayUser user;
    private int uid;

    public TransactionListBean()  {
        
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

    public HolidayUser getUser() {
        return user;
    }

    public void setUser(HolidayUser user) {
        this.user = user;
    }

    /**
     * Retrieve all the transactions.
     * @return 
     */
    public List<HolidayTransaction> getAllTransactions(){
        try{
            return tm.findAllTransaction();
        }catch(Exception ex){
            Logger.getLogger(TransactionListBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Retrieve transactions of current login user.
     * @return 
     */
    public List<HolidayTransaction> getCurrentUserTransactions(){
        try {
            return tm.findTransactionOfPublic(currentUser.getUserId());
        } catch (Exception ex) {
            Logger.getLogger(TransactionListBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Find a transaction by the user id get from the user details page.
     * @return 
     */
    public List<HolidayTransaction> getUserTransactions(){
         uid = Integer.valueOf(FacesContext.getCurrentInstance() 
                         .getExternalContext()
                         .getRequestParameterMap()
                         .get("uid"));
         
        try {
            this.user = um.findUserById(uid);
            return tm.findTransactionOfPublic(user.getUserId());
        } catch (Exception ex) {
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
    
    @PostConstruct
    public void init(){
        String email = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        this.currentUser = um.findUserByEmail(email);
        
        
    }
    
    
}
