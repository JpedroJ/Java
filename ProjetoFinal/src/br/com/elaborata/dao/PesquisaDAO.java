package br.com.elaborata.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.elaborata.modelo.Pesquisa;
import hibernate.HibernateUtils;

public class PesquisaDAO {

	public void inserir(Pesquisa pesquisa) throws Exception{
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			
			session.save(pesquisa);
			session.flush();
			
			transaction.commit();
		} catch (Exception e) {
			//TODO armazenar em log a exceção
			throw new Exception(e);
		}finally {
			session.close();
		}
		
	}
	
}
