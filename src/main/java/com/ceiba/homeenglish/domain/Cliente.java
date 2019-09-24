package com.ceiba.homeenglish.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String cedula;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = true)
	private int edad;
	
	@Column(nullable = false)
	private String apellido;
	
	@Column(nullable = true)
	private String direccion;
	
	
	public Cliente() {}
	
	public Cliente(long id, String cedula, String nombre, int edad, String apellido, String direccion) {
		super();
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
