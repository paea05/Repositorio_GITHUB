package com.msd.ham.job;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.msd.ham.excel.leerExcelDtosEcologicos;

public class ejecutarLeerExcelDtosEco implements Job {
	private static final Logger log = Logger.getLogger(ejecutarLeerExcelDtosEco.class);
	private static final leerExcelDtosEcologicos lEDtEco = new leerExcelDtosEcologicos();

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			lEDtEco.validaExcel();
		} catch (Exception e) {
			System.out.println("Error al ejecutar Job ::::>> " + e.getMessage());
            log.fatal("Error al ejecutar Job ::::>> " + e.getMessage());
		}
		
	}
	
}
