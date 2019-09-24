package com.ceiba.homeenglish.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.homeenglish.domain.Cliente;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Long>{
	
	

}
