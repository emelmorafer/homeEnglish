package com.ceiba.homeenglish.service;

import java.util.List;

import com.ceiba.homeenglish.domain.Cliente;

public interface ClienteService {
			
	public Cliente guardarCliente(Cliente cliente);
	
	public Cliente actualizarCliente(Cliente cliente);
	
	public Cliente obtenerClientePorId(long id);
	
	public List<Cliente> obtenerListadoClientes();
	
}
