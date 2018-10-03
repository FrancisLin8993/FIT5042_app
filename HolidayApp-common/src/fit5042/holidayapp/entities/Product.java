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
 *
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

    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    @NotNull(message = "Please enter a product name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    @NotNull(message = "please enter a start date")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @NotNull(message = "please enter a end date")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @NotNull(message = "please enter a price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    public Set<HolidayTransaction> getTrasaction() {
        return trasaction;
    }

    public void setTrasaction(Set<HolidayTransaction> trasaction) {
        this.trasaction = trasaction;
    }
    
    
}
