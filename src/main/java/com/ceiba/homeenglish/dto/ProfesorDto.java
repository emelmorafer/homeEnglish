package com.ceiba.homeenglish.dto;

public class ProfesorDto  extends PersonaDto{
	
	public ProfesorDto() {
	}
	
	public ProfesorDto(Long id, String cedula, String nombre, int edad, String apellido, String direccion) {
		super.id = id;
		super.cedula = cedula;
		super.nombre = nombre;
		super.edad = edad;
		super.apellido = apellido;
		super.direccion = direccion;
	}
	
}
