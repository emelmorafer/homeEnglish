package com.ceiba.homeenglish.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.homeenglish.service.ProfesorService;
import com.ceiba.homeenglish.dto.ProfesorDto;
import com.ceiba.homeenglish.repository.ProfesorRepository;

@Service("profesorService")
public class ProfesorServiceImpl implements ProfesorService{
	
	@Autowired
    ProfesorRepository profesorRepository;
	
	public ProfesorDto guardarProfesor(ProfesorDto profesorDto) {	
		return profesorRepository.save(profesorDto);
	}

    public ProfesorDto obtenerProfesorPorId(long id) {
    	return profesorRepository.findById(id); 
    }

    public List<ProfesorDto> obtenerListadoProfesores(){
    	return profesorRepository.findAll();
    }

}
