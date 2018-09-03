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
 *
 * @author fengcilin
 */
@Remote
public interface TransactionManagement {
    
    public HolidayTransaction findTransactionById(int id);
    
    public List<HolidayTransaction> findTransactionByName(String name);
    
    public List<HolidayTransaction> findTransactionByType(TransactionType type);
    
}
