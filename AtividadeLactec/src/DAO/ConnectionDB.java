package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// classe que cria a conexão com o banco
public class ConnectionDB {

	private static ConnectionDB connectionDB = null;

	private static Connection conn = null;

	private ConnectionDB() {

	}

	public static ConnectionDB getInstance() {
		if (connectionDB == null) {
			connectionDB = new ConnectionDB();
		}
		return connectionDB;
	}

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CLIENTE_CADASTRO?user=root&password=1049");

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
