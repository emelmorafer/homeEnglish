package com.ceiba.homeenglish;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.ceiba.homeenglish.job.JobCita;


//@ComponentScan("")
@SpringBootApplication
@EnableScheduling
public class HomeEnglishApplication {
	
	private static final String URL_SERVICIO = "http://localhost:8080/homeEnglish/rechazarCitasVencidas";
		
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeEnglishApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HomeEnglishApplication.class, args);
	}
	
	
	@Bean
	boolean programarTarea(){
		try {				
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			
			//String cronExpression = "0 0/1 * 1/1 * ? *";  //Cada Minuto
			String cronExpression = "0 0 0/1 1/1 * ? *";  //Cada Hora
	        				    
		    JobDetail job = JobBuilder.newJob(JobCita.class)  
		        .withIdentity("jobCita","groupCita")
		        .usingJobData("urlServicio",URL_SERVICIO).build();
		        
		    
		    CronTrigger trigger = TriggerBuilder.newTrigger()
		    	.withIdentity("triggerCita","groupCita").startNow()
		    	.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
		    	.build();
		        	
            scheduler.scheduleJob(job,trigger);	
            scheduler.start();	
            scheduler.shutdown(Boolean.TRUE);
            LOGGER.info("\n Se programo la tarea para verificar citas vencidas \n"); 
			return true;			
		} catch (Exception e) {
			LOGGER.error("\n No se pudo programar la tarea para verificar citas vencidas ", e );
			return false;
		}	
	}

}
