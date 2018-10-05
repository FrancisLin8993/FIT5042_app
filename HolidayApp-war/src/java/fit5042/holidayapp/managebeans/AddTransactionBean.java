/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.managebeans;

import fit5042.holidayapp.entities.HolidayPublic;
import fit5042.holidayapp.entities.HolidayTransaction;
import fit5042.holidayapp.entities.HolidayUser;
import fit5042.holidayapp.entities.Product;
import fit5042.holidayapp.entities.TransactionStatus;
import fit5042.holidayapp.entities.TransactionType;
import fit5042.holidayapp.management.ProductManagement;
import fit5042.holidayapp.management.TransactionManagement;
import fit5042.holidayapp.management.UserManagement;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author fengcilin
 */
@Named(value = "addTransactionBean")
@SessionScoped
public class AddTransactionBean implements Serializable {

    @EJB
    private TransactionManagement tm;
    @EJB
    private ProductManagement pm;
    @EJB
    private UserManagement um;
    
    private HolidayTransaction transaction;
    private Product product;
    private int pid;
    private HolidayUser user;
    private TransactionType ttype;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public HolidayUser getUser() {
        return user;
    }

    public void setUser(HolidayUser user) {
        this.user = user;
    }

    
    
    

    public TransactionType getTtype() {
        return ttype;
    }

    public void setTtype(TransactionType ttype) {
        this.ttype = ttype;
    }
    
    public TransactionType[] getTypes(){
        return TransactionType.values();
    }
    
    
    public TransactionManagement getTm() {
        return tm;
    }

    public void setTm(TransactionManagement tm) {
        this.tm = tm;
    }

    public ProductManagement getPm() {
        return pm;
    }

    public void setPm(ProductManagement pm) {
        this.pm = pm;
    }

    public UserManagement getUm() {
        return um;
    }

    public void setUm(UserManagement um) {
        this.um = um;
    }

    public HolidayTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(HolidayTransaction transaction) {
        this.transaction = transaction;
    }
    

    /**
     * Creates a new instance of AddTransactionBean
     */
    public AddTransactionBean() {
    }
    
    @PostConstruct
    public void init(){
        
        pid = Integer.valueOf(FacesContext.getCurrentInstance() 
                         .getExternalContext()
                         .getRequestParameterMap()
                         .get("pid"));
        
        
        try{
            product = pm.findProductById(pid);
            
            String email = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
            this.user = um.findUserByEmail(email);
        }
        catch(Exception ex){
            Logger.getLogger(TransactionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String bookProduct(){
        this.transaction = new HolidayTransaction();
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String stringOfDate = formatter.format(date);
        this.transaction.setStatus(TransactionStatus.Created);
        this.transaction.setDescription("This Transaction was created at " + stringOfDate);
        this.transaction.setName(user.getUserId() + "-" + stringOfDate);
        this.transaction.setType(ttype);
        try {                
            this.transaction.setCustomer((HolidayPublic) user);            
            this.transaction.setProduct(product);
            this.transaction.setStatus(TransactionStatus.Created);
            this.transaction.setDescription(String.valueOf(new Date()));
            tm.addTransaction(transaction);
            return "/Public/transactionlist?faces-redirect=true.xhtml";
        } catch (Exception ex) {
            Logger.getLogger(TransactionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        return null;
    }
}
