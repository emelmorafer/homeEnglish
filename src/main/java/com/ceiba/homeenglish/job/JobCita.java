package com.ceiba.homeenglish.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.homeenglish.service.CitaService;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class JobCita implements org.quartz.Job {
	
	@Autowired
	private CitaService citaService;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(JobCita.class);

		
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		//citaService.rechazarCitasVencidas();
		
		LOGGER.info("\n Se acaban de verificar citas vencidas \n"); 
	}

}
