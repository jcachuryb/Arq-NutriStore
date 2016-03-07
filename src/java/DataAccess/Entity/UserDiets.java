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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juanca
 */
@Entity
@Table(name = "user_diets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDiets.findAll", query = "SELECT u FROM UserDiets u"),
    @NamedQuery(name = "UserDiets.findById", query = "SELECT u FROM UserDiets u WHERE u.id = :id"),
    @NamedQuery(name = "UserDiets.findByNsuserid", query = "SELECT u FROM UserDiets u WHERE u.nsuserid = :nsuserid"),
    @NamedQuery(name = "UserDiets.findByNsdietid", query = "SELECT u FROM UserDiets u WHERE u.nsdietid = :nsdietid")})
public class UserDiets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nsuserid")
    private int nsuserid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nsdietid")
    private int nsdietid;

    public UserDiets() {
    }

    public UserDiets(Integer id) {
        this.id = id;
    }

    public UserDiets(Integer id, int nsuserid, int nsdietid) {
        this.id = id;
        this.nsuserid = nsuserid;
        this.nsdietid = nsdietid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNsuserid() {
        return nsuserid;
    }

    public void setNsuserid(int nsuserid) {
        this.nsuserid = nsuserid;
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
        if (!(object instanceof UserDiets)) {
            return false;
        }
        UserDiets other = (UserDiets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.UserDiets[ id=" + id + " ]";
    }
    
}
