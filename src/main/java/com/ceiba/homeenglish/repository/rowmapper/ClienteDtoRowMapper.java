package com.ceiba.homeenglish.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.ceiba.homeenglish.dto.ClienteDto;

public class ClienteDtoRowMapper implements RowMapper<ClienteDto> {

	public ClienteDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClienteDto cliente = new ClienteDto();
		cliente.setApellido(rs.getString("apellido"));
		cliente.setCedula(rs.getString("cedula"));
		cliente.setDireccion(rs.getString("direccion"));
		cliente.setEdad(rs.getInt("edad"));
		cliente.setNombre(rs.getString("nombre"));
		cliente.setId(rs.getLong("id"));
		return cliente;
	}

}
