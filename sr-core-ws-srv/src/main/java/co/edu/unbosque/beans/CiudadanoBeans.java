package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import co.edu.unbosque.bsn.ctrl.CiudadanosCtrlService;
import co.edu.unbosque.persistence.model.Ciudad;
import co.edu.unbosque.persistence.model.Ciudadano;




@Named( "CiudadanoBeans")
@RequestScoped
public class CiudadanoBeans implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	CiudadanosCtrlService ciudadanosCtrlService;
	
	private Ciudadano ciudadano;
    
    private List<Ciudadano> ciudadanos;
    
    private List<Ciudad> ciudades;
    
    @SuppressWarnings("unused")
	private Date today;

    public CiudadanoBeans() {
    
    }

    public void prepararInsertar() {
    	ciudadano = new Ciudadano();
    }
    
    
    public void prepararActualizar(Integer paiscodi) {
       
    }
    
    public void prepararEliminar(Integer paiscodi) {
        
    }

    public void insertar() {
    try {   	
    	ciudadanosCtrlService.insertar(ciudadano); 
    	FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Ciudadano Guardado Exitosamente"));
	} catch (Exception e) {
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Error al Guardar el Ciudadano"));
	}	
    	
    }


    public Ciudadano getCiudadano() {
        if (ciudadano == null) {
        	ciudadano = new Ciudadano();
        }
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public List<Ciudadano> getCiudadanos() {
    	ciudadanos = ciudadanosCtrlService.buscarTodos();
        return ciudadanos;
    }

    public void setCiudadanos(List<Ciudadano> ciudadanos) {
        this.ciudadanos = ciudadanos;
    }

    
    public Date getToday() {
        return new Date();
    }

    public void setToday(Date today) {
        this.today = today;
    }

	public List<Ciudad> getCiudades() {	
		ciudades=ciudadanosCtrlService.buscarAllCiudades();
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
  
}
