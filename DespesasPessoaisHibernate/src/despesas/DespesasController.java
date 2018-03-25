package despesas;

import java.util.List;

public class DespesasController {
	
	private DespesasDAO dao = null;
	
	public DespesasController() {
		dao = new DespesasDAO();
	}
	
	public void inserir(DespesaModel entidade) {
		dao.inserir(entidade);
	}
	
	public List<DespesaModel> listar() {
		return dao.listar();
	}
	
	public void excluir(int codigo) {
		dao.excluir(codigo);
	}
	
	public void alterar(DespesaModel entidade) {
		dao.alterar(entidade);
	}

}
