/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.webservice;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fengcilin
 */
@Entity
@Table(name = "HOLIDAYUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Holidayuser.findAll", query = "SELECT h FROM Holidayuser h")
    , @NamedQuery(name = "Holidayuser.findByUserid", query = "SELECT h FROM Holidayuser h WHERE h.userid = :userid")
    , @NamedQuery(name = "Holidayuser.findByUserType", query = "SELECT h FROM Holidayuser h WHERE h.userType = :userType")
    , @NamedQuery(name = "Holidayuser.findByEmail", query = "SELECT h FROM Holidayuser h WHERE h.email = :email")
    , @NamedQuery(name = "Holidayuser.findByFirstname", query = "SELECT h FROM Holidayuser h WHERE h.firstname = :firstname")
    , @NamedQuery(name = "Holidayuser.findByLastname", query = "SELECT h FROM Holidayuser h WHERE h.lastname = :lastname")
    , @NamedQuery(name = "Holidayuser.findByPassword", query = "SELECT h FROM Holidayuser h WHERE h.password = :password")
    , @NamedQuery(name = "Holidayuser.findByPhoneno", query = "SELECT h FROM Holidayuser h WHERE h.phoneno = :phoneno")
    , @NamedQuery(name = "Holidayuser.findByUsertype", query = "SELECT h FROM Holidayuser h WHERE h.usertype = :usertype")
    , @NamedQuery(name = "Holidayuser.findByCity", query = "SELECT h FROM Holidayuser h WHERE h.city = :city")
    , @NamedQuery(name = "Holidayuser.findByCountry", query = "SELECT h FROM Holidayuser h WHERE h.country = :country")
    , @NamedQuery(name = "Holidayuser.findByPostcode", query = "SELECT h FROM Holidayuser h WHERE h.postcode = :postcode")
    , @NamedQuery(name = "Holidayuser.findByStreetaddress", query = "SELECT h FROM Holidayuser h WHERE h.streetaddress = :streetaddress")})
public class Holidayuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private Integer userid;
    @Size(max = 31)
    @Column(name = "USER_TYPE")
    private String userType;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 255)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 255)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 255)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 255)
    @Column(name = "PHONENO")
    private String phoneno;
    @Size(max = 255)
    @Column(name = "USERTYPE")
    private String usertype;
    @Size(max = 255)
    @Column(name = "CITY")
    private String city;
    @Size(max = 255)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 255)
    @Column(name = "POSTCODE")
    private String postcode;
    @Size(max = 255)
    @Column(name = "STREETADDRESS")
    private String streetaddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publicId")
    private Collection<Holidaytransaction> holidaytransactionCollection;

    public Holidayuser() {
    }

    public Holidayuser(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
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

    public String getStreetaddress() {
        return streetaddress;
    }

    public void setStreetaddress(String streetaddress) {
        this.streetaddress = streetaddress;
    }

    @XmlTransient
    public Collection<Holidaytransaction> getHolidaytransactionCollection() {
        return holidaytransactionCollection;
    }

    public void setHolidaytransactionCollection(Collection<Holidaytransaction> holidaytransactionCollection) {
        this.holidaytransactionCollection = holidaytransactionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Holidayuser)) {
            return false;
        }
        Holidayuser other = (Holidayuser) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5042.holidayapp.webservice.Holidayuser[ userid=" + userid + " ]";
    }
    
}