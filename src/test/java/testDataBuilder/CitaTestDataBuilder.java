package testDataBuilder;

import java.time.LocalDateTime;

import com.ceiba.homeenglish.domain.Cita;
import com.ceiba.homeenglish.domain.Cliente;
import com.ceiba.homeenglish.domain.Profesor;

public class CitaTestDataBuilder {

	private static final long ID = 10L;
	private static final String ESTADO_CITA = "PENDIENTE DE PAGO";	
	private static final LocalDateTime FECHA_INICIO = LocalDateTime.now();	
	private static final int CANTIDAD_HORAS = 3;
	private static final String DIRECCION = "Cra 14 # 56 - 36";
	private static final String NOTA = "prueba";
	
	
	private long id;
	private Cliente cliente;
	private Profesor profesor;
	private String estadoCita;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private int cantidadHoras;
	private double precio;
	private String direccion;
	private String nota;
	
	
	public CitaTestDataBuilder() {
		this.id = ID;		
		this.cliente = new ClienteTestDataBuilder().build();
		this.profesor = new ProfesorTestDataBuilder().build();
		this.estadoCita = ESTADO_CITA;
		this.fechaInicio = FECHA_INICIO;
		this.cantidadHoras = CANTIDAD_HORAS;
		this.direccion = DIRECCION;
		this.nota = NOTA;
	}

	public CitaTestDataBuilder conCantidadHoras(int cantidadHoras) {
		this.cantidadHoras=cantidadHoras;
		this.fechaFin=this.fechaInicio.plusHours(cantidadHoras);
		return this;
	}
	
	public CitaTestDataBuilder conFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaInicio.plusHours(this.cantidadHoras);
		return this;
	}
	
	public CitaTestDataBuilder conFechaFin(LocalDateTime fechaFin) {
		this.fechaFin=fechaFin;
		return this;
	}
		
	public Cita build() {
		return new Cita(this.id,this.cliente,this.profesor,this.estadoCita,this.fechaInicio,
				this.fechaFin,this.cantidadHoras,this.precio,this.direccion,this.nota);
	}


}
