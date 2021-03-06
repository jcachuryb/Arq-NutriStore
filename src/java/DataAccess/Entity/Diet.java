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
@Table(name = "diet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diet.findAll", query = "SELECT d FROM Diet d"),
    @NamedQuery(name = "Diet.findById", query = "SELECT d FROM Diet d WHERE d.id = :id"),
    @NamedQuery(name = "Diet.findByNsname", query = "SELECT d FROM Diet d WHERE d.nsname = ?1")})
public class Diet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nsname")
    private String nsname;
    @Size(max = 300)
    @Column(name = "nsdescription")
    private String nsdescription;

    public Diet() {
    }

    public Diet(Integer id) {
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

    public String getNsdescription() {
        return nsdescription;
    }

    public void setNsdescription(String nsdescription) {
        this.nsdescription = nsdescription;
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
        if (!(object instanceof Diet)) {
            return false;
        }
        Diet other = (Diet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Diet[ id=" + id + " ]";
    }
    
}
