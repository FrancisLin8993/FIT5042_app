/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.management;

import fit5042.holidayapp.entities.HolidayUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fengcilin
 */
@Stateless
public class UserManagementBean implements UserManagement{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public HolidayUser findUserById(int id) throws Exception{
        return em.find(HolidayUser.class, id);
    }
    
    @Override
    public HolidayUser findUserByEmail(String email) {
        List<HolidayUser> userList = em.createNamedQuery(HolidayUser.FIND_USER_BY_EMAIL).setParameter("email", email).getResultList();
        if (userList.isEmpty())
        {
            return null;
        }
        else
        {
            return userList.get(0);
        }
    }
    
    @Override
    public List<HolidayUser> findAllUsers(){
        return em.createNamedQuery(HolidayUser.FIND_ALL, HolidayUser.class).getResultList();
        
    }

    @Override
    public void addUser(HolidayUser user) throws Exception {
        if (findUserByEmail(user.getEmail()) != null)
        {
            throw new Exception("This email has already existed.");
        }
        else
        {
            em.persist(user);
        }
    }

    @Override
    public void removeUser(int id) throws Exception {
        HolidayUser user = findUserById(id);
        if(user == null){
            throw new Exception("User does not existed");
        }
        else{
            em.remove(user);
        }
    }

    @Override
    public void updateUser(HolidayUser user) throws Exception {
        /*user = findUserById(user.getUserId());
        if (user == null) {
            throw new Exception("User does not exist");
        }*/
        em.merge(user);
    }

    
}
