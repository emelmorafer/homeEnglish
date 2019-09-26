package com.ceiba.homeenglish.builder;

import com.ceiba.homeenglish.domain.Cita;
import com.ceiba.homeenglish.domain.Cliente;
import com.ceiba.homeenglish.domain.Profesor;
import com.ceiba.homeenglish.dto.CitaDto;

public class CitaBuilder {	
	
	private CitaBuilder() {}
	
	public static CitaDto convertirADto(Cita cita) {
		
		CitaDto citaDto = null;
		
		if(cita != null) {
			citaDto = new CitaDto(cita.getId(), 
					cita.getCliente().getId(), 
					cita.getProfesor().getId(), 
					cita.getEstadoCita(), 
					cita.getFechaInicio(), 
					cita.getFechaFin(), 
					cita.getCantidadHoras(), 
					cita.getPrecio(), 
					cita.getDireccion(), 
					cita.getNota());
		}
		
		return citaDto;
	}
	
	public static Cita convertirAEntity(CitaDto citaDto) {	
				
		Cliente cliente = new Cliente(citaDto.getIdCliente());
		Profesor profesor = new Profesor(citaDto.getIdProfesor());
		
		Cita cita = new Cita();	
		
		if(citaDto.getId() != null) {
			cita.setId(citaDto.getId());
		}
		cita.setCliente(cliente);
		cita.setProfesor(profesor);
		cita.setEstadoCita(citaDto.getEstadoCita());
		cita.setFechaInicio(citaDto.getFechaInicio());
		cita.setFechaFin(citaDto.getFechaFin());
		cita.setCantidadHoras(citaDto.getCantidadHoras());
		cita.setPrecio(citaDto.getPrecio());
		cita.setDireccion(citaDto.getDireccion());
		cita.setNota(citaDto.getNota());
				
		return cita;
	}
}
