package com.ceiba.homeEnglish.integracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.homeenglish.dto.CitaDto;
import testDataBuilder.CitaTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CitaTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	private static final Long ID_CITA_CREADA = 1L;
	private static final Long ID_PROFESOR_CREADO = 10L;
	private static final String NOTA_CREACION = "Nota de creacion";
	private static final int DOS_HORAS = 2;
	private static final int UNA_HORA = 1;

	private String crearURL(String uri) {
		return "http://localhost:" + port + uri;
	}

	
	@Test
	public void guardarCitaTest() {
		// arrange		
		CitaDto request = new CitaTestDataBuilder().conId(null).conNota(NOTA_CREACION).build();
		HttpEntity<CitaDto> entity = new HttpEntity<>(request, headers);
		// act
		ResponseEntity<CitaDto> response = restTemplate.exchange(
				crearURL("/api/guardarCita"), HttpMethod.POST, entity, CitaDto.class);
		CitaDto cita = response.getBody();
		// assert
		assertEquals(NOTA_CREACION,cita.getNota());
	}	
	
	@Test
	public void getCitaByIdTest() {
		// arrange
		HttpEntity<CitaDto> entity = new HttpEntity<>(headers);
		// act
		ResponseEntity<CitaDto> response = restTemplate.exchange(
				crearURL("/api/getCitaById?id=" + ID_CITA_CREADA), 
				HttpMethod.GET, entity, CitaDto.class);
		CitaDto cita = response.getBody();
		// assert
		assertEquals(ID_CITA_CREADA, cita.getId());
	}
	
	@Test
	public void aprobarCitaPorIdTest() {
		// arrange
		HttpEntity<Boolean> entity = new HttpEntity<>(headers);
		HttpEntity<CitaDto> entity2 = new HttpEntity<>(headers);
		// act
		ResponseEntity<Boolean> response = restTemplate.exchange(
				crearURL("/api/aprobarCitaPorId?id=" + ID_CITA_CREADA), 
				HttpMethod.GET, entity, Boolean.class);
		Boolean respuesta = response.getBody();
		
		ResponseEntity<CitaDto> response2 = restTemplate.exchange(
				crearURL("/api/getCitaById?id=" + ID_CITA_CREADA), 
				HttpMethod.GET, entity2, CitaDto.class);
		CitaDto cita = response2.getBody();
		// assert
		assertTrue( (respuesta==true) && (cita.getEstadoCita().equals("APROBADA")) );
	}
	
	@Test
	public void rechazarCitaPorIdTest() {
		// arrange
		HttpEntity<Boolean> entity = new HttpEntity<>(headers);
		HttpEntity<CitaDto> entity2 = new HttpEntity<>(headers);
		// act
		ResponseEntity<Boolean> response = restTemplate.exchange(
				crearURL("/api/rechazarCitaPorId?id=" + ID_CITA_CREADA), 
				HttpMethod.GET, entity, Boolean.class);
		Boolean respuesta = response.getBody();
		
		ResponseEntity<CitaDto> response2 = restTemplate.exchange(
				crearURL("/api/getCitaById?id=" + ID_CITA_CREADA), 
				HttpMethod.GET, entity2, CitaDto.class);
		CitaDto cita = response2.getBody();
		// assert
		assertTrue( (respuesta==true) && (cita.getEstadoCita().equals("REACHAZADA")) );
	}
	
	@Test
	public void getListCitaTest() {
		// arrange
		HttpEntity<CitaDto[]> entity = new HttpEntity<>(headers);
		// act
		ResponseEntity<CitaDto[]> response = restTemplate.exchange(
				crearURL("/api/getListCita"), 
				HttpMethod.GET, entity, CitaDto[].class);
		CitaDto[] arrayCita = response.getBody();
		// assert
		assertTrue(arrayCita.length>0);
	}
	
	@Test
	public void verificarValidesGuardadoDeCitaCorrectaTest() {
		// arrange				
		LocalDateTime fechaAhora = LocalDateTime.now();
		CitaDto request1 = new CitaTestDataBuilder().conId(null)
				.conFechaInicio(fechaAhora)
				.conCantidadHoras(DOS_HORAS)
				.conIdProfesor(ID_PROFESOR_CREADO)
				.conFechaFin(fechaAhora.plusHours(DOS_HORAS)).build();
		
		CitaDto request2 = new CitaTestDataBuilder().conId(null)
				.conFechaInicio(fechaAhora.plusHours(UNA_HORA + DOS_HORAS))
				.conCantidadHoras(DOS_HORAS)
				.conIdProfesor(ID_PROFESOR_CREADO)
		        .conFechaFin(fechaAhora.plusHours(UNA_HORA+DOS_HORAS+DOS_HORAS)).build();
		
		HttpEntity<CitaDto> entity1 = new HttpEntity<>(request1, headers);
		HttpEntity<CitaDto> entity2 = new HttpEntity<>(request2, headers);
		
		restTemplate.exchange(crearURL("/api/guardarCita"), HttpMethod.POST, entity1, CitaDto.class);
		// act
		ResponseEntity<Boolean> response2 = restTemplate.exchange(
				crearURL("/api/verificarValidesGuardadoDeCita"), HttpMethod.POST, entity2, Boolean.class);
		
		boolean citaValida = response2.getBody();
		
		// assert
		assertTrue(citaValida);
	}
		
	@Test
	public void verificarValidesGuardadoDeCitaIncorrectaTest() {
		// arrange				
		LocalDateTime fechaAhora = LocalDateTime.now();
		CitaDto request1 = new CitaTestDataBuilder().conId(null)
				.conFechaInicio(fechaAhora)
				.conCantidadHoras(DOS_HORAS)
				.conIdProfesor(ID_PROFESOR_CREADO)
				.conFechaFin(fechaAhora.plusHours(DOS_HORAS)).build();
		
		CitaDto request2 = new CitaTestDataBuilder().conId(null)
				.conFechaInicio(fechaAhora.plusHours(UNA_HORA))
				.conCantidadHoras(DOS_HORAS)
				.conIdProfesor(ID_PROFESOR_CREADO)
				.conFechaFin(fechaAhora.plusHours(UNA_HORA+DOS_HORAS)).build();	
		
		HttpEntity<CitaDto> entity1 = new HttpEntity<>(request1, headers);
		HttpEntity<CitaDto> entity2 = new HttpEntity<>(request2, headers);
		
		restTemplate.exchange(crearURL("/api/guardarCita"), HttpMethod.POST, entity1, CitaDto.class);
		// act
		ResponseEntity<Boolean> response2 = restTemplate.exchange(
				crearURL("/api/verificarValidesGuardadoDeCita"), HttpMethod.POST, entity2, Boolean.class);
		
		boolean citaValida = response2.getBody();
		
		// assert
		assertFalse(citaValida);
	}

	
	
}
