package com.paea05.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.paea05.beans.dtEcologico;
import com.paea05.dao.dtEcologicoDAO;
import com.paea05.daoimpl.dtEcologicoDAOImpl;

public class leerExcelDtEcologico {
	private XSSFWorkbook Libro;
	private static XSSFSheet Hoja;
	private FileInputStream Excel;
	private File Archivo;
	private String urlE;
	private String urlS;
	private String urlEr;
	private static final String nAComp = "Platilla_DtEcologicos.xlsx";

	private dtEcologicoDAO dtosEco = new dtEcologicoDAOImpl();

	private dtEcologico dtE = new dtEcologico();

	public void lExceldtEco(String E, String S, String Er) {

		try {
			Archivo = new File(E);
			Excel = new FileInputStream(Archivo);
			Libro = new XSSFWorkbook(Excel);
			Hoja = Libro.getSheet("HOSPITAL ABC OBSERVATORIO");
			XSSFRow fHosp;
			String vCHosp;
			int cUno = 0;
			int cDos = 1;
			// int cTr = 2;
			// int cCu = 3;
			int cCin = 4;
			// int cS = 5;
			// int cSt = 6;
			int cOc = 7;
			int cNv = 8;
			// int cDz = 9;
			int cOnc = 10;
			int cDc = 11;

			Integer fUno = 2;
			fHosp = Hoja.getRow(fUno);
			if (fHosp != null) {
				vCHosp = fHosp.getCell(cUno) == null ? ""
						: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cUno).getStringCellValue()
								: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cUno).getNumericCellValue()
										: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cUno).getNumericCellValue()
												: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cUno).getStringCellValue()
														: "";
				dtE.setNomHospital(vCHosp.trim());

				vCHosp = fHosp.getCell(cDos) == null ? ""
						: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cDos).getStringCellValue()
								: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cDos).getNumericCellValue()
										: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cDos).getNumericCellValue()
												: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cDos).getStringCellValue()
														: "";
				dtE.setPotencialDtCoorp(vCHosp);

				vCHosp = fHosp.getCell(cNv) == null ? ""
						: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cNv).getStringCellValue()
								: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cNv).getNumericCellValue()
										: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cNv).getNumericCellValue()
												: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cNv).getStringCellValue()
														: "";
				dtE.setPerfilDtCoorp(vCHosp);
			}

			Integer fDos = 5;
			fHosp = Hoja.getRow(fDos);
			if (fHosp != null) {
				vCHosp = fHosp.getCell(cUno) == null ? ""
						: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cUno).getStringCellValue()
								: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cUno).getNumericCellValue()
										: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cUno).getNumericCellValue()
												: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cUno).getStringCellValue()
														: "";

				dtE.setPorcAccesoDtCoorp(vCHosp);

				vCHosp = fHosp.getCell(cDos) == null ? ""
						: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cDos).getStringCellValue()
								: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cDos).getNumericCellValue()
										: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cDos).getNumericCellValue()
												: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cDos).getStringCellValue()
														: "";
				dtE.setNoCamasEnfDtCoorp(vCHosp);

				vCHosp = fHosp.getCell(cCin) == null ? ""
						: (fHosp.getCell(cCin).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cCin).getStringCellValue()
								: (fHosp.getCell(cCin).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cCin).getNumericCellValue()
										: (fHosp.getCell(cCin).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cCin).getNumericCellValue()
												: (fHosp.getCell(cCin).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cCin).getStringCellValue()
														: "";
				dtE.setTasaOcNoCamasEnfDtCoorp(vCHosp);

				vCHosp = fHosp.getCell(cNv) == null ? ""
						: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cNv).getStringCellValue()
								: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cNv).getNumericCellValue()
										: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cNv).getNumericCellValue()
												: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cNv).getStringCellValue()
														: "";
				dtE.setNoCamasCIntDtCoorp(vCHosp);

				vCHosp = fHosp.getCell(cDc) == null ? ""
						: (fHosp.getCell(cDc).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cDc).getStringCellValue()
								: (fHosp.getCell(cDc).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cDc).getNumericCellValue()
										: (fHosp.getCell(cDc).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cDc).getNumericCellValue()
												: (fHosp.getCell(cDc).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cDc).getStringCellValue()
														: "";
				dtE.setTasaOcNoCamasCIntDtCoorp(vCHosp);
			}

			Integer fOc = 7;
			fHosp = Hoja.getRow(fOc);
			if (fHosp != null) {
				vCHosp = fHosp.getCell(cDos) == null ? ""
						: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cDos).getStringCellValue()
								: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cDos).getNumericCellValue()
										: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cDos).getNumericCellValue()
												: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cDos).getStringCellValue()
														: "";
				dtE.setConvADtCoorp(dtosEco.consConv(vCHosp.trim()));

				vCHosp = fHosp.getCell(cNv) == null ? ""
						: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cNv).getStringCellValue()
								: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cNv).getNumericCellValue()
										: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cNv).getNumericCellValue()
												: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cNv).getStringCellValue()
														: "";
				dtE.setPorcConvADtCoorp(vCHosp);
			}

			Integer fNv = 8;
			fHosp = Hoja.getRow(fNv);
			if (fHosp != null) {
				vCHosp = fHosp.getCell(cDos) == null ? ""
						: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cDos).getStringCellValue()
								: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cDos).getNumericCellValue()
										: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cDos).getNumericCellValue()
												: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cDos).getStringCellValue()
														: "";
				dtE.setConvBDtCoorp(dtosEco.consConv(vCHosp.trim()));

				vCHosp = fHosp.getCell(cNv) == null ? ""
						: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cNv).getStringCellValue()
								: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cNv).getNumericCellValue()
										: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cNv).getNumericCellValue()
												: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cNv).getStringCellValue()
														: "";
				dtE.setPorcConvBDtCoorp(vCHosp);
			}

			Integer fDz = 9;
			fHosp = Hoja.getRow(fDz);
			if (fHosp != null) {
				vCHosp = fHosp.getCell(cDos) == null ? ""
						: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cDos).getStringCellValue()
								: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cDos).getNumericCellValue()
										: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cDos).getNumericCellValue()
												: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cDos).getStringCellValue()
														: "";
				dtE.setConvCDtCoorp(dtosEco.consConv(vCHosp.trim()));

				vCHosp = fHosp.getCell(cNv) == null ? ""
						: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cNv).getStringCellValue()
								: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cNv).getNumericCellValue()
										: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cNv).getNumericCellValue()
												: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cNv).getStringCellValue()
														: "";
				dtE.setPorcConvCDtCoorp(vCHosp);
			}

			Integer fOn = 10;
			fHosp = Hoja.getRow(fOn);
			if (fHosp != null) {
				vCHosp = fHosp.getCell(cDos) == null ? ""
						: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cDos).getStringCellValue()
								: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cDos).getNumericCellValue()
										: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cDos).getNumericCellValue()
												: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cDos).getStringCellValue()
														: "";
				dtE.setConvDDtCoorp(dtosEco.consConv(vCHosp.trim()));

				vCHosp = fHosp.getCell(cNv) == null ? ""
						: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cNv).getStringCellValue()
								: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cNv).getNumericCellValue()
										: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cNv).getNumericCellValue()
												: (fHosp.getCell(cNv).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cNv).getStringCellValue()
														: "";
				dtE.setPorcConvDDtCoorp(vCHosp);
			}

			Integer fCtc = 13;
			fHosp = Hoja.getRow(fCtc);
			if (fHosp != null) {
				vCHosp = fHosp.getCell(cUno) == null ? ""
						: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cUno).getStringCellValue()
								: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cUno).getNumericCellValue()
										: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cUno).getNumericCellValue()
												: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cUno).getStringCellValue()
														: "";
				dtE.setLabPropioDtCoorp(vCHosp);

				vCHosp = fHosp.getCell(cDos) == null ? ""
						: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cDos).getStringCellValue()
								: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cDos).getNumericCellValue()
										: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cDos).getNumericCellValue()
												: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cDos).getStringCellValue()
														: "";
				dtE.setIdEquipADtCoorp(dtosEco.consEquip(vCHosp.trim()));

				vCHosp = fHosp.getCell(cCin) == null ? ""
						: (fHosp.getCell(cCin).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cCin).getStringCellValue()
								: (fHosp.getCell(cCin).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cCin).getNumericCellValue()
										: (fHosp.getCell(cCin).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cCin).getNumericCellValue()
												: (fHosp.getCell(cCin).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cCin).getStringCellValue()
														: "";
				dtE.setIdEquipBDtCoorp(dtosEco.consEquip(vCHosp.trim()));

				vCHosp = fHosp.getCell(cOc) == null ? ""
						: (fHosp.getCell(cOc).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cOc).getStringCellValue()
								: (fHosp.getCell(cOc).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cOc).getNumericCellValue()
										: (fHosp.getCell(cOc).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cOc).getNumericCellValue()
												: (fHosp.getCell(cOc).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cOc).getStringCellValue()
														: "";
				dtE.setIdEquipCDtCoorp(dtosEco.consEquip(vCHosp.trim()));

				vCHosp = fHosp.getCell(cOnc) == null ? ""
						: (fHosp.getCell(cOnc).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cOnc).getStringCellValue()
								: (fHosp.getCell(cOnc).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cOnc).getNumericCellValue()
										: (fHosp.getCell(cOnc).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cOnc).getNumericCellValue()
												: (fHosp.getCell(cOnc).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cOnc).getStringCellValue()
														: "";
				dtE.setTmpRetAntBDtCoorp(vCHosp);
			}

			Integer fDzSt = 16;
			fHosp = Hoja.getRow(fDzSt);
			if (fHosp != null) {
				vCHosp = fHosp.getCell(cUno) == null ? ""
						: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cUno).getStringCellValue()
								: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cUno).getNumericCellValue()
										: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cUno).getNumericCellValue()
												: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cUno).getStringCellValue()
														: "";
				dtE.setNomJfeAreaDtCoorp(vCHosp);

				vCHosp = fHosp.getCell(cDos) == null ? ""
						: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cDos).getStringCellValue()
								: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cDos).getNumericCellValue()
										: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cDos).getNumericCellValue()
												: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cDos).getStringCellValue()
														: "";
				dtE.setAreaDtCoorp(vCHosp);
				dtE.setIdAreaDtCoorp(dtosEco.consEspec(dtE.getAreaDtCoorp().trim()));

				vCHosp = fHosp.getCell(cOc) == null ? ""
						: (fHosp.getCell(cOc).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cOc).getStringCellValue()
								: (fHosp.getCell(cOc).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cOc).getNumericCellValue()
										: (fHosp.getCell(cOc).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cOc).getNumericCellValue()
												: (fHosp.getCell(cOc).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cOc).getStringCellValue()
														: "";
				dtE.setCrmDtCoorp(vCHosp);
			}

			Integer fDzNv = 18;
			fHosp = Hoja.getRow(fDzNv);
			if (fHosp != null) {
				vCHosp = fHosp.getCell(cDos) == null ? ""
						: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cDos).getStringCellValue()
								: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cDos).getNumericCellValue()
										: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cDos).getNumericCellValue()
												: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cDos).getStringCellValue()
														: "";
				dtE.setComEstNomCRMDtCoorp(vCHosp);
			}

			Integer fVtUno = 20;
			fHosp = Hoja.getRow(fVtUno);
			if (fHosp != null) {
				vCHosp = fHosp.getCell(cDos) == null ? ""
						: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cDos).getStringCellValue()
								: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cDos).getNumericCellValue()
										: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cDos).getNumericCellValue()
												: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cDos).getStringCellValue()
														: "";
				dtE.setDesEscalonarDtCoorp(vCHosp);
			}

			Integer fVtTr = 22;
			fHosp = Hoja.getRow(fVtTr);
			if (fHosp != null) {
				vCHosp = fHosp.getCell(cDos) == null ? ""
						: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cDos).getStringCellValue()
								: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cDos).getNumericCellValue()
										: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cDos).getNumericCellValue()
												: (fHosp.getCell(cDos).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cDos).getStringCellValue()
														: "";
				dtE.setProgAMSDtCoorp(vCHosp);
			}

			Integer fVtNv = 28;
			fHosp = Hoja.getRow(fVtNv);
			if (fHosp != null) {
				vCHosp = fHosp.getCell(cUno) == null ? ""
						: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cUno).getStringCellValue()
								: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cUno).getNumericCellValue()
										: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cUno).getNumericCellValue()
												: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cUno).getStringCellValue()
														: "";
				String[] tProt = vCHosp.split(" ");
				if (tProt[5] != null && tProt[5].equals("IIA")) {
					String cProVtNv = tProt[5].concat("C");
					dtE.setTipProtDtCuant_U(cProVtNv.toUpperCase());
				} else {
					dtE.setTipProtDtCuant_U(tProt[5].toUpperCase());
				}
			}

			Integer fTt = 29;
			fHosp = Hoja.getRow(fTt);
			if (fHosp != null) {
				vCHosp = fHosp.getCell(cUno) == null ? ""
						: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_STRING)
								? fHosp.getCell(cUno).getStringCellValue()
								: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_NUMERIC)
										? "" + fHosp.getCell(cUno).getNumericCellValue()
										: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_FORMULA)
												? "" + fHosp.getCell(cUno).getNumericCellValue()
												: (fHosp.getCell(cUno).getCellType() == Cell.CELL_TYPE_ERROR)
														? fHosp.getCell(cUno).getStringCellValue()
														: "";
