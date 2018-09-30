/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.managebeans;

import fit5042.holidayapp.entities.Product;
import fit5042.holidayapp.management.ProductManagement;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author fengcilin
 */
@Named(value = "productBean")
@SessionScoped
public class ProductBean implements Serializable{

    @EJB
    private ProductManagement pm;
    private List<Product> productList;
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    
    

    
    
    
    public ProductManagement getPm() {
        return pm;
    }

    public void setPm(ProductManagement pm) {
        this.pm = pm;
    }
    
    public void getAllProducts(){
        try{
            productList = pm.findAllProducts();
        }catch(Exception ex){
            Logger.getLogger(ProductBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String displayProductDetail(Product product){
        this.product = product;
        return "/product?faces-redirect=true.xhtml";
    }
    
    public String directToBooking(Product product){
        this.product = product;
        return "/confirmbooking?faces-redirect=true.xhtml";
    }
    
    /**
     * Creates a new instance of productBean
     */
    public ProductBean() {
        
    }
    
    @PostConstruct
    public void init(){
        getAllProducts();
        
        
        
    }
}
