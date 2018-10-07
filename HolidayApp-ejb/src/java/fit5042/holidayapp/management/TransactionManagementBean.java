/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.management;

import fit5042.holidayapp.entities.HolidayTransaction;
import fit5042.holidayapp.entities.TransactionStatus;
import fit5042.holidayapp.entities.TransactionType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * A EJB dealing with transactions.
 * @author fengcilin
 */
@Stateless
public class TransactionManagementBean implements TransactionManagement{
    @PersistenceContext (unitName = "HolidayApp-ejbPU")
    private EntityManager em;

    /**
     * Find a transaction by its id.
     * @param id
     * @return
     * @throws Exception 
     */
    @Override
    public HolidayTransaction findTransactionById(int id) throws Exception{
        return em.find(HolidayTransaction.class, id);
    }

    
    /**
     * Find all the transactions in the system.
     * @return
     * @throws Exception 
     */
    @Override
    public List<HolidayTransaction> findAllTransaction() throws Exception{
        return em.createNamedQuery(HolidayTransaction.FIND_ALL).getResultList();
        
    }

    /**
     * Search a transaction of a customer by transaction id or transaction name or transaction type.
     * @param transactionNo
     * @param name
     * @param type
     * @param userId
     * @return
     * @throws Exception 
     */
    @Override
    public List<HolidayTransaction> findTransactions(int transactionNo, String name, TransactionType type, int userId) throws Exception {
        return em.createNamedQuery(HolidayTransaction.FIND_BY_CONDITION)
                .setParameter("id", transactionNo)
                .setParameter("name", name)
                .setParameter("type", type)
                .setParameter("uid", userId)
                .getResultList();
    }

    /**
     * Find all the transactions created by a public.
     * @param publicId
     * @return
     * @throws Exception 
     */
    @Override
    public List<HolidayTransaction> findTransactionOfPublic(int publicId) throws Exception {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(HolidayTransaction.class);
        Root<HolidayTransaction> r = cq.from(HolidayTransaction.class);
        cq.where(cb.equal(r.get("customer").get("userId"), publicId));
        cq.select(r);
        return em.createQuery(cq).getResultList();
        
    }

    /**
     * Update Transaction information.
     * @param transaction
     * @throws Exception 
     */
    @Override
    public void updateTransaction(HolidayTransaction transaction) throws Exception {
        em.merge(transaction);
    }

    /**
     * Add a transaction into the system.
     * @param transaction
     * @throws Exception 
     */
    @Override
    public void addTransaction(HolidayTransaction transaction) throws Exception {
        
        em.persist(transaction);
    }

    /**
     * Find all the transaction related to a specific product.
     * @param productId
     * @return
     * @throws Exception 
     */
    @Override
    public List<HolidayTransaction> findTransactionOfProduct(int productId) throws Exception {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(HolidayTransaction.class);
        Root<HolidayTransaction> r = cq.from(HolidayTransaction.class);
        cq.where(cb.equal(r.get("product").get("id"), productId));
        cq.select(r);
        return em.createQuery(cq).getResultList();
    }
    
    
}
