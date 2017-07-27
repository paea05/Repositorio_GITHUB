package com.paea05.excel;

public class testExcel {

	public static void main(String... Paea05) {
		lEDtosEcologicos lEE = new lEDtosEcologicos();

		try {
			lEE.validaExcel();
		} catch (Exception e) {
			System.out.println("Error en Test Excel :::>> " + e.getMessage());
		}
	}
}
