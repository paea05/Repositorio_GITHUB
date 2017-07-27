package com.msd.ham.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.msd.ham.conexion.Conexion;
import com.msd.ham.dao.cargarExcelBulkDAO;
import com.msd.ham.models.ventas;
import com.msd.ham.utils.moverDir;

public class cargarExcelBulkDAOImpl implements cargarExcelBulkDAO {
	private static final Conexion conectar = new Conexion();
	private Connection conn = null;
	private PreparedStatement stm = null;
	private static int[] res;
	private moverDir mD = new moverDir();

	private static final String query = "INSERT INTO HAM_ATVVENTAS_T  "
			+ " (ID_VENTA,BRICK_VENTA,ID_PRODUCTO,ANIO_VENTA,MES_VENTA,RUTA_VENTA,FACTOR_VENTA,UNIDADES_VENTA,VALORES_VENTA)  "
			+ " VALUES (?,?,?,?,?,?,?,?,?) ";

	@Override
	public int[] insertBulkVtas(List<ventas> vta, String DE, String DS, String DER) {
		res = new int[2];
		try {
			conectar.conectar();
			conn = conectar.getConnection();
			stm = conn.prepareStatement(query);
			for (ventas vt : vta) {
				stm.setInt(1, vt.getIdVentas());
				stm.setInt(2, vt.getBrickVentas());
				stm.setInt(3, vt.getIdProducto());
				stm.setInt(4, vt.getAnioVenta());
				stm.setInt(5, vt.getMesVenta());
				stm.setString(6, vt.getRutaVenta());
				stm.setInt(7, vt.getFactorVenta());
				stm.setInt(8, vt.getUniVenta());
				stm.setInt(9, vt.getValVenta());
				stm.addBatch();
			}
			res = stm.executeBatch();
			System.out.println("Bulkado Exitoso ... ");
			mD.moveFile(DE, DS);
			System.out.println(vta.size() + " Registros Insertado en la tabla HAM_ATVVENTAS_1 ");
		} catch (Exception e) {
			mD.moveFile(DE, DER);
			System.out.println("Error al Bulkar HAM_ATVVENTAS_T :::>> " + e.getMessage());
		} finally {
			Conexion.cerrar(conn, stm);
		}
		return res;
	}

}
