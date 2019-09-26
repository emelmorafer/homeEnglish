package testDataBuilder;

import com.ceiba.homeenglish.dto.ClienteDto;

public class ClienteTestDataBuilder {

	private static final String NOMBRE = "Carlos";
	private static final String CEDULA = "1128532784";
	private static final int EDAD = 33;
	private static final String APELLIDO = "Restrepo";
	private static final String DIRECCION = "Cra 14 # 56 - 36";
	
	
	private Long id;
	private String cedula;
	private String nombre;
	private int edad;
	private String apellido;
	private String direccion;
	
	public ClienteTestDataBuilder() {
		this.cedula = CEDULA;
		this.nombre = NOMBRE;
		this.edad = EDAD;
		this.apellido = APELLIDO;
		this.direccion = DIRECCION;
	}
	
	public ClienteTestDataBuilder conId(Long id) {
		this.id=id;
		return this;
	}

	public ClienteTestDataBuilder conCedula(String cedula) {
		this.cedula=cedula;
		return this;
	}
	
	public ClienteTestDataBuilder conNombre(String nombre) {
		this.nombre=nombre;
		return this;
	}
	
	public ClienteTestDataBuilder conEdad(int edad) {
		this.edad=edad;
		return this;
	}
	
	public ClienteTestDataBuilder conApellido(String apellido) {
		this.apellido=apellido;
		return this;
	}
	
	public ClienteDto build() {
		return new ClienteDto(this.id,this.cedula,this.nombre,this.edad,this.apellido,this.direccion);
	}


}
