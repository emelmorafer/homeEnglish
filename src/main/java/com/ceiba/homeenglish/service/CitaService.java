package com.ceiba.homeenglish.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ceiba.homeenglish.domain.Cita;

public interface CitaService {
			
	public Cita guardarCita(Cita cita);
	
    public double calcularPrecioCita(Cita cita);
	
	public LocalDateTime obtenerFechaFinCita(Cita cita);
	
	public boolean aprobarCitaPorId(long id);
	
	public boolean rechazarCitaPorId(long id);
	
	public boolean verificarVencimientoCita(Cita cita, LocalDateTime fechaActual);
	
	public Cita obtenerCitaPorId(long id);
	
	public List<Cita> obtenerListadoCitas();
	
	public List<Cita> obtenerListadoCitasPorProfesor(long idProfesor);
	
	public List<Cita> obtenerListadoCitasPorCliente(long idCliente);
	
	boolean verificarCruce2Citas(Cita citaPorGuardar, Cita citaGuardada);
	
	public boolean verificarValidesGuardadoDeCita(Cita cita);
	
	public void rechazarCitasVencidas();
		
}
