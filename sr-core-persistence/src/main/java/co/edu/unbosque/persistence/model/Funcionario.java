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
@Table(name = "FUNCIONARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByIdentificacion", query = "SELECT f FROM Funcionario f WHERE f.identificacion = :identificacion"),
    @NamedQuery(name = "Funcionario.findByNombres", query = "SELECT f FROM Funcionario f WHERE f.nombres = :nombres"),
    @NamedQuery(name = "Funcionario.findByApellidos", query = "SELECT f FROM Funcionario f WHERE f.apellidos = :apellidos"),
    @NamedQuery(name = "Funcionario.findByCorreoElectronico", query = "SELECT f FROM Funcionario f WHERE f.correoElectronico = :correoElectronico")})
public class Funcionario implements PersistentObject {

    private static final long serialVersionUID = -1527091107005764626L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDENTIFICACION")
    private Integer identificacion;
    @Column(name = "NOMBRES")
    private String nombres;
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @OneToMany(mappedBy = "identificacion", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;
    @JoinColumn(name = "IDRANGO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Rango idrango;
    @JoinColumn(name = "IDFUERZAPUBLICA", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fuerzapublica idfuerzapublica;

    public Funcionario() {
    	this.idfuerzapublica = new Fuerzapublica();
    	this.idrango = new Rango();
    }

    public Funcionario(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Rango getIdrango() {
        return idrango;
    }

    public void setIdrango(Rango idrango) {
        this.idrango = idrango;
    }

    public Fuerzapublica getIdfuerzapublica() {
        return idfuerzapublica;
    }

    public void setIdfuerzapublica(Fuerzapublica idfuerzapublica) {
        this.idfuerzapublica = idfuerzapublica;
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
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unbosque.persistence.model.Funcionario[ identificacion=" + identificacion + " ]";
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
