/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp;

import fit5042.holidayapp.entities.HolidayTransaction;
import fit5042.holidayapp.entities.TransactionType;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * Implementation of the GUI interface
 * @author fengcilin
 */
public class TransactionSearcherGUIImpl extends JFrame implements TransactionSearcherGUI{
    
    private static final String[] TABLE_COLUMNS = {"Transaction No.", "Name", "Customer", "Description", "Status", "Type", "Product"};
    
    private final JButton closeButton;
    private final JButton viewButton;
    private final JButton searchButton;
    
    private final JPanel inputPanel;
    private final JPanel buttonPanel;
    
    private final JLabel transactionNoLabel;
    private final JLabel nameLabel;
    private final JLabel customerLabel;
    private final JLabel descLabel;
    private final JLabel statusLabel;
    private final JLabel typeLabel;
    private final JLabel productLabel;
    
    private final JTextField transactionNoField;
    private final JTextField nameField;
    private final JTextField customerField;
    private final JTextField descField;
    private final JTextField statusField;
    private final JComboBox typeComboBox;
    private final JTextField productField;
    
    private final JTable transactionTable;

    public TransactionSearcherGUIImpl(ActionListener actionListener, ListSelectionListener listSelectionListener)  {
        super("Lin's Holiday Booking");
        
        this.closeButton = new JButton("Close");
        this.viewButton = new JButton("View");
        this.searchButton = new JButton("Search");
        
        Container container = this.getContentPane();
        
        this.transactionNoLabel = new JLabel("Transaction No.");
        this.nameLabel = new JLabel("Transaction Name");
        this.customerLabel = new JLabel("Customer");
        this.descLabel = new JLabel("Description");
        this.statusLabel = new JLabel("Transaction Status");
        this.typeLabel = new JLabel("Transaction Type");
        this.productLabel = new JLabel("Product");
        
        this.transactionNoField = new JTextField();
        this.nameField = new JTextField();
        this.customerField = new JTextField();
        this.descField = new JTextField();
        this.statusField = new JTextField();
        this.productField = new JTextField();
        
        nameField.setEditable(false);
        customerField.setEditable(false);
        descField.setEditable(false);
        statusField.setEditable(false);
        productField.setEditable(false);
        
        
        
        
        this.transactionTable = new JTable(new DefaultTableModel(TABLE_COLUMNS, 0));
        this.transactionTable.getSelectionModel().addListSelectionListener(listSelectionListener);       
        this.transactionTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        TableColumnModel propertyTableColumnModel = this.transactionTable.getColumnModel();
        propertyTableColumnModel.getColumn(0).setPreferredWidth(50);
        propertyTableColumnModel.getColumn(1).setPreferredWidth(300);
        propertyTableColumnModel.getColumn(2).setPreferredWidth(100);
        propertyTableColumnModel.getColumn(3).setPreferredWidth(300);
        propertyTableColumnModel.getColumn(4).setPreferredWidth(100);
        propertyTableColumnModel.getColumn(5).setPreferredWidth(100);
        propertyTableColumnModel.getColumn(5).setPreferredWidth(100);
        
        this.typeComboBox = new JComboBox(TransactionType.values());
        this.typeComboBox.setEditable(false);

         this.inputPanel = new JPanel();
        this.buttonPanel = new JPanel();
        
        container.setLayout(new BorderLayout());
        this.inputPanel.setLayout(new GridLayout(7,2));
        this.buttonPanel.setLayout(new GridLayout(1,3));
        
        this.closeButton.addActionListener(actionListener);
        this.viewButton.addActionListener(actionListener);
        this.searchButton.addActionListener(actionListener);
        
        this.inputPanel.add(transactionNoLabel);
        this.inputPanel.add(transactionNoField);
        
        this.inputPanel.add(nameLabel);
        this.inputPanel.add(nameField);
        
        this.inputPanel.add(customerLabel);
        this.inputPanel.add(customerField);
        
        this.inputPanel.add(descLabel);
        this.inputPanel.add(descField);
        
        this.inputPanel.add(statusLabel);
        this.inputPanel.add(statusField);
        
        this.inputPanel.add(typeLabel);
        this.inputPanel.add(typeComboBox);
        
        this.inputPanel.add(productLabel);
        this.inputPanel.add(productField);
        
        
        this.buttonPanel.add(this.searchButton);
        this.buttonPanel.add(this.viewButton);
        this.buttonPanel.add(this.closeButton);
        
        container.add(inputPanel,BorderLayout.NORTH);
        container.add(new JScrollPane(this.transactionTable), BorderLayout.CENTER);
        container.add(buttonPanel,BorderLayout.SOUTH);
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(800, 600);       
        this.setVisible(true);
        
    }
    
    

    

