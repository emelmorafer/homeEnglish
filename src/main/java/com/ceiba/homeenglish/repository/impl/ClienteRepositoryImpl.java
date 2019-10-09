package com.ceiba.homeenglish.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.ceiba.homeenglish.dto.ClienteDto;
import com.ceiba.homeenglish.jdbc.dao.Dao;
import com.ceiba.homeenglish.repository.ClienteRepository;
import com.ceiba.homeenglish.repository.rowmapper.ClienteDtoRowMapper;

@Repository
public class ClienteRepositoryImpl extends Dao implements ClienteRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteRepositoryImpl.class);
			
	private String sql = "";
	
	private static final String SQL_INSERT = 
			"INSERT INTO Cliente (cedula,nombre,apellido,edad,direccion) VALUES (?,?,?,?,?) ";
	
	private static final String SQL_UPDATE = 
			"UPDATE Cliente SET cedula=?,nombre=?,apellido=?,edad=?,direccion=? WHERE id = ? ";
	
	
	@Override
	public ClienteDto save (ClienteDto clienteDto) {
		try {	
			if(clienteDto.getId() == null) {
				getJdbcTemplate().update(SQL_INSERT
						,clienteDto.getCedula()	
						,clienteDto.getNombre()
						,clienteDto.getApellido()														
						,clienteDto.getEdad()
						,clienteDto.getDireccion());				
			}else {
				getJdbcTemplate().update(SQL_UPDATE
						,clienteDto.getCedula()	
						,clienteDto.getNombre()
						,clienteDto.getApellido()														
						,clienteDto.getEdad()
						,clienteDto.getDireccion()
						,clienteDto.getId());				
			}
			return clienteDto;
		} catch (Exception e) {
			LOGGER.error("Error al ingresar un nuevo Cliente" + e);
			return new ClienteDto();
		}
	}
	
	
	@Override
	public ClienteDto findById(Long id) {
		sql = "SELECT * FROM Cliente WHERE id = ? ";
		try {
			return getJdbcTemplate().queryForObject(sql, new Object[] { id }, new ClienteDtoRowMapper());
		} catch (Exception e) {
			LOGGER.error("Error al consultar el cliente: " + e);
			return new ClienteDto();
		}
	}
	
	
	@Override
	public List<ClienteDto> findAll() {
		sql = "SELECT * FROM Cliente";
		try {					
			return getNamedParameterJdbcTemplate().query(sql, new ClienteDtoRowMapper());
		} catch (Exception e) {
			LOGGER.error("Error al obtener el listado de clientes: " + e);
			return new ArrayList<>();
		}
	}


}
