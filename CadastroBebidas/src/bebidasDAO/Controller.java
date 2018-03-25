package bebidasDAO;

import java.util.List;

import beans.Bebida;

public class Controller {

	private DAO dao = null;
	
	public Controller(){
		dao = new DAO();
	}
	
	public void inserir (Bebida bebida){
		dao.inserir(bebida);
	}
	public List listar(){
		return dao.listar();
	}
	
	public void excluir(int codigo){
		dao.excluir(codigo);
	}
	
	
}
