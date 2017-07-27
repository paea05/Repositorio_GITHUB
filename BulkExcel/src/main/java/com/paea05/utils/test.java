package com.paea05.utils;

import com.paea05.dao.pgConsultasDAO;
import com.paea05.daoimpl.pgConsultasDAOImpl;

public class test {

	public static void main(String[] args) {
		// LeerExcel le = new LeerExcel();
		// lectorExcel lc = new lectorExcel();
		// xlsxOracle xO = new xlsxOracle();
		// nvoLExcel nE = new nvoLExcel();
		pgConsultasDAO pgC = new pgConsultasDAOImpl();
		String rst;
		try {
			// le.lExcel();
			// lc.leerEx();
			// xO.cargarXlsxOracle();
			// xO.validaCargaExcel();
			// nE.nvocargarExcel();
			rst = pgC.consTest();
			if (rst != null) {
				System.out.println("Registros PostgreSQL : " + rst);
			}else {
				rst="";
				System.out.println("No Hay Datos");
			}

		} catch (Exception e) {
			System.out.println("Error En Test :::> " + e.getMessage());
		}
	}

}
