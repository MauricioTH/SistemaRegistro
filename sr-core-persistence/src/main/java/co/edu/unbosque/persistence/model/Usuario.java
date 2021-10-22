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
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Proxy;

import co.edu.unbosque.persistence.PersistentObject;

/**
 *
 * @author MauricioTascon
 */
@Entity
@Proxy(lazy = false)
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByNotificacionEmail", query = "SELECT u FROM Usuario u WHERE u.notificacionEmail = :notificacionEmail"),
    @NamedQuery(name = "Usuario.findByFechaCreacion", query = "SELECT u FROM Usuario u WHERE u.fechaCreacion = :fechaCreacion")})
public class Usuario implements PersistentObject {

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
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "NOTIFICACION_EMAIL")
    private Boolean notificacionEmail;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumn(name = "IDFUERZAPUBLICA", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fuerzapublica idfuerzapublica;
    @JoinColumn(name = "IDRANGO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Rango idrango;  
    @JoinColumn(name = "IDPERFIL", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Perfil idperfil;  
   

    
    public Usuario() {  	
    	this.idfuerzapublica = new Fuerzapublica();
    	this.idrango = new Rango();  
    	this.idperfil = new Perfil();
    }
   
    public Usuario(Integer identificacion) {
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getNotificacionEmail() {
        return notificacionEmail;
    }

    public void setNotificacionEmail(Boolean notificacionEmail) {
        this.notificacionEmail = notificacionEmail;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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
    
    public Perfil getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Perfil idperfil) {
        this.idperfil = idperfil;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unbosque.persistence.model.Usuario[ identificacion=" + identificacion + " ]";
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
