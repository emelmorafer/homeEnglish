package com.ceiba.homeenglish.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.ceiba.homeenglish.dto.CitaDto;

@Repository
public interface CitaRepository extends com.ceiba.homeenglish.repository.data.CrudRepository<CitaDto> {
	
	public List<CitaDto> obtenerCitasAprobadasPorIdCliente(Long idCliente);
	
	public List<CitaDto> obtenerCitasAprobadasPorIdProfesor(Long idProfesor);
	
	public List<CitaDto> obtenerCitasNoRechazadasPorIdProfesor(Long idProfesor);
	
	public List<CitaDto> obtenerCitasPendientesDePago(LocalDateTime fechaActual);

}
