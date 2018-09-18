/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.entities;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

/**
 *
 * @author fengcilin
 */
@Embeddable
@Access(AccessType.PROPERTY)
public class Address implements Serializable{
    private String streetAddress;
    private String city;
    private String country;
    private String postcode;

    public Address() {
    }

    public Address(String streetAddress, String city, String country, String postcode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
        this.postcode = postcode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return  streetAddress + ", " + city + ", " + country + ", " + postcode;
        
    }
    
}
