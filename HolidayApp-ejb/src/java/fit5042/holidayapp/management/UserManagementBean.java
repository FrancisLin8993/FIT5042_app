/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.management;

import fit5042.holidayapp.entities.HolidayUser;
import fit5042.holidayapp.entities.UserType;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

    @Override
    public List<HolidayUser> findUserByCombinationCriteria(int userId, String firstName, String lastName, UserType userType, String email) throws Exception {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(HolidayUser.class);
        Root<HolidayUser> user = cq.from(HolidayUser.class);
        cq.select(user);
        cq.where(cb.equal(user.get("userId").as(Integer.class), userId),
                cb.and(cb.like(user.get("firstName").as(String.class), firstName)),
                cb.and(cb.like(user.get("lastName").as(String.class), lastName)),
                cb.and(cb.like(user.get("email").as(String.class), email)),
                cb.and(cb.equal(user.get("userType"), userType)));
        return em.createQuery(cq).getResultList();
    }

    
}
