package com.ceiba.homeenglish.service;

import java.util.List;

import com.ceiba.homeenglish.domain.Profesor;

public interface ProfesorService {
			
	public Profesor guardarProfesor(Profesor profesor);
	
	public Profesor actualizarProfesor(Profesor profesor);
	
	public Profesor obtenerProfesorPorId(long id);
	
	public List<Profesor> obtenerListadoProfesores();
	
}
