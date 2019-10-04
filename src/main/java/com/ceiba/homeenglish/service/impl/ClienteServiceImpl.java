package com.ceiba.homeenglish.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.homeenglish.service.ClienteService;
import com.ceiba.homeenglish.dto.ClienteDto;
import com.ceiba.homeenglish.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
    ClienteRepository clienteRepository;
	
	public ClienteDto guardarCliente(ClienteDto clienteDto) {	
		return clienteRepository.save(clienteDto);
	}

    public ClienteDto obtenerClientePorId(long id) {
    	return clienteRepository.findById(id); 
    }

    public List<ClienteDto> obtenerListadoClientes(){
    	return clienteRepository.findAll();
    }

}
