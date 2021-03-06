package br.univel.dao.hb;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static StandardServiceRegistry registry;

	private static SessionFactory buildSessionFactory() {

		registry = new StandardServiceRegistryBuilder().configure() // configures
																	// settings
																	// from
																	// hibernate.cfg.xml
				.build();

		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			// The registry would be destroyed by the SessionFactory, but we had
			// trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry);
		}
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void finalizar() {
		StandardServiceRegistryBuilder.destroy(registry);

	}
}
