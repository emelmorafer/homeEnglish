package com.ceiba.homeenglish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.homeenglish.dto.ClienteDto;
import com.ceiba.homeenglish.service.ClienteService;

@RestController
@RequestMapping("api")
public class ClienteRestController {
	
	
	@Autowired
	ClienteService clienteService; 
	
	
	@PostMapping(value = "/guardarCliente")
    public ClienteDto guardarCliente(@RequestBody ClienteDto cliente) {		
		return clienteService.guardarCliente(cliente);
	}
	
	@GetMapping(value = "/getClienteById")
    public ClienteDto getClienteByID(@RequestParam(value="id") long id) {		
		return clienteService.obtenerClientePorId(id);

	}
	
	@GetMapping(value = "/getListCliente")
    public List<ClienteDto> getListCliente() {		
		return clienteService.obtenerListadoClientes();
	}

}
