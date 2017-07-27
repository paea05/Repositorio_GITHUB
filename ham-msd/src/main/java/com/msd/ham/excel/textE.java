package com.msd.ham.excel;

public class textE {

	public static void main(String... Paea05) {
		leerExcelDtosEcologicos lEE = new leerExcelDtosEcologicos();
//		cargarExcel cE = new cargarExcel();
		try {
			lEE.validaExcel();
//			cE.validaExcel();
		} catch (Exception e) {
			System.out.println("Error en Test Excel :::>> " + e.getMessage());
		}

	}

}
