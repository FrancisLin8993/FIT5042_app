/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.webservice;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fengcilin
 */
@Entity
@Table(name = "HOLIDAYTRANSACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Holidaytransaction.findAll", query = "SELECT h FROM Holidaytransaction h")
    , @NamedQuery(name = "Holidaytransaction.findByTransactionno", query = "SELECT h FROM Holidaytransaction h WHERE h.transactionno = :transactionno")
    , @NamedQuery(name = "Holidaytransaction.findByDescription", query = "SELECT h FROM Holidaytransaction h WHERE h.description = :description")
    , @NamedQuery(name = "Holidaytransaction.findByName", query = "SELECT h FROM Holidaytransaction h WHERE h.name = :name")
    , @NamedQuery(name = "Holidaytransaction.findByStatus", query = "SELECT h FROM Holidaytransaction h WHERE h.status = :status")
    , @NamedQuery(name = "Holidaytransaction.findByTransactiontype", query = "SELECT h FROM Holidaytransaction h WHERE h.transactiontype = :transactiontype")})
public class Holidaytransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSACTIONNO")
    private Integer transactionno;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Size(max = 255)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 255)
    @Column(name = "TRANSACTIONTYPE")
    private String transactiontype;
    @JoinColumn(name = "PUBLIC_ID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private Holidayuser publicId;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Product productId;

    public Holidaytransaction() {
    }

    public Holidaytransaction(Integer transactionno) {
        this.transactionno = transactionno;
    }

    public Integer getTransactionno() {
        return transactionno;
    }

    public void setTransactionno(Integer transactionno) {
        this.transactionno = transactionno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    public Holidayuser getPublicId() {
        return publicId;
    }

    public void setPublicId(Holidayuser publicId) {
        this.publicId = publicId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionno != null ? transactionno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Holidaytransaction)) {
            return false;
        }
        Holidaytransaction other = (Holidaytransaction) object;
        if ((this.transactionno == null && other.transactionno != null) || (this.transactionno != null && !this.transactionno.equals(other.transactionno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5042.holidayapp.webservice.Holidaytransaction[ transactionno=" + transactionno + " ]";
    }
    
}
