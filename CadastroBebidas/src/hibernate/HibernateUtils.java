package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {

	private static SessionFactory sessionFactory = null;

	private HibernateUtils() {

	}

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) { // Fábrica ainda não existe

			// Estas configurações são para a versão 5.2 do Hibernate
			StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

			registryBuilder.loadProperties("hibernate.properties");

			StandardServiceRegistry registry = registryBuilder.build();

			MetadataSources ms = new MetadataSources(registry);

			ms.addAnnotatedClass(beans.Bebida.class);

			sessionFactory = ms.buildMetadata().buildSessionFactory();

		}

		return sessionFactory;

	}

}
