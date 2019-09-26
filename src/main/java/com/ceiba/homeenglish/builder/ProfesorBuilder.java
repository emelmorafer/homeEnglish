package com.ceiba.homeenglish.builder;

import com.ceiba.homeenglish.domain.Profesor;
import com.ceiba.homeenglish.dto.ProfesorDto;

public class ProfesorBuilder {
	
	private ProfesorBuilder() {}
	
	public static ProfesorDto convertirADto(Profesor profesor) {
		
		ProfesorDto profesorDto = null;
		
		if(profesor != null) {
			profesorDto = new ProfesorDto(profesor.id, profesor.cedula, 
					profesor.nombre, profesor.edad, profesor.apellido, profesor.direccion);
		}
		
		return profesorDto;
	}
	
	public static Profesor convertirAEntity(ProfesorDto profesorDto) {
		
		Profesor profesor = new Profesor();
		
		if(profesorDto.getId() != null) {
			profesor.setId(profesorDto.getId());
		}
		profesor.setCedula(profesorDto.getCedula());
		profesor.setNombre(profesorDto.getNombre());
		profesor.setEdad(profesorDto.getEdad());
		profesor.setApellido(profesorDto.getApellido());
		profesor.setDireccion(profesorDto.getDireccion());
		
		return profesor;
	}
}
