package com.ceiba.homeEnglish.unitaria;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ceiba.homeenglish.dao.ClienteDao;
import com.ceiba.homeenglish.domain.Cliente;

import testDataBuilder.ClienteTestDataBuilder;

public class ClienteTest {
	
	private static final long ID_CLIENTE_PRUEBA = 10L;
	private static final long ID_CLIENTE_PRUEBA2 = 11L;
	private static final String NOMBRE_CLIENTE_PRUEBA = "Emel";
	
	
	private ClienteDao clienteDao;
	
	@Before
	public void setUp() {
		clienteDao = mock(ClienteDao.class);
	}


	@Test
	public void clienteDaoGuardarTest() {
		// arrange
		Cliente cliente = new ClienteTestDataBuilder().conId(ID_CLIENTE_PRUEBA).build();
		// act
		when(clienteDao.save(cliente)).thenReturn(cliente);		
		// assert
		Assert.assertNotNull(clienteDao.findById(cliente.getId()));
	}

	@Test
	public void clienteDaoObtenerPorIdTest() {
		// arrange
		Cliente cliente = new ClienteTestDataBuilder().conId(ID_CLIENTE_PRUEBA).build();
		
		Cliente cliente2 = new ClienteTestDataBuilder().conId(ID_CLIENTE_PRUEBA).build();
		// act
		when(clienteDao.findById(cliente.getId()).get()).thenReturn(cliente2);	
		// assert
		Assert.assertTrue(cliente.getId() == cliente2.getId());
	}


}
