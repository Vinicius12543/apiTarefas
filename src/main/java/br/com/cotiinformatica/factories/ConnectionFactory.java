package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Classe para fabricar conexões com banco de dados do MySQL
 */
public class ConnectionFactory {

	/*
	 * Método para abrir e retornar uma conexão com o banco de dados
	 */
	public static Connection getConnection() throws Exception {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bd_apiTarefas";
		String user = "root";
		String pass = "coti";
		
		Class.forName(driver);
		return DriverManager.getConnection(url, user, pass);
	}
}
