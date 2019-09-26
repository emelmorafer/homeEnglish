package com.ceiba.homeenglish.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Profesor")
public class Profesor {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@Column(name = "cedula", nullable = false)
	public String cedula;
	
	@Column(name = "nombre", nullable = false)
	public String nombre;
	
	@Column(name = "apellido", nullable = false)
	public String apellido;
	
	@Column(name = "edad", nullable = true)
	public int edad;	
	
	@Column(name = "direccion", nullable = true)
	public String direccion;
	
	
	public Profesor() {}
	
	public Profesor(Long id) {
		super();
		this.id = id;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
