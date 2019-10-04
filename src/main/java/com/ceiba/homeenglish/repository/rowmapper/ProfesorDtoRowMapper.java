package com.ceiba.homeenglish.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.ceiba.homeenglish.dto.ProfesorDto;

public class ProfesorDtoRowMapper implements RowMapper<ProfesorDto> {

	public ProfesorDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProfesorDto profesor = new ProfesorDto();
		profesor.setApellido(rs.getString("apellido"));
		profesor.setCedula(rs.getString("cedula"));
		profesor.setDireccion(rs.getString("direccion"));
		profesor.setEdad(rs.getInt("edad"));
		profesor.setNombre(rs.getString("nombre"));
		profesor.setId(rs.getLong("id"));
		return profesor;
	}

}
