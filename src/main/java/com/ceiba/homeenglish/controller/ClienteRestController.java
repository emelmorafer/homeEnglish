package com.ceiba.homeenglish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.homeenglish.domain.Cliente;
import com.ceiba.homeenglish.service.ClienteService;

@RestController
@RequestMapping("api")
public class ClienteRestController {
	
	
	@Autowired
	ClienteService clienteService; 
	
	
	@RequestMapping(value = "/guardarCliente", method = RequestMethod.POST)
    public Cliente guardarCliente(@RequestBody Cliente cliente) {		
		return clienteService.guardarCliente(cliente);
	}
	
	@RequestMapping(value = "/actualizarCliente", method = RequestMethod.PUT)
    public Cliente actualizarCliente(@RequestBody Cliente cliente) {		
		return clienteService.actualizarCliente(cliente);
	}
	
	@RequestMapping(value = "/getClienteById", method = RequestMethod.GET)
    public Cliente getClienteByID(@RequestParam(value="id") long id) {		
		return clienteService.obtenerClientePorId(id);

	}
	
	@RequestMapping(value = "/getListCliente", method = RequestMethod.GET)
    public List<Cliente> getListCliente() {		
		return clienteService.obtenerListadoClientes();
	}

}
