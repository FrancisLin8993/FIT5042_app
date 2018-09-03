/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author fengcilin
 */
public class Product implements Serializable{
    
    private int Id;
    private String productName;
    private String description;
    private String hotelName;
    private String airlineName;
    private Date startDate;
    private Date endDate;
    private double price;
    
    
}
