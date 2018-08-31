/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.entities;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author fengcilin
 */
public class Hotel extends Product implements Serializable{
    private Address address;
    private String hotelName;
    private Calendar startDate;
    private Calendar endDate;
    private double pricePerNight;
}
