/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.management;

import fit5042.holidayapp.entities.HolidayUser;
import javax.ejb.Remote;

/**
 *
 * @author fengcilin
 */
@Remote
public interface UserManagement {
    public HolidayUser findUserById(int id);
    
    
}
