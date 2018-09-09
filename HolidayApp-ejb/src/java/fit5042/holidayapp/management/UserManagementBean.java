/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.management;

import fit5042.holidayapp.entities.HolidayUser;
import javax.ejb.Stateless;

/**
 *
 * @author fengcilin
 */
@Stateless
public class UserManagementBean implements UserManagement{

    @Override
    public HolidayUser findUserById(int id) throws Exception{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
