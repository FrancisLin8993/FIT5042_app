/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.management;

import fit5042.holidayapp.entities.HolidayUser;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author fengcilin
 */
@Remote
public interface UserManagement {
    HolidayUser findUserById(int id) throws Exception;
    
    HolidayUser findUserByEmail(String email);
    
    List<HolidayUser> findAllUsers() throws Exception;
    
    void addUser(HolidayUser user) throws Exception;
    
    void removeUser(int id) throws Exception;
    
    void updateUser(HolidayUser user) throws Exception;
}
