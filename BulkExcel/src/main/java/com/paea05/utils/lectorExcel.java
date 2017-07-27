package com.paea05.utils;

import java.io.File;
import java.io.FileInputStream;
//import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class lectorExcel {

	private XSSFWorkbook Libro;
	private XSSFSheet Hoja;
	private FileInputStream Excel;
	private String spool;
	private File Archivo;
	private XSSFRow xFilas;
	// private XSSFCell xCeldas;
	private String vCeldas;

	public void leerEx() {
		try {
			Properties propiedaRutas = new Properties();
			propiedaRutas.load(LeerExcel.class.getClassLoader().getResourceAsStream("rutas.properties"));
			String urlE = propiedaRutas.getProperty("URL_ENTRADA_T");

			Archivo = new File(urlE);
			Excel = new FileInputStream(Archivo);
			Libro = new XSSFWorkbook(Excel);
			Hoja = Libro.getSheet("Test");

			Integer Filas = Hoja.getLastRowNum();
			int Col = 0;

			traducirE(Hoja, Filas, Col);

		} catch (Exception e) {
			System.out.println("Error de Lectura :::>> " + e.getMessage());
		}
	}

	public String traducirE(XSSFSheet H, Integer F, int C) {
		spool = "";
		ObtenerL(H, F, C);
		return spool;
	}

	public String ObtenerL(XSSFSheet H, Integer F, int C) {
		String nL = "";
		for (int i = 0; i < F; i++) {
			xFilas = H.getRow(i);
			if (xFilas == null) {
				break;
			} else {
				System.out.print("Fila: " + i + " -> ");
				for (int c = 0; c < (C = xFilas.getLastCellNum()); c++) {
					vCeldas = xFilas.getCell(c) == null ? ""
							: (xFilas.getCell(c).getCellType() == Cell.CELL_TYPE_STRING)
									? xFilas.getCell(c).getStringCellValue()
									: (xFilas.getCell(c).getCellType() == Cell.CELL_TYPE_NUMERIC)
											? "" + xFilas.getCell(c).getNumericCellValue()
											: (xFilas.getCell(c).getCellType() == Cell.CELL_TYPE_BOOLEAN)
													? "" + xFilas.getCell(c).getBooleanCellValue()
													: (xFilas.getCell(c).getCellType() == Cell.CELL_TYPE_BLANK)
															? "BLANK"
															: (xFilas.getCell(c)
																	.getCellType() == Cell.CELL_TYPE_FORMULA)
																			? "FORMULA"
																			: (xFilas.getCell(c)
																					.getCellType() == Cell.CELL_TYPE_ERROR)
																							? "ERROR"
																							: "";
					System.out.print("[Columna " + c + ": " + vCeldas + "] ");
				}
				System.out.println();
			}
		}
		return nL;
	}

}
