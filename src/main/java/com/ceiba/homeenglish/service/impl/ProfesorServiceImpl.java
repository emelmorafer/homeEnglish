package com.ceiba.homeenglish.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.homeenglish.service.ProfesorService;
import com.ceiba.homeenglish.dao.ProfesorDao;
import com.ceiba.homeenglish.domain.Profesor;

@Service("profesorService")
public class ProfesorServiceImpl implements ProfesorService{
	
	@Autowired
    ProfesorDao profesorDao;
	
	public Profesor guardarProfesor(Profesor profesor) {		
		profesorDao.save(profesor);		
		return profesor;
	}

    public Profesor actualizarProfesor(Profesor profesor) {
    	profesorDao.save(profesor);		
		return profesor;
    }

    public Profesor obtenerProfesorPorId(long id) {
    	return profesorDao.findById(id).get();
    }

    public List<Profesor> obtenerListadoProfesores(){
    	return (List<Profesor>) profesorDao.findAll();
    }

}
