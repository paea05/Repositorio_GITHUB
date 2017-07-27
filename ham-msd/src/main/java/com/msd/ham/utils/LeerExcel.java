package com.msd.ham.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeerExcel {
	private static final Logger log = Logger.getLogger(LeerExcel.class);

	private XSSFWorkbook Libro;
	private XSSFSheet Hoja;
	private FileInputStream Excel;
	private String oEx;
	private File Archivo;
	private XSSFRow xFilas;
	private String vCeldas;

	public void LeerEx() {
		try {
			Properties propRuta = new Properties();
			propRuta.load(LeerExcel.class.getClassLoader().getResourceAsStream("rutas.properties"));
			String urlE = propRuta.getProperty("URL_ENTRADA");

			Archivo = new File(urlE);
			Excel = new FileInputStream(Archivo);
			Libro = new XSSFWorkbook(Excel);
			Hoja = Libro.getSheet("Antibioticos iny");

//			Integer Filas = Hoja.getLastRowNum();
			Integer Filas = 15;
			int Col = 0;
			tradExcel(Hoja, Filas, Col);

		} catch (Exception e) {
			log.fatal("Error de Lectura de Excel " + e.getMessage());
			System.out.println();
		}
	}

	public String tradExcel(XSSFSheet H, Integer F, int C) {
		oEx = "";
		ObtenerColU(H, F, C);
		return oEx;
	}

	public String ObtenerColU(XSSFSheet H, Integer F, int C) {
		String oCU = "";
		try {
			for (int f = 2; f < F; f++) {
				xFilas = H.getRow(f);
				if (xFilas != null) {
					System.out.print("Fila " + f + " :::> ");
					vCeldas = xFilas.getCell(C) == null ? ""
							: (xFilas.getCell(C).getCellType() == Cell.CELL_TYPE_STRING)
									? xFilas.getCell(C).getStringCellValue()
									: (xFilas.getCell(C).getCellType() == Cell.CELL_TYPE_NUMERIC)
											? "" + xFilas.getCell(C).getNumericCellValue()
											: (xFilas.getCell(C).getCellType() == Cell.CELL_TYPE_BOOLEAN)
													? "" + xFilas.getCell(C).getBooleanCellValue()
													: (xFilas.getCell(C).getCellType() == Cell.CELL_TYPE_BLANK) ? "BLANK"
															: (xFilas.getCell(C).getCellType() == Cell.CELL_TYPE_FORMULA)
																	? "FORMULA"
																	: (xFilas.getCell(C)
																			.getCellType() == Cell.CELL_TYPE_ERROR)
																					? "ERROR"
																					: "";
					System.out.print(" ["  + ": " + vCeldas + "] ");
					System.out.println();
				} else {
					break;
				}
			}
		} catch (Exception e) {
			log.error("Error ObtenerColU ::>> " + e.getMessage());
			System.out.println("Error ObtenerColU ::>> " + e.getMessage());
		}		
		return oCU;
	}

}
