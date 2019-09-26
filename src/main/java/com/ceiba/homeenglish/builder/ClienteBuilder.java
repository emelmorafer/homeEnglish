package com.ceiba.homeenglish.builder;

import com.ceiba.homeenglish.domain.Cliente;
import com.ceiba.homeenglish.dto.ClienteDto;

public class ClienteBuilder {
	
	private ClienteBuilder() {}
	
	public static ClienteDto convertirADto(Cliente cliente) {
		
		ClienteDto clienteDto = null;
		
		if(cliente != null) {
			clienteDto = new ClienteDto(cliente.id, cliente.cedula, 
					cliente.nombre, cliente.edad, cliente.apellido, cliente.direccion);
		}
		
		return clienteDto;
	}
	
	public static Cliente convertirAEntity(ClienteDto clienteDto) {
		
		Cliente cliente = new Cliente();
		
		if(clienteDto.getId() != null) {
		    cliente.setId(clienteDto.getId());
		}
		cliente.setCedula(clienteDto.getCedula());
		cliente.setNombre(clienteDto.getNombre());
		cliente.setEdad(clienteDto.getEdad());
		cliente.setApellido(clienteDto.getApellido());
		cliente.setDireccion(clienteDto.getDireccion());
		
		return cliente;
	}
}
