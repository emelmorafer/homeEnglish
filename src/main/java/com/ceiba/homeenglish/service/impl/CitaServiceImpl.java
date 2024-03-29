package com.ceiba.homeenglish.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.homeenglish.service.CitaService;
import com.ceiba.homeenglish.dto.CitaDto;
import com.ceiba.homeenglish.repository.CitaRepository;

@Service
public class CitaServiceImpl implements CitaService{
	
	private static final String ESTADO_CREACION = "PENDIENTE DE PAGO";
	private static final String ESTADO_APROBACION = "APROBADA";
	private static final String ESTADO_RECHAZO = "RECHAZADA";
	private static final Double PRECIO_HORA_CITA = 25000D;
	private static final int NUMERO_HORAS_DIA = 24;
	
	@Autowired
    CitaRepository citaRepository;
	
	public CitaDto guardarCita(CitaDto citaDto) {		
		if (verificarValidesGuardadoDeCita(citaDto)) {
			citaDto.setEstadoCita(ESTADO_CREACION);
			citaDto.setPrecio(calcularPrecioCita(citaDto));
			citaDto.setFechaFin(obtenerFechaFinCita(citaDto));			

			return citaRepository.save(citaDto);
						
		} else {
			return new CitaDto();
		}
	}
	
	public double calcularPrecioCita(CitaDto cita) {
		return PRECIO_HORA_CITA*cita.getCantidadHoras();
	}
	
	public LocalDateTime obtenerFechaFinCita(CitaDto cita) {
		return cita.getFechaInicio().plusHours(cita.getCantidadHoras());
	}
	

    public boolean aprobarCitaPorId(long id) {    	
    	CitaDto cita = citaRepository.findById(id);  
    	boolean respuesta = false;
    	if(cita != null) {
    		cita.setEstadoCita(ESTADO_APROBACION); 		
    		if(citaRepository.save(cita).getId() != null) {
    			respuesta = true;
    		}		
    	}
    	return respuesta;
    }
    
    public boolean rechazarCitaPorId(long id) {    	
    	CitaDto cita = citaRepository.findById(id);	
    	boolean respuesta = false;
    	if(cita != null) {
    		cita.setEstadoCita(ESTADO_RECHAZO); 		
    		if(citaRepository.save(cita).getId() != null) {
    			respuesta = true;
    		}		
    	}
    	return respuesta;
    }
    
	public boolean verificarVencimientoCita(CitaDto cita, LocalDateTime fechaActual) {
		LocalDateTime fechaEn24Horas = fechaActual.plusHours(NUMERO_HORAS_DIA);
		
		return cita.getFechaInicio().isBefore(fechaEn24Horas);
	}
    

    public CitaDto obtenerCitaPorId(long id) {
    	return citaRepository.findById(id);
    }
    

    public List<CitaDto> obtenerListadoCitas(){
    	return citaRepository.findAll();
    }
    
    
    public List<CitaDto> obtenerListadoCitasAprobadasPorProfesor(long idProfesor){
    	return citaRepository.obtenerCitasAprobadasPorIdProfesor(idProfesor);
    }
    
	
	public List<CitaDto> obtenerListadoCitasAprobadasPorCliente(long idCliente){
		return citaRepository.obtenerCitasAprobadasPorIdCliente(idCliente);
	}
	
	public boolean verificarCruce2Citas(CitaDto citaPorGuardar, CitaDto citaGuardada) {	
		citaPorGuardar.setFechaFin(obtenerFechaFinCita(citaPorGuardar));
		boolean verificacion = false;
		if(citaPorGuardar.getFechaInicio().isAfter(citaGuardada.getFechaInicio()) &&
		   citaPorGuardar.getFechaInicio().isBefore(citaGuardada.getFechaFin())) {		
			verificacion = true;
		}else {
			if(citaPorGuardar.getFechaFin().isAfter(citaGuardada.getFechaInicio()) &&
			   citaPorGuardar.getFechaFin().isBefore(citaGuardada.getFechaFin())) {
				verificacion = true;						
			}else {
				if(citaPorGuardar.getFechaInicio().isBefore(citaGuardada.getFechaInicio()) &&
				   citaPorGuardar.getFechaFin().isAfter(citaGuardada.getFechaFin())) {
					verificacion = true;									
				}				
			}
		}
		return verificacion;
	}
	

	public boolean verificarValidesGuardadoDeCita(CitaDto cita) {		
		List<CitaDto> listadoCitas = citaRepository.obtenerCitasNoRechazadasPorIdProfesor(cita.getIdProfesor());		
		for (CitaDto citaGuardada : listadoCitas) {			
			if(verificarCruce2Citas(cita,citaGuardada)){
				return false;
			}
		}
		return true;
	}
		
	public boolean rechazarCitasVencidas() {
		List<CitaDto> listadoCitas = citaRepository.obtenerCitasPendientesDePago(LocalDateTime.now());	
		boolean respuesta = true;
		for (CitaDto cita : listadoCitas) {			
			if(verificarVencimientoCita(cita, LocalDateTime.now())) {
				respuesta = rechazarCitaPorId(cita.getId());
				if(!respuesta) {
					return respuesta;
				}
			}	
		}
		return respuesta;			
	}
	

}
