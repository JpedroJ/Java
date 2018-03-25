package despesas;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import hibernate.HibernateUtils;

public class DespesasDAO extends DAO<DespesaModel> {
	
	public DespesasDAO(){
		super(DespesaModel.class);
	}
	public List<DespesaModel> listarPorCategoria(String categoria){
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		List<DespesaModel> despesa = null;
		try {
			String hql = "FROM DespesaModel WHERE categoria = :categoria AND dataPagamento = :";
			TypedQuery<DespesaModel> query = session.createQuery(hql, DespesaModel.class);
			
			query.setParameter("categoria", categoria);
			
		
		} catch (Exception e) {

		}finally{
			session.close();
		}
		return despesa;
	}

}
