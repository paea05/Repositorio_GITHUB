package com.paea05.utils;

import java.io.File;
import java.io.FileInputStream;
//import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import com.paea05.beans.ventas;

public class nvoLExcel {
	private XSSFWorkbook Libro;
	private XSSFSheet Hoja;
	private FileInputStream Excel;
	private File Archivo;
	private XSSFRow xFilas;
	private String vCeldas;
	private String vCeldas_D;
//	private List<ventas> vta;

	public void nvocargarExcel() {
		try {
			Properties prpRuta = new Properties();
			prpRuta.load(xlsxOracle.class.getClassLoader().getResourceAsStream("rutas.properties"));
			String urlE = prpRuta.getProperty("URL_ENTRADA_T");

			Archivo = new File(urlE);
			Excel = new FileInputStream(Archivo);
			Libro = new XSSFWorkbook(Excel);
			Hoja = Libro.getSheet("Test_1");

			// Integer Filas = Hoja.getLastRowNum();
			Integer Filas = 20;

			for (int f = 1; f < Filas; f++) {
				xFilas = Hoja.getRow(f);
				// System.out.println("Filas : " + f);
				if (xFilas != null) {
					vCeldas = xFilas.getCell(0) == null ? ""
							: (xFilas.getCell(0).getCellType() == Cell.CELL_TYPE_STRING)
									? xFilas.getCell(0).getStringCellValue()
									: (xFilas.getCell(0).getCellType() == Cell.CELL_TYPE_NUMERIC)
											? "" + xFilas.getCell(0).getNumericCellValue()
											: (xFilas.getCell(0).getCellType() == Cell.CELL_TYPE_BOOLEAN)
													? "" + xFilas.getCell(0).getBooleanCellValue()
													: (xFilas.getCell(0).getCellType() == Cell.CELL_TYPE_BLANK)
															? "BLANK"
															: (xFilas.getCell(0)
																	.getCellType() == Cell.CELL_TYPE_FORMULA)
																			? "FORMULA"
																			: (xFilas.getCell(0)
																					.getCellType() == Cell.CELL_TYPE_ERROR)
																							? "ERROR"
																							: "";
					System.out.print("C1: " + vCeldas + " <> ");

					vCeldas_D = xFilas.getCell(7) == null ? ""
							: (xFilas.getCell(7).getCellType() == Cell.CELL_TYPE_STRING)
									? xFilas.getCell(7).getStringCellValue()
									: (xFilas.getCell(7).getCellType() == Cell.CELL_TYPE_NUMERIC)
											? "" + xFilas.getCell(7).getNumericCellValue()
											: (xFilas.getCell(7).getCellType() == Cell.CELL_TYPE_BOOLEAN)
													? "" + xFilas.getCell(7).getBooleanCellValue()
													: (xFilas.getCell(7).getCellType() == Cell.CELL_TYPE_BLANK)
															? "BLANK"
															: (xFilas.getCell(7)
																	.getCellType() == Cell.CELL_TYPE_FORMULA) ? ""
																			+ xFilas.getCell(7).getNumericCellValue()
																			: (xFilas.getCell(7)
																					.getCellType() == Cell.CELL_TYPE_ERROR)
																							? "ERROR"
																							: "";
					System.out.print(" C8: " + vCeldas_D);
					System.out.println();
					// vta.setBrickVentas(Integer.parseInt(vCeldas_D));
				}
			}
			System.out.println("Datos :::>> " + vCeldas + " <> " + vCeldas_D);

		} catch (Exception e) {
			System.out.println("Error nvocargarExcel :::>> " + e.getMessage());
		}
	}
}
