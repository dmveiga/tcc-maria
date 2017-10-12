package com.fumec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BuscaSimples {

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

			
			Scanner reader = new Scanner(System.in);
			System.out.println("Escreva o número de repetições de busca a serem realizadas: ");
			boolean valido = false;
			Integer quantidade = 0;
			while (!valido) {
				try {
					quantidade = reader.nextInt();
					valido = true;
				} catch (NumberFormatException e) {
					System.out.println("Favor digitar um NÚMERO");
				}
			}
			reader.close();
			
			String sql = "SELECT * FROM funcionario WHERE nome = 'Neymar da Silva Santos Júnior'";
//			String sql = "SELECT * FROM funcionario fun JOIN empresa emp ON fun.id_empresa = emp.id_empresa JOIN endereco end ON end.id_endereco = emp.id_endereco WHERE end.rua = 'Av. dos Andradas'";

			// Executar query
			System.out.println("Pesquisando dados...");
			stmt = conn.createStatement();
			long inicio = System.nanoTime();
			ResultSet rs = stmt.executeQuery(sql);;
			for (int i = 0; i < quantidade; i++) {
//				System.out.println(i);
				 rs = stmt.executeQuery(sql);
			}
			
			long tempoDecorrido = System.nanoTime() - inicio;
			
			if (rs.next()) {
				String nome = rs.getString("nome");
				System.out.println(nome + "\n");
			}

			double segundos = (double) tempoDecorrido / 1000000000.0;

			System.out.println("Registros pesquisados com sucesso!");
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
