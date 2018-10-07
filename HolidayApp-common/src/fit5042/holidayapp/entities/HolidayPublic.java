/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A class of public user in the application
 * @author fengcilin
 */
@Entity
@DiscriminatorValue(value = "Public")
@XmlRootElement
public class HolidayPublic extends HolidayUser implements Serializable{
    
    private Set<HolidayTransaction> transaction;

    public HolidayPublic() {
    }

    public HolidayPublic(UserType type, int userId, String lastName, String firstName, String email, String password, Address address, String phoneNo) {
        super(type, userId, lastName, firstName, email, password, address, phoneNo);
        this.transaction = new HashSet<>();
    }
    
    

    /**
     * The Collection of transactions a specific public has.
     * @return 
     */
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    public Set<HolidayTransaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<HolidayTransaction> transaction) {
        this.transaction = transaction;
    }
}
