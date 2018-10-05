/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.managebeans;

import fit5042.holidayapp.entities.Product;
import fit5042.holidayapp.management.ProductManagement;
import fit5042.holidayapp.management.TransactionManagement;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @EJB
    private TransactionManagement tm;
    private List<Product> productList;
    private Product product;
    private Product editProduct;
    private String startDate;
    private String endDate;
    private double price;
    private String message;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getEditProduct() {
        return editProduct;
    }

    public void setEditProduct(Product editProduct) {
        this.editProduct = editProduct;
    }
    
    

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TransactionManagement getTm() {
        return tm;
    }

    public void setTm(TransactionManagement tm) {
        this.tm = tm;
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
    
    public String redirectAddProductPage(){
        this.product = new Product();
        return "/Worker/addproduct?faces-redirect=true.xhtml";
    }
    
    public String addProduct() {
       
        try {
            if(product.getStartDate().compareTo(product.getEndDate()) >= 0)
            {
                return "";
            }
            else
            {
                pm.addProduct(product);
                setProduct(null);
                getAllProducts();   
            }
                     
        } catch (Exception ex) {
            Logger.getLogger(ProductBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/productlist?faces-redirect=true.xhtml";
    }
    
    public String redirectEditProductPage(Product product){
        
        this.editProduct = product;
        
        return "/Worker/editproduct?faces-redirect=true.xhtml";
    }
    
    public String updateProduct() {    
        
        try {
            pm.updateProduct(editProduct);
            
            return "/HolidayApp-war/productlist?faces-redirect=true.xhtml";
        } catch (Exception ex) {
            Logger.getLogger(ProductBean.class.getName()).log(Level.SEVERE, null, ex);
                    
            return "";
        }
    }
    
    public boolean isProductHasTransactions(){
        try{
            return tm.findTransactionOfProduct(product.getId()).size() > 0;
                         
        }catch (Exception ex) {
            Logger.getLogger(ProductBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public String removeProduct(Product product){
        
        this.product = product;
        try 
        {
            if (isProductHasTransactions() == true)
            {
                message = "Sorry, A product with transaction records cannot be removed.";
            }
            else
            {
                pm.removeProduct(this.product.getId());
                getAllProducts();
                message = "Product has removed.";
            }
                        
            return "/productlist.xhtml";
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ProductBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public boolean compareDates(Date startDate, Date endDate){
        return startDate.compareTo(endDate) < 0;
    }
    
    /**
     * Creates a new instance of productBean
     */
    public ProductBean() {
        
    }
    
    @PostConstruct
    public void init(){
        getAllProducts();
        message = "";
        
        
    }
}