    @Override
    public void clearInput() {
        this.clearTextFields();
        this.clearComboBoxes();    
    }

    @Override
    public void clearTextFields() {
        this.transactionNoField.setText("");
        this.customerField.setText("");
        this.descField.setText("");
        this.nameField.setText("");
        this.productField.setText("");
        this.statusField.setText("");

    }

    @Override
    public void clearComboBoxes() {
        
    }

    @Override
    public void clearTransactionTable() {
        int numberOfRow = this.transactionTable.getModel().getRowCount();
        
        if (numberOfRow > 0) {
            DefaultTableModel tableModel = (DefaultTableModel) this.transactionTable.getModel();
            for (int index = (numberOfRow - 1); index >= 0; index --) {
                tableModel.removeRow(index);
            }            
        }
    }

    @Override
    public void displayMessageInDialog(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * Display All the transaction details in the table.
     * @param transaction 
     */
    @Override
    public void displayTransactionDetails(HolidayTransaction transaction) {
        this.clearTransactionTable();
        this.clearInput();
        
        ((DefaultTableModel)this.transactionTable.getModel()).addRow(new Object[]{transaction.getTransactionNo(), 
                                                                               transaction.getName(), 
                                                                               transaction.getCustomer().getFirstName(), 
                                                                               transaction.getDescription(), 
                                                                               transaction.getStatus(),
                                                                               transaction.getType(),
                                                                               transaction.getProduct().getProductName()
        });    
    }

    /**
     * Display the single transaction details in the input panel.
     * @param transaction 
     */
    @Override
    public void displaySelectedTransactionDetails(HolidayTransaction transaction) {
        this.transactionNoField.setText(String.valueOf(transaction.getTransactionNo()));           
        this.nameField.setText(transaction.getName());
        this.customerField.setText(transaction.getCustomer().getFirstName() + " " + transaction.getCustomer().getLastName());
        this.descField.setText(transaction.getDescription());
        this.statusField.setText(String.valueOf(transaction.getStatus()));        
        this.productField.setText(transaction.getProduct().getProductName());               
        this.typeComboBox.setSelectedItem(transaction.getType());
    }

    /**
     * Display a collection of transaction details in the table.
     * @param transactions 
     */
    @Override
    public void displayTransactionDetails(List<HolidayTransaction> transactions) {
        this.clearTransactionTable();
        this.clearInput();
        
        for(HolidayTransaction transaction: transactions){
            ((DefaultTableModel)this.transactionTable.getModel()).addRow(new Object[]{transaction.getTransactionNo(), 
                                                                               transaction.getName(), 
                                                                               transaction.getCustomer().getFirstName(), 
                                                                               transaction.getDescription(), 
                                                                               transaction.getStatus(),
                                                                               transaction.getType(),
                                                                               transaction.getProduct().getProductName()
            });  
        }
    }

    @Override
    public int getSelectedTransactionId() throws Exception {
        int selectedRowIndex = this.transactionTable.getSelectedRow();
        
        String tno = this.transactionTable.getValueAt(selectedRowIndex, 0).toString();
        return Integer.parseInt(tno);     
    }

    @Override
    public JButton getCloseButton() {
        return closeButton;
    }

    @Override
    public JButton getSearchButton() {
        return searchButton;
    }

    @Override
    public JButton getViewButton() {
        return viewButton;
    }

    @Override
    public JTable getTransactionTable() {
        return transactionTable;
    }

    

    @Override
    public boolean isTransactionSelected() {
        return (this.transactionTable.getSelectedRow() >= 0);
    }

    @Override
    public TransactionType getSelectedType() {
        if (this.typeComboBox.getItemCount() > 0 && this.typeComboBox.getSelectedIndex() > 0) {
            return (TransactionType)this.typeComboBox.getSelectedItem();
        } else {
            return null;
        }
    }

    @Override
    public void displayTransactionType(TransactionType[] type) {
        
    }

    @Override
    public int getTransactionNo() {
        String id = this.transactionNoField.getText();
        return id == null || id.isEmpty() ? 0 : Integer.parseInt(id);    
    }

    @Override
    public String getTransactionName() {
        String name = this.nameField.getText();
        return name == null || name.isEmpty() ? "" : name;
    }

    
    
}
