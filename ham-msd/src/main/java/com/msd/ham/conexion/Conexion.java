package com.msd.ham.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;
import org.apache.log4j.Logger;

public class Conexion {

	private static final Logger log = Logger.getLogger(Conexion.class);
	private static final String urlConn = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String urlConnuser = "AVACO";
	private static final String urlConnPass = "LAmxcred1t";

	private static final String urlConnIO = "jdbc:oracle:thin:@10.10.101.209:1521/TRAZABILIDAD";
	private static final String urlConnuserIO = "USER_INTEROP_OWNER";
	private static final String urlConnPassIO = "ConInter17";

	private Connection conn;

	public Connection getConnection() {
		return conn;
	}

	public void registrarDriver() throws SQLException {
		OracleDriver oracleDriver = new oracle.jdbc.driver.OracleDriver();
		DriverManager.registerDriver(oracleDriver);
	}

	public void conectar() throws SQLException {
		// System.out.println(connection);
		if (conn == null || conn.isClosed() == true) {

			registrarDriver();
			conn = DriverManager.getConnection(urlConn, urlConnuser, urlConnPass);
		}
	}

	public void registrarDriverIO() throws SQLException {
		OracleDriver oracleDriver = new oracle.jdbc.driver.OracleDriver();
		DriverManager.registerDriver(oracleDriver);
	}

	public void conectarIO() throws SQLException {
		// System.out.println(connection);
		if (conn == null || conn.isClosed() == true) {

			registrarDriverIO();
			conn = DriverManager.getConnection(urlConnIO, urlConnuserIO, urlConnPassIO);
		}
	}

	public static void cerrar(Connection conn, PreparedStatement stm) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (stm != null) {
				stm.close();
			}
		} catch (SQLException e) {
			log.error("Error al cerrar la conexion: ", e);
		}
	}

	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			log.error("Error al realizar rollback: ", e);
		}
	}

}
