package com.ceiba.homeenglish.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Cita")
public class Cita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private long idCliente;
	
	@Column(nullable = false)
	private long idProfesor;
	
	@Column(nullable = false)
	private String estadoCita;
	
	@Column(nullable = false)
	private LocalDateTime fechaInicio;
	
	@Column(nullable = false)
	private LocalDateTime fechaFin;
		
	@Column(nullable = false)
	private int cantidadHoras;
	
	@Column(nullable = true)
	private double precio;
	
	@Column(nullable = false)
	private String direccion;
	
	@Column(nullable = true)
	private String nota;
	
	
	public Cita() {}
	
	public Cita(long id, long idCliente, long idProfesor, String estadoCita, LocalDateTime fechaInicio,
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
