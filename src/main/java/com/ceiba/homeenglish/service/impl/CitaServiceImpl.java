package com.ceiba.homeenglish.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.homeenglish.service.CitaService;
import com.ceiba.homeenglish.builder.CitaBuilder;
import com.ceiba.homeenglish.dao.CitaDao;
import com.ceiba.homeenglish.domain.Cita;
import com.ceiba.homeenglish.dto.CitaDto;

@Service
public class CitaServiceImpl implements CitaService{
	
	private static final String ESTADO_CREACION = "PENDIENTE DE PAGO";
	private static final String ESTADO_APROBACION = "APROBADA";
	private static final String ESTADO_RECHAZO = "REACHAZADA";
	private static final Double PRECIO_HORA_CITA = 25000D;
	private static final int NUMERO_HORAS_DIA = 24;
	
	@Autowired
    CitaDao citaDao;
	
	public CitaDto guardarCita(CitaDto citaDto) {		
		if (verificarValidesGuardadoDeCita(citaDto)) {
			citaDto.setEstadoCita(ESTADO_CREACION);
			citaDto.setPrecio(calcularPrecioCita(citaDto));
			citaDto.setFechaFin(obtenerFechaFinCita(citaDto));			
			try {
				Cita cita = CitaBuilder.convertirAEntity(citaDto);
				citaDao.save(cita);
				return CitaBuilder.convertirADto(cita);
				
    		} catch (Exception e) {
    			return null;
    		}						
		} else {
			return null;
		}
	}
	
	public double calcularPrecioCita(CitaDto cita) {
		return PRECIO_HORA_CITA*cita.getCantidadHoras();
	}
	
	public LocalDateTime obtenerFechaFinCita(CitaDto cita) {
		return cita.getFechaInicio().plusHours(cita.getCantidadHoras());
	}
	

    public boolean aprobarCitaPorId(long id) {    	
    	CitaDto cita = citaDao.citaDtoObtenerPorId(id);  	
    	if(cita != null) {
    		try {
    			cita.setEstadoCita(ESTADO_APROBACION); 
    			citaDao.save(CitaBuilder.convertirAEntity(cita));	
    			return true;
    		} catch (Exception e) {
    			return false;
    		}    		
    	}else {
    		return false;
    	}
    }
    
    public boolean rechazarCitaPorId(long id) {    	
    	CitaDto cita = citaDao.citaDtoObtenerPorId(id);	
    	if(cita != null) {
    		try {
    			cita.setEstadoCita(ESTADO_RECHAZO); 
    			citaDao.save(CitaBuilder.convertirAEntity(cita));
    			return true;
    		} catch (Exception e) {
    			return false;
    		}    		
    	}else {
    		return false;
    	}
    }
    
	public boolean verificarVencimientoCita(CitaDto cita, LocalDateTime fechaActual) {
		LocalDateTime fechaEn24Horas = fechaActual.plusHours(NUMERO_HORAS_DIA);
		if (cita.getFechaInicio().isBefore(fechaEn24Horas)) {
			return true;
		} else {
			return false;
		}
	}
    

    public CitaDto obtenerCitaPorId(long id) {
    	return citaDao.citaDtoObtenerPorId(id);
    }
    

    public List<CitaDto> obtenerListadoCitas(){
    	return citaDao.citaDtoObtenerTodas();
    }
    
    
    public List<CitaDto> obtenerListadoCitasPorProfesor(long idProfesor){
    	return citaDao.obtenerCitasAprobadasPorIdProfesor(idProfesor);
    }
    
	
	public List<CitaDto> obtenerListadoCitasPorCliente(long idCliente){
		return citaDao.obtenerCitasAprobadasPorIdCliente(idCliente);
	}
	
	public boolean verificarCruce2Citas(CitaDto citaPorGuardar, CitaDto citaGuardada) {	
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
	

	public boolean verificarValidesGuardadoDeCita(CitaDto cita) {		
		List<CitaDto> listadoCitas = citaDao.obtenerCitasNoRechazadasPorIdProfesor(cita.getIdProfesor());		
		for (CitaDto citaGuardada : listadoCitas) {			
			if(verificarCruce2Citas(cita,citaGuardada)){
				return false;
			}
		}
		return true;
	}
		
	public void rechazarCitasVencidas() {		
		List<CitaDto> listadoCitas = citaDao.obtenerCitasPendientesDePago(LocalDateTime.now());		
		for (CitaDto cita : listadoCitas) {			
			if(verificarVencimientoCita(cita, LocalDateTime.now())) {
				rechazarCitaPorId(cita.getId());
			}	
		}
	}
	
	
	
}
