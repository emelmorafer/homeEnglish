package com.ceiba.homeenglish.integracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.homeenglish.dto.ClienteDto;
import testdatabuilder.ClienteTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class ClienteTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	private static final String NOMBRE_CLIENTE_CREACION = "Emel";
	private static final Long ID_CLIENTE_CREADO = 100L;

	private String crearURL(String uri) {
		return "http://localhost:" + port + uri;
	}
	
	@Test
	public void guardarClienteTest() {
		// arrange		
		ClienteDto request = new ClienteTestDataBuilder().conId(null).conNombre(NOMBRE_CLIENTE_CREACION).build();
		HttpEntity<ClienteDto> entity = new HttpEntity<>(request, headers);
		// act
		ResponseEntity<ClienteDto> response = restTemplate.exchange(
				crearURL("/homeEnglish/guardarCliente"), HttpMethod.POST, entity, ClienteDto.class);
		ClienteDto cliente = response.getBody();
		// assert
		assertEquals(NOMBRE_CLIENTE_CREACION,cliente.getNombre());
	}
		
	@Test
	public void getClienteByIdTest() {
		// arrange
		HttpEntity<ClienteDto> entity = new HttpEntity<>(headers);
		// act
		ResponseEntity<ClienteDto> response = restTemplate.exchange(
				crearURL("/homeEnglish/getClienteById?id=" + ID_CLIENTE_CREADO), 
				HttpMethod.GET, entity, ClienteDto.class);
		ClienteDto cliente = response.getBody();
		// assert
		assertEquals(ID_CLIENTE_CREADO, cliente.getId());
	}
	
	@Test
	public void getListClienteTest() {
		// arrange
		HttpEntity<ClienteDto[]> entity = new HttpEntity<>(headers);
		// act
		ResponseEntity<ClienteDto[]> response = restTemplate.exchange(
				crearURL("/homeEnglish/getListCliente"), 
				HttpMethod.GET, entity, ClienteDto[].class);
		ClienteDto[] arrayCliente = response.getBody();
		// assert
		assertTrue(arrayCliente.length>0);
	}
	
	

}
