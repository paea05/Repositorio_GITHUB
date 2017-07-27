package com.paea05.initialize;

import com.paea05.job.reloj;

public class testInicializar {
	public static void main(String... Paea05)  {
		try {
			System.out.println(" << :::::::: Inicializando ::::::::>> ");

			reloj r = new reloj();
			r.relojProgramador();

		} catch (Exception e) {
			System.out.println("Error de Inicializacion :::>> " + e.getMessage());
		}
	}	
}
