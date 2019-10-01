package com.ceiba.homeenglish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.homeenglish.dto.CitaDto;
import com.ceiba.homeenglish.service.CitaService;

@CrossOrigin(origins =  { "*"})
@RestController
@RequestMapping("homeEnglish")
public class CitaRestController {
	
	@Autowired
	CitaService citaService; 
	
	@PostMapping(value = "/guardarCita")
    public CitaDto guardarCita(@RequestBody CitaDto cita) {		
		return citaService.guardarCita(cita);
	}
	
	@GetMapping(value = "/aprobarCitaPorId")
    public boolean aprobarCitaPorId(@RequestParam(value="id") long id) {		
		return citaService.aprobarCitaPorId(id);
	}
	
	@GetMapping(value = "/rechazarCitaPorId")
    public boolean rechazarCitaPorId(@RequestParam(value="id") long id) {		
		return citaService.rechazarCitaPorId(id);
	}
	
	@GetMapping(value = "/getCitaById")
    public CitaDto getCitaByID(@RequestParam(value="id") long id) {		
		return citaService.obtenerCitaPorId(id);
	}
	
	@GetMapping(value = "/getListCita")
    public List<CitaDto> getListCita() {		
		return citaService.obtenerListadoCitas();
	}
	
	@GetMapping(value = "/getListCitasAprobadasByIdCliente")
    public List<CitaDto> getListCitasAprobadasByIdCliente(@RequestParam(value="idCliente") long idCliente) {		
		return citaService.obtenerListadoCitasAprobadasPorCliente(idCliente);
	}
	
	@GetMapping(value = "/getListCitasAprobadasByIdProfesor")
    public List<CitaDto> getListCitasAprobadasByIdProfesor(@RequestParam(value="idProfesor") long idProfesor) {		
		return citaService.obtenerListadoCitasAprobadasPorProfesor(idProfesor);
	}
	
	@PostMapping(value = "/verificarValidesGuardadoDeCita")
    public boolean verificarValidesGuardadoDeCita(@RequestBody CitaDto cita) {		
		return citaService.verificarValidesGuardadoDeCita(cita);
	}
		
	@PostMapping(value = "/calcularPrecioCita")
    public double calcularPrecioCita(@RequestBody CitaDto cita) {
		return citaService.calcularPrecioCita(cita);
	}

}
