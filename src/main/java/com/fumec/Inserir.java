package com.fumec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Inserir {

	static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	static final String DB_URL = "jdbc:mariadb://127.0.0.1/tcc";

	static final String USER = "root";
	static final String PASS = "admin";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			final Integer QUANTIDADE = 1000;
			// Registrar driver jdbc
			Class.forName("org.mariadb.jdbc.Driver");

			// Abrir conexão
			System.out.println("Conectando ao MariaDb");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Conexão bem sucedida");

			// Executar query
			System.out.println("Inserindo dados...");
			stmt = conn.createStatement();

			String sql = "INSERT INTO endereco (PAIS, ESTADO, CIDADE, BAIRRO, RUA, NUMERO, CEP) VALUES ";

			for (int i = 1; i < (QUANTIDADE / 3); i++) {
				sql += "('Brasil', 'MG', 'Belo Horizonte', 'Santa Efigênia', 'Av. dos Andradas', 3000, '30260070'), ";
			}
			for (int i = 333; i < (QUANTIDADE / 3 * 2); i++) {
				sql += "('Brasil', 'SP', 'São Paulo', 'Morumbi', 'Av. Dr. Chucri Zaidan', 1240, '04711130'), ";
			}
			for (int i = 666; i < QUANTIDADE ; i++) {
				sql += "('Brasil', 'RJ', 'Rio de Janeiro', 'Lapa', 'R. Teixeira de Freitas', 31, '20021350'), ";
			}
			sql += "('Brasil', 'RJ', 'Rio de Janeiro', 'Lapa', 'R. Teixeira de Freitas', 31, '20021350');";

			long inicio = System.nanoTime();
			stmt.executeQuery(sql);
			long tempoDecorrido = System.nanoTime() - inicio;

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
