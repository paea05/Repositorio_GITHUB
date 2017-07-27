package com.msd.ham.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.msd.ham.conexion.Conexion;
import com.msd.ham.dao.dtosCuantEcoDAO;
import com.msd.ham.models.dtosCuantEco;

public class dtosCuantEcoDAOImpl implements dtosCuantEcoDAO {
	private static final Conexion conectar = new Conexion();
	private Connection conn = null;
	private PreparedStatement stm = null;
	private ResultSet rs = null;
	
	private static final String sqlCGram = "SELECT *FROM HAM_TIPO_GRAM WHERE DESC_REISTENCIA = ?";

	@Override
	public String consGram(String nG) {
		String idCG = "";
		try {
			conectar.conectar();
			conn = conectar.getConnection();
			stm = conn.prepareStatement(sqlCGram);
			stm.setString(1, nG);
			rs = stm.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					idCG = rs.getString("ID_GRAM");
				}
			}

		} catch (Exception e) {
			System.out.println("Error Consulta HAM_HOSPITALES :::>> " + e.getMessage());
		} finally {
			Conexion.cerrar(conn, stm);
		}
		return idCG;
	}

	@Override
	public int insertDtCuant(dtosCuantEco dCu) {
		int Resultado = 0;
		try {
			
		} catch (Exception e) {
			System.out.println("Error al Insertar HAM_DTCOORPORATIVOS :::>> " + e.getMessage());
		} finally {
			Conexion.cerrar(conn, stm);
		}
		return Resultado;
	}

}
