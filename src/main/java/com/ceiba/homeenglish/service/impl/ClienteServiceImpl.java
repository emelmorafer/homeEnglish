package com.ceiba.homeenglish.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.homeenglish.service.ClienteService;
import com.ceiba.homeenglish.dao.ClienteDao;
import com.ceiba.homeenglish.domain.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
    ClienteDao clienteDao;//Holi
	
	public Cliente guardarCliente(Cliente cliente) {		
		return clienteDao.save(cliente);		
	}

    public Cliente actualizarCliente(Cliente cliente) {
    	clienteDao.save(cliente);		
		return cliente;
    }

    public Cliente obtenerClientePorId(long id) {
    	return clienteDao.findById(id).get();
    }

    public List<Cliente> obtenerListadoClientes(){
    	return (List<Cliente>) clienteDao.findAll();
    }

}
