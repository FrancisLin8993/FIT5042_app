/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.management;

import fit5042.holidayapp.entities.HolidayUser;
import fit5042.holidayapp.entities.UserType;
import java.util.List;
import javax.ejb.Remote;

/**
 * Interface of the User EJB.
 * @author fengcilin
 */
@Remote
public interface UserManagement {
    
    /**
     * Find a user by its id.
     * @param id
     * @return
     * @throws Exception 
     */
    HolidayUser findUserById(int id) throws Exception;
    
    /**
     * Find a user by its email.
     * @param email
     * @return 
     */
    HolidayUser findUserByEmail(String email);
    
    /**
     * Find all the users.
     * @return
     * @throws Exception 
     */
    List<HolidayUser> findAllUsers() throws Exception;
    
    /**
     * Add a user into the application.
     * @param user
     * @throws Exception 
     */
    void addUser(HolidayUser user) throws Exception;
    
    /**
     * Remove a user in the system.
     * @param id
     * @throws Exception 
     */
    void removeUser(int id) throws Exception;
    
    /**
     * Update a user information.
     * @param user
     * @throws Exception 
     */
    void updateUser(HolidayUser user) throws Exception;
    
    /**
     * Find a user by a combination of following criteria.
     * @param userId
     * @param firstName
     * @param lastName
     * @param userType
     * @param email
     * @return
     * @throws Exception 
     */
    List<HolidayUser> findUserByCombinationCriteria(int userId, String firstName, String lastName, UserType userType, String email) throws Exception;
}
