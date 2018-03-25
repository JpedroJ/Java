package despesas;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateUtils;

public class DespesasDAO {
	
	public void inserir(DespesaModel entidade) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			
			session.save(entidade);
			session.flush();
			
			transaction.commit();
		} catch (Exception  e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}

	}
	
	public List<DespesaModel> listar() {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		List<DespesaModel> despesas = new ArrayList<>();
		try {
			
			despesas = session.createQuery("FROM DespesaModel").list();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return despesas;
	}
	
	public void excluir(int codigo) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			
			//DespesaModel despesa = (DespesaModel)session.createQuery("FROM DespesaModel WHERE codigo = " + codigo).uniqueResult();
			
			Query query = session.createQuery("FROM DespesaModel WHERE codigo = " + codigo);
			DespesaModel despesa = (DespesaModel)query.uniqueResult();
			
			session.delete(despesa);
			session.flush();
			
			transaction.commit();
		} catch (Exception  e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
		
	}
	
	public void excluir(DespesaModel despesa) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			
			session.remove(despesa);
			session.flush();
			
			transaction.commit();
		} catch (Exception  e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
		
	}

	public void alterar(DespesaModel entidade) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			
			session.update(entidade);
			session.flush();
			
			transaction.commit();
		} catch (Exception  e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
		
	}


}



















