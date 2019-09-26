package com.ceiba.homeenglish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.homeenglish.dto.ProfesorDto;
import com.ceiba.homeenglish.service.ProfesorService;

@RestController
@RequestMapping("api")
public class ProfesorRestController {
	
	
	@Autowired
	ProfesorService profesorService; 
	
	
	@PostMapping(value = "/guardarProfesor")
    public ProfesorDto guardarProfesor(@RequestBody ProfesorDto profesor) {		
		return profesorService.guardarProfesor(profesor);
	}
	
	@GetMapping(value = "/getProfesorById")
    public ProfesorDto getProfesorByID(@RequestParam(value="id") long id) {		
		return profesorService.obtenerProfesorPorId(id);
	}
	
	@GetMapping(value = "/getListProfesor")
    public List<ProfesorDto> getListProfesor() {		
		return profesorService.obtenerListadoProfesores();
	}

}
