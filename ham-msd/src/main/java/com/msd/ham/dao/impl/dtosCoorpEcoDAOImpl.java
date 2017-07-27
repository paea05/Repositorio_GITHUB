package com.msd.ham.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.msd.ham.conexion.Conexion;
import com.msd.ham.dao.dtosCoorpEcoDAO;
import com.msd.ham.models.dtosCoorpEco;

public class dtosCoorpEcoDAOImpl implements dtosCoorpEcoDAO {
	private static final Conexion conectar = new Conexion();
	private Connection conn = null;
	private PreparedStatement stm = null;
	private ResultSet rs = null;

	private static final String sqlCHosp = "SELECT ID_HOSPITAL FROM HAM_HOSPITALES WHERE NOMBRE_HOSPITAL = ?";

	private static final String sqlInsertCHosp = "INSERT INTO HAM_DTCOORPORATIVOS (ID_DTCOORPO, ID_HOSPITAL, POTENCIAL_DTCOORPO, "
			+ " PERFIL_DTCOORPO, PORC_ACC_PRIV_DTCOORPO, NCAMAS_ENF_DTCOORPO, TO_ENF_DTCOORPO, NCAMAS_CINT_DTCOORPO, "
			+ " TO_CINT_DTCOORPO, LABORATORIO_PRO_DTCOORPO, ID_EQUIPAMIENTO, NDIAS_RET_ANT_DTCOORPO, CONV_A_DTCOORPO, "
			+ " CONV_B_DTCOORPO, CONV_C_DTCOORPO, CONV_D_DTCOORPO, TO_CONVE_A_DTCOORPO, TO_CONVE_B_DTCOORPO, TO_CONVE_C_DTCOORPO, "
			+ " TO_CONVE_D_DTCOORPO, JEF_DEPT_NOMBRE_DTCOORPO, ID_ESPECIALIDAD, JEFE_DEPTO_ESP_DTCOORPO, CRM_DTCOORPO, "
			+ " COM_ESTANDAR_DTCOORPO, DESCALONAR_HSP_DTCOORPO, PROG_AMS_DTCOORPO) "
			+ " VALUES (SEQ_HAM_DTCOORP.NEXTVAL, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private static final String sqlCConv = "SELECT * FROM HAM_CAT_CONVENIO WHERE NOM_CONVENIO = ?";
	private static final String sqlCEquip = "SELECT * FROM HAM_EQUIPAMIENTOS WHERE NOMBRE_EQUIPAMIENTO = ?";
	private static final String sqlCEspec = "SELECT * FROM HAM_ESPECIALIDAD WHERE NOMBRE_ESPECIALIDAD = ?";

	@Override
	public String consHosp(String nH) {
		String idH = "";
		try {
			conectar.conectar();
			conn = conectar.getConnection();
			stm = conn.prepareStatement(sqlCHosp);
			stm.setString(1, nH);
			rs = stm.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					idH = rs.getString("ID_HOSPITAL");
				}
			}

		} catch (Exception e) {
			System.out.println("Error Consulta HAM_HOSPITALES :::>> " + e.getMessage());
		} finally {
			Conexion.cerrar(conn, stm);
		}
		return idH;
	}

	@Override
	public String consConv(String nC) {
		String idC = "";
		try {
			conectar.conectar();
			conn = conectar.getConnection();
			stm = conn.prepareStatement(sqlCConv);
			stm.setString(1, nC);
			rs = stm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					idC = rs.getString("ID_CONVENIO");
				}
			}
		} catch (Exception e) {
			System.out.println("Error Consulta HAM_CAT_CONVENIO :::>> " + e.getMessage());
		} finally {
			Conexion.cerrar(conn, stm);
		}
		return idC;
	}

	@Override
	public String consEquip(String nE) {
		String idE = "";
		try {
			conectar.conectar();
			conn = conectar.getConnection();
			stm = conn.prepareStatement(sqlCEquip);
			stm.setString(1, nE);
			rs = stm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					idE = rs.getString("ID_EQUIPAMIENTO");
				}
			}
		} catch (Exception e) {
			System.out.println("Error Consulta HAM_CAT_CONVENIO :::>> " + e.getMessage());
		} finally {
			Conexion.cerrar(conn, stm);
		}
		return idE;
	}

	@Override
	public String consEspec(String nEs) {
		String idEs = "";
		try {
			conectar.conectar();
			conn = conectar.getConnection();
			stm = conn.prepareStatement(sqlCEspec);
			stm.setString(1, nEs);
			rs = stm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					idEs = rs.getString("ID_ESPECIALIDAD");
				}
			}
		} catch (Exception e) {
			System.out.println("Error Consulta HAM_CAT_CONVENIO :::>> " + e.getMessage());
		} finally {
			Conexion.cerrar(conn, stm);
		}
		return idEs;
	}

	@Override
	public int insertDtCoorp(dtosCoorpEco dE) {
		int Resultados = 0;
		try {
			conectar.conectar();
			conn = conectar.getConnection();
			stm = conn.prepareStatement(sqlInsertCHosp);
			stm.setString(1, dE.getIdHospDtCoorp());
			stm.setString(2, dE.getPotencialDtCoorp());
			stm.setString(3, dE.getPerfilDtCoorp());
			stm.setString(4, dE.getPorcAccesoDtCoorp());
			stm.setString(5, dE.getNoCamasEnfDtCoorp());
			stm.setString(6, dE.getTasaOcNoCamasEnfDtCoorp());
			stm.setString(7, dE.getNoCamasCIntDtCoorp());
			stm.setString(8, dE.getTasaOcNoCamasCIntDtCoorp());
			stm.setString(9, dE.getLabPropioDtCoorp());
			stm.setString(10, dE.getIdEquipADtCoorp());
			stm.setString(11, dE.getTmpRetAntBDtCoorp());
			stm.setString(12, dE.getConvADtCoorp());
			stm.setString(13, dE.getConvBDtCoorp());
			stm.setString(14, dE.getConvCDtCoorp());
			stm.setString(15, dE.getConvDDtCoorp());
			stm.setString(16, dE.getPorcConvADtCoorp());
			stm.setString(17, dE.getPorcConvBDtCoorp());
			stm.setString(18, dE.getPorcConvCDtCoorp());
			stm.setString(19, dE.getPorcConvDDtCoorp());
			stm.setString(20, dE.getNomJfeAreaDtCoorp());
			stm.setString(21, dE.getIdAreaDtCoorp());
			stm.setString(22, dE.getAreaDtCoorp());
			stm.setString(23, dE.getCrmDtCoorp());
			stm.setString(24, dE.getComEstNomCRMDtCoorp());
			stm.setString(25, dE.getDesEscalonarDtCoorp());
			stm.setString(26, dE.getProgAMSDtCoorp());
			Resultados = stm.executeUpdate();
			System.out.println("Registro Insertado .... ");
		} catch (Exception e) {
			System.out.println("Error al Insertar HAM_DTCOORPORATIVOS :::>> " + e.getMessage());
		} finally {
			Conexion.cerrar(conn, stm);
		}
		return Resultados;
	}

}
