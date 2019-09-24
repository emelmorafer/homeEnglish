package com.ceiba.homeenglish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.homeenglish.domain.Cita;
import com.ceiba.homeenglish.service.CitaService;

@RestController
@RequestMapping("api")
public class CitaRestController {
	
	@Autowired
	CitaService citaService; 
	
	@RequestMapping(value = "/guardarCita", method = RequestMethod.POST)
    public Cita guardarCita(@RequestBody Cita cita) {		
		return citaService.guardarCita(cita);
	}
	
	@RequestMapping(value = "/actualizarCita", method = RequestMethod.PUT)
    public Cita actualizarCita(@RequestBody Cita cita) {		
		return citaService.actualizarCita(cita);
	}
	
	@RequestMapping(value = "/getCitaById", method = RequestMethod.GET)
    public Cita getCitaByID(@RequestParam(value="id") long id) {		
		return citaService.obtenerCitaPorId(id);
	}
	
	@RequestMapping(value = "/getListCita", method = RequestMethod.GET)
    public List<Cita> getListCita() {		
		return citaService.obtenerListadoCitas();
	}

}
