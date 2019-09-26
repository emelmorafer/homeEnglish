package com.ceiba.homeEnglish.integracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

import com.ceiba.homeenglish.dto.ProfesorDto;
import testDataBuilder.ProfesorTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProfesorTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	private static final String NOMBRE_PROFESOR_CREACION = "Santiago";
	private static final Long ID_PROFESOR_CREADO = 1L;

	private String crearURL(String uri) {
		return "http://localhost:" + port + uri;
	}

	
	@Test
	public void guardarProfesorTest() {
		// arrange		
		ProfesorDto request = new ProfesorTestDataBuilder().conId(null).conNombre(NOMBRE_PROFESOR_CREACION).build();
		HttpEntity<ProfesorDto> entity = new HttpEntity<>(request, headers);
		// act
		ResponseEntity<ProfesorDto> response = restTemplate.exchange(
				crearURL("/api/guardarProfesor"), HttpMethod.POST, entity, ProfesorDto.class);
		ProfesorDto profesor = response.getBody();
		// assert
		assertEquals(NOMBRE_PROFESOR_CREACION,profesor.getNombre());
	}
		
	@Test
	public void getProfesorByIdTest() {
		// arrange
		HttpEntity<ProfesorDto> entity = new HttpEntity<>(headers);
		// act
		ResponseEntity<ProfesorDto> response = restTemplate.exchange(
				crearURL("/api/getProfesorById?id=" + ID_PROFESOR_CREADO), 
				HttpMethod.GET, entity, ProfesorDto.class);
		ProfesorDto profesor = response.getBody();
		// assert
		assertEquals(ID_PROFESOR_CREADO, profesor.getId());
	}
	
	@Test
	public void getListProfesorTest() {
		// arrange
		HttpEntity<ProfesorDto[]> entity = new HttpEntity<>(headers);
		// act
		ResponseEntity<ProfesorDto[]> response = restTemplate.exchange(
				crearURL("/api/getListProfesor"), 
				HttpMethod.GET, entity, ProfesorDto[].class);
		ProfesorDto[] arrayProfesor = response.getBody();
		// assert
		assertTrue(arrayProfesor.length>0);
	}
	
	

}
