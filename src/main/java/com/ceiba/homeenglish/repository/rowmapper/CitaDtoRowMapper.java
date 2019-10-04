package com.ceiba.homeenglish.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.ceiba.homeenglish.dto.CitaDto;

public class CitaDtoRowMapper implements RowMapper<CitaDto> {

	public CitaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CitaDto cita = new CitaDto();
		cita.setId(rs.getLong("id"));
		cita.setIdCliente(rs.getLong("idCliente"));
		cita.setNombreCompletoCliente(rs.getString("nombreCompletoCliente"));
		cita.setIdProfesor(rs.getLong("idProfesor"));
		cita.setNombreCompletoProfesor(rs.getString("nombreCompletoProfesor"));
		cita.setEstadoCita(rs.getString("estadoCita"));
		cita.setFechaInicio(rs.getTimestamp("fechaInicio").toLocalDateTime());
		cita.setFechaFin(rs.getTimestamp("fechaInicio").toLocalDateTime());
		cita.setCantidadHoras(rs.getInt("cantidadHoras"));
		cita.setPrecio(rs.getDouble("precio"));
		cita.setDireccion(rs.getString("direccion"));
		cita.setNota(rs.getString("nota"));
		
		return cita;
	}

}
