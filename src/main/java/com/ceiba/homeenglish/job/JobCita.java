package com.ceiba.homeenglish.job;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class JobCita implements org.quartz.Job {
	
	RestTemplate restTemplate = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();
	HttpEntity<Boolean> entity = new HttpEntity<>(headers);
	ResponseEntity<Boolean> response = null;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(JobCita.class);

		
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();

		response = restTemplate.exchange(dataMap.getString("urlServicio"),HttpMethod.GET, entity, Boolean.class);
		
		if(response.getBody()) {
			LOGGER.info("\n Se acaban de rechazar las citas vencidas \n"); 
		}else {
			LOGGER.info("\n No se pudieron rechazar las citas vencidas \n"); 
		}
				
	}

}
