package co.edu.unbosque.beans;



import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

//import model.Mndaccipermi;
import org.primefaces.context.RequestContext;

import co.edu.unbosque.bsn.ctrl.UsuarosCtrlService;
import co.edu.unbosque.persistence.model.Usuario;


@Named( "LoginBean")
@SessionScoped
public class LoginBean implements Serializable {
	
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
    
	@Inject
    UsuarosCtrlService usuarosCtrlService;
    
    
    
    public LoginBean() {
    }

    
    public void login() {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean loggedIn = false;
         
        try {
        	usuario = usuarosCtrlService.loginUsua(usuario);

            if (usuario != null) {        	
                loggedIn = true;
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", "Mndusua");
                
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
                FacesContext.getCurrentInstance().getExternalContext().redirect("View/menu.xhtml");
           
            } else {
                loggedIn = false;
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
        

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
    }

    
    
    
    
    
    
    
    
   
    public void clocksSessions() {
    	  FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
   	try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/paymentServices/View/Inicio/inicio.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public void clocksSession() {
  	  FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
  	try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("../");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
    
    

    
    
//    public boolean canInsert() {
//        Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//        Set acciones = (Set) session.get("acciones");
//        if (acciones != null) {
//            for (Object a : acciones) {
//                Mndaccipermi ap = (Mndaccipermi) a;
//                if (ap.getMndacciones().getIdAccion() == 1) {
//                    return true;
//                }
//            }
//        }
//        return false;
//
//    }
//
//    public boolean canUdate() {
//        Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//        Set acciones = (Set) session.get("acciones");
//        if (acciones != null) {
//            for (Object a : acciones) {
//                Mndaccipermi ap = (Mndaccipermi) a;
//                if (ap.getMndacciones().getIdAccion() == 2) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public boolean canDelete() {
//        Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//        Set acciones = (Set) session.get("acciones");
//        if (acciones != null) {
//            for (Object a : acciones) {
//                Mndaccipermi ap = (Mndaccipermi) a;
//                if (ap.getMndacciones().getIdAccion() == 3) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

   

	public Usuario getUsuario() {
		if (usuario == null) {
            usuario = new Usuario();
        }
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