//			vCHosp = validaCelda(29, 0, fHosp);
				String[] tProt = vCHosp.split(" ");
				if (tProt[5] != null && tProt[5].equals("IIA")) {
					String cProVtNv = tProt[5].concat("C");
					dtE.setTipProtDtCuant_D(cProVtNv.toUpperCase());
				} else {
					dtE.setTipProtDtCuant_D(tProt[5].toUpperCase());
				}
			}

			dtE.setIdHospDtCoorp(dtosEco.consHosp(dtE.getNomHospital().trim()));
			// System.out.println("Valor celda A3 : " + dtE.getNomHospital());
//			System.out.println("Valor celda A3 : " + dtE.getIdHospDtCoorp());
//			System.out.println("Valor celda B3 : " + dtE.getPotencialDtCoorp());
//			System.out.println("Valor celda I3 : " + dtE.getPerfilDtCoorp());
//			System.out.println("Valor celda A6 : " + dtE.getPorcAccesoDtCoorp());
//			System.out.println("Valor celda B6 : " + dtE.getNoCamasEnfDtCoorp());
//			System.out.println("Valor celda E6 : " + dtE.getTasaOcNoCamasEnfDtCoorp());
//			System.out.println("Valor celda I6 : " + dtE.getNoCamasCIntDtCoorp());
//			System.out.println("Valor celda L6 : " + dtE.getTasaOcNoCamasCIntDtCoorp());
//			System.out.println("Valor celda B8 : " + dtE.getConvADtCoorp());
//			System.out.println("Valor celda I8 : " + dtE.getPorcConvADtCoorp());
//			System.out.println("Valor celda B9 : " + dtE.getConvBDtCoorp());
//			System.out.println("Valor celda I9 : " + dtE.getPorcConvBDtCoorp());
//			System.out.println("Valor celda B10 : " + dtE.getConvCDtCoorp());
//			System.out.println("Valor celda I10 : " + dtE.getPorcConvCDtCoorp());
//			System.out.println("Valor celda B11 : " + dtE.getConvDDtCoorp());
//			System.out.println("Valor celda I11 : " + dtE.getPorcConvDDtCoorp());
//			System.out.println("Valor celda A14 : " + dtE.getLabPropioDtCoorp());
//			System.out.println("Valor celda B14 : " + dtE.getIdEquipADtCoorp());
//			System.out.println("Valor celda E14 : " + dtE.getIdEquipBDtCoorp());
//			System.out.println("Valor celda H14 : " + dtE.getIdEquipCDtCoorp());
//			System.out.println("Valor celda K14 : " + dtE.getTmpRetAntBDtCoorp());
//			System.out.println("Valor celda A17 : " + dtE.getNomJfeAreaDtCoorp());
//			System.out.println("Valor celda B17 : " + dtE.getAreaDtCoorp());
//			System.out.println("Valor ID B17 : " + dtE.getIdAreaDtCoorp());
//			System.out.println("Valor celda H17 : " + dtE.getCrmDtCoorp());
//			System.out.println("Valor celda B19 : " + dtE.getComEstNomCRMDtCoorp());
//			System.out.println("Valor celda B21 : " + dtE.getDesEscalonarDtCoorp());
//			System.out.println("Valor celda B23 : " + dtE.getProgAMSDtCoorp());
			System.out.println("Valor celda A29 : " + dtE.getTipProtDtCuant_U());
			System.out.println("Valor celda A30 : " + dtE.getTipProtDtCuant_D());

			 dtosEco.insertDtCoorp(dtE);

		} catch (Exception e) {
			System.out.println("Error metodo lExceldtEco :::>> " + e.getMessage());
		}

	}

	public void validaExcel() {
		Properties pRutas = new Properties();
		try {
			pRutas.load(leerExcelDtEcologico.class.getClassLoader().getResourceAsStream("rutas.properties"));
			urlE = pRutas.getProperty("URL_ENTRADA") + nAComp;
			urlS = pRutas.getProperty("URL_SALIDA") + nAComp;
			urlEr = pRutas.getProperty("URL_ERROR") + nAComp;
			File ValidarArchivo = new File(urlE);

			if (ValidarArchivo.exists()) {
				lExceldtEco(urlE, urlS, urlEr);
			} else {
				System.out.println("No existe archivo para procesar en : " + urlE);
			}

		} catch (Exception e) {
			System.out.println("Error al validar Existenacia de Excel :::>> " + e.getMessage());
		}
	}
	
	public static String validaCelda(Integer nF, int nC, XSSFRow xF) {
		String vCHosp = "";
		xF = Hoja.getRow(nF);
		if (xF != null) {
			vCHosp = xF.getCell(nC) == null ? ""
					: (xF.getCell(nC).getCellType() == Cell.CELL_TYPE_STRING)
							? xF.getCell(nC).getStringCellValue()
							: (xF.getCell(nC).getCellType() == Cell.CELL_TYPE_NUMERIC)
									? "" + xF.getCell(nC).getNumericCellValue()
									: (xF.getCell(nC).getCellType() == Cell.CELL_TYPE_FORMULA)
											? "" + xF.getCell(nC).getNumericCellValue()
											: (xF.getCell(nC).getCellType() == Cell.CELL_TYPE_ERROR)
													? xF.getCell(nC).getStringCellValue()
													: "";
		}
		return vCHosp;
	}
		
}
