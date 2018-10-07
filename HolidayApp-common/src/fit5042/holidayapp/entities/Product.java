/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A class of Holiday Package Product.
 * @author fengcilin
 */
@Entity
@XmlRootElement
public class Product implements Serializable{
    
    private int Id;
    private String productName;
    private String description;
    private String hotelName;
    private String airlineName;
    private Date startDate;
    private Date endDate;
    private double price;
    private Set<HolidayTransaction> trasaction;

    public Product() {
    }

    public Product(int Id, String productName, String description, String hotelName, String airlineName, Date startDate, Date endDate, double price) {
        this.Id = Id;
        this.productName = productName;
        this.description = description;
        this.hotelName = hotelName;
        this.airlineName = airlineName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.trasaction = new HashSet<>();
    }

    
    /**
     * Unique ID of a product.
     * @return 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * Name of a product.
     * @return 
     */
    @NotNull(message = "Please enter a product name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Description of a product.
     * @return 
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Hotel name in a product.
     * @return 
     */
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * Airline company name in a product.
     * @return 
     */
    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    /**
     * Start Date of the journey of the holiday package.
     * @return 
     */
    @NotNull(message = "please enter a start date")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * End Date of the journey of the holiday package.
     * @return 
     */
    @NotNull(message = "please enter a end date")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Price of a holiday package product.
     * @return 
     */
    @NotNull(message = "please enter a price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Transaction of a product.
     * @return 
     */
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    public Set<HolidayTransaction> getTrasaction() {
        return trasaction;
    }

    public void setTrasaction(Set<HolidayTransaction> trasaction) {
        this.trasaction = trasaction;
    }
    
    
}
