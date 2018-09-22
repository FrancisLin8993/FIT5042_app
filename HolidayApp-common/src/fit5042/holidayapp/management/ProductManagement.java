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
 *
 * @author fengcilin
 */
@Remote
public interface ProductManagement {
    
    List<Product> findAllProducts() throws Exception;
    
    Product findProductById(int id) throws Exception;
}
