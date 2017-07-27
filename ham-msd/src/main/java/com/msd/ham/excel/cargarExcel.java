package com.msd.ham.excel;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.msd.ham.dao.cargarExcelBulkDAO;
import com.msd.ham.dao.impl.cargarExcelBulkDAOImpl;
import com.msd.ham.models.ventas;
import com.msd.ham.utils.moverDir;

public class cargarExcel {
	private XSSFWorkbook Libro;
	private static XSSFSheet Hoja;
	private FileInputStream Excel;
	private File Archivo;
	private XSSFRow xFilas;
	private String urlE;
	private String urlS;
	private String urlEr;
	private moverDir mD = new moverDir();
	private static final Date fechaHoy = new Date();
	private static final SimpleDateFormat formatomes = new SimpleDateFormat("MMMM yy");
	private static final String fNEPre = "ATV ";
	private static final String fNEMes = formatomes.format(fechaHoy);
	private static final String fNEPost = " Revisión.xlsx";
	private static final String fNEComp = fNEPre + fNEMes + fNEPost;

	private List<ventas> vt = new ArrayList<ventas>();

	private cargarExcelBulkDAO cXlsx = new cargarExcelBulkDAOImpl();

	public void cargarXlsxBulk(String E, String S, String Er) {
		try {
			Archivo = new File(E);
			Excel = new FileInputStream(Archivo);
			Libro = new XSSFWorkbook(Excel);
			Hoja = Libro.getSheet("Test_1");

			Integer Filas = Hoja.getLastRowNum();
			Integer f;

			int colUno = 0;
			int colDos = 1;
			int colTrs = 2;
			int colCutr = 3;
			int colCnco = 4;
			int colSeis = 5;
			int colSte = 6;
			int colOcho = 7;
			int colNve = 8;

			for (f = 1; f <= Filas; f++) {

				vt.add(new ventas((int) validaCeldaNum(xFilas, f, colUno), (int) validaCeldaNum(xFilas, f, colDos),
						(int) validaCeldaNum(xFilas, f, colTrs), (int) validaCeldaNum(xFilas, f, colCutr),
						(int) validaCeldaNum(xFilas, f, colCnco), validaCelda(xFilas, f, colSeis),
						(int) validaCeldaNum(xFilas, f, colSte), (int) validaCeldaNum(xFilas, f, colOcho),
						(int) validaCeldaNum(xFilas, f, colNve)));
			}

			cXlsx.insertBulkVtas(vt, urlE, urlS, urlEr);

		} catch (Exception e) {
			System.out.println("Error cargarXlsxBulk ::::>> " + e.getMessage());
			mD.moveFile(urlE, urlEr);
		}
	}

	public void validaExcel() {
		Properties pRutas = new Properties();
		try {
			pRutas.load(leerExcelDtosEcologicos.class.getClassLoader().getResourceAsStream("rutas.properties"));
			urlE = pRutas.getProperty("URL_ENTRADA") + fNEComp;
			urlS = pRutas.getProperty("URL_SALIDA") + fNEComp;
			urlEr = pRutas.getProperty("URL_ERROR") + fNEComp;
			File ValidarArchivo = new File(urlE);

			if (ValidarArchivo.exists()) {
				cargarXlsxBulk(urlE, urlS, urlEr);
			} else {
				System.out.println("No existe archivo para procesar en :::>> " + urlE.replace(fNEComp, ""));
			}

		} catch (Exception e) {
			System.out.println("Error al validar Existenacia de Excel :::>> " + e.getMessage());
		}
	}

	public static String validaCelda(XSSFRow xF, Integer nF, int nC) {
		String vCHosp = "";
		xF = Hoja.getRow(nF);
		try {
			if (xF != null) {
				vCHosp = xF.getCell(nC) == null ? ""
						: (xF.getCell(nC).getCellType() == Cell.CELL_TYPE_STRING) ? xF.getCell(nC).getStringCellValue()
								: (xF.getCell(nC).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + xF.getCell(nC).getNumericCellValue()
										: (xF.getCell(nC).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + xF.getCell(nC).getNumericCellValue()
												: (xF.getCell(nC).getCellType() == Cell.CELL_TYPE_ERROR)
														? xF.getCell(nC).getStringCellValue()
														: "";
			}
		} catch (Exception e) {
			System.out.println("Error validacion de celda : " + e.getMessage());
		}

		return vCHosp;
	}

	public static double validaCeldaNum(XSSFRow xF, Integer nF, int nC) {
		double vCelda = 0;
		xF = Hoja.getRow(nF);
		try {
			if (xF != null) {
				vCelda = xF.getCell(nC).getNumericCellValue();
			}
		} catch (Exception e) {
			System.out.println("Error validacion de celda porcentaje : " + e.getMessage());
		}
		return vCelda;
	}

}
