package co.edu.unbosque.bsn.ctrl.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.example.registraduria.ConsultaAntecedentesReq;
import org.example.registraduria.ConsultaAntecedentesResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.edu.unbosque.bsn.ctrl.CiudadanosCtrlService;
import co.edu.unbosque.bsn.services.CiudadanosBussinesService;
import co.edu.unbosque.converter.CiudadanosObjectsConverter;
import co.edu.unbosque.dto.in.CiudadanosInDTO;
import co.edu.unbosque.dto.out.CiudadanosOutDTO;
import co.edu.unbosque.persistence.dao.AntecedentesCiudadanosDAO;
import co.edu.unbosque.persistence.dao.AntecedentesDAO;
import co.edu.unbosque.persistence.dao.CiudadDAO;
import co.edu.unbosque.persistence.dao.CiudadanosDAO;
import co.edu.unbosque.persistence.model.Antecedentes;
import co.edu.unbosque.persistence.model.Antecedentesciudadanos;
import co.edu.unbosque.persistence.model.Ciudad;
import co.edu.unbosque.persistence.model.Ciudadano;

@Service
public class CiudadanosCtrlServiceImpl implements CiudadanosCtrlService {

	static Logger LOGGER = LoggerFactory.getLogger(CiudadanosCtrlServiceImpl.class);

	@Resource
	CiudadanosBussinesService ciudadanosBussinesService;
	
	@Resource
	CiudadanosDAO ciudadanosDAO;
	
	@Resource
	CiudadDAO ciudadDAO;
	
	@Resource
	AntecedentesCiudadanosDAO antecedentesCiudadanosDAO;
	
	@Resource
	AntecedentesDAO antecedentesDAO;
	
	List<Ciudadano>listRequeridos; 
	
	List<Ciudadano>listNotRequeridos;
	
	List<Antecedentes>listAntecedentes;
	
	
	
	@Override
	public ConsultaAntecedentesResp consultaAntecedente(ConsultaAntecedentesReq parameter) {
		// TODO Auto-generated method stub
		CiudadanosInDTO ciiudadanosInDTO = CiudadanosObjectsConverter.convertAntecedentesTypeToUsuarioInDTO(parameter.getAntecedentesIn()); 
		CiudadanosOutDTO ciudadanosOutDTO = ciudadanosBussinesService.getAntecedentes(ciiudadanosInDTO); 
		ConsultaAntecedentesResp responseType = CiudadanosObjectsConverter.toAntecedentesResponseType(ciudadanosOutDTO);
		return responseType;
	}
	

	@Override
	public List<Ciudadano> buscarTodos() {
		List<Ciudadano> ciudadanos=null;
		ciudadanos=ciudadanosDAO.buscarTodos();
		return ciudadanos;
	}

	@Override
	public List<Ciudad> buscarAllCiudades() {
		// TODO Auto-generated method stub
		List<Ciudad> ciudades=null;
		ciudades=ciudadDAO.buscarAll();
		return ciudades;
	}

	@Override
	public void insertar(Ciudadano ciudadano) {
		try {
			ciudadanosDAO.create(ciudadano);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public List<Ciudadano> getRequeridos(Date fechaDesde, Date fechaHasta) {
		listRequeridos = ciudadanosDAO.getRequeridos(fechaDesde, fechaHasta);
		return listRequeridos;
	}

	@Override
	public List<Ciudadano> getNoRequeridos(Date fechaDesde, Date fechaHasta) {
		listNotRequeridos = ciudadanosDAO.getNotRequeridos(fechaDesde, fechaHasta);
		return listNotRequeridos;
	}

	@Override
	public void insertarAntecedente(Antecedentesciudadanos antecedentes) {
	try {
		antecedentesCiudadanosDAO.create(antecedentes);
	} catch (Exception e) {
		throw e;
	}
		
	}

	@Override
	public List<Antecedentes> buscarAllAntecedentes() {
		listAntecedentes=antecedentesDAO.buscarAllAntecedentes();
		return listAntecedentes;
	}

	

	
	
	
}
