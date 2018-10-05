/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.managebeans;

import fit5042.holidayapp.entities.Address;
import fit5042.holidayapp.entities.HolidayPublic;
import fit5042.holidayapp.entities.HolidayUser;
import fit5042.holidayapp.entities.HolidayWorker;
import fit5042.holidayapp.entities.UserType;
import fit5042.holidayapp.management.TransactionManagement;
import fit5042.holidayapp.management.UserManagement;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
//import javax.faces.bean.SessionScoped;


/**
 *
 * @author fengcilin
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    @EJB
    private UserManagement um;
    @EJB
    private TransactionManagement tm;
    private HolidayUser editUser;
    private HolidayUser user; 
    private HolidayPublic customer;
    private HolidayWorker worker;
    private List<HolidayUser> userlist;
    private UserType type;
    private Address address;
    private String message;
    

    public HolidayUser getEditUser() {
        return editUser;
    }

    public void setEditUser(HolidayUser editUser) {
        this.editUser = editUser;
    }
    
    

    public HolidayPublic getCustomer() {
        return customer;
    }

    public void setCustomer(HolidayPublic customer) {
        this.customer = customer;
    }

    public HolidayWorker getWorker() {
        return worker;
    }

    public void setWorker(HolidayWorker worker) {
        this.worker = worker;
    }

    
    
    public TransactionManagement getTm() {
        return tm;
    }

    public void setTm(TransactionManagement tm) {
        this.tm = tm;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    

    public UserType getType() {
        return type;
    }
    
    public UserType[] getTypes(){
        return UserType.values();
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public List<HolidayUser> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<HolidayUser> userlist) {
        this.userlist = userlist;
    }

    
    
    
    public void findUsers(){
        try {           
            userlist = um.findAllUsers();
        } catch (Exception ex) {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    public UserManagement getUm() {
        return um;
    }

    public void setUm(UserManagement um) {
        this.um = um;
    }

    public HolidayUser getUser() {
        return user;
    }

    public void setUser(HolidayUser user) {
        this.user = user;
    }
    
    
    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }
    
    public String addUser() {
        try {
            if (this.customer != null)
            {
                customer.setAddress(address);
                customer.setUserType(UserType.Public);
                um.addUser(customer);
                setCustomer(null);
            }
            else if (this.worker != null)
            {
                worker.setAddress(address);
                worker.setUserType(UserType.Worker);
                um.addUser(worker);
                setWorker(null);
            }                  
            findUsers();
            message = "User has been added.";
        } catch (Exception ex) {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/Worker/userlist?faces-redirect=true.xhtml";
    }
    
    public String displayUserDetail(HolidayUser user){
        this.user = user;
        return "/Worker/user?faces-redirect=true.xhtml";
    }
    
    public String redirectAddPublicPage(){
        this.customer = new HolidayPublic();
        this.address = new Address();
        return "/Worker/addpublic?faces-redirect=true.xhtml";
    }
    
    public String redirectAddWorkerPage(){        
        this.worker = new HolidayWorker();
        this.address = new Address();
        return "/Worker/addworker?faces-redirect=true.xhtml";
    }
    
    public boolean isPublicHasTransactions(){
        try{
            return tm.findTransactionOfPublic(user.getUserId()).size() > 0;
                         
        }catch (Exception ex) {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public String removeUser(HolidayUser user){
        
        this.user = user;
        try 
        {
            if (user.getUserType().equals(UserType.valueOf("Public")) && (isPublicHasTransactions() == true))
            {
                message = "Sorry, A user with transaction records cannot be removed.";
            }
            else
            {
                um.removeUser(user.getUserId());
                findUsers();
                message = "User has removed.";
            }
                        
            return "/Worker/userlist?faces-redirect=true.xhtml";
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    
    
    public String redirectEditUserPage(HolidayUser user){
        
        this.editUser = user;
        
        return "/Worker/edituser?faces-redirect=true.xhtml";
    }
    
    public String updateUser() {    
        
        try {
            um.updateUser(editUser);
            message = "User details has updated.";
            return "/Worker/userlist?faces-redirect=true.xhtml";
        } catch (Exception ex) {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
            message = "User details has failed to update.";            
            return "";
        }
    }
    
    
    @PostConstruct
    public void init(){
        findUsers();
        setMessage("");
        
        
        
    }
    
}
