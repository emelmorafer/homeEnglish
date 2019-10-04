package com.ceiba.homeenglish.repository.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.ceiba.homeenglish.dto.CitaDto;
import com.ceiba.homeenglish.jdbc.dao.Dao;
import com.ceiba.homeenglish.repository.CitaRepository;
import com.ceiba.homeenglish.repository.rowmapper.CitaDtoRowMapper;

@Repository
public class CitaRepositoryImpl extends Dao implements CitaRepository {

	private static Logger LOGGER = LoggerFactory.getLogger(CitaRepositoryImpl.class);
	
	private static String SQL = "";
	
	private static String SELECT_SQL = "SELECT cit.id, "
			+ "cli.id AS idCliente, "
			+ "cli.nombre || ' ' || cli.apellido AS nombreCompletoCliente, "
			+ "pro.id AS idProfesor, "
			+ "pro.nombre || ' ' || pro.apellido AS nombreCompletoProfesor, "
			+ "cit.estado_cita AS estadoCita, "
			+ "cit.fecha_inicio AS fechaInicio, "
			+ "cit.fecha_fin AS fechaFin, "
			+ "cit.cantidad_horas AS cantidadHoras, "
			+ "cit.precio AS precio, "
			+ "cit.direccion AS direccion, "
			+ "cit.nota AS nota "
			+ "FROM Cita cit JOIN Cliente cli JOIN Profesor pro ";
	
	private static final String SQL_INSERT = 
			"INSERT INTO Cita (id_cliente,id_profesor,estado_cita,"
			+ "fecha_inicio,fecha_fin,cantidad_horas,precio,direccion,nota) "
			+ "VALUES (?,?,?,?,?,?,?,?,?) ";
	
	private static final String SQL_UPDATE = 
			"UPDATE Cita SET id_cliente=?,id_profesor=?,estado_cita=?,fecha_inicio=?,"
			+ "fecha_fin=?,cantidad_horas=?,precio=?,direccion=?,nota=? WHERE id = ? ";
	
	@Override
	public CitaDto save (CitaDto citaDto) {
		try {	
			if(citaDto.getId() == null) {
				getJdbcTemplate().update(SQL_INSERT
						,citaDto.getIdCliente()
						,citaDto.getIdProfesor()
						,citaDto.getEstadoCita()
						,citaDto.getFechaInicio()
						,citaDto.getFechaFin()
						,citaDto.getCantidadHoras()
						,citaDto.getPrecio()
						,citaDto.getDireccion()
						,citaDto.getNota());				
			}else {
				getJdbcTemplate().update(SQL_UPDATE						
						,citaDto.getIdCliente()
						,citaDto.getIdProfesor()
						,citaDto.getEstadoCita()
						,citaDto.getFechaInicio()
						,citaDto.getFechaFin()
						,citaDto.getCantidadHoras()
						,citaDto.getPrecio()
						,citaDto.getDireccion()
						,citaDto.getNota()
						,citaDto.getId());				
			}
			return citaDto;
		} catch (Exception e) {
			LOGGER.error("Error al ingresar un nuevo Profesor" + e);
			return new CitaDto();
		}
	}
	
	@Override
	public CitaDto findById(Long id) {
		SQL = SELECT_SQL + "WHERE cit.id = ? ";
		try {
			return getJdbcTemplate().queryForObject(SQL, new Object[] { id }, new CitaDtoRowMapper());
		} catch (Exception e) {
			LOGGER.error("Error al consultar el cita: " + e);
			return new CitaDto();
		}
	}
	
	
	@Override
	public List<CitaDto> findAll() {
		SQL = SELECT_SQL;
		try {					
			return getNamedParameterJdbcTemplate().query(SQL, new CitaDtoRowMapper());
		} catch (Exception e) {
			LOGGER.error("Error al obtener el listado de citas: " + e);
			return new ArrayList<CitaDto>();
		}
	}

	
	@Override
	public List<CitaDto> obtenerCitasAprobadasPorIdCliente(Long idCliente) {
		SQL = SELECT_SQL + "WHERE cit.estado_cita = 'APROBADA' AND cli.id = :id_cliente ";
		try {	
			Map<String, Object> parametros = new HashMap<>();
			parametros.put("id_cliente", idCliente);
			
			return getNamedParameterJdbcTemplate().query(SQL, parametros, new CitaDtoRowMapper());
		} catch (Exception e) {
			LOGGER.error("Error al obtener el listado de citas: " + e);
			return new ArrayList<CitaDto>();
		}
	}
	
	
	@Override
	public List<CitaDto> obtenerCitasAprobadasPorIdProfesor(Long idProfesor) {
		SQL = SELECT_SQL + "WHERE cit.estado_cita = 'APROBADA' AND pro.id = :id_profesor ";
		try {
			Map<String, Object> parametros = new HashMap<>();
			parametros.put("id_profesor", idProfesor);
			
			return getNamedParameterJdbcTemplate().query(SQL, parametros, new CitaDtoRowMapper());
		} catch (Exception e) {
			LOGGER.error("Error al obtener el listado de citas: " + e);
			return new ArrayList<CitaDto>();
		}
	}
	
	
	@Override
	public List<CitaDto> obtenerCitasNoRechazadasPorIdProfesor(Long idProfesor) {
		SQL = SELECT_SQL + "WHERE cit.estado_cita <> 'RECHAZADA' AND pro.id = :id_profesor ";
		try {	
			Map<String, Object> parametros = new HashMap<>();
			parametros.put("id_profesor", idProfesor);
			
			return getNamedParameterJdbcTemplate().query(SQL, parametros, new CitaDtoRowMapper());
		} catch (Exception e) {
			LOGGER.error("Error al obtener el listado de citas: " + e);
			return new ArrayList<CitaDto>();
		}
	}
	
	
	@Override
	public List<CitaDto> obtenerCitasPendientesDePago(LocalDateTime fechaActual) {
		SQL = SELECT_SQL + "WHERE cit.estado_cita = 'PENDIENTE DE PAGO' AND cit.fechaInicio >= :fecha_actual ";
		try {	
			Map<String, Object> parametros = new HashMap<>();
			parametros.put("fecha_actual", fechaActual);
			
			return getNamedParameterJdbcTemplate().query(SQL, new CitaDtoRowMapper());
		} catch (Exception e) {
			LOGGER.error("Error al obtener el listado de citas: " + e);
			return new ArrayList<CitaDto>();
		}
	}
	
	

	@Override
	protected String getSequenceName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
