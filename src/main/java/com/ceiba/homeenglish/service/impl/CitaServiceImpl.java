package com.ceiba.homeenglish.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.homeenglish.service.CitaService;
import com.ceiba.homeenglish.dao.CitaDao;
import com.ceiba.homeenglish.domain.Cita;

@Service
public class CitaServiceImpl implements CitaService{
	
	private static final String ESTADO_CREACION = "PENDIENTE DE PAGO";
	private static final String ESTADO_APROBACION = "APROBADA";
	private static final String ESTADO_RECHAZO = "REACHAZADA";
	private static final Double PRECIO_HORA_CITA = 25000D;
	private static final int NUMERO_HORAS_DIA = 24;
	
	@Autowired
    CitaDao citaDao;
	
	public Cita guardarCita(Cita cita) {		
		if (verificarValidesGuardadoDeCita(cita)) {
			cita.setEstadoCita(ESTADO_CREACION);
			cita.setPrecio(calcularPrecioCita(cita));
			cita.setFechaFin(obtenerFechaFinCita(cita));			
			try {
				citaDao.save(cita);
				return cita;
    		} catch (Exception e) {
    			return null;
    		}						
		} else {
			return null;
		}
	}
	
	public double calcularPrecioCita(Cita cita) {
		return PRECIO_HORA_CITA*cita.getCantidadHoras();
	}
	
	public LocalDateTime obtenerFechaFinCita(Cita cita) {
		return cita.getFechaInicio().plusHours(cita.getCantidadHoras());
	}
	

    public boolean aprobarCitaPorId(long id) {    	
    	Cita cita = citaDao.findById(id).get();  	
    	if(cita != null) {
    		try {
    			cita.setEstadoCita(ESTADO_APROBACION); 
    			citaDao.save(cita);	
    			return true;
    		} catch (Exception e) {
    			return false;
    		}    		
    	}else {
    		return false;
    	}
    }
    
    public boolean rechazarCitaPorId(long id) {    	
    	Cita cita = citaDao.findById(id).get();  	
    	if(cita != null) {
    		try {
    			cita.setEstadoCita(ESTADO_RECHAZO); 
    			citaDao.save(cita);	
    			return true;
    		} catch (Exception e) {
    			return false;
    		}    		
    	}else {
    		return false;
    	}
    }
    
	public boolean verificarVencimientoCita(Cita cita, LocalDateTime fechaActual) {
		LocalDateTime fechaEn24Horas = fechaActual.plusHours(NUMERO_HORAS_DIA);
		if (cita.getFechaInicio().isBefore(fechaEn24Horas)) {
			return true;
		} else {
			return false;
		}
	}
    

    public Cita obtenerCitaPorId(long id) {
    	return citaDao.findById(id).get();
    }
    

    public List<Cita> obtenerListadoCitas(){
    	return (List<Cita>) citaDao.findAll();
    }
    
    
    public List<Cita> obtenerListadoCitasPorProfesor(long idProfesor){
    	return (List<Cita>) citaDao.obtenerCitasAprobadasPorIdProfesor(idProfesor);
    }
    
	
	public List<Cita> obtenerListadoCitasPorCliente(long idCliente){
		return (List<Cita>) citaDao.obtenerCitasAprobadasPorIdCliente(idCliente);
	}
	
	public boolean verificarCruce2Citas(Cita citaPorGuardar, Cita citaGuardada) {	
		citaPorGuardar.setFechaFin(obtenerFechaFinCita(citaPorGuardar));
		if(citaPorGuardar.getFechaInicio().isAfter(citaGuardada.getFechaInicio()) &&
		   citaPorGuardar.getFechaInicio().isBefore(citaGuardada.getFechaFin())) {		
			return true;
		}else {
			if(citaPorGuardar.getFechaFin().isAfter(citaGuardada.getFechaInicio()) &&
			   citaPorGuardar.getFechaFin().isBefore(citaGuardada.getFechaFin())) {
				return true;						
			}else {
				if(citaPorGuardar.getFechaInicio().isBefore(citaGuardada.getFechaInicio()) &&
				   citaPorGuardar.getFechaFin().isAfter(citaGuardada.getFechaFin())) {
					return true;									
				}else {
					return false;							
				}				
			}
		}
	}
	

	public boolean verificarValidesGuardadoDeCita(Cita cita) {		
		List<Cita> listadoCitas = citaDao.obtenerCitasAprobadasPorIdProfesor(cita.getProfesor().getId());		
		for (Cita citaGuardada : listadoCitas) {			
			if(verificarCruce2Citas(cita,citaGuardada)){
				return false;
			}
		}
		return true;
	}
		
	public void rechazarCitasVencidas() {		
		List<Cita> listadoCitas = citaDao.obtenerCitasPendientesDePago(LocalDateTime.now());		
		for (Cita cita : listadoCitas) {			
			if(verificarVencimientoCita(cita, LocalDateTime.now())) {
				rechazarCitaPorId(cita.getId());
			}	
		}
	}
	
	
	
}
