package com.msd.ham.inicializar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.msd.ham.job.reloj;

public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static void main(String... Paea05) throws ServletException {
		try {
			System.out.println(" << :::::::: Inicializando ::::::::>> ");

			reloj r = new reloj();
			r.relojProgramador();

		} catch (Exception e) {
			System.out.println("Error de Inicializacion :::>> " + e.getMessage());
		}
	}	
}