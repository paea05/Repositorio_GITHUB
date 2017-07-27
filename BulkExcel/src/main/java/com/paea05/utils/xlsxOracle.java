package com.paea05.utils;

import java.io.File;
import java.io.FileInputStream;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.paea05.conexion.Conexion;

public class xlsxOracle {

	private static final Conexion conectar = new Conexion();
	private Connection conn = null;
	private PreparedStatement st = null;
	private static int[] res;
	private XSSFWorkbook Libro;
	private XSSFSheet Hoja;
	private FileInputStream Excel;
	private File Archivo;
	private XSSFRow xFilas;
	private String vCeldas;
	private String vCeldas_D;
	private String vCeldas_T;
	private String vCeldas_C;
	private String vCeldas_CC;
	private String vCeldas_S;
	private String vCeldas_ST;
	private String vCeldas_O;
	private String vCeldas_N;
	private String urlE;
	private String urlS;
	private String urlEr;
	private moveDir mD = new moveDir();
	private static final Date fechaHoy = new Date();
	private static final SimpleDateFormat formatomes = new SimpleDateFormat("MMMM yy");
	private static final String fNEPre = "ATV ";
	private static final String fNEMes = formatomes.format(fechaHoy);
	private static final String fNEPost = " Revisión.xlsx";
	private static final String fNEComp = fNEPre + fNEMes + fNEPost;

	private static final String query = "INSERT INTO HAM_ATVVENTAS_T  "
			+ " (ID_VENTA,BRICK_VENTA,ID_PRODUCTO,ANIO_VENTA,MES_VENTA,RUTA_VENTA,FACTOR_VENTA,UNIDADES_VENTA,VALORES_VENTA)  "
			+ " VALUES (?,?,?,?,?,?,?,?,?) ";

	private static final String querySQL = "INSERT INTO HAM_ATVVENTAS_T  "
			+ " (ID_VENTA,BRICK_VENTA,ID_PRODUCTO,ANIO_VENTA,MES_VENTA,RUTA_VENTA,FACTOR_VENTA,UNIDADES_VENTA,VALORES_VENTA)  "
			+ " VALUES (?,?,?,?,?,?,?,?,?) ";

	public void cargarXlsxOracle() {
		try {

			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "AVACO", "LAmxcred1t");
			PreparedStatement stm = null;

			stm = con.prepareStatement(query);

			Properties propRuta = new Properties();
			propRuta.load(xlsxOracle.class.getClassLoader().getResourceAsStream("rutas.properties"));
			String urlE = propRuta.getProperty("URL_ENTRADA_T");

			Archivo = new File(urlE);
			Excel = new FileInputStream(Archivo);
			Libro = new XSSFWorkbook(Excel);
			Hoja = Libro.getSheet("Test");

			Iterator<Row> fItera = Hoja.iterator();
			while (fItera.hasNext()) {
				Row Fila = fItera.next();
				Iterator<Cell> cItera = Fila.cellIterator();
				while (cItera.hasNext()) {
					Cell cell = cItera.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						stm.setDouble(1, cell.getNumericCellValue());
						stm.setDouble(2, cell.getNumericCellValue());
						stm.setDouble(3, cell.getNumericCellValue());
						stm.setDouble(4, cell.getNumericCellValue());
						stm.setDouble(5, cell.getNumericCellValue());
						stm.setDouble(7, cell.getNumericCellValue());
						stm.setDouble(8, cell.getNumericCellValue());
						stm.setDouble(9, cell.getNumericCellValue());
						break;
					case Cell.CELL_TYPE_STRING:
						stm.setString(6, cell.getStringCellValue());
						break;
					}

				}
				stm.addBatch();
			}

			int[] totalReg = new int[9];

			try {
				totalReg = stm.executeBatch();
			} catch (BatchUpdateException e) {
				System.out.println("Error Bulkado ::::>> " + e.getMessage());
				totalReg = e.getUpdateCounts();
			}
			System.out.println("Total de Registros insertados : " + totalReg.length);

			Excel.close();

			stm.close();

