package com.ceiba.homeenglish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.homeenglish.domain.Profesor;
import com.ceiba.homeenglish.service.ProfesorService;

@RestController
@RequestMapping("api")
public class ProfesorRestController {
	
	
	@Autowired
	ProfesorService profesorService; 
	
	
	@RequestMapping(value = "/guardarProfesor", method = RequestMethod.POST)
    public Profesor guardarProfesor(@RequestBody Profesor profesor) {		
		return profesorService.guardarProfesor(profesor);
	}
	
	@RequestMapping(value = "/actualizarProfesor", method = RequestMethod.PUT)
    public Profesor actualizarProfesor(@RequestBody Profesor profesor) {		
		return profesorService.actualizarProfesor(profesor);
	}
	
	@RequestMapping(value = "/getProfesorById", method = RequestMethod.GET)
    public Profesor getProfesorByID(@RequestParam(value="id") long id) {		
		return profesorService.obtenerProfesorPorId(id);
	}
	
	@RequestMapping(value = "/getListProfesor", method = RequestMethod.GET)
    public List<Profesor> getListProfesor() {		
		return profesorService.obtenerListadoProfesores();
	}

}
