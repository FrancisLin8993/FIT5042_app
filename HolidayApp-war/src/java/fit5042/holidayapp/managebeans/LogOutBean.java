/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.managebeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Manage Bean dealing with log out.
 * @author fengcilin
 */
@Named(value = "logOutBean")
@SessionScoped
public class LogOutBean implements Serializable {

    
    public LogOutBean() {
    }
    
    public String logOut(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "HolidayApp-war/faces/index?facesredirect=true.xhtml";
    }
    
}
