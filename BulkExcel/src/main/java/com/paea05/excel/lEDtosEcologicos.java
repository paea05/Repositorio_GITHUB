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

public class lEDtosEcologicos {
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
			XSSFRow fHosp = null;

			Integer fTr = 2;
			Integer fSs = 5;
			Integer fOc = 7;
			Integer fNv = 8;
			Integer fDz = 9;
			Integer fOn = 10;
			Integer fCtc = 13;
			Integer fDzSt = 16;
			Integer fDzNv = 18;
			Integer fVtUno = 20;
			Integer fVtTr = 22;
			Integer fVtNv = 28;
			Integer fTt = 29;

			int cUno = 0;
			int cDos = 1;
			int cCin = 4;
			int cOc = 7;
			int cNv = 8;
			int cOnc = 10;
			int cDc = 11;

			dtE.setNomHospital(validaCelda(fHosp, fTr, cUno).trim());
			dtE.setIdHospDtCoorp(dtosEco.consHosp(dtE.getNomHospital().trim()));

			dtE.setPotencialDtCoorp(validaCelda(fHosp, fTr, cDos));

			dtE.setPerfilDtCoorp(validaCelda(fHosp, fTr, cNv));

			dtE.setPorcAccesoDtCoorp(validaCelda(fHosp, fSs, cUno));

			dtE.setNoCamasEnfDtCoorp(validaCelda(fHosp, fSs, cDos));

			dtE.setTasaOcNoCamasEnfDtCoorp(validaCelda(fHosp, fSs, cCin));

			dtE.setNoCamasCIntDtCoorp(validaCelda(fHosp, fSs, cNv));

			dtE.setTasaOcNoCamasCIntDtCoorp(validaCelda(fHosp, fSs, cDc));

			dtE.setConvADtCoorp(dtosEco.consConv(validaCelda(fHosp, fOc, cDos).trim()));

			dtE.setPorcConvADtCoorp(validaCelda(fHosp, fOc, cNv));

			dtE.setConvBDtCoorp(dtosEco.consConv(validaCelda(fHosp, fNv, cDos).trim()));

			dtE.setPorcConvBDtCoorp(validaCelda(fHosp, fNv, cNv));

			dtE.setConvCDtCoorp(dtosEco.consConv(validaCelda(fHosp, fDz, cDos).trim()));

			dtE.setPorcConvCDtCoorp(validaCelda(fHosp, fDz, cNv));

			dtE.setConvDDtCoorp(dtosEco.consConv(validaCelda(fHosp, fOn, cDos).trim()));

			dtE.setPorcConvDDtCoorp(validaCelda(fHosp, fOn, cNv));

			dtE.setLabPropioDtCoorp(validaCelda(fHosp, fCtc, cUno));

			dtE.setIdEquipADtCoorp(dtosEco.consEquip(validaCelda(fHosp, fCtc, cDos).trim()));

			dtE.setIdEquipBDtCoorp(dtosEco.consEquip(validaCelda(fHosp, fCtc, cCin).trim()));

			dtE.setIdEquipCDtCoorp(dtosEco.consEquip(validaCelda(fHosp, fCtc, cOc).trim()));

			dtE.setTmpRetAntBDtCoorp(validaCelda(fHosp, fCtc, cOnc));

			dtE.setNomJfeAreaDtCoorp(validaCelda(fHosp, fDzSt, cUno));

			dtE.setAreaDtCoorp(validaCelda(fHosp, fDzSt, cDos));
			dtE.setIdAreaDtCoorp(dtosEco.consEspec(dtE.getAreaDtCoorp().trim()));

			dtE.setCrmDtCoorp(validaCelda(fHosp, fDzSt, cOc));

			dtE.setComEstNomCRMDtCoorp(validaCelda(fHosp, fDzNv, cDos));

			dtE.setDesEscalonarDtCoorp(validaCelda(fHosp, fVtUno, cDos));

			dtE.setProgAMSDtCoorp(validaCelda(fHosp, fVtTr, cDos));

			String[] tProtA = validaCelda(fHosp, fVtNv, cUno).split(" ");
			if (tProtA[5] != null && tProtA[5].equals("IIA")) {
				String cProVtNv = tProtA[5].concat("C");
				dtE.setTipProtDtCuant_U(cProVtNv.toUpperCase());
			} else {
				dtE.setTipProtDtCuant_U(tProtA[5].toUpperCase());
			}

			String[] tProtB = validaCelda(fHosp, fTt, cUno).split(" ");
			if (tProtB[5] != null && tProtB[5].equals("IIA")) {
				String cProVtNv = tProtB[5].concat("C");
				dtE.setTipProtDtCuant_D(cProVtNv.toUpperCase());
			} else {
				dtE.setTipProtDtCuant_D(tProtB[5].toUpperCase());
			}

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

	public static String validaCelda(XSSFRow xF, Integer nF, int nC) {
		String vCHosp = "";
		xF = Hoja.getRow(nF);
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
		return vCHosp;
	}

}
