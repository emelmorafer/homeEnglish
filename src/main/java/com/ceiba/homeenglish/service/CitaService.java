package com.ceiba.homeenglish.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ceiba.homeenglish.dto.CitaDto;

public interface CitaService {
			
	public CitaDto guardarCita(CitaDto cita);
	
    public double calcularPrecioCita(CitaDto cita);
	
	public LocalDateTime obtenerFechaFinCita(CitaDto cita);
	
	public boolean aprobarCitaPorId(long id);
	
	public boolean rechazarCitaPorId(long id);
	
	public boolean verificarVencimientoCita(CitaDto cita, LocalDateTime fechaActual);
	
	public CitaDto obtenerCitaPorId(long id);
	
	public List<CitaDto> obtenerListadoCitas();
	
	public List<CitaDto> obtenerListadoCitasAprobadasPorProfesor(long idProfesor);
	
	public List<CitaDto> obtenerListadoCitasAprobadasPorCliente(long idCliente);
	
	boolean verificarCruce2Citas(CitaDto citaPorGuardar, CitaDto citaGuardada);
	
	public boolean verificarValidesGuardadoDeCita(CitaDto cita);
	
	public boolean rechazarCitasVencidas();
		
}
