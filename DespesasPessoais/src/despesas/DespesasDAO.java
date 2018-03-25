package despesas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DespesasDAO {

	public void inserir(DespesaModel entidade) {
		PreparedStatement statement = null;
		Connection con = null;
		try {
			con = ConnectionDB.getInstance().getConnection();
			String sqlInsert = "INSERT INTO Despesas (categoria, descricao, valor, data_pagamento ) "
					+ "VALUES (?,?,?,?)";
			statement = con.prepareStatement(sqlInsert);

			statement.setString(1, entidade.getCategoria());
			statement.setString(2, entidade.getDescricao());
			statement.setDouble(3, entidade.getValor());
			statement.setDate(4, new java.sql.Date(entidade.getDataPagamento().getTime()));
			
			statement.execute();

			long codigo = ((com.mysql.jdbc.PreparedStatement)statement).getLastInsertID();
			entidade.setCodigo((int)codigo);
		} catch (Exception e) {

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public List listar() { // vulgo select
		List despesas = new ArrayList();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = ConnectionDB.getInstance().getConnection();
			String sqlSelect = "SELECT codigo, categoria, descricao, valor, data_pagamento FROM Despesas";
			st = con.createStatement();
			rs = st.executeQuery(sqlSelect);

			while (rs.next()) {
				// criando o objeto do tipo despesamodel
				DespesaModel despesa = new DespesaModel();
				
				// preenchendo o conteudo do objeto
				despesa.setCodigo(rs.getInt("codigo"));
				despesa.setCategoria(rs.getString("categoria"));
				despesa.setDescricao(rs.getString("descricao"));
				despesa.setValor(rs.getDouble("valor"));
				despesa.setDataPagamento(rs.getDate("data_pagamento"));

				// adicionando o objeto na lista
				despesas.add(despesa);
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
		return despesas;
	}
	public void excluir(Integer codigo){
		Connection con = null;
		Statement st = null;
		try{
			con = ConnectionDB.getInstance().getConnection();
			
			String sqlDelete = "DELETE FROM Despesas WHERE codigo = " + codigo;
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
	public void alterar(DespesaModel entidade) {
		PreparedStatement statement = null;
		Connection con = null;
		try {
			con = ConnectionDB.getInstance().getConnection();
			String sqlInsert = "UPDATE Despesas set categoria=?, descricao=?, valor=?, data_pagamento=? "	
			+ "WHERE codigo =?";
			statement = con.prepareStatement(sqlInsert);

			statement.setString(1, entidade.getCategoria());
			statement.setString(2, entidade.getDescricao());
			statement.setDouble(3, entidade.getValor());
			statement.setDate(4, new java.sql.Date(entidade.getDataPagamento().getTime()));
			statement.setInt(5, entidade.getCodigo());
			statement.execute();

		} catch (Exception e) {

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}
	

}
