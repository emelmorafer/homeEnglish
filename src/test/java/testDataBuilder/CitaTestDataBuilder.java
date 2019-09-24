package testDataBuilder;

import java.time.LocalDateTime;

import com.ceiba.homeenglish.domain.Cita;

public class CitaTestDataBuilder {

	private static final long ID = 10L;
	private static final long ID_CLIENTE = 10L;
	private static final long ID_PROFESOR = 10L;
	private static final String ESTADO_CITA = "PENDIENTE DE PAGO";	
	private static final LocalDateTime FECHA_INICIO = LocalDateTime.now();	
	private static final int CANTIDAD_HORAS = 3;
	private static final String DIRECCION = "Cra 14 # 56 - 36";
	private static final String NOTA = "prueba";
	
	
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
	
	
	public CitaTestDataBuilder() {
		this.id = ID;		
		this.idCliente = ID_CLIENTE;
		this.idProfesor = ID_PROFESOR;
		this.estadoCita = ESTADO_CITA;
		this.fechaInicio = FECHA_INICIO;
		this.cantidadHoras = CANTIDAD_HORAS;
		this.direccion = DIRECCION;
		this.nota = NOTA;
	}


		
	public Cita build() {
		return new Cita(this.id,this.idCliente,this.idProfesor,this.estadoCita,this.fechaInicio,
				this.fechaFin,this.cantidadHoras,this.precio,this.direccion,this.nota);
	}


}
