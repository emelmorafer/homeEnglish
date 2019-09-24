package com.ceiba.homeEnglish.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.ceiba.homeenglish.controller.ClienteRestController;
import com.ceiba.homeenglish.domain.Cliente;
import com.ceiba.homeenglish.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;
import testDataBuilder.ClienteTestDataBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(ClienteRestController.class)
public class ClienteTest {

	private static final long ID_CLIENTE_PRUEBA = 10L;
	private static final long ID_CLIENTE_PRUEBA2 = 11L;
	private static final String NOMBRE_CLIENTE_PRUEBA = "Emel";

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;
	
	@Autowired
	private ClienteService clienteServiceReal;

	@MockBean
	private ClienteService clienteService;

	@Before
	public void setUp() {
	}

	@Test
	public void obtenerClientePorIdTest() throws Exception {

		// arrange
		Cliente cliente = new ClienteTestDataBuilder().conId(ID_CLIENTE_PRUEBA).build();
		clienteServiceReal.guardarCliente(cliente);

		// act - assert
		mocMvc.perform(get("/api/getClienteById").param("id",String.valueOf(ID_CLIENTE_PRUEBA))).andDo(print())
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$[0].id").value(ID_CLIENTE_PRUEBA));

	}
	



}
