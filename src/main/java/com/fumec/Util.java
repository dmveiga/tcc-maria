package com.fumec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

	static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	static final String DB_URL = "jdbc:mariadb://127.0.0.1/tcc?allowMultiQueries=true";

	static final String USER = "root";
	static final String PASS = "admin";

	public static Connection abrirConexao() {
		Connection conn = null;
		// Registrar driver jdbc
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Abrir conexão
		System.out.println("Conectando ao MariaDb");
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Conexão bem sucedida");
		return conn;
	}
	
	public static void fecharConexao(Connection conn) {
		try {
			conn.close();
		} catch (SQLException se) {
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}
