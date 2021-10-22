/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.persistence.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import co.edu.unbosque.persistence.PersistentObject;

/**
 *
 * @author MauricioTascon
 */
@Entity
@Table(name = "ANTECEDENTESCIUDADANOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Antecedentesciudadanos.findAll", query = "SELECT a FROM Antecedentesciudadanos a"),
    @NamedQuery(name = "Antecedentesciudadanos.findById", query = "SELECT a FROM Antecedentesciudadanos a WHERE a.id = :id"),
    @NamedQuery(name = "Antecedentesciudadanos.findByFechaRegistro", query = "SELECT a FROM Antecedentesciudadanos a WHERE a.fechaRegistro = :fechaRegistro")})
public class Antecedentesciudadanos implements PersistentObject {

    private static final long serialVersionUID = -1527091107005764626L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(
			name="ID_GENERATOR_SEQ_ANTECEDENTES",
			sequenceName="SEQ_ANTECEDENTES",
			initialValue=1,
			allocationSize=1
			)
    @GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="ID_GENERATOR_SEQ_ANTECEDENTES"
			)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro; 
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;   
    @Column(name = "REQUERIDO")
    private Boolean requerido;  
    @JoinColumn(name = "IDENTIFICACION", referencedColumnName = "IDENTIFICACION")
    @ManyToOne(fetch = FetchType.EAGER)
    private Ciudadano identificacion;
    @JoinColumn(name = "IDANTECEDENTE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Antecedentes idantecedente;

    public Antecedentesciudadanos() {
    	this.identificacion = new Ciudadano();
    	this.idantecedente = new Antecedentes();
    }

    public Antecedentesciudadanos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechamodificacion() {
		return fechamodificacion;
	}

	public void setFechamodificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}

	public Boolean getRequerido() {
		return requerido;
	}

	public void setRequerido(Boolean requerido) {
		this.requerido = requerido;
	}

	public Ciudadano getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Ciudadano identificacion) {
        this.identificacion = identificacion;
    }

    public Antecedentes getIdantecedente() {
        return idantecedente;
    }

    public void setIdantecedente(Antecedentes idantecedente) {
        this.idantecedente = idantecedente;
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
        if (!(object instanceof Antecedentesciudadanos)) {
            return false;
        }
        Antecedentesciudadanos other = (Antecedentesciudadanos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unbosque.persistence.model.Antecedentesciudadanos[ id=" + id + " ]";
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
