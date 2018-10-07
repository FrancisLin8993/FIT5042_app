/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.management;

import fit5042.holidayapp.entities.Product;
import java.util.List;
import javax.ejb.Remote;

/**
 * Interface of the Product EJB.
 * @author fengcilin
 */
@Remote
public interface ProductManagement {
    
    /**
     * Retrieve all products in the application.
     * @return
     * @throws Exception 
     */
    List<Product> findAllProducts() throws Exception;
    
    /**
     * Find a product according to its id
     * @param id
     * @return
     * @throws Exception 
     */
    Product findProductById(int id) throws Exception;
    
    /**
     * Add a new product into system.
     * @param product
     * @throws Exception 
     */
    void addProduct(Product product) throws Exception;
    
    /**
     * Remove a product in the system.
     * @param id
     * @throws Exception 
     */
    void removeProduct(int id) throws Exception;
    
    /**
     * Update product information.
     * @param product
     * @throws Exception 
     */
    void updateProduct(Product product) throws Exception;
}
