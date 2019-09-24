package com.ceiba.homeenglish.dto;

import java.time.LocalDateTime;

public class CitaDto {
	
	private long id;
	private long idCliente;
	private long idProfesor;
	private String estadoCita;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private int cantidadHoras;
	private double precio;
	private String direccion;
	private String nota;
	

	public CitaDto(long id, long idCliente, long idProfesor, String estadoCita, LocalDateTime fechaInicio,
			LocalDateTime fechaFin, int cantidadHoras, double precio, String direccion, String nota) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.idProfesor = idProfesor;
		this.estadoCita = estadoCita;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cantidadHoras = cantidadHoras;
		this.precio = precio;
		this.direccion = direccion;
		this.nota = nota;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public long getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(long idProfesor) {
		this.idProfesor = idProfesor;
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
