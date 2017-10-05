package com.fumec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Inserir {

	static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	static final String DB_URL = "jdbc:mariadb://127.0.0.1/tcc?allowMultiQueries=true";

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
			System.out.println("Escreva o número de registros a serem inseridos: ");
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

			// Executar query
			System.out.println("Inserindo dados...");
			stmt = conn.createStatement();
			String sql = "";
			long inicio = System.nanoTime();
			for (int i = 0; i < quantidade / 3; i++) {
				// //3 endereços diferentes
				// stmt.executeQuery("INSERT INTO endereco (PAIS, ESTADO, CIDADE, BAIRRO, RUA,
				// NUMERO, CEP)"
				// + " VALUES ('Brasil', 'MG', 'Belo Horizonte', 'Santa Efigênia', 'Av. dos
				// Andradas', 3000, '30260070');");
				// stmt.executeQuery("INSERT INTO endereco (PAIS, ESTADO, CIDADE, BAIRRO, RUA,
				// NUMERO, CEP)"
				// + " VALUES ('Brasil', 'SP', 'São Paulo', 'Morumbi', 'Av. Dr. Chucri Zaidan',
				// 1240, '04711130');");
				// stmt.executeQuery("INSERT INTO endereco (PAIS, ESTADO, CIDADE, BAIRRO, RUA,
				// NUMERO, CEP)"
				// + " VALUES ('Brasil', 'RJ', 'Rio de Janeiro', 'Lapa', 'R. Teixeira de
				// Freitas', 31, '20021350');");
				// // 3 empresas diferentes
				// stmt.executeQuery("INSERT INTO empresa (ID_ENDERECO, NOME, DATA_CRIACAO,
				// NUM_FUNCIONARIOS, LUCRO)"
				// + " VALUES (1, 'Unisys', '1900-01-01', 100000, 5000000000.50);");
				// stmt.executeQuery("INSERT INTO empresa (ID_ENDERECO, NOME, DATA_CRIACAO,
				// NUM_FUNCIONARIOS, LUCRO)"
				// + " VALUES (2, 'Microsoft', '1950-02-02', 200000, 10000000000.50);");
				// stmt.executeQuery("INSERT INTO empresa (ID_ENDERECO, NOME, DATA_CRIACAO,
				// NUM_FUNCIONARIOS, LUCRO)"
				// + " VALUES (3, 'Google', '2000-05-05', 300000, 15000000000.50);");
				// //3 funções diferentes
				// stmt.executeQuery("INSERT INTO funcao (NOME, DESCRICAO)"
				// + " VALUES ('Desenvolvedor Java Jr.', 'Desenvolver, analisar requisitos e
				// testar aplicações Java Web,"
				// +" utuilizando conhecimentos em HTML, Javascript, Css, entre outros');");
				// stmt.executeQuery("INSERT INTO funcao (NOME, DESCRICAO)"
				// + " VALUES ('Gerente de Projetos', 'Os gerentes de projetos cultivam as
				// habilidades das pessoas para desenvolver"
				// + " confiança e comunicação entre todas as partes interessadas do projeto:
				// seus patrocinadores, aqueles que farão"
				// + " uso dos resultados do projeto, aqueles que dispõem dos recursos
				// necessários e os membros da equipe do projeto');");
				// stmt.executeQuery("INSERT INTO funcao (NOME, DESCRICAO)"
				// + " VALUES ('SCRUM Master', 'O Scrum Master procura assegurar que a equipe
				// respeite e siga os valores e as práticas"
				// + " do Scrum. Ele também protege a equipe assegurando que ela não se
				// comprometa excessivamente com relação àquilo que"
				// + " é capaz de realizar durante um Sprint.');");
				// //3 funcionários diferentes
				// stmt.executeQuery("INSERT INTO funcionario (ID_EMPRESA, ID_FUNCAO, NOME,
				// DATA_NASCIMENTO, EMAIL, ATIVO, SALARIO)"
				// + " VALUES (1, 3, 'Neymar da Silva Santos Júnior', '1992-02-05',
				// 'neymar.jr@gmail.com', true, 10000000.23);");
				// stmt.executeQuery("INSERT INTO funcionario (ID_EMPRESA, ID_FUNCAO, NOME,
				// DATA_NASCIMENTO, EMAIL, ATIVO, SALARIO)"
				// + " VALUES (2, 2, 'William Henry Gates III', '1992-02-05',
				// 'bill@microsoft.com', false, 50000000.75);");
				// stmt.executeQuery("INSERT INTO funcionario (ID_EMPRESA, ID_FUNCAO, NOME,
				// DATA_NASCIMENTO, EMAIL, ATIVO, SALARIO)"
				// + " VALUES (3, 1, 'Gisele Caroline Bündchen', '1975-10-28',
				// 'gisele@outlook.com', true, 15000000.99);");
				// //3 dependentes diferentes
				// stmt.executeQuery("INSERT INTO dependente (ID_FUNCIONARIO, NOME,
				// DATA_NASCIMENTO, EMAIL, PARENTESCO)"
				// + " VALUES (1, 'Alok Achkar Peres Petrillo', '1991-08-26',
				// 'alok@artistfactory.com', 'filho');");
				// stmt.executeQuery("INSERT INTO dependente (ID_FUNCIONARIO, NOME,
				// DATA_NASCIMENTO, EMAIL, PARENTESCO)"
				// + " VALUES (1, 'Marília Mendonça', '1995-07-22', 'marilia@hotmail.com',
				// 'prima');");
				// stmt.executeQuery("INSERT INTO dependente (ID_FUNCIONARIO, NOME,
				// DATA_NASCIMENTO, EMAIL, PARENTESCO)"
				// + " VALUES (1, 'Larissa de Macedo Machado', '1993-03-30',
				// 'anitta@somlivre.com.br', 'filha');");

				sql = "INSERT INTO endereco (PAIS, ESTADO, CIDADE, BAIRRO, RUA, NUMERO, CEP)"
						+ " VALUES ('Brasil', 'MG', 'Belo Horizonte', 'Santa Efigênia', 'Av. dos Andradas', 3000, '30260070');\n";
				sql += "INSERT INTO empresa (ID_ENDERECO, NOME, DATA_CRIACAO, NUM_FUNCIONARIOS, LUCRO)"
						+ " VALUES (1, 'Unisys', '1900-01-01', 100000, 5000000000.50);\n";
				sql += "INSERT INTO funcao (NOME, DESCRICAO)"
						+ " VALUES ('Desenvolvedor Java Jr.', 'Desenvolver, analisar requisitos e testar aplicações Java Web,"
						+ " utuilizando conhecimentos em HTML, Javascript, Css, entre outros');\n";
				sql += "INSERT INTO funcionario (ID_EMPRESA, ID_FUNCAO, NOME, DATA_NASCIMENTO, EMAIL, ATIVO, SALARIO)"
						+ " VALUES (1, 1, 'Neymar da Silva Santos Júnior', '1992-02-05', 'neymar.jr@gmail.com', true, 10000000.23);";
				sql += "INSERT INTO dependente (ID_FUNCIONARIO, NOME, DATA_NASCIMENTO, EMAIL, PARENTESCO)"
						+ " VALUES (1, 'Alok Achkar Peres Petrillo', '1991-08-26', 'alok@artistfactory.com', 'filho');";
				stmt.executeUpdate(sql);

				sql = "INSERT INTO endereco (PAIS, ESTADO, CIDADE, BAIRRO, RUA, NUMERO, CEP)\n"
						+ " VALUES ('Brasil', 'SP', 'São Paulo', 'Morumbi', 'Av. Dr. Chucri Zaidan', 1240, '04711130');\n";
				sql += "INSERT INTO empresa (ID_ENDERECO, NOME, DATA_CRIACAO, NUM_FUNCIONARIOS, LUCRO)"
						+ " VALUES (2, 'Microsoft', '1950-02-02', 200000, 10000000000.50);\n";
				sql += "INSERT INTO funcao (NOME, DESCRICAO)"
						+ " VALUES ('Gerente de Projetos', 'Os gerentes de projetos cultivam as habilidades das pessoas para desenvolver"
						+ " confiança e comunicação entre todas as partes interessadas do projeto: seus patrocinadores, aqueles que farão"
						+ " uso dos resultados do projeto, aqueles que dispõem dos recursos necessários e os membros da equipe do projeto');\n";
				sql += "INSERT INTO funcionario (ID_EMPRESA, ID_FUNCAO, NOME, DATA_NASCIMENTO, EMAIL, ATIVO, SALARIO)"
						+ " VALUES (2, 2, 'William Henry Gates III', '1992-02-05', 'bill@microsoft.com', false, 50000000.75);";
				sql += "INSERT INTO dependente (ID_FUNCIONARIO, NOME, DATA_NASCIMENTO, EMAIL, PARENTESCO)"
						+ " VALUES (1, 'Marília Mendonça', '1995-07-22', 'marilia@hotmail.com', 'prima');";

				sql += "INSERT INTO endereco (PAIS, ESTADO, CIDADE, BAIRRO, RUA, NUMERO, CEP)"
						+ " VALUES ('Brasil', 'RJ', 'Rio de Janeiro', 'Lapa', 'R. Teixeira de Freitas', 31, '20021350');\n";
				sql += "INSERT INTO empresa (ID_ENDERECO, NOME, DATA_CRIACAO, NUM_FUNCIONARIOS, LUCRO)"
						+ " VALUES (3, 'Google', '2000-05-05', 300000, 15000000000.50);\n";
				sql += "INSERT INTO funcao (NOME, DESCRICAO)"
						+ " VALUES ('SCRUM Master', 'O Scrum Master procura assegurar que a equipe respeite e siga os valores e as práticas"
						+ " do Scrum. Ele também protege a equipe assegurando que ela não se comprometa excessivamente com relação àquilo que"
						+ " é capaz de realizar durante um Sprint.');\n";
				sql += "INSERT INTO funcionario (ID_EMPRESA, ID_FUNCAO, NOME, DATA_NASCIMENTO, EMAIL, ATIVO, SALARIO)"
						+ " VALUES (3, 1, 'Gisele Caroline Bündchen', '1975-10-28', 'gisele@outlook.com', true, 15000000.99);";
				sql += "INSERT INTO dependente (ID_FUNCIONARIO, NOME, DATA_NASCIMENTO, EMAIL, PARENTESCO)"
						+ " VALUES (1, 'Larissa de Macedo Machado', '1993-03-30', 'anitta@somlivre.com.br', 'filha');";
				stmt.executeUpdate(sql);

			}
			long tempoDecorrido = System.nanoTime() - inicio;

			double segundos = (double) tempoDecorrido / 1000000000.0;

			System.out.println(quantidade + " registros inseridos com sucesso!");
			System.out.println("Tempo gasto(em segundos): " + segundos);

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
