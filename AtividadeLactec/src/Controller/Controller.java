package Controller;


import java.util.List;

import DAO.ClienteDAO;
import Model.Cliente;

public class Controller {

	ClienteDAO clienteDAO = null;

	public Controller() {
		clienteDAO = new ClienteDAO();
	}
	public void inserir(Cliente cliente) {
		clienteDAO.inserir(cliente);
	}
	public List listar(){
		return clienteDAO.listar();
	}
	public void excluir(Integer codigo){
		clienteDAO.excluirPorID(codigo);
	}
	public void excluir(String nome){
		clienteDAO.excluirPorNome(nome);
	}
	
	
}
