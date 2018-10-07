/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.management;

import fit5042.holidayapp.entities.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * The Product Management EJB
 * @author fengcilin
 */
@Stateless
public class ProductManagementBean implements ProductManagement{

    @PersistenceContext
    private EntityManager em;
    
    /**
     * Find all products in the system.
     * @return A List of all products.
     * @throws Exception 
     */
    @Override
    public List<Product> findAllProducts() throws Exception {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Product.class);
        Root<Product> r = cq.from(Product.class);
        cq.select(r);
        
        return em.createQuery(cq).getResultList();
        
    }

    /**
     * Find a product by its id.
     * @param id
     * @return
     * @throws Exception 
     */
    @Override
    public Product findProductById(int id) throws Exception {
        Product product = em.find(Product.class, id);
        product.getTrasaction().size();
        return product;
    }

    /**
     * Add a product into the system.
     * @param product
     * @throws Exception 
     */
    @Override
    public void addProduct(Product product) throws Exception {
        em.persist(product);
    }

    /**
     * Remove a product in the system.
     * @param id
     * @throws Exception 
     */
    @Override
    public void removeProduct(int id) throws Exception {
        Product product = this.findProductById(id);
        if(product == null){
            throw new Exception("Product does not existed");
        }
        else{
            em.remove(product);
        }
    }
    

    /**
     * Update a product in the system.
     * @param product
     * @throws Exception 
     */
    @Override
    public void updateProduct(Product product) throws Exception {
        em.merge(product);
    }
}
