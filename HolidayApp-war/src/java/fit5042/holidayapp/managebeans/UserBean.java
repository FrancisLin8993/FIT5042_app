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
import javax.enterprise.context.SessionScoped;
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
    private HolidayUser user; 
    private HolidayPublic customer;
    private HolidayWorker worker;
    private List<HolidayUser> users;
    private UserType type;
    private Address address;
    private String message;

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

    public List<HolidayUser> getUsers() {
        return users;
    }
    
    
    
    public void findUsers(){
        try {           
            users = um.findAllUsers();
        } catch (Exception ex) {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setUsers(List<HolidayUser> users) {
        this.users = users;
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
            if ()
            {
                
            }
                   
            user.setAddress(address);
            user.setType(type);
            
            um.addUser(user);                        
            findUsers();
            message = "User has been added.";
        } catch (Exception ex) {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/userlist?faces-redirect=true.xhtml";
    }
    
    public String displayUserDetail(HolidayUser user){
        this.user = user;
        return "/user?faces-redirect=true.xhtml";
    }
    
    public String redirectAddUserPage(){
        this.customer = new HolidayPublic();
        this.worker = new HolidayWorker();
        this.address = new Address();
        return "/adduser?faces-redirect=true.xhtml";
    }
    
    public boolean isPublicHasTransactions(){
        try{
            return tm.findTransacionOfPublic(user.getUserId()).size() > 0;
                         
        }catch (Exception ex) {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public String removeUser(HolidayUser user){
        
        this.user = user;
        try 
        {
            if (user.getType().equals(UserType.valueOf("Public")) && (isPublicHasTransactions() == true))
            {
                message = "Sorry, A user with transaction records cannot be removed.";
            }
            else
            {
                um.removeUser(user.getUserId());
                findUsers();
                message = "User has removed.";
            }
                        
            return "/userlist?faces-redirect=true.xhtml";
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    
    
    
    @PostConstruct
    public void init(){
        findUsers();
        
        
    }
    
}
