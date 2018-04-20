package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Cliente;


public class ClienteDAO {
	
	//metodo para inserir no banco
	public void inserir(Cliente entidade) {
		PreparedStatement statement = null;
		Connection con = null;
		try {
			con = ConnectionDB.getInstance().getConnection();
			String sqlInsert = "INSERT INTO CLIENTE (NOME, IDADE, TELEFONE) " + "VALUES (?,?,?,?)";
			statement = con.prepareStatement(sqlInsert);

			statement.setString(1, entidade.getNome());
			statement.setString(2, entidade.getIdade());
			statement.setString(3, entidade.getTelefone());

			statement.execute();

			long codigo = ((com.mysql.jdbc.PreparedStatement) statement).getLastInsertID();
			entidade.setIdCLiente(((int) codigo));
		} catch (Exception e) {

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
	//metodo para listar os dados do banco
	public List listar() { // vulgo select
		List clientes = new ArrayList();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = ConnectionDB.getInstance().getConnection();
			String sqlSelect = "SELECT IDCLIENTE, NOME, IDADE, TELEFONE FROM CLIENTE";
			st = con.createStatement();
			rs = st.executeQuery(sqlSelect);

			while (rs.next()) {
				// criando o objeto do tipo despesamodel
				Cliente cliente = new Cliente();
				
				// preenchendo o conteudo do objeto
				cliente.setIdCLiente((rs.getInt("IDCLIENTE")));;
				cliente.setNome((rs.getString("NOME")));;
				cliente.setIdade((rs.getString("IDADE")));
				cliente.setTelefone((rs.getString("TELEFONE")));;

				// adicionando o objeto na lista
				clientes.add(cliente);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return clientes;
	}
	//metodo para excluir por id 
	public void excluirPorID(Integer idCliente){
		Connection con = null;
		Statement st = null;
		try{
			con = ConnectionDB.getInstance().getConnection();
			
			String sqlDelete = "DELETE FROM CLIENTE WHERE IDCLIENTE = " + idCliente;
		    st = con.createStatement();
		    st.execute(sqlDelete);
		    	
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//metodo para excluir por nome
	public void excluirPorNome(String nome){
		Connection con = null;
		Statement st = null;
		try{
			con = ConnectionDB.getInstance().getConnection();
			
			String sqlDelete = "DELETE FROM CLIENTE WHERE NOME = " + nome;
		    st = con.createStatement();
		    st.execute(sqlDelete);
		    	
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
