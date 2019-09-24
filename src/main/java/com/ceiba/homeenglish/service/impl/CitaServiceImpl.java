package com.ceiba.homeenglish.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.homeenglish.service.CitaService;
import com.ceiba.homeenglish.dao.CitaDao;
import com.ceiba.homeenglish.domain.Cita;

@Service
public class CitaServiceImpl implements CitaService{
	
	private static final String ESTADO_CREACION = "PENDIENTE";
	private static final Double PRECIO_HORA_CITA = 25000D;
	
	@Autowired
    CitaDao citaDao;
	
	public Cita guardarCita(Cita cita) {		
		cita.setEstadoCita(ESTADO_CREACION);		
		cita.setPrecio(PRECIO_HORA_CITA*cita.getCantidadHoras());
		cita.setFechaFin(cita.getFechaInicio().plusHours(cita.getCantidadHoras()));
		
		citaDao.save(cita);				
		return cita;
	}

    public Cita actualizarCita(Cita cita) {
    	citaDao.save(cita);		
		return cita;
    }

    public Cita obtenerCitaPorId(long id) {
    	return citaDao.findById(id).get();
    }

    public List<Cita> obtenerListadoCitas(){
    	return (List<Cita>) citaDao.findAll();
    }
    
    public List<Cita> obtenerListadoCitasPorProfesor(long idProfesor){
    	return (List<Cita>) citaDao.obtenerCitasAprobadasPorIdProfesor(idProfesor);
    }
	
	public List<Cita> obtenerListadoCitasPorCliente(long idCliente){
		return (List<Cita>) citaDao.findByIdCliente(idCliente);
	}
	
	public boolean verificarCruceDeCitas(long idProfesor, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		
		List<Cita> listadoCitas = citaDao.obtenerCitasPorIdProfesoryFechas(idProfesor, fechaInicio, fechaFin);
		
		if(listadoCitas.isEmpty() || listadoCitas==null) {
			return false;
		}else {
			return true;
		}
	}

}
