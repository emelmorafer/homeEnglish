package com.ceiba.homeenglish.service;

import java.util.List;

import com.ceiba.homeenglish.dto.ProfesorDto;

public interface ProfesorService {
			
	public ProfesorDto guardarProfesor(ProfesorDto profesor);
	
	public ProfesorDto obtenerProfesorPorId(long id);
	
	public List<ProfesorDto> obtenerListadoProfesores();
	
}
