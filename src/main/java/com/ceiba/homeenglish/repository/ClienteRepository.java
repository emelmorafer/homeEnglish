package com.ceiba.homeenglish.repository;

import org.springframework.stereotype.Repository;
import com.ceiba.homeenglish.dto.ClienteDto;

@Repository
public interface ClienteRepository extends com.ceiba.homeenglish.repository.data.CrudRepository<ClienteDto> {
	

}
