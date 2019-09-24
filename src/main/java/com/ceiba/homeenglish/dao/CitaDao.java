package com.ceiba.homeenglish.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.homeenglish.domain.Cita;

@Repository
public interface CitaDao extends CrudRepository<Cita, Long>{
	
	public List<Cita> findByIdCliente(long id);
	
	@Query("SELECT c FROM Cita AS c WHERE c.estadoCita = 'APROBADA' AND c.idProfesor = ?1 ")
	public List<Cita> obtenerCitasAprobadasPorIdProfesor(long id);
	
	@Query("SELECT c FROM Cita AS c WHERE c.estadoCita <> 'CANCELADA' AND c.idProfesor = ?1 AND " +
		   " ((?2 BETWEEN c.fechaInicio AND c.fechaFin) OR " +
		   "  (?3 BETWEEN c.fechaInicio AND c.fechaFin)) ")
    public List<Cita> obtenerCitasPorIdProfesoryFechas(long idProfesor, LocalDateTime fechaInicio, LocalDateTime fechaFin);

}
