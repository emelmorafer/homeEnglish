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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	
}
