package co.edu.unbosque.bsn.ctrl;

import java.util.Date;
import java.util.List;

import org.example.registraduria.ConsultaAntecedentesReq;
import org.example.registraduria.ConsultaAntecedentesResp;

import co.edu.unbosque.persistence.model.Antecedentes;
import co.edu.unbosque.persistence.model.Antecedentesciudadanos;
import co.edu.unbosque.persistence.model.Ciudad;
import co.edu.unbosque.persistence.model.Ciudadano;



/**
 * Servicio puente para las peticiones entre los servicios de Payments y el Core
 * @author Mauricio Tacon Hernandez
 * @version 1.0
 * @since 1.0
 * @Fecha Agosto 17 del 2017
 */
public interface CiudadanosCtrlService {

    
    public ConsultaAntecedentesResp consultaAntecedente(ConsultaAntecedentesReq parameter);
    
    public List<Ciudadano>buscarTodos();
    
    public List<Ciudad>buscarAllCiudades();
    
    public List<Antecedentes>buscarAllAntecedentes();
    
    public void insertar(Ciudadano ciudadano);
    
    public void insertarAntecedente(Antecedentesciudadanos ciudadano);
    
    public List<Ciudadano>getRequeridos(Date fechaDesde, Date fechaHasta);
    
    public List<Ciudadano>getNoRequeridos(Date fechaDesde, Date fechaHasta);

  
}
