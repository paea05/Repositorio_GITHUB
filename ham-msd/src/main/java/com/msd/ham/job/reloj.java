package com.msd.ham.job;

import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;

import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

public class reloj {
	private static final Logger log = Logger.getLogger(reloj.class);

	public void relojProgramador() {
		try {
			Scheduler programador = StdSchedulerFactory.getDefaultScheduler();
			System.out.println("Iniciando Scheduler...");
			log.info("Iniciando Scheduler...");

			programador.start();

			JobDetail detalleTrabajo = new JobDetail("EjecutarExcel", Scheduler.DEFAULT_GROUP,
					ejecutarLeerExcelDtosEco.class);

			CronTrigger trigger = new CronTrigger("EjecutarExcel", Scheduler.DEFAULT_GROUP);

			trigger.setCronExpression("0 0/1 * * * ?");

			programador.scheduleJob(detalleTrabajo, trigger);

		} catch (Exception e) {
			System.out.println("Ocurrió una excepción ::::>> " + e.getMessage());
			log.error("Ocurrió una excepción ::::>> " + e.getMessage());
		}
	}
}
