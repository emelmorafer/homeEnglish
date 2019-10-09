package com.ceiba.homeenglish.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Cita")
public class Cita {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_profesor", referencedColumnName = "id")
	private Profesor profesor;
	
	@Column(name = "estado_cita", nullable = false)
	private String estadoCita;
	
	@Column(name = "fecha_inicio", nullable = false)
	private LocalDateTime fechaInicio;
	
	@Column(name = "fecha_fin", nullable = false)
	private LocalDateTime fechaFin;
		
	@Column(name = "cantidad_horas", nullable = false)
	private int cantidadHoras;
	
	@Column(name = "precio", nullable = true)
	private double precio;
	
	@Column(name = "direccion", nullable = false)
	private String direccion;
	
	@Column(name = "nota", nullable = true)
	private String nota;
	
	
	public Cita() {
		super();
	}

	
}
