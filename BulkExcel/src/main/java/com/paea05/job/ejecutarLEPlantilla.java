package com.paea05.job;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.paea05.excel.lEDtosEcologicos;

public class ejecutarLEPlantilla implements Job {
	private static final Logger log = Logger.getLogger(ejecutarLEPlantilla.class);
	private static final lEDtosEcologicos lEDE = new lEDtosEcologicos();

	public void execute(JobExecutionContext C) throws JobExecutionException {
		try {
			lEDE.validaExcel();
		} catch (Exception e) {
			System.out.println("Error al ejecutar Job ::::>> " + e.getMessage());
            log.fatal("Error al ejecutar Job ::::>> " + e.getMessage());
		}
		
	}
	
}
