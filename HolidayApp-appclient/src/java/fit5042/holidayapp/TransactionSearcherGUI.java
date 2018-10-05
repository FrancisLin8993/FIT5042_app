/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp;

import fit5042.holidayapp.entities.HolidayTransaction;
import fit5042.holidayapp.entities.TransactionType;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author fengcilin
 */
public interface TransactionSearcherGUI {
    
    /**
     * Clear all the inputs in the GUI
     */
    void clearInput();

    /**
     * Clear all the text fields in the GUI
     */
    void clearTextFields();
    
    /**
     * Clear all the combo boxes in the GUI
     */
    void clearComboBoxes();
    
    /**
     * Clear all records in the table
     */
    void clearTransactionTable();

    /**
     * Display a message in a dialog box
     *
     * @param message - the message to display
     */
    void displayMessageInDialog(String message);
    
    void displayTransactionDetails(HolidayTransaction transaction);
    
    void displaySelectedTransactionDetails(HolidayTransaction transaction);
    
    void displayTransactionDetails(List<HolidayTransaction> transactions);
    
    int getSelectedTransactionId() throws Exception;
    
    JButton getCloseButton();
    
    JButton getSearchButton();
    
    JButton getViewButton(); 
    
    public JTable getTransactionTable();
    
    
    
    boolean isTransactionSelected();
    
    TransactionType getSelectedType();
    
    void displayTransactionType(TransactionType[] type);
    
    int getTransactionNo();
    
    String getTransactionName();
    
    
    
    
    
}
