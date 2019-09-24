package com.ceiba.homeenglish.dto;

public class ProfesorDto {
	
	private long id;
	private String cedula;
	private String nombre;
	private int edad;
	private String apellido;
	private String direccion;
	
	
	public ProfesorDto(long id, String cedula, String nombre, int edad, String apellido, String direccion) {
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.edad = edad;
		this.apellido = apellido;
		this.direccion = direccion;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
