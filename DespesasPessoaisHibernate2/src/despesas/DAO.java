package despesas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateUtils;

public class DAO<E> {
	private Class<E> persistentEntity;

	protected DAO(){
		
	}

	protected DAO(Class<E> clazz){
		this();
		this.persistentEntity = clazz;
	}

	public void inserir(E entidade) {

		Session session = HibernateUtils.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			session.save(entidade);
			session.flush();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}

	}

	public List<E> listar() {

		Session session = HibernateUtils.getSessionFactory().openSession();

		List<E> itens = new ArrayList<>();
		try {
			//estamos usando o recurso do Hibernate chamado criteria
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<E> criteria = cb.createQuery(persistentEntity);
			criteria.from(persistentEntity);
			
			itens = session.createQuery(criteria).getResultList();
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return itens;

	}

	public void excluir(int codigo) {

		Session session = HibernateUtils.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			
			E entidade = session.find(persistentEntity, codigo);
			
			
			
			/*// DespesaModel despesa = (DespesaModel)session.createQuery("FROM
			// DespesaModel WHERE codigo = " + codigo).uniqueResult();

			Query query = session.createQuery("FROM DespesaModel WHERE codigo = " + codigo);
			DespesaModel despesa = (DespesaModel) query.uniqueResult();
*/
			session.delete(entidade);
			session.flush();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}

	}

	public void excluir(E despesa) {

		Session session = HibernateUtils.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			session.remove(despesa);
			session.flush();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}

	}

	public void alterar(E entidade) {
		Session session = HibernateUtils.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			session.update(entidade);
			session.flush();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}

	}

}
