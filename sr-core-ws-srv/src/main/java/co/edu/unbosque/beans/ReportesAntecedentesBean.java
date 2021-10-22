package co.edu.unbosque.beans;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import antlr.Utils;
import co.edu.unbosque.bsn.ctrl.CiudadanosCtrlService;
import co.edu.unbosque.persistence.model.Ciudadano;
import co.edu.unbosque.reportes.FileJasperReportsHelper;




@Named( "ReportesAntecedentesBean")
@ViewScoped
public class ReportesAntecedentesBean implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Ciudadano antecedentesCiudadanos;
   
    public List<Ciudadano> listAntecedentesCiudadanos=null;
    public List<Ciudadano> listNoRequeridos=null;
    private Date fechaDesde;
    private Date fechaHasta;
    private int mes;
    private int anio;
    
    private String descripcionAntecedente;
    
    private String nombres;
    
    private String apellidos;
    
    
    
    @Inject
    CiudadanosCtrlService ciudadanosCtrlService;
    

    public ReportesAntecedentesBean() { 
    	listAntecedentesCiudadanos= null;
    	antecedentesCiudadanos = new Ciudadano();
        Calendar calendar = Calendar.getInstance();
        anio = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        fechaDesde = getPrimerDiaDelMes(anio,mes);
        fechaHasta = getUltimoDiaDelMes(anio,mes);  
    }
    
    public static Date getPrimerDiaDelMes(int anio, int mes) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, anio);
        cal.set(Calendar.MONTH, mes);
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }
    
    public static Date getUltimoDiaDelMes(int anio, int mes) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, anio);
        cal.set(Calendar.MONTH, mes);
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }
    
    @SuppressWarnings("null")
	public void consultarRequeridos(){
    	List<Ciudadano> requeridos=null;
    	
    	listAntecedentesCiudadanos =new ArrayList<Ciudadano>();
    	antecedentesCiudadanos = new Ciudadano();
    	nombres=null;
    	apellidos=null;
    	descripcionAntecedente=null;   	
        fechaDesde = getPrimerDiaDelMes(anio,mes);
        fechaHasta = getUltimoDiaDelMes(anio,mes);
             
        listAntecedentesCiudadanos = ciudadanosCtrlService.getRequeridos(fechaDesde,fechaHasta);        
           if(listAntecedentesCiudadanos!=null){
       		for(Ciudadano ciudadano : listAntecedentesCiudadanos ){
       			nombres=ciudadano.getPrimerNombre()+ " - " + ciudadano.getSegundoNombre();
       			apellidos=ciudadano.getPrimerApellido()+ " - " +ciudadano.getSegundoApellido();
       			ciudadano.setFechaexpedicion(listAntecedentesCiudadanos.get(0).getAntecedentesciudadanosList().get(0).getFechaRegistro());
       			listAntecedentesCiudadanos.get(0).setFechaexpedicion(ciudadano.getFechaexpedicion());
       			descripcionAntecedente= listAntecedentesCiudadanos.get(0).getAntecedentesciudadanosList().get(0).getIdantecedente().getDescripcion();
       		  }
       		}             
       }
    
    
    
    public void consultarNoRequeridos(){
    	listNoRequeridos = null;
    	antecedentesCiudadanos = new Ciudadano();
    	nombres=null;
    	apellidos=null;
    	
        listNoRequeridos = ciudadanosCtrlService.getNoRequeridos(fechaDesde,fechaHasta);
           if(listNoRequeridos!=null){
       		for(Ciudadano ciudadano : listNoRequeridos ){
       			nombres=ciudadano.getPrimerNombre()+ " - " + ciudadano.getSegundoNombre();
       			apellidos=ciudadano.getPrimerApellido()+ " - " +ciudadano.getSegundoApellido();       			
       						
       		  }
       		} 
       }

   
    @SuppressWarnings("unused")
	public void retornarFormatoPDF() throws Exception {
        byte[] file = null;
        FileJasperReportsHelper fileJasperReportsHelper = new FileJasperReportsHelper();
        if(listAntecedentesCiudadanos!=null){
        	
        	Properties propiedade = new Properties();
   
        	InputStream inputStream=this.getClass().getClassLoader().getResourceAsStream("Prueba.txt");
        	InputStream inputStreams=this.getClass().getResourceAsStream("Prueba.txt");
        	File files =new File(Utils.class.getResource("D:/sr-core-config/Requeridos").getFile());
        	
        	propiedade.load(new FileInputStream("D:/sr-core-config/sr-config.properties"));
            file = fileJasperReportsHelper.writeCollectionIntoPDFByte(listAntecedentesCiudadanos, "Requeridos.jasper");
        }
        if (file != null) {
            FacesContext faces = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) faces.getExternalContext().getResponse();
            response.setContentType("application/pdf");
            response.setContentLength(file.length);
            //response.setHeader("Content-disposition", "attachment;filename=\"" + "BalanceDetalladoCuentas.pdf" + "\"");
            response.setHeader("Content-disposition", "filename=\"" + "Requeridos.pdf" + "\"");
            try {
                ServletOutputStream out;
                out = response.getOutputStream();
                out.write(file);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            faces.responseComplete();
        }

    }
    
    public void retornarFormatoXls() throws Exception {
        byte[] file = null;
        FileJasperReportsHelper fileJasperReportsHelper = new FileJasperReportsHelper();
        if(listAntecedentesCiudadanos!=null){
            file = fileJasperReportsHelper.writeCollectionIntoExcelByte(listAntecedentesCiudadanos,"Requeridos.jasper");
        }
        if (file != null) {
            FacesContext faces = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) faces.getExternalContext().getResponse();
            
            
            response.setContentType("application/xls");
            response.setContentLength(file.length);
            //response.setHeader("Content-disposition", "attachment;filename=\"" + "BalanceDetalladoCuentas.pdf" + "\""); este sirve para mandarlo a descargar
            response.setHeader("Content-disposition", "attachment;filename=\"" + "Requeridos.xls" + "\"");
            try {
                ServletOutputStream out;
                out = response.getOutputStream();
                out.write(file);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //response.sendRedirect(null);
            faces.responseComplete();
        }

    }
    
    public void retornarFormatoXml() throws Exception {
        byte[] file = null;
        FileJasperReportsHelper fileJasperReportsHelper = new FileJasperReportsHelper();
        if(listAntecedentesCiudadanos!=null){
            file = fileJasperReportsHelper.writeCollectionIntoXmlByte(listAntecedentesCiudadanos,"Requeridos.jasper");
        }
        if (file != null) {
            FacesContext faces = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) faces.getExternalContext().getResponse();
            
            
            response.setContentType("application/xml");
            response.setContentLength(file.length);
            //response.setHeader("Content-disposition", "attachment;filename=\"" + "BalanceDetalladoCuentas.pdf" + "\""); este sirve para mandarlo a descargar
            response.setHeader("Content-disposition", "attachment;filename=\"" + "Requeridos.xml" + "\"");
            try {
                ServletOutputStream out;
                out = response.getOutputStream();
                out.write(file);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //response.sendRedirect(null);
            faces.responseComplete();
        }

    }
    
    public void retornarFormatoCsv() throws Exception {
        byte[] file = null;
        FileJasperReportsHelper fileJasperReportsHelper = new FileJasperReportsHelper();
        if(listAntecedentesCiudadanos!=null){
            file = fileJasperReportsHelper.writeCollectionIntoCsvByte(listAntecedentesCiudadanos,"Requeridos.jasper");
        }
        if (file != null) {
            FacesContext faces = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) faces.getExternalContext().getResponse();
            
            
            response.setContentType("application/csv");
            response.setContentLength(file.length);
            //response.setHeader("Content-disposition", "attachment;filename=\"" + "BalanceDetalladoCuentas.pdf" + "\""); este sirve para mandarlo a descargar
            response.setHeader("Content-disposition", "attachment;filename=\"" + "Requeridos.csv" + "\"");
            try {
                ServletOutputStream out;
                out = response.getOutputStream();
                out.write(file);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //response.sendRedirect(null);
            faces.responseComplete();
        }

    }
  

    
    public void retornarFormatoPDFnoRequerido() throws Exception {
        byte[] file = null;
        FileJasperReportsHelper fileJasperReportsHelper = new FileJasperReportsHelper();
        if(listNoRequeridos!=null){
            file = fileJasperReportsHelper.writeCollectionIntoPDFByte(listNoRequeridos,"BalanceGeneralCuentas.jasper");
        }
        if (file != null) {
            FacesContext faces = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) faces.getExternalContext().getResponse();
            response.setContentType("application/pdf");
            response.setContentLength(file.length);
            //response.setHeader("Content-disposition", "attachment;filename=\"" + "BalanceDetalladoCuentas.pdf" + "\"");
            response.setHeader("Content-disposition", "filename=\"" + "BalanceGeneralCuentas.pdf" + "\"");
            try {
                ServletOutputStream out;
                out = response.getOutputStream();
                out.write(file);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            faces.responseComplete();
        }

    }
    
    public void retornarFormatoXlsnoRequerido() throws Exception {
        byte[] file = null;
        FileJasperReportsHelper fileJasperReportsHelper = new FileJasperReportsHelper();
        if(listNoRequeridos!=null){
            file = fileJasperReportsHelper.writeCollectionIntoExcelByte(listNoRequeridos,"BalanceGeneralCuentas.jasper");
        }
        if (file != null) {
            FacesContext faces = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) faces.getExternalContext().getResponse();
            
            
            response.setContentType("application/xls");
            response.setContentLength(file.length);
            //response.setHeader("Content-disposition", "attachment;filename=\"" + "BalanceDetalladoCuentas.pdf" + "\""); este sirve para mandarlo a descargar
            response.setHeader("Content-disposition", "attachment;filename=\"" + "BalanceGeneralCuentas.xls" + "\"");
            try {
                ServletOutputStream out;
                out = response.getOutputStream();
                out.write(file);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //response.sendRedirect(null);
            faces.responseComplete();
        }

    }
    
    public void retornarFormatoXmlnoRequerido() throws Exception {
        byte[] file = null;
        FileJasperReportsHelper fileJasperReportsHelper = new FileJasperReportsHelper();
        if(listNoRequeridos!=null){
            file = fileJasperReportsHelper.writeCollectionIntoXmlByte(listNoRequeridos,"BalanceGeneralCuentas.jasper");
        }
        if (file != null) {
            FacesContext faces = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) faces.getExternalContext().getResponse();
            
            
            response.setContentType("application/xml");
            response.setContentLength(file.length);
            //response.setHeader("Content-disposition", "attachment;filename=\"" + "BalanceDetalladoCuentas.pdf" + "\""); este sirve para mandarlo a descargar
            response.setHeader("Content-disposition", "attachment;filename=\"" + "BalanceGeneralCuentas.xml" + "\"");
            try {
                ServletOutputStream out;
                out = response.getOutputStream();
                out.write(file);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //response.sendRedirect(null);
            faces.responseComplete();
        }

    }
    
    public void retornarFormatoCsvnoRequerido() throws Exception {
        byte[] file = null;
        FileJasperReportsHelper fileJasperReportsHelper = new FileJasperReportsHelper();
        if(listNoRequeridos!=null){
            file = fileJasperReportsHelper.writeCollectionIntoCsvByte(listNoRequeridos,"BalanceGeneralCuentas.jasper");
        }
        if (file != null) {
            FacesContext faces = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) faces.getExternalContext().getResponse();
            
            
            response.setContentType("application/csv");
            response.setContentLength(file.length);
            //response.setHeader("Content-disposition", "attachment;filename=\"" + "BalanceDetalladoCuentas.pdf" + "\""); este sirve para mandarlo a descargar
            response.setHeader("Content-disposition", "attachment;filename=\"" + "BalanceGeneralCuentas.csv" + "\"");
            try {
                ServletOutputStream out;
                out = response.getOutputStream();
                out.write(file);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //response.sendRedirect(null);
            faces.responseComplete();
        }

    }

  
    
    
    
	public Ciudadano getAntecedentesCiudadanos() {		 
        if (antecedentesCiudadanos == null) {
    	antecedentesCiudadanos = new Ciudadano();
    }
	return antecedentesCiudadanos;
	}

	public void setAntecedentesCiudadanos(Ciudadano antecedentesCiudadanos) {
		this.antecedentesCiudadanos = antecedentesCiudadanos;
	}

	public List<Ciudadano> getListAntecedentesCiudadanos() {
		return listAntecedentesCiudadanos;
	}

	public void setListAntecedentesCiudadanos(List<Ciudadano> listAntecedentesCiudadanos) {
		this.listAntecedentesCiudadanos = listAntecedentesCiudadanos;
	}

	
	public List<Ciudadano> getListNoRequeridos() {
		return listNoRequeridos;
	}

	public void setListNoRequeridos(List<Ciudadano> listNoRequeridos) {
		this.listNoRequeridos = listNoRequeridos;
	}  
    
    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
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

	public String getDescripcionAntecedente() {
		return descripcionAntecedente;
	}

	public void setDescripcionAntecedente(String descripcionAntecedente) {
		this.descripcionAntecedente = descripcionAntecedente;
	}

	
}
