package com.ceiba.homeEnglish.unitaria;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import com.ceiba.homeenglish.dto.CitaDto;
import com.ceiba.homeenglish.service.CitaService;
import com.ceiba.homeenglish.service.impl.CitaServiceImpl;

import testDataBuilder.CitaTestDataBuilder;

public class CitaTest {
	
	private static final int DOS_HORAS = 2;
	private static final int UNA_HORA = 1;
	private static final double PRECIO_2_HORAS = 50000D;
	private static final int CANTIDAD_HORAS_MAYOR_DIA = 25;
	
	
	
	private CitaService citaService;
	
	@Before
	public void setUp() {
		citaService = new CitaServiceImpl();
	}


	@Test
	public void calcularPrecioCitaTest() {
		// arrange
		CitaDto cita = new CitaTestDataBuilder().conCantidadHoras(DOS_HORAS).build();
		// act
		double precio = citaService.calcularPrecioCita(cita);	
		// assert
		assertTrue(PRECIO_2_HORAS == precio);
	}
	
	@Test
	public void obtenerFechaFinCitaTest() {
		// arrange
		LocalDateTime fechaAhora = LocalDateTime.now();
		CitaDto cita = new CitaTestDataBuilder()
				.conFechaInicio(fechaAhora).conCantidadHoras(DOS_HORAS).build();
		// act
		LocalDateTime fechaFinal = citaService.obtenerFechaFinCita(cita);	
		// assert
		assertEquals(fechaAhora.plusHours(DOS_HORAS),fechaFinal);
	}
	
	@Test
	public void verificarCitaVencidaTest() {
		// arrange
		LocalDateTime fechaAhora = LocalDateTime.now();
		CitaDto cita = new CitaTestDataBuilder().conFechaInicio(fechaAhora.plusHours(DOS_HORAS)).build();
		// act
		boolean citaVencida = citaService.verificarVencimientoCita(cita,fechaAhora);	
		// assert
		assertTrue(citaVencida);
	}
	
	@Test
	public void verificarCitaNoVencidaTest() {
		// arrange
		LocalDateTime fechaAhora = LocalDateTime.now();
		CitaDto cita = new CitaTestDataBuilder()
				.conFechaInicio(fechaAhora.plusHours(CANTIDAD_HORAS_MAYOR_DIA)).build();
		// act
		boolean citaVencida = citaService.verificarVencimientoCita(cita,fechaAhora);	
		// assert
		assertFalse(citaVencida);
	}
	
	@Test
	public void verificarCitasCruzadasTest() {
		// arrange
		LocalDateTime fechaAhora = LocalDateTime.now();
		CitaDto cita1 = new CitaTestDataBuilder()
				.conFechaInicio(fechaAhora)
				.conCantidadHoras(DOS_HORAS)
				.conFechaFin(fechaAhora.plusHours(DOS_HORAS)).build();
		
		CitaDto cita2 = new CitaTestDataBuilder()
				.conFechaInicio(fechaAhora.plusHours(UNA_HORA))
				.conCantidadHoras(DOS_HORAS)
				.conFechaFin(fechaAhora.plusHours(UNA_HORA+DOS_HORAS)).build();	
		// act		
		boolean citasCruzadas = citaService.verificarCruce2Citas(cita1,cita2);
		// assert
		assertTrue(citasCruzadas);
	}
	
	@Test
	public void verificarCitasNoCruzadasTest() {
		// arrange
		LocalDateTime fechaAhora = LocalDateTime.now();
		CitaDto cita1 = new CitaTestDataBuilder()
				.conFechaInicio(fechaAhora)
				.conCantidadHoras(DOS_HORAS)
				.conFechaFin(fechaAhora.plusHours(DOS_HORAS)).build();
		
		CitaDto cita2 = new CitaTestDataBuilder()
				.conFechaInicio(fechaAhora.plusHours(UNA_HORA + DOS_HORAS))
				.conCantidadHoras(DOS_HORAS)
		        .conFechaFin(fechaAhora.plusHours(UNA_HORA+DOS_HORAS+DOS_HORAS)).build();
		// act
		boolean citasCruzadas = citaService.verificarCruce2Citas(cita1,cita2);	
		// assert
		assertFalse(citasCruzadas);
	}


}
