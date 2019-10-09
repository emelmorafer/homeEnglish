package com.ceiba.homeenglish.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ceiba.homeenglish.dto.ProfesorDto;
import com.ceiba.homeenglish.jdbc.dao.Dao;
import com.ceiba.homeenglish.repository.ProfesorRepository;
import com.ceiba.homeenglish.repository.rowmapper.ProfesorDtoRowMapper;

@Repository
public class ProfesorRepositoryImpl extends Dao implements ProfesorRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfesorRepositoryImpl.class);
	
	private String sql = "";

	private static final String SQL_INSERT = 
			"INSERT INTO Profesor (cedula,nombre,apellido,edad,direccion) VALUES (?,?,?,?,?) ";
	
	private static final String SQL_UPDATE = 
			"UPDATE Profesor SET cedula=?,nombre=?,apellido=?,edad=?,direccion=? WHERE id = ? ";
	
	
	@Override
	public ProfesorDto save (ProfesorDto profesorDto) {
		try {	
			if(profesorDto.getId() == null) {
				getJdbcTemplate().update(SQL_INSERT
						,profesorDto.getCedula()	
						,profesorDto.getNombre()
						,profesorDto.getApellido()														
						,profesorDto.getEdad()
						,profesorDto.getDireccion());				
			}else {
				getJdbcTemplate().update(SQL_UPDATE
						,profesorDto.getCedula()	
						,profesorDto.getNombre()
						,profesorDto.getApellido()														
						,profesorDto.getEdad()
						,profesorDto.getDireccion()
						,profesorDto.getId());				
			}
			return profesorDto;
		} catch (Exception e) {
			LOGGER.error("Error al ingresar un nuevo Profesor" + e);
			return new ProfesorDto();
		}
	}
	
	
	@Override
	public ProfesorDto findById(Long id) {
		sql = "SELECT * FROM Profesor WHERE id = ? ";
		try {
			return getJdbcTemplate().queryForObject(sql, new Object[] { id }, new ProfesorDtoRowMapper());
		} catch (Exception e) {
			LOGGER.error("Error al consultar el profesor: " + e);
			return new ProfesorDto();
		}
	}
	
	
	@Override
	public List<ProfesorDto> findAll() {
		sql = "SELECT * FROM Profesor";
		try {					
			return getNamedParameterJdbcTemplate().query(sql, new ProfesorDtoRowMapper());
		} catch (Exception e) {
			LOGGER.error("Error al obtener el listado de profesors: " + e);
			return new ArrayList<>();
		}
	}


}
