/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.managebeans;

import fit5042.holidayapp.entities.HolidayUser;
import fit5042.holidayapp.management.UserManagement;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 * Manage Bean of personal information page.
 * @author fengcilin
 */
@Named(value = "personalInfoBean")
@SessionScoped
public class PersonalInfoBean implements Serializable {

    private HolidayUser user; 
    private String email;
    @EJB
    private UserManagement um;

    public HolidayUser getUser() {
        return user;
    }

    public void setUser(HolidayUser user) {
        this.user = user;
    }
    
    
    
    public PersonalInfoBean() {
    }
    
    //Get the current login user.
    @PostConstruct
    public void init(){
        this.email = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        this.user = um.findUserByEmail(email);
        
        
    }
    
}
