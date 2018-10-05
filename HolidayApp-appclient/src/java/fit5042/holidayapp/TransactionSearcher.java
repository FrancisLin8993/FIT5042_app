/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp;

import fit5042.holidayapp.entities.HolidayTransaction;
import fit5042.holidayapp.entities.TransactionType;
import fit5042.holidayapp.management.TransactionManagement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author fengcilin
 */
public class TransactionSearcher implements ActionListener, ListSelectionListener{

    @EJB
    private static TransactionManagement tm;
    private String name;
    private TransactionSearcherGUI gui;

    public TransactionSearcher(String name) {
        this.name = name;
    }
    
    public void initView() {
        this.gui = new TransactionSearcherGUIImpl(this, this);
        this.displayAllTransactions();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final TransactionSearcher ts = new TransactionSearcher("Lin's Holiday Booking");
        ts.initView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.getSearchButton()) {            
            this.searchTransactions();
        }
        else if (e.getSource() == gui.getViewButton()) {
            this.displayAllTransactions();
        }
        else
        {
            System.exit(0);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if ((e.getSource() == this.gui.getTransactionTable().getSelectionModel())
            && (! e.getValueIsAdjusting()))
        {
            try
            {
                if (this.gui.isTransactionSelected()) {
                    int tno = this.gui.getSelectedTransactionId();
                
                    HolidayTransaction transaction = tm.findTransactionById(tno);
                    this.gui.displaySelectedTransactionDetails(transaction);
                }               
            }
            catch (Exception exception)
            {
                gui.displayMessageInDialog(exception.getMessage());
            }
        }
    }

    private void displayAllTransactions() {
        try {
            List<HolidayTransaction> transactions = tm.findAllTransaction();
            
            if (transactions != null) {
                this.gui.displayTransactionDetails(transactions);
            }
            
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to retrieve properties: " + ex.getMessage());
        }
    }

    private void searchTransactions() {
        int tno = this.gui.getTransactionNo();
        String tname = this.gui.getTransactionName();
        TransactionType type = this.gui.getSelectedType();
        
        try {
            HolidayTransaction transactions = tm.findTransactionById(tno);
            if (transactions != null) {
                this.gui.displayTransactionDetails(transactions);
            } else {
                this.gui.displayMessageInDialog("No matched transactions found");
                this.gui.clearTransactionTable();
            }  
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to search transactions: " + ex.getMessage());
            this.gui.clearTransactionTable();
        }finally {
            this.gui.clearInput();
        }
        
    }

      
    
}
