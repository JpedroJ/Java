package despesas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	//Objeto utilizado pelo padrao de projeto Singleton
	private static ConnectionDB connectionDB = null;
	
	//Objeto que representara a conexao com o banco de dados
	private static Connection con = null;
	
	//Construtor privado para o padrao Singleton
	private ConnectionDB(){
		
	}
	
	//garante que havera apenas uma instancia da classe connectiondb
	//esse é o conceito do Singleton
	public static ConnectionDB getInstance(){
		if (connectionDB == null){
			connectionDB = new ConnectionDB();
		}
		return connectionDB;
	}
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DespesasPessoais?user=root&password=elaborata");
			return con;
		} catch (ClassNotFoundException e) {
			System.out.println("Erro no nome do Driver JDBC");		
			
		} catch (SQLException e) {
			System.out.println("ERRO: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
		
	}
	public void closeConnection(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
