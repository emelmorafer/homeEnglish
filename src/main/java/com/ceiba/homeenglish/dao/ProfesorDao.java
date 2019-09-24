package com.ceiba.homeenglish.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.homeenglish.domain.Profesor;

@Repository
public interface ProfesorDao extends CrudRepository<Profesor, Long>{
	
	

}
