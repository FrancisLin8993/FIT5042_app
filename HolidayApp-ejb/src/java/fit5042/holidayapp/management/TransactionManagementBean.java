/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.management;

import fit5042.holidayapp.entities.HolidayTransaction;
import fit5042.holidayapp.entities.TransactionType;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fengcilin
 */
@Stateless
public class TransactionManagementBean implements TransactionManagement{
    @PersistenceContext (unitName = "HolidayApp-ejbPU")
    private EntityManager em;

    @Override
    public HolidayTransaction findTransactionById(int id) throws Exception{
        return em.find(HolidayTransaction.class, id);
    }

    

    @Override
    public List<HolidayTransaction> findAllTransaction() throws Exception{
        return em.createNamedQuery(HolidayTransaction.FIND_ALL).getResultList();
        
    }

    @Override
    public List<HolidayTransaction> findTransactions(int transactionNo, String name, TransactionType type) throws Exception {
        return em.createNamedQuery(HolidayTransaction.FIND_BY_CONDITION)
                .setParameter("id", transactionNo)
                .setParameter("name", name)
                .setParameter("type", type)
                .getResultList();
    }
}
