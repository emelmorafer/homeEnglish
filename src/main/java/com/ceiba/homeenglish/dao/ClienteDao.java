package com.ceiba.homeenglish.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.homeenglish.domain.Cliente;
import com.ceiba.homeenglish.dto.ClienteDto;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Long>{	
	
	@Query("SELECT new com.ceiba.homeenglish.dto.ClienteDto(c.id, c.cedula, "
			+ "c.nombre, c.edad, c.apellido, c.direccion) FROM Cliente AS c ")
	List<ClienteDto> clienteDtoObtenerTodos();
	
	@Query("SELECT new com.ceiba.homeenglish.dto.ClienteDto(c.id, c.cedula, "
			+ "c.nombre, c.edad, c.apellido, c.direccion) FROM Cliente AS c WHERE c.id= ?1")
	ClienteDto clienteDtoObtenerPorId(Long id);
	
}
