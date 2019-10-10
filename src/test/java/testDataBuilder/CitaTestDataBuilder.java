package testdatabuilder;

import java.time.LocalDateTime;
import com.ceiba.homeenglish.dto.CitaDto;

public class CitaTestDataBuilder {

	private static final long ID = 100L;
	private static final long ID_CLIENTE = 100L;
	private static final String NOMBRE_CLIENTE = "nombreCliente";
	private static final long ID_PROFESOR = 100L;
	private static final String NOMBRE_PROFESOR = "nombreProfesor";
	private static final String ESTADO_CITA = "PENDIENTE DE PAGO";	
	private static final LocalDateTime FECHA_INICIO = LocalDateTime.now();	
	private static final int CANTIDAD_HORAS = 3;
	private static final String DIRECCION = "Cra 14 # 56 - 36";
	private static final String NOTA = "prueba";
	
	
	private Long id;
	private Long idCliente;
	private String nombreCompletoCliente;
	private Long idProfesor;
	private String nombreCompletoProfesor;
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
		this.nombreCompletoCliente = NOMBRE_CLIENTE;
		this.idProfesor = ID_PROFESOR;
		this.nombreCompletoProfesor = NOMBRE_PROFESOR;
		this.estadoCita = ESTADO_CITA;
		this.fechaInicio = FECHA_INICIO;
		this.cantidadHoras = CANTIDAD_HORAS;
		this.direccion = DIRECCION;
		this.nota = NOTA;
	}
	
	public CitaTestDataBuilder conId(Long id) {
		this.id=id;
		return this;
	}
	
	public CitaTestDataBuilder conIdProfesor(Long idProfesor) {
		this.idProfesor=idProfesor;
		return this;
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
	
	public CitaTestDataBuilder conNota(String nota) {
		this.nota=nota;
		return this;
	}
		
	public CitaDto build() {		
		CitaDto citaDto = new CitaDto();
		
		citaDto.setId(this.id);
		citaDto.setIdCliente(this.idCliente);
		citaDto.setNombreCompletoCliente(this.nombreCompletoCliente);
		citaDto.setIdProfesor(this.idProfesor);
		citaDto.setNombreCompletoProfesor(this.nombreCompletoProfesor);
		citaDto.setEstadoCita(this.estadoCita);
		citaDto.setFechaInicio(this.fechaInicio);
		citaDto.setFechaFin(this.fechaFin);
		citaDto.setCantidadHoras(this.cantidadHoras);
		citaDto.setPrecio(this.precio);
		citaDto.setDireccion(this.direccion);
		citaDto.setNota(this.nota);
				
		return citaDto;
	}


}
