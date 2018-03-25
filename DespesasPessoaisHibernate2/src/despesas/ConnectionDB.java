package despesas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	// Objeto utilizado pelo padrão de projeto Singleton.
	private static ConnectionDB connectionDB = null;
	
	// Objeto que reprensetará a conexção com o banco de dados.
	private static Connection conn = null;
	
	// Construtor privado para o padrão Singleton
	private ConnectionDB() {
		
	}

	// Garante que haverá apenas uma instancia da classe ConnectionDB
	// Este é o conceito do Singleton
	public static ConnectionDB getInstance() {
		if (connectionDB == null) {
			connectionDB = new ConnectionDB();
		}
		return connectionDB;
	}
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DespesasPessoais?user=root&password=elaborata");
			
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
