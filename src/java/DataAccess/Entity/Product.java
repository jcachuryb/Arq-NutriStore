/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juanca
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByNsname", query = "SELECT p FROM Product p WHERE p.nsname = ?1"),
    @NamedQuery(name = "Product.findByNstype", query = "SELECT p FROM Product p WHERE p.nstype = :nstype"),
    @NamedQuery(name = "Product.findByNscategory", query = "SELECT p FROM Product p WHERE p.nscategory = :nscategory")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nsname")
    private String nsname;
    @Size(max = 30)
    @Column(name = "nstype")
    private String nstype;
    @Size(max = 200)
    @Column(name = "nsdescription")
    private String nsdescription;
    @Size(max = 30)
    @Column(name = "nscategory")
    private String nscategory;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNsname() {
        return nsname;
    }

    public void setNsname(String nsname) {
        this.nsname = nsname;
    }

    public String getNstype() {
        return nstype;
    }

    public void setNstype(String nstype) {
        this.nstype = nstype;
    }

    public String getNsdescription() {
        return nsdescription;
    }

    public void setNsdescription(String nsdescription) {
        this.nsdescription = nsdescription;
    }

    public String getNscategory() {
        return nscategory;
    }

    public void setNscategory(String nscategory) {
        this.nscategory = nscategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Product[ id=" + id + " ]";
    }
    
}
