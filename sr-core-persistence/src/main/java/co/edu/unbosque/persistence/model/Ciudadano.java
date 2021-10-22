/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.persistence.model;

import java.util.ArrayList;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import co.edu.unbosque.persistence.PersistentObject;

/**
 *
 * @author MauricioTascon
 */
@Entity
@Table(name = "CIUDADANO")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Ciudadano.findAll", query = "SELECT c FROM Ciudadano c"),
    @NamedQuery(name = "Ciudadano.findByIdentificacion", query = "SELECT c FROM Ciudadano c WHERE c.identificacion = :identificacion"),
    @NamedQuery(name = "Ciudadano.findByPrimerNombre", query = "SELECT c FROM Ciudadano c WHERE c.primerNombre = :primerNombre"),
    @NamedQuery(name = "Ciudadano.findBySegundoNombre", query = "SELECT c FROM Ciudadano c WHERE c.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Ciudadano.findByFechanacimiento", query = "SELECT c FROM Ciudadano c WHERE c.fechanacimiento = :fechanacimiento"),
    @NamedQuery(name = "Ciudadano.findByFechaexpedicion", query = "SELECT c FROM Ciudadano c WHERE c.fechaexpedicion = :fechaexpedicion"),
    @NamedQuery(name = "Ciudadano.findByRh", query = "SELECT c FROM Ciudadano c WHERE c.rh = :rh"),
    @NamedQuery(name = "Ciudadano.findBySexo", query = "SELECT c FROM Ciudadano c WHERE c.sexo = :sexo"),
    @NamedQuery(name = "Ciudadano.findByPrimerApellido", query = "SELECT c FROM Ciudadano c WHERE c.primerApellido = :primerApellido"),
    @NamedQuery(name = "Ciudadano.findBySegundoApellido", query = "SELECT c FROM Ciudadano c WHERE c.segundoApellido = :segundoApellido")})

public class Ciudadano implements PersistentObject {

    private static final long serialVersionUID = -1527091107005764626L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDENTIFICACION")
    private Integer identificacion;  
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Column(name = "FECHANACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechanacimiento;
    @Column(name = "FECHAEXPEDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaexpedicion;
    @Column(name = "RH")
    private String rh;
    @Column(name = "SEXO")
    private String sexo;
    @JoinColumn(name = "LUGAREXPEDICION", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Ciudad lugarexpedicion;
    @JoinColumn(name = "LUGARNACIMIENTO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Ciudad lugarnacimiento;
    @OneToMany(mappedBy = "identificacion", fetch = FetchType.EAGER)
    private List<Antecedentesciudadanos> antecedentesciudadanosList;
    

    public Ciudadano() {
    	this.lugarnacimiento = new Ciudad();
    	this.lugarexpedicion = new Ciudad();
    	this.antecedentesciudadanosList= new ArrayList<Antecedentesciudadanos>();
    	
    }

    public Ciudadano(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Date getFechaexpedicion() {
        return fechaexpedicion;
    }

    public void setFechaexpedicion(Date fechaexpedicion) {
        this.fechaexpedicion = fechaexpedicion;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Ciudad getLugarexpedicion() {
        return lugarexpedicion;
    }

    public void setLugarexpedicion(Ciudad lugarexpedicion) {
        this.lugarexpedicion = lugarexpedicion;
    }

    public Ciudad getLugarnacimiento() {
        return lugarnacimiento;
    }

    public void setLugarnacimiento(Ciudad lugarnacimiento) {
        this.lugarnacimiento = lugarnacimiento;
    }
    
    
    @XmlTransient
    public List<Antecedentesciudadanos> getAntecedentesciudadanosList() {
        return antecedentesciudadanosList;
    }

    public void setAntecedentesciudadanosList(List<Antecedentesciudadanos> antecedentesciudadanosList) {
        this.antecedentesciudadanosList = antecedentesciudadanosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacion != null ? identificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudadano)) {
            return false;
        }
        Ciudadano other = (Ciudadano) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unbosque.persistence.model.Ciudadano[ identificacion=" + identificacion + " ]";
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
