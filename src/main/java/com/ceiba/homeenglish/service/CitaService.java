package com.ceiba.homeenglish.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ceiba.homeenglish.domain.Cita;

public interface CitaService {
			
	public Cita guardarCita(Cita cita);
	
	public Cita actualizarCita(Cita cita);
	
	public Cita obtenerCitaPorId(long id);
	
	public List<Cita> obtenerListadoCitas();
	
	public List<Cita> obtenerListadoCitasPorProfesor(long idProfesor);
	
	public List<Cita> obtenerListadoCitasPorCliente(long idCliente);
	
	public boolean verificarCruceDeCitas(long idProfesor, LocalDateTime fechaInicio, LocalDateTime fechaFin);
	
}
