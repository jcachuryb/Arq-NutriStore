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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juanca
 */
@Entity
@Table(name = "diet_products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DietProducts.findAll", query = "SELECT d FROM DietProducts d"),
    @NamedQuery(name = "DietProducts.findById", query = "SELECT d FROM DietProducts d WHERE d.id = :id"),
    @NamedQuery(name = "DietProducts.findByNsproductid", query = "SELECT d FROM DietProducts d WHERE d.nsproductid = :nsproductid"),
    @NamedQuery(name = "DietProducts.findByNsdietid", query = "SELECT d FROM DietProducts d WHERE d.nsdietid = :nsdietid")})
public class DietProducts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nsproductid")
    private int nsproductid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nsdietid")
    private int nsdietid;

    public DietProducts() {
    }

    public DietProducts(Integer id) {
        this.id = id;
    }

    public DietProducts(Integer id, int nsproductid, int nsdietid) {
        this.id = id;
        this.nsproductid = nsproductid;
        this.nsdietid = nsdietid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNsproductid() {
        return nsproductid;
    }

    public void setNsproductid(int nsproductid) {
        this.nsproductid = nsproductid;
    }

    public int getNsdietid() {
        return nsdietid;
    }

    public void setNsdietid(int nsdietid) {
        this.nsdietid = nsdietid;
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
        if (!(object instanceof DietProducts)) {
            return false;
        }
        DietProducts other = (DietProducts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.DietProducts[ id=" + id + " ]";
    }
    
}
