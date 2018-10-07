/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.management;

import fit5042.holidayapp.entities.HolidayTransaction;
import fit5042.holidayapp.entities.TransactionType;
import java.util.List;
import javax.ejb.Remote;


/**
 * Interface of the Transaction EJB.
 * @author fengcilin
 */
@Remote
public interface TransactionManagement {
    
    /**
     * Find a transaction by its id.
     * @param id
     * @return
     * @throws Exception 
     */
    HolidayTransaction findTransactionById(int id) throws Exception;
    
    /**
     * Search transactions by names or transaction types or transaction number.
     * @param transactionNo
     * @param name
     * @param type
     * @param userId
     * @return
     * @throws Exception 
     */
    List<HolidayTransaction> findTransactions(int transactionNo, String name, TransactionType type, int userId) throws Exception;
    
    /**
     * Retrieve all the transactions in the system.
     * @return
     * @throws Exception 
     */
    List<HolidayTransaction> findAllTransaction() throws Exception;
    
    /**
     * Retrieve transactions of a specific public user.
     * @param publicId
     * @return
     * @throws Exception 
     */
    List<HolidayTransaction> findTransactionOfPublic(int publicId) throws Exception;
    
    /**
     * Retrieve transactions of a specific product.
     * @param productId
     * @return
     * @throws Exception 
     */
    List<HolidayTransaction> findTransactionOfProduct(int productId) throws Exception;
    
    /**
     * Update transaction information.
     * @param transaction
     * @throws Exception 
     */
    void updateTransaction(HolidayTransaction transaction) throws Exception;
    
    /**
     * Add a transaction record in the system.
     * @param transaction
     * @throws Exception 
     */
    void addTransaction(HolidayTransaction transaction) throws Exception;
}
