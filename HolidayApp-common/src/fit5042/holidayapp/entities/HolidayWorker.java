/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.entities;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author fengcilin
 */
@Entity
@DiscriminatorValue(value = "Worker")
public class HolidayWorker extends HolidayUser implements Serializable{
    
}
