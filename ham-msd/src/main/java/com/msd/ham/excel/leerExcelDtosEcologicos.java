package com.msd.ham.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.msd.ham.dao.dtosCoorpEcoDAO;
import com.msd.ham.dao.dtosCuantEcoDAO;
import com.msd.ham.dao.impl.dtosCoorpEcoDAOImpl;
import com.msd.ham.dao.impl.dtosCuantEcoDAOImpl;
import com.msd.ham.models.dtosCoorpEco;
import com.msd.ham.models.dtosCuantEco;

public class leerExcelDtosEcologicos {
	private XSSFWorkbook Libro;
	private static XSSFSheet Hoja;
	private FileInputStream Excel;
	private File Archivo;
	private String urlE;
	private String urlS;
	private String urlEr;
	private static final String nAComp = "Platilla_DtEcologicos.xlsx";

	private dtosCoorpEcoDAO dtosCoorpEco = new dtosCoorpEcoDAOImpl();
	private dtosCuantEcoDAO dtosCuantEco = new dtosCuantEcoDAOImpl();

	private dtosCoorpEco dtCpE = new dtosCoorpEco();
	private dtosCuantEco dtCuaE = new dtosCuantEco();

	public void lExceldtCpEco(String E, String S, String Er) {

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
			Integer fVtSt = 26;
			Integer fVtOc = 27;
			Integer fVtNv = 28;
			Integer fTt = 29;

			int cUno = 0;
			int cDos = 1;
			int cTrs = 2;
			int cCua = 3;
			int cCin = 4;
			int cSs = 5;
			int cOc = 7;
			int cNv = 8;
			int cOnc = 10;
			int cDc = 11;
			int cTrCs = 12;

			dtCpE.setNomHospital(validaCelda(fHosp, fTr, cUno).trim());
			dtCpE.setIdHospDtCoorp(dtosCoorpEco.consHosp(dtCpE.getNomHospital().trim()));

			dtCpE.setPotencialDtCoorp(validaCelda(fHosp, fTr, cDos));

			dtCpE.setPerfilDtCoorp(validaCelda(fHosp, fTr, cNv));

			dtCpE.setPorcAccesoDtCoorp(validaCelda(fHosp, fSs, cUno));

			dtCpE.setNoCamasEnfDtCoorp(validaCelda(fHosp, fSs, cDos));

			dtCpE.setTasaOcNoCamasEnfDtCoorp(validaCelda(fHosp, fSs, cCin));

			dtCpE.setNoCamasCIntDtCoorp(validaCelda(fHosp, fSs, cNv));

			dtCpE.setTasaOcNoCamasCIntDtCoorp(validaCelda(fHosp, fSs, cDc));

			dtCpE.setConvADtCoorp(dtosCoorpEco.consConv(validaCelda(fHosp, fOc, cDos).trim()));

			dtCpE.setPorcConvADtCoorp(validaCelda(fHosp, fOc, cNv));

			dtCpE.setConvBDtCoorp(dtosCoorpEco.consConv(validaCelda(fHosp, fNv, cDos).trim()));

			dtCpE.setPorcConvBDtCoorp(validaCelda(fHosp, fNv, cNv));

			dtCpE.setConvCDtCoorp(dtosCoorpEco.consConv(validaCelda(fHosp, fDz, cDos).trim()));

			dtCpE.setPorcConvCDtCoorp(validaCelda(fHosp, fDz, cNv));

			dtCpE.setConvDDtCoorp(dtosCoorpEco.consConv(validaCelda(fHosp, fOn, cDos).trim()));

			dtCpE.setPorcConvDDtCoorp(validaCelda(fHosp, fOn, cNv));

			dtCpE.setLabPropioDtCoorp(validaCelda(fHosp, fCtc, cUno));

			dtCpE.setIdEquipADtCoorp(dtosCoorpEco.consEquip(validaCelda(fHosp, fCtc, cDos).trim()));

			dtCpE.setIdEquipBDtCoorp(dtosCoorpEco.consEquip(validaCelda(fHosp, fCtc, cCin).trim()));

			dtCpE.setIdEquipCDtCoorp(dtosCoorpEco.consEquip(validaCelda(fHosp, fCtc, cOc).trim()));

			dtCpE.setTmpRetAntBDtCoorp(validaCelda(fHosp, fCtc, cOnc));

			dtCpE.setNomJfeAreaDtCoorp(validaCelda(fHosp, fDzSt, cUno));

			dtCpE.setAreaDtCoorp(validaCelda(fHosp, fDzSt, cDos));
			dtCpE.setIdAreaDtCoorp(dtosCoorpEco.consEspec(dtCpE.getAreaDtCoorp().trim()));

			dtCpE.setCrmDtCoorp(validaCelda(fHosp, fDzSt, cOc));

			dtCpE.setComEstNomCRMDtCoorp(validaCelda(fHosp, fDzNv, cDos));

			dtCpE.setDesEscalonarDtCoorp(validaCelda(fHosp, fVtUno, cDos));

			dtCpE.setProgAMSDtCoorp(validaCelda(fHosp, fVtTr, cDos));

			String[] tProtA = validaCelda(fHosp, fVtNv, cUno).split(" ");
			if (tProtA[5] != null && tProtA[5].equals("IIA")) {
				String cProVtNv = tProtA[5].concat("C");
				dtCuaE.setTipProtDtCuant_U(cProVtNv.toUpperCase());
			} else {
				dtCuaE.setTipProtDtCuant_U(tProtA[5].toUpperCase());
			}

			String[] tProtB = validaCelda(fHosp, fTt, cUno).split(" ");
			if (tProtB[5] != null && tProtB[5].equals("IIA")) {
				String cProVtNv = tProtB[5].concat("C");
				dtCuaE.setTipProtDtCuant_D(cProVtNv.toUpperCase());
			} else {
				dtCuaE.setTipProtDtCuant_D(tProtB[5].toUpperCase());
			}

			dtCuaE.setTotPacXMes(validaCelda(fHosp, fVtSt, cDos));

			dtCuaE.setCantPacUrgXMes(validaCelda(fHosp, fVtSt, cTrs));

			dtCuaE.setPorcPacUrgXMes(String.valueOf(Math.round(valCeldaPorc(fHosp, fVtSt, cCua) * 100)));

			dtCuaE.setCantPacEnfXMes(validaCelda(fHosp, fVtSt, cSs));

			dtCuaE.setPorcPacEnfXMes(String.valueOf(Math.round(valCeldaPorc(fHosp, fVtSt, cOc) * 100)));

			dtCuaE.setCantPacCuiIntXMes(validaCelda(fHosp, fVtSt, cOnc));

			dtCuaE.setPorcPacCuiIntXMes(String.valueOf(Math.round(valCeldaPorc(fHosp, fVtSt, cTrCs) * 100)));

			dtCuaE.setSegGramNeg(dtosCuantEco.consGram(validaCelda(fHosp, fVtOc, cUno).trim().toUpperCase()));

			System.out.println("Valor celda B27 : " + dtCuaE.getTotPacXMes());
			System.out.println("Valor celda C27 : " + dtCuaE.getCantPacUrgXMes());
			System.out.println("Valor celda D27 : " + dtCuaE.getPorcPacUrgXMes());
			System.out.println("Valor celda F27 : " + dtCuaE.getCantPacEnfXMes());
			System.out.println("Valor celda H27 : " + dtCuaE.getPorcPacEnfXMes());
			System.out.println("Valor celda K27 : " + dtCuaE.getCantPacCuiIntXMes());
			System.out.println("Valor celda M27 : " + dtCuaE.getPorcPacCuiIntXMes());
			System.out.println("Valor celda A28 : " + dtCuaE.getSegGramNeg());
			System.out.println("Valor celda A29 : " + dtCuaE.getTipProtDtCuant_U());
			System.out.println("Valor celda A30 : " + dtCuaE.getTipProtDtCuant_D());

			// dtosCoorpEco.insertDtCoorp(dtCpE);

		} catch (Exception e) {
			System.out.println("Error metodo lExceldtCpEco :::>> " + e.getMessage());
		}

	}

	public void validaExcel() {
		Properties pRutas = new Properties();
		try {
			pRutas.load(leerExcelDtosEcologicos.class.getClassLoader().getResourceAsStream("rutas.properties"));
			urlE = pRutas.getProperty("URL_ENTRADA") + nAComp;
			urlS = pRutas.getProperty("URL_SALIDA") + nAComp;
			urlEr = pRutas.getProperty("URL_ERROR") + nAComp;
			File ValidarArchivo = new File(urlE);

			if (ValidarArchivo.exists()) {
				lExceldtCpEco(urlE, urlS, urlEr);
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

	public static double valCeldaPorc(XSSFRow xF, Integer nF, int nC) {
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
