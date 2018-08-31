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
public class Flight extends Product implements Serializable{
    private String airlineName;
    private String flightNo;
    private Calendar datetime;
    private double flightPrice;
}
