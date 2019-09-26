package com.ceiba.homeenglish.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.homeenglish.domain.Cita;
import com.ceiba.homeenglish.dto.CitaDto;

@Repository
public interface CitaDao extends CrudRepository<Cita, Long>{
	
	@Query("SELECT new com.ceiba.homeenglish.dto.CitaDto(c.id, c.cliente.id, c.profesor.id, "
			+ "c.estadoCita, c.fechaInicio, c.fechaFin, c.cantidadHoras, c.precio, "
			+ "c.direccion, c.nota) FROM Cita AS c "
			+ "WHERE c.id= ?1")
	CitaDto citaDtoObtenerPorId(Long id);
		
	@Query("SELECT new com.ceiba.homeenglish.dto.CitaDto(c.id, c.cliente.id, c.profesor.id, "
			+ "c.estadoCita, c.fechaInicio, c.fechaFin, c.cantidadHoras, c.precio, "
			+ "c.direccion, c.nota) FROM Cita AS c "
			+ "WHERE c.estadoCita = 'APROBADA' AND c.cliente.id = ?1 ")
	public List<CitaDto> obtenerCitasAprobadasPorIdCliente(long id);
	
	
	@Query("SELECT new com.ceiba.homeenglish.dto.CitaDto(c.id, c.cliente.id, c.profesor.id, "
			+ "c.estadoCita, c.fechaInicio, c.fechaFin, c.cantidadHoras, c.precio, "
			+ "c.direccion, c.nota) FROM Cita AS c "
			+ "WHERE c.estadoCita = 'APROBADA' AND c.profesor.id = ?1 ")
	public List<CitaDto> obtenerCitasAprobadasPorIdProfesor(long id);
	
	@Query("SELECT new com.ceiba.homeenglish.dto.CitaDto(c.id, c.cliente.id, c.profesor.id, "
			+ "c.estadoCita, c.fechaInicio, c.fechaFin, c.cantidadHoras, c.precio, "
			+ "c.direccion, c.nota) FROM Cita AS c "
			+ "WHERE c.estadoCita <> 'RECHAZADA' AND c.profesor.id = ?1 ")
	public List<CitaDto> obtenerCitasNoRechazadasPorIdProfesor(long id);
			
	@Query("SELECT new com.ceiba.homeenglish.dto.CitaDto(c.id, c.cliente.id, c.profesor.id, "
			+ "c.estadoCita, c.fechaInicio, c.fechaFin, c.cantidadHoras, c.precio, "
			+ "c.direccion, c.nota) FROM Cita AS c "
			+ "WHERE c.estadoCita = 'PENDIENTE DE PAGO' AND c.fechaInicio >= ?1 ")
	public List<CitaDto> obtenerCitasPendientesDePago(LocalDateTime fechaActual);
	
	
	@Query("SELECT new com.ceiba.homeenglish.dto.CitaDto(c.id, c.cliente.id, c.profesor.id, "
			+ "c.estadoCita, c.fechaInicio, c.fechaFin, c.cantidadHoras, c.precio, "
			+ "c.direccion, c.nota) FROM Cita AS c ")
	public List<CitaDto> citaDtoObtenerTodas();

}
