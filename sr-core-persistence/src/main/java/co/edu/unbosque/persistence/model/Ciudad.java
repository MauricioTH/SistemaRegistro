/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.persistence.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import co.edu.unbosque.persistence.PersistentObject;

/**
 *
 * @author MauricioTascon
 */
@Entity
@Table(name = "CIUDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "Ciudad.findById", query = "SELECT c FROM Ciudad c WHERE c.id = :id"),
    @NamedQuery(name = "Ciudad.findByNombreciudad", query = "SELECT c FROM Ciudad c WHERE c.nombreciudad = :nombreciudad")})
public class Ciudad implements PersistentObject {

    private static final long serialVersionUID = -1527091107005764626L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOMBRECIUDAD")
    private String nombreciudad;
    @OneToMany(mappedBy = "lugarexpedicion", fetch = FetchType.LAZY)
    private List<Ciudadano> ciudadanoList;
    @OneToMany(mappedBy = "lugarnacimiento", fetch = FetchType.LAZY)
    private List<Ciudadano> ciudadanoList1;
    @JoinColumn(name = "DEPARTAMENTO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Departamento departamento;

    public Ciudad() {
    	this.departamento = new Departamento();
    }

    public Ciudad(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreciudad() {
        return nombreciudad;
    }

    public void setNombreciudad(String nombreciudad) {
        this.nombreciudad = nombreciudad;
    }

    @XmlTransient
    public List<Ciudadano> getCiudadanoList() {
        return ciudadanoList;
    }

    public void setCiudadanoList(List<Ciudadano> ciudadanoList) {
        this.ciudadanoList = ciudadanoList;
    }

    @XmlTransient
    public List<Ciudadano> getCiudadanoList1() {
        return ciudadanoList1;
    }

    public void setCiudadanoList1(List<Ciudadano> ciudadanoList1) {
        this.ciudadanoList1 = ciudadanoList1;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
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
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unbosque.persistence.model.Ciudad[ id=" + id + " ]";
    }

	@Override
	public boolean isRowDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRowDeleted(boolean rowDeleted) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getRowCreationDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRowCreationDate(Date rowCreationDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getRowLastUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRowLastUpdate(Date rowLastUpdate) {
		// TODO Auto-generated method stub
		
	}
    
}
