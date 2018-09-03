/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author fengcilin
 */
@Entity
public class HolidayPublic extends HolidayUser implements Serializable{
    
    private Set<HolidayTransaction> order;

    @OneToMany(mappedBy = "public", fetch = FetchType.LAZY)
    public Set<HolidayTransaction> getOrder() {
        return order;
    }

    public void setOrder(Set<HolidayTransaction> order) {
        this.order = order;
    }
}
