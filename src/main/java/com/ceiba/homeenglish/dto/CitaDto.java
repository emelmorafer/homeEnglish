package com.ceiba.homeenglish.dto;

import java.time.LocalDateTime;

public class CitaDto {
	
	private Long id;
	private long idCliente;
	private String nombreCompletoCliente;
	private long idProfesor;
	private String nombreCompletoProfesor;
	private String estadoCita;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;	
	private int cantidadHoras;
	private double precio;
	private String direccion;
	private String nota;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getNombreCompletoCliente() {
		return nombreCompletoCliente;
	}

	public void setNombreCompletoCliente(String nombreCompletoCliente) {
		this.nombreCompletoCliente = nombreCompletoCliente;
	}

	public long getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(long idProfesor) {
		this.idProfesor = idProfesor;
	}
	
	public String getNombreCompletoProfesor() {
		return nombreCompletoProfesor;
	}

	public void setNombreCompletoProfesor(String nombreCompletoProfesor) {
		this.nombreCompletoProfesor = nombreCompletoProfesor;
	}

	public String getEstadoCita() {
		return estadoCita;
	}

	public void setEstadoCita(String estadoCita) {
		this.estadoCita = estadoCita;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}
	
	

}
