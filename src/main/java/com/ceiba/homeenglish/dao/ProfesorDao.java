package com.ceiba.homeenglish.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.homeenglish.domain.Profesor;
import com.ceiba.homeenglish.dto.ProfesorDto;

@Repository
public interface ProfesorDao extends CrudRepository<Profesor, Long>{
	
	@Query("SELECT new com.ceiba.homeenglish.dto.ProfesorDto(p.id, p.cedula, "
			+ "p.nombre, p.edad, p.apellido, p.direccion) FROM Profesor AS p ")
	List<ProfesorDto> profesorDtoObtenerTodos();
	
	@Query("SELECT new com.ceiba.homeenglish.dto.ProfesorDto(p.id, p.cedula, "
			+ "p.nombre, p.edad, p.apellido, p.direccion) FROM Profesor AS p WHERE p.id= ?1")
	ProfesorDto profesorDtoObtenerPorId(Long id);

}
