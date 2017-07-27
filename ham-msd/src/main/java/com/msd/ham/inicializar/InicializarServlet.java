package com.msd.ham.inicializar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.msd.ham.job.reloj;

public class InicializarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(InicializarServlet.class);

	public void inicio() throws ServletException {
		try {
			System.out.println(" << :::::::: Inicializando ::::::::>> ");
			log.info(" << :::::::: Inicializando ::::::::>> ");

			reloj r = new reloj();
			r.relojProgramador();
		} catch (Exception e) {
			System.out.println("Error de Inicializacion :::>> " + e.getMessage());
			log.error("Error de Inicializacion :::>> " + e.getMessage());
		}
	}
}
