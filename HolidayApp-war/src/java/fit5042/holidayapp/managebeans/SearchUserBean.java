/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.managebeans;

import fit5042.holidayapp.entities.HolidayUser;
import fit5042.holidayapp.entities.UserType;
import fit5042.holidayapp.management.UserManagement;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 * Manage Bean of Search User Page.
 * @author fengcilin
 */
@Named(value = "searchUserBean")
@SessionScoped
public class SearchUserBean implements Serializable {

    private List<HolidayUser> userlist;
    @EJB
    private UserManagement um;
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private UserType type;

    public List<HolidayUser> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<HolidayUser> userlist) {
        this.userlist = userlist;
    }

    

    public UserManagement getUm() {
        return um;
    }

    public void setUm(UserManagement um) {
        this.um = um;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
    
    public UserType[] getTypes(){
        return UserType.values();
    }
    
    
    
    public SearchUserBean() {
    }
    
    /**
     * Search a user by combination of following criteria.
     * @return 
     */
    public String searchUser(){
        try {
            userlist = um.findUserByCombinationCriteria(userId, firstName, lastName, type, email);
        } catch (Exception ex) {
            Logger.getLogger(SearchUserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "usersearchresult?faces-redirect=true.xhtml";
    }
    
    
}
