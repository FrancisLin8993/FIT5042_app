/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import static org.apache.commons.codec.digest.DigestUtils.sha256Hex;

/**
 * A class of the user in the application.
 * @author fengcilin
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@NamedQueries({@NamedQuery(name = HolidayUser.FIND_ALL, query = "SELECT u FROM HolidayUser u"),
@NamedQuery(name = HolidayUser.FIND_USER_BY_ID, query = "SELECT u FROM HolidayUser u WHERE u.userId=:id"),
@NamedQuery(name = HolidayUser.FIND_USER_BY_EMAIL, query = "SELECT u FROM HolidayUser u WHERE u.email = :email")})
public class HolidayUser implements Serializable{
    public final static String FIND_ALL = "User.findAll";
    public final static String FIND_USER_BY_ID = "User.findUserById";
    public final static String FIND_USER_BY_EMAIL = "User.findUserByEmail";
    private UserType userType;
    private int userId;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private Address address;
    private String phoneNo;
    
    public HolidayUser() {
    }

    public HolidayUser(UserType type, int userId, String lastName, String firstName, String email, String password, Address address, String phoneNo) {
        this.userType = type;
        this.userId = userId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = sha256Hex(password);
        this.address = address;
        this.phoneNo = phoneNo;
    }
    
    
    /**
     * Unique user id of a user.
     * @return 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Last name of a user.
     * @return 
     */
    @NotNull(message = "Please enter your last name.")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Sorry, names cannot contain numberic characters.")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * First name of a user.
     * @return 
     */
    @NotNull(message = "Please enter your first name.")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Sorry, names cannot contain numberic characters.")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Email of a user.
     * @return 
     */
    @NotNull(message = "Please enter your email")
    @Pattern(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
            message = "Sorry, your input email does not conform to the correct format.")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * password of a user.
     * @return 
     */
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = sha256Hex(password);
    }
    
    /**
     * Address of a user.
     * @return 
     */
    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Phone number of a user.
     * @return 
     */
    @NotNull(message = "Please enter your phone number.")
    @Pattern(regexp = "^9\\d{7}|0\\d{9}$", 
           message = "Your phone number have to be 8 digits long if starting with 9, or be 10 digits long if starting with 0.")
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    /**
     * Type of a user.
     * @return 
     */
    @Enumerated(EnumType.STRING)
    @Column(name="USERTYPE")
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType type) {
        this.userType = type;
    }
    
    

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email + ", password=" + password + ", address=" + address + ", phoneNo=" + phoneNo + '}';
    }
    
}
