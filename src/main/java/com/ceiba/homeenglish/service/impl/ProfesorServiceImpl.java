package com.ceiba.homeenglish.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.homeenglish.service.ProfesorService;
import com.ceiba.homeenglish.builder.ProfesorBuilder;
import com.ceiba.homeenglish.dao.ProfesorDao;
import com.ceiba.homeenglish.domain.Profesor;
import com.ceiba.homeenglish.dto.ProfesorDto;

@Service("profesorService")
public class ProfesorServiceImpl implements ProfesorService{
	
	@Autowired
    ProfesorDao profesorDao;
	
	public ProfesorDto guardarProfesor(ProfesorDto profesorDto) {		
		Profesor profesor = ProfesorBuilder.convertirAEntity(profesorDto);
		profesorDao.save(profesor);
		return ProfesorBuilder.convertirADto(profesor);
	}

    public ProfesorDto obtenerProfesorPorId(long id) {
    	return profesorDao.profesorDtoObtenerPorId(id); 
    }

    public List<ProfesorDto> obtenerListadoProfesores(){
    	return profesorDao.profesorDtoObtenerTodos();
    }

}
