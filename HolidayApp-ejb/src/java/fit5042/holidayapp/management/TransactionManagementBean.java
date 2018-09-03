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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fengcilin
 */
public class TransactionManagementBean implements TransactionManagement{
    @PersistenceContext
    private EntityManager em;

    @Override
    public HolidayTransaction findTransactionById(int id) {
        return em.find(HolidayTransaction.class, id);
    }

    @Override
    public List<HolidayTransaction> findTransactionByName(String name) {
        List<HolidayTransaction> transactions = em.createNamedQuery(HolidayTransaction.FIND_BY_NAME).setParameter("name", name).getResultList();
        
        return transactions;
    }

    @Override
    public List<HolidayTransaction> findTransactionByType(TransactionType type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