			con.close();

		} catch (Exception e) {
			System.out.println("Error Lectura Insercion :::>> " + e);
		}

	}

	public int[] bulkXlsxOracle(String E, String S, String Er) {
		res = new int[2];
		try {
			conectar.conectar();
			conn = conectar.getConnection();
			st = conn.prepareStatement(querySQL);

			Archivo = new File(E);
			Excel = new FileInputStream(Archivo);
			Libro = new XSSFWorkbook(Excel);
			Hoja = Libro.getSheet("Test_1");

			Integer Filas = Hoja.getLastRowNum();

			for (int f = 1; f < Filas + 1; f++) {
				xFilas = Hoja.getRow(f);
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
					st.setString(1, vCeldas);

					vCeldas_D = xFilas.getCell(1) == null ? ""
							: (xFilas.getCell(1).getCellType() == Cell.CELL_TYPE_STRING)
									? xFilas.getCell(1).getStringCellValue()
									: (xFilas.getCell(1).getCellType() == Cell.CELL_TYPE_NUMERIC)
											? "" + xFilas.getCell(1).getNumericCellValue()
											: (xFilas.getCell(1).getCellType() == Cell.CELL_TYPE_BOOLEAN)
													? "" + xFilas.getCell(1).getBooleanCellValue()
													: (xFilas.getCell(1).getCellType() == Cell.CELL_TYPE_BLANK)
															? "BLANK"
															: (xFilas.getCell(1)
																	.getCellType() == Cell.CELL_TYPE_FORMULA)
																			? "FORMULA"
																			: (xFilas.getCell(1)
																					.getCellType() == Cell.CELL_TYPE_ERROR)
																							? "ERROR"
																							: "";
					st.setString(2, vCeldas_D);

					vCeldas_T = xFilas.getCell(2) == null ? ""
							: (xFilas.getCell(2).getCellType() == Cell.CELL_TYPE_STRING)
									? xFilas.getCell(2).getStringCellValue()
									: (xFilas.getCell(2).getCellType() == Cell.CELL_TYPE_NUMERIC)
											? "" + xFilas.getCell(2).getNumericCellValue()
											: (xFilas.getCell(2).getCellType() == Cell.CELL_TYPE_BOOLEAN)
													? "" + xFilas.getCell(2).getBooleanCellValue()
													: (xFilas.getCell(2).getCellType() == Cell.CELL_TYPE_BLANK)
															? "BLANK"
															: (xFilas.getCell(2)
																	.getCellType() == Cell.CELL_TYPE_FORMULA)
																			? "FORMULA"
																			: (xFilas.getCell(2)
																					.getCellType() == Cell.CELL_TYPE_ERROR)
																							? "ERROR"
																							: "";
					st.setString(3, vCeldas_T);

					vCeldas_C = xFilas.getCell(3) == null ? ""
							: (xFilas.getCell(3).getCellType() == Cell.CELL_TYPE_STRING)
									? xFilas.getCell(3).getStringCellValue()
									: (xFilas.getCell(3).getCellType() == Cell.CELL_TYPE_NUMERIC)
											? "" + xFilas.getCell(3).getNumericCellValue()
											: (xFilas.getCell(3).getCellType() == Cell.CELL_TYPE_BOOLEAN)
													? "" + xFilas.getCell(3).getBooleanCellValue()
													: (xFilas.getCell(3).getCellType() == Cell.CELL_TYPE_BLANK)
															? "BLANK"
															: (xFilas.getCell(3)
																	.getCellType() == Cell.CELL_TYPE_FORMULA)
																			? "FORMULA"
																			: (xFilas.getCell(3)
																					.getCellType() == Cell.CELL_TYPE_ERROR)
																							? "ERROR"
																							: "";
					st.setString(4, vCeldas_C);

					vCeldas_CC = xFilas.getCell(4) == null ? ""
							: (xFilas.getCell(4).getCellType() == Cell.CELL_TYPE_STRING)
									? xFilas.getCell(4).getStringCellValue()
									: (xFilas.getCell(4).getCellType() == Cell.CELL_TYPE_NUMERIC)
											? "" + xFilas.getCell(4).getNumericCellValue()
											: (xFilas.getCell(4).getCellType() == Cell.CELL_TYPE_BOOLEAN)
													? "" + xFilas.getCell(4).getBooleanCellValue()
													: (xFilas.getCell(4).getCellType() == Cell.CELL_TYPE_BLANK)
															? "BLANK"
															: (xFilas.getCell(4)
																	.getCellType() == Cell.CELL_TYPE_FORMULA)
																			? "FORMULA"
																			: (xFilas.getCell(4)
																					.getCellType() == Cell.CELL_TYPE_ERROR)
																							? "ERROR"
																							: "";
					st.setString(5, vCeldas_CC);

					vCeldas_S = xFilas.getCell(5) == null ? ""
							: (xFilas.getCell(5).getCellType() == Cell.CELL_TYPE_STRING)
									? xFilas.getCell(5).getStringCellValue()
									: (xFilas.getCell(5).getCellType() == Cell.CELL_TYPE_NUMERIC)
											? "" + xFilas.getCell(5).getNumericCellValue()
											: (xFilas.getCell(5).getCellType() == Cell.CELL_TYPE_BOOLEAN)
													? "" + xFilas.getCell(5).getBooleanCellValue()
													: (xFilas.getCell(5).getCellType() == Cell.CELL_TYPE_BLANK)
															? "BLANK"
															: (xFilas.getCell(5)
																	.getCellType() == Cell.CELL_TYPE_FORMULA)
																			? "FORMULA"
																			: (xFilas.getCell(5)
																					.getCellType() == Cell.CELL_TYPE_ERROR)
																							? "ERROR"
																							: "";
					st.setString(6, vCeldas_S);

					vCeldas_ST = xFilas.getCell(6) == null ? ""
							: (xFilas.getCell(6).getCellType() == Cell.CELL_TYPE_STRING)
									? xFilas.getCell(6).getStringCellValue()
									: (xFilas.getCell(6).getCellType() == Cell.CELL_TYPE_NUMERIC)
											? "" + xFilas.getCell(6).getNumericCellValue()
											: (xFilas.getCell(6).getCellType() == Cell.CELL_TYPE_BOOLEAN)
													? "" + xFilas.getCell(6).getBooleanCellValue()
													: (xFilas.getCell(6).getCellType() == Cell.CELL_TYPE_BLANK)
															? "BLANK"
															: (xFilas.getCell(6)
																	.getCellType() == Cell.CELL_TYPE_FORMULA)
																			? "FORMULA"
																			: (xFilas.getCell(6)
																					.getCellType() == Cell.CELL_TYPE_ERROR)
																							? "ERROR"
																							: "";
					st.setString(7, vCeldas_ST);

					vCeldas_O = xFilas.getCell(7) == null ? ""
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
					st.setString(8, vCeldas_O);

					vCeldas_N = xFilas.getCell(8) == null ? ""
							: (xFilas.getCell(8).getCellType() == Cell.CELL_TYPE_STRING)
									? xFilas.getCell(8).getStringCellValue()
									: (xFilas.getCell(8).getCellType() == Cell.CELL_TYPE_NUMERIC)
											? "" + xFilas.getCell(8).getNumericCellValue()
											: (xFilas.getCell(8).getCellType() == Cell.CELL_TYPE_BOOLEAN)
													? "" + xFilas.getCell(8).getBooleanCellValue()
													: (xFilas.getCell(8).getCellType() == Cell.CELL_TYPE_BLANK)
															? "BLANK"
															: (xFilas.getCell(8)
																	.getCellType() == Cell.CELL_TYPE_FORMULA) ? ""
																			+ xFilas.getCell(7).getNumericCellValue()
																			: (xFilas.getCell(8)
																					.getCellType() == Cell.CELL_TYPE_ERROR)
																							? "ERROR"
																							: "";
					st.setString(9, vCeldas_N);

				}
				st.addBatch();
			}

			try {
				res = st.executeBatch();
				mD.moverArchivo(E, S);
			} catch (BatchUpdateException e) {
				System.out.println("Error Bulkado ::::>> " + e.getMessage());
				res = e.getUpdateCounts();
				mD.moverArchivo(E, Er);
			} finally {
				Conexion.cerrar(conn, st);
			}

			System.out.println("Total de Registros insertados : " + res.length);

		} catch (Exception e) {
			System.out.println("Error bulkXlsxOracle :::>> " + e.getMessage());
			mD.moverArchivo(E, Er);
		}
		return res;
	}

	public void validaCargaExcel() {
		Properties prpRuta = new Properties();
		try {
			prpRuta.load(xlsxOracle.class.getClassLoader().getResourceAsStream("rutas.properties"));
			urlE = prpRuta.getProperty("URL_ENTRADA") + fNEComp;
			urlS = prpRuta.getProperty("URL_SALIDA") + fNEComp;
			urlEr = prpRuta.getProperty("URL_ERROR") + fNEComp;
			File ArchivoV = new File(urlE);

			if (ArchivoV.exists()) {
				bulkXlsxOracle(urlE, urlS, urlEr);
			} else {
				char carpDir = urlE.charAt('/');
				System.out.println(carpDir);
				System.out.println("No existe archivo para procesar en : " + urlE);
			}
		} catch (Exception e) {
			System.out.println("Error al validar carga de Excel :::>> " + e.getMessage());
		}
	}

}
