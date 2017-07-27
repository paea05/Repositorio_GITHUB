package com.paea05.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.paea05.conexion.Conexion;
import com.paea05.dao.pgConsultasDAO;

public class pgConsultasDAOImpl implements pgConsultasDAO {

	private static final Conexion conectar = new Conexion();
	private Connection conn = null;
	private PreparedStatement stm = null;
	private ResultSet rs = null;
	private static final String pgSQL = "select *from test";

	public String consTest() {
		String Rst = "";
		try {
			conectar.conectarPG();
			conn = conectar.getConnection();
			stm = conn.prepareStatement(pgSQL);
			rs = stm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Rst = rs.getString("id") + " | " + rs.getString("nombre") + " | " + rs.getString("apellidos")
							+ " | " + rs.getString("edad") + " | " + rs.getString("sexo");
				}
			}
		} catch (Exception e) {
			System.out.println("Error en consTest :::>> " + e.getMessage());
		} finally {
			Conexion.cerrar(conn, stm);
		}
		return Rst;
	}

}
