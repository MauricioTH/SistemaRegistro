package co.edu.unbosque.beans;



import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import co.edu.unbosque.bsn.ctrl.CiudadanosCtrlService;
import co.edu.unbosque.persistence.model.Antecedentes;
import co.edu.unbosque.persistence.model.Antecedentesciudadanos;
import co.edu.unbosque.persistence.model.Ciudad;
import co.edu.unbosque.persistence.model.Ciudadano;




@Named( "AntecedentesCiudadanosBeans")
@ViewScoped
public class AntecedentesCiudadanosBeans {


	//private static final long serialVersionUID = 1L;

	@Inject
	CiudadanosCtrlService ciudadanosCtrlService;
	
	private Ciudadano ciudadano;
	
	private Antecedentesciudadanos antecedentesciudadano;
    
    private List<Ciudadano> ciudadanos;
    
    private List<Ciudad> ciudades;
    
    private List<Antecedentes> antecedentes;
    
    
    @SuppressWarnings("unused")
	private Date today;

    public AntecedentesCiudadanosBeans() {
    
    }

    public void prepararInsertar() {
    	antecedentesciudadano = new Antecedentesciudadanos();
    	antecedentesciudadano.getIdentificacion().setIdentificacion(ciudadano.getIdentificacion()); 
    }
    
    
    public void insertar() {
    	antecedentesciudadano.getIdentificacion().setIdentificacion(ciudadano.getIdentificacion()); 
    	antecedentesciudadano.setRequerido(true); 
    	//antecedentesciudadano.setFechaRegistro(new Date()); 
    try {   	
    	ciudadanosCtrlService.insertarAntecedente(antecedentesciudadano); 
    	FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Antecedente Guardado Exitosamente"));
	} catch (Exception e) {
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Error al Guardar el Antecedente"));
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

	public Antecedentesciudadanos getAntecedentesciudadano() {
		return antecedentesciudadano;
	}

	public void setAntecedentesciudadano(
			Antecedentesciudadanos antecedentesciudadano) {
		this.antecedentesciudadano = antecedentesciudadano;
	}

	public List<Antecedentes> getAntecedentes() {
		antecedentes=ciudadanosCtrlService.buscarAllAntecedentes();
		return antecedentes;
	}

	public void setAntecedentes(List<Antecedentes> antecedentes) {
		this.antecedentes = antecedentes;
	}
  
}
