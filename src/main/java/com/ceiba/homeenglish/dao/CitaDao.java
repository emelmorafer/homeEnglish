package com.ceiba.homeenglish.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.homeenglish.domain.Cita;

@Repository
public interface CitaDao extends JpaRepository<Cita, Long>{
	
	
	@Query("SELECT c FROM Cita AS c WHERE c.estadoCita = 'APROBADA' AND c.cliente.id = ?1 ")
	public List<Cita> obtenerCitasAprobadasPorIdCliente(long id);
	
	
	@Query("SELECT c FROM Cita AS c WHERE c.estadoCita = 'APROBADA' AND c.profesor.id = ?1 ")
	public List<Cita> obtenerCitasAprobadasPorIdProfesor(long id);
		
	
	/*@Query("SELECT c FROM Cita AS c WHERE c.estadoCita <> 'RECHAZADA' AND c.profesor.id = ?1 AND " +
		   " ((?2 BETWEEN c.fechaInicio AND c.fechaFin) OR " +
		   "  (?3 BETWEEN c.fechaInicio AND c.fechaFin)) ")
    public List<Cita> verificarCitaExistentePorProfesor(long idProfesor, LocalDateTime fechaInicio, LocalDateTime fechaFin);*/
	

	@Query("SELECT c FROM Cita AS c WHERE c.estadoCita = 'PENDIENTE DE PAGO' AND c.fechaInicio >= ?1 ")
	public List<Cita> obtenerCitasPendientesDePago(LocalDateTime fechaActual);

}
