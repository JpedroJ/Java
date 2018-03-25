package bebidasDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Bebida;
import hibernate.HibernateUtils;

public class DAO {
	public void inserir(Bebida bebe) {
		Session session = HibernateUtils.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(bebe);
			session.flush();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}
	}

	public List listar() {
		Session session = HibernateUtils.getSessionFactory().openSession();

		List bebidas = new ArrayList();
		try {
			bebidas = session.createQuery("FROM Bebida").list();
		} catch (Exception e) {

		} finally {
			session.close();
		}
		return bebidas;
	}

	public void excluir(int codigo){
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
		Query query= session.createQuery("FROM Bebidas WHERE codigo"  + codigo);
		Bebida bebida = (Bebida)query.uniqueResult();
		
		session.delete(bebida);
		session.flush();
		
		transaction.commit();
		}catch (Exception e) {
			if(transaction != null){
				transaction.rollback();
			}
		
		}finally {
			session.close();
		}
		
		}

}
