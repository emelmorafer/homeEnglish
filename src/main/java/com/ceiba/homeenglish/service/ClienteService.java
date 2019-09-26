package com.ceiba.homeenglish.service;

import java.util.List;
import com.ceiba.homeenglish.dto.ClienteDto;

public interface ClienteService {
			
	public ClienteDto guardarCliente(ClienteDto cliente);
	
	public ClienteDto obtenerClientePorId(long id);
	
	public List<ClienteDto> obtenerListadoClientes(); 
	
}
