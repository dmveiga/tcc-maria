package com.fumec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pesquisar {

	static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	static final String DB_URL = "jdbc:mariadb://127.0.0.1/tcc";

	static final String USER = "root";
	static final String PASS = "admin";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			
			// Registrar driver jdbc
			Class.forName("org.mariadb.jdbc.Driver");

			// Abrir conexão
			System.out.println("Conectando ao MariaDb");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Conexão bem sucedida");

			// Executar query
			System.out.println("Pesquisando dados...");
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM endereco e WHERE e.rua LIKE 'R. Teixeira'";

			long inicio = System.nanoTime();
			ResultSet rs = stmt.executeQuery(sql);
			long tempoDecorrido = System.nanoTime() - inicio;
			
			while (rs.next()) {
				String rua = rs.getString("rua");
				System.out.println(rua + "\n");
			}

			double segundos = (double) tempoDecorrido / 1000000000.0;

			System.out.println("Registros inseridos com sucesso!");
			System.out.println("Tempo decorrido(em segundos): " + segundos);

		} catch (SQLException se) {
			// Erros para JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Erros para Class.forName
			e.printStackTrace();
		} finally {
			// Fechar conexão
			try {
				if (stmt != null) {
					conn.close();
				}
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

}
