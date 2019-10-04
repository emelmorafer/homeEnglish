package testdatabuilder;

import com.ceiba.homeenglish.dto.ProfesorDto;

public class ProfesorTestDataBuilder {

	private static final long ID = 100L;
	private static final String NOMBRE = "Carlos";
	private static final String CEDULA = "1128532784";
	private static final int EDAD = 780000;
	private static final String APELLIDO = "Restrepo";
	private static final String DIRECCION = "Cra 14 # 56 - 36";
	
	
	private Long id;
	private String cedula;
	private String nombre;
	private int edad;
	private String apellido;
	private String direccion;
	
	public ProfesorTestDataBuilder() {
		this.id = ID;
		this.cedula = CEDULA;
		this.nombre = NOMBRE;
		this.edad = EDAD;
		this.apellido = APELLIDO;
		this.direccion = DIRECCION;
	}
	
	public ProfesorTestDataBuilder conId(Long id) {
		this.id=id;
		return this;
	}

	public ProfesorTestDataBuilder conCedula(String cedula) {
		this.cedula=cedula;
		return this;
	}
	
	public ProfesorTestDataBuilder conNombre(String nombre) {
		this.nombre=nombre;
		return this;
	}
	
	public ProfesorTestDataBuilder conEdad(int edad) {
		this.edad=edad;
		return this;
	}
	
	public ProfesorTestDataBuilder conApellido(String apellido) {
		this.apellido=apellido;
		return this;
	}
	
	
	public ProfesorDto build() {		
		return new ProfesorDto(this.id,this.cedula,this.nombre,this.edad,this.apellido,this.direccion);
	}


}
