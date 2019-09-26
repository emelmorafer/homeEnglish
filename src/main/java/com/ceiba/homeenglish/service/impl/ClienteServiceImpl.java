package com.ceiba.homeenglish.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.homeenglish.service.ClienteService;
import com.ceiba.homeenglish.builder.ClienteBuilder;
import com.ceiba.homeenglish.dao.ClienteDao;
import com.ceiba.homeenglish.domain.Cliente;
import com.ceiba.homeenglish.dto.ClienteDto;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
    ClienteDao clienteDao;
	
	public ClienteDto guardarCliente(ClienteDto clienteDto) {		
		Cliente cliente = ClienteBuilder.convertirAEntity(clienteDto);
		clienteDao.save(cliente);
		return ClienteBuilder.convertirADto(cliente);
	}

    public ClienteDto obtenerClientePorId(long id) {
    	return clienteDao.clienteDtoObtenerPorId(id); 
    }

    public List<ClienteDto> obtenerListadoClientes(){
    	return clienteDao.clienteDtoObtenerTodos();
    }

}
