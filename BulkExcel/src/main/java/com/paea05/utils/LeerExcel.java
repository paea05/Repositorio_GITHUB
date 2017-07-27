package com.paea05.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeerExcel {

	private Workbook Libro;
	private Sheet Hoja;
	private FileInputStream Excel;
	private String spool;
	private File Archivo;

	public void lExcel() {
		try {
			Properties propiedaRutas = new Properties();
			propiedaRutas.load(LeerExcel.class.getClassLoader().getResourceAsStream("rutas.properties"));
			String urlE = propiedaRutas.getProperty("URL_ENTRADA");

			Archivo = new File(urlE);
			Excel = new FileInputStream(Archivo);
			Libro = new XSSFWorkbook(Excel);
			Hoja = Libro.getSheet("Antibioticos iny");

//			Integer cFilas = Hoja.getLastRowNum();
			Iterator<Row> tFilas = Hoja.iterator();

			traducirE(Hoja, tFilas);

		} catch (Exception e) {
			System.out.println("Error de Lectura :::>> " + e.getMessage());
		}
	}

	public String traducirE(Sheet H, Iterator<Row> F) {
		spool = "";
		ObtenerL(H, F);
		return spool;
	}

	public String ObtenerL(Sheet H, Iterator<Row> F) {
		String nL = "";
		while (F.hasNext()) {
			Row cantFilas = F.next();
			Iterator<Cell> itCell = cantFilas.iterator();
			while (itCell.hasNext()) {
				Cell cantCeldas = itCell.next();
				if (cantCeldas.getCellType() == Cell.CELL_TYPE_STRING) {
                    System.out.print(cantCeldas.getStringCellValue() + " <> ");
                } else if (cantCeldas.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    System.out.print(cantCeldas.getNumericCellValue() + "<> ");
                }
				

			}
			System.out.println();
		}
		return nL;
	}

}
